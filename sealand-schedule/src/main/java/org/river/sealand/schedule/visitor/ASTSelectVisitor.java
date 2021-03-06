package org.river.sealand.schedule.visitor;

import java.util.ArrayList;
import java.util.List;

import org.river.sealand.metainfo.IMetaDataService;
import org.river.sealand.schedule.node.AggregateNode;
import org.river.sealand.schedule.node.HavingNode;
import org.river.sealand.schedule.node.JoinNode;
import org.river.sealand.schedule.node.JoinNode.JoinType;
import org.river.sealand.schedule.node.LimitNode;
import org.river.sealand.schedule.node.ScanNode;
import org.river.sealand.schedule.node.ScheduleNode;
import org.river.sealand.schedule.node.ScheduleNode.NodeType;
import org.river.sealand.schedule.node.SortNode;
import org.river.sealand.sql.ast.ASTStructUtils;
import org.river.sealand.sql.ast.ISqlStruct;
import org.river.sealand.sql.ast.ISqlStruct.SqlType;
import org.river.sealand.sql.ast.SQLBoolExpr;
import org.river.sealand.sql.ast.SQLGroupBy;
import org.river.sealand.sql.ast.SQLJoin;
import org.river.sealand.sql.ast.SQLLimit;
import org.river.sealand.sql.ast.SQLSelect;
import org.river.sealand.sql.ast.SQLSort;
import org.river.sealand.sql.ast.SQLTabReference;
import org.river.sealand.sql.ast.SQLTable;
import org.river.sealand.sql.util.SQLUtils;
import org.river.sealand.utils.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 对SQL语法抽象树中的Select树的访问者实现
 * 
 * @author river
 * @since Nov 27, 2013
 */
public class ASTSelectVisitor extends ASTVisitor {
	private static final Logger log = LoggerFactory.getLogger(ASTSelectVisitor.class);

	private IMetaDataService metaDataService;

	@Override
	protected ScheduleNode doVisit(ISqlStruct ast) {
		ScheduleNode node = null;
		NodeType nodeType = this.getNodeType(ast);

		if (nodeType == NodeType.SCAN) {
			return this.visitScan(ast);
		}

		SQLSelect select = (SQLSelect) ast;

		// 处理生成LmiteNode
		SQLLimit limit = select.getLimit();
		if (limit != null) {
			node = this.visitLimit(limit);
		}

		// 处理生成SortNode
		SQLSort sort = select.getOrderby();
		if (sort != null) {
			ScheduleNode sortNode = this.visitSort(sort);
			if (node != null) {
				sortNode.setDestNode(node);
				node.getSrcNodes().add(sortNode);
				node = sortNode;
			}
		}

		// 处理生成HavingNode
		SQLBoolExpr having = select.getHaving();
		if (having != null) {
			ScheduleNode havingNode = this.visitHaving(having);
			if (node != null) {
				havingNode.setDestNode(node);
				node.getSrcNodes().add(havingNode);
				node = havingNode;
			}
		}

		// 处理生成AggregateNode
		SQLGroupBy groupBy = select.getGroupBy();
		if (groupBy != null) {
			ScheduleNode groupByNode = this.visitGroupBy(groupBy);
			if (node != null) {
				groupByNode.setDestNode(node);
				node.getSrcNodes().add(groupByNode);
				node = groupByNode;
			}
		}
		// 处理生成JoinNode
		ScheduleNode joinNode = this.visitJoin(ast);
		if (node != null) {
			joinNode.setDestNode(node);
			node.getSrcNodes().add(joinNode);
			node = joinNode;
		}

		// 处理返回列表
		List<String> fields = select.getSelectFields();
		node.setFields(fields);

		return node;
	}

	/*
	 * 访问Limit关键字,构建limit节点
	 * 
	 * @param ast
	 * 
	 * @return
	 */
	private ScheduleNode visitLimit(ISqlStruct ast) {
		LimitNode limitNode = new LimitNode();
		SQLLimit limit = (SQLLimit) ast;
		limitNode.setStart(limit.getStart());
		limitNode.setOffset(limit.getOffset());
		return limitNode;
	}

	/*
	 * 访问Sort关键字,构建sort节点
	 * 
	 * @param ast
	 * 
	 * @return
	 */
	private ScheduleNode visitSort(ISqlStruct ast) {
		SortNode sortNode = new SortNode();
		SQLSort sort = (SQLSort) ast;
		List<SQLSort.Entry> entries = sort.getOrderbys();
		for (SQLSort.Entry tmp : entries) {
			sortNode.getSorts().add(new Entry<String,SQLSort.Type>(tmp.getField(), tmp.getType()));
		}
		return sortNode;
	}

	/*
	 * 访问having关键字,构建Having节点
	 * 
	 * @param ast
	 * 
	 * @return
	 */
	private ScheduleNode visitHaving(ISqlStruct ast) {
		SQLBoolExpr having = (SQLBoolExpr) ast;
		HavingNode havingNode = new HavingNode();
		havingNode.setHavings(having.toString());
		return havingNode;
	}

	/*
	 * 访问join关键字,构建Join节点
	 * 
	 * @param ast
	 * 
	 * @return
	 */
	private ScheduleNode visitJoin(ISqlStruct ast) {
		SQLSelect select = (SQLSelect) ast;
		List<SQLTabReference> fromTbls = select.getFromTbls();
		if (fromTbls.size() == 1) {
			this.visitTabRef(select.getFromTbls().get(0));
		} else if (fromTbls.size() > 1) {
			return this.visitCrossJoin(ast);
		}

		return null;
	}

	/*
	 * 访问表引用关键字,相应节点
	 * 
	 * @param ast
	 * 
	 * @return
	 */
	private ScheduleNode visitTabRef(SQLTabReference tabRef) {
		ISqlStruct ref = tabRef.getRef();
		ScheduleNode node = null;
		switch (tabRef.getRefType()) {
		case SUB_SELECT: {
			SQLSelect select = (SQLSelect) ref;
			SQLBoolExpr criteria = tabRef.getCriteria();
			if (criteria != null) {
				select.getCriteria().and(criteria);
			}
			node = this.visit(select);
			break;
		}
		case JOIN: {
			SQLJoin join = (SQLJoin) ref;
			SQLBoolExpr criteria = tabRef.getCriteria();
			if (criteria != null) {
				join.getOn().and(criteria);
			}
			node = this.visitOnJoin(join);
			break;
		}
		case TABLE: {
			node = this.visitTable(tabRef);
		}
		}

		node.setAlias(tabRef.getAlias());

		return node;
	}

	/*
	 * 表对象查询
	 * 
	 * @param tabRef
	 * 
	 * @return
	 */
	private ScheduleNode visitTable(SQLTabReference tabRef) {
		StringBuffer sb = new StringBuffer("SELECT ");
		sb.append(SQLUtils.buildSelectList(tabRef.getFields())).append(" ");
		sb.append("FROM ");
		String tableName = ((SQLTable) tabRef.getRef()).getTableName();
		sb.append(tableName).append(" ");

		SQLBoolExpr expr = tabRef.getCriteria();
		if (expr != null) {
			sb.append(expr.toString());
		}
		ScanNode node = new ScanNode();
		node.setSql(sb.toString());
		node.setGlobal(this.metaDataService.isGlobal(tableName));

		return node;
	}

	/*
	 * 访问join关键字,构建Join节点
	 * 
	 * @param ast
	 * 
	 * @return
	 */
	private ScheduleNode visitOnJoin(SQLJoin join) {
		if (NodeType.SCAN == this.getNodeType(join)) {
			return this.visitScan(join);
		}

		SQLTabReference left = join.getLeft();
		SQLTabReference right = join.getRight();
		ScheduleNode leftNode = this.visitTabRef(left);
		ScheduleNode rightNode = this.visitTabRef(right);
		List<ScheduleNode> srcNodes = new ArrayList<ScheduleNode>();
		srcNodes.add(leftNode);
		srcNodes.add(rightNode);

		JoinNode joinNode = new JoinNode();
		joinNode.setOn(join.getOn().toString());
		joinNode.setSrcNodes(srcNodes);

		leftNode.setDestNode(joinNode);
		rightNode.setDestNode(joinNode);

		SQLJoin.JoinType joinType = join.getJoinType();
		if (joinType == SQLJoin.JoinType.INNER) {
			joinNode.setJoinType(JoinType.INNER);
		} else if (joinType == SQLJoin.JoinType.LEFT) {
			joinNode.setJoinType(JoinType.RIGHT);
		} else if (joinType == SQLJoin.JoinType.RIGHT) {
			joinNode.setJoinType(JoinType.RIGHT);
		}

		return joinNode;
	}

	/*
	 * 访问cross join,构建Join节点
	 * 
	 * @param ast
	 * 
	 * @return
	 */
	private ScheduleNode visitCrossJoin(ISqlStruct ast) {
		SQLSelect select = (SQLSelect) ast;
		SQLBoolExpr where = select.getCriteria();
		where = ASTStructUtils.beatOrOut(where);
		List<SQLTabReference> fromTbls = select.getFromTbls();

		JoinNode node = new JoinNode();
		node.setJoinType(JoinType.CROSS);

		for (SQLTabReference tmp : fromTbls) {
			ScheduleNode childNode = this.visitTabRef(tmp);
			node.getSrcNodes().add(childNode);
			childNode.setDestNode(node);
		}

		node.setOn(where.toString());

		return node;
	}

	/*
	 * 访问可执行SQL,构建Scan节点
	 * 
	 * @param ast
	 * 
	 * @return
	 */
	private ScheduleNode visitScan(ISqlStruct ast) {
		SQLSelect select = (SQLSelect) ast;
		ScanNode scanNode = new ScanNode();
		scanNode.setSql(select.toString());
		return scanNode;
	}

	/*
	 * 访问group by关键字,构建Aggregate节点
	 * 
	 * @param ast
	 * 
	 * @return
	 */
	private ScheduleNode visitGroupBy(ISqlStruct ast) {
		SQLGroupBy groupBy = (SQLGroupBy) ast;
		String fields[] = groupBy.getFields();
		AggregateNode node = new AggregateNode();
		for (String tmp : fields) {
			node.getFields().add(tmp);
		}
		return node;
	}

	public boolean accept(ISqlStruct ast) {
		return SqlType.SELECT == ast.getSqlType();
	}

	public void setMetaDataService(IMetaDataService metaDataService) {
		this.metaDataService = metaDataService;
	}

}
