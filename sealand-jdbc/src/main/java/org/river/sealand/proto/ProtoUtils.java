package org.river.sealand.proto;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.river.sealand.jdbc.support.Field;
import org.river.sealand.jdbc.support.IParams;
import org.river.sealand.jdbc.support.IQuery;
import org.river.sealand.utils.ArrayUtils;
import org.river.sealand.utils.NumberUtils;

/**
 * <p>
 * 协议包工具类
 * 
 * @author river
 * @since Dec 18, 2013
 */
public class ProtoUtils {
	private static final int MSG_LEN_SIZE = 4;
	private static final int MSG_TYPE_SIZE = 1;
	private static final int MSG_HEAD_SIZE = 5;

	/**
	 * <p>
	 * 构建执行消息
	 * 
	 * @param query
	 * @param params
	 * @return
	 */
	public static byte[] pack4ExecMsg(IQuery query, IParams params) {
		return null;
	}

	/**
	 * <p>
	 * 解析行描述消息
	 * 
	 * @param msg
	 * @return
	 */
	public static List<Field> decodeRowDescMsg(Message msg) {
		byte[] data = msg.getData();
		int pos = RowDescProtoDef.FRAG_FLD_NUM_INDEX;
		byte[] fldNumByte = ArrayUtils.subarray(data, pos, pos + RowDescProtoDef.FRAG_FLD_NUM_SIZE);

		int fldNum = NumberUtils.readInt2(fldNumByte);
		pos = +RowDescProtoDef.FRAG_FLD_NUM_SIZE;

		List<Field> fields = new ArrayList<Field>();
		for (int i = 0; i < fldNum; i++) {
			Field fld = new Field();
			int fragLen = NumberUtils.readInt2(ArrayUtils.subarray(data, pos, pos + 2));
			pos = +2;
			String label = new String(ArrayUtils.subarray(data, pos, pos + fragLen), Charset.forName("UTF-8"));
			fld.setLabel(label);
			pos = +fragLen;

			fragLen = NumberUtils.readInt2(ArrayUtils.subarray(data, pos, pos + 2));
			pos = +2;
			String tabName = new String(ArrayUtils.subarray(data, pos, pos + fragLen), Charset.forName("UTF-8"));
			fld.setTableName(tabName);
			pos = +fragLen;

			fragLen = NumberUtils.readInt2(ArrayUtils.subarray(data, pos, pos + 2));
			pos = +2;
			String schemeName = new String(ArrayUtils.subarray(data, pos, pos + fragLen), Charset.forName("UTF-8"));
			fld.setSchemaName(schemeName);
			pos = +fragLen;

			int typeOid = NumberUtils.readInt4(ArrayUtils.subarray(data, pos, pos + 4));
			Type type = Type.fromOid(typeOid);
			fld.setType(type);
			pos = +4;

			int colLen = NumberUtils.readInt4(ArrayUtils.subarray(data, pos, pos + 4));
			fld.setLength(colLen);
			pos = +4;

			int posIndexInTable = NumberUtils.readInt2(ArrayUtils.subarray(data, pos, pos + 2));
			fld.setPosIndexInTable(posIndexInTable);
			pos = +2;

			// TODO nullable autoIncrement

		}
		return fields;
	}

	/**
	 * <p>
	 * 解析行数据消息
	 * 
	 * @param msg
	 * @return
	 */
	public static byte[][] decodeRowData(Message msg) {
		byte[] data = msg.getData();
		int pos = RowDataProtoDef.FRAG_COL_NUM_INDEX;
		byte[] colNumByte = ArrayUtils.subarray(data, pos, pos + RowDataProtoDef.FRAG_COL_NUM_INDEX);

		int colNum = NumberUtils.readInt2(colNumByte);
		pos = +RowDataProtoDef.FRAG_COL_NUM_INDEX;

		byte[][] cols = new byte[colNum][];
		for (int i = 0; i < colNum; i++) {
			int fragLen = NumberUtils.readInt4(ArrayUtils.subarray(data, pos, pos + 4));
			pos = +4;
			cols[i] = ArrayUtils.subarray(data, pos, pos + fragLen);
			pos = +fragLen;
		}
		return cols;
	}
}
