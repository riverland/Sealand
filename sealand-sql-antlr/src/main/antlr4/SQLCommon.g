/**
 * <p>
 * SQL中通用的语法
 */
grammar SQLCommon;
options {
  language=Java;
}

@header{
  package org.river.sealand.sql.syntex;
}

import Token;

statement
        : select_stmt
        | insert_clause
        | update_clause
        | delete_clause
        ;

select_stmt
        : select_clause ((UNION (ALL)?) select_clause)*
        ;
         
expr_stmt
        : expression
        | expression NEWLINE
        ;

/**DML**/
select_clause
        :SELECT        
        ( ALL | DISTINCT)? 
        select_list        
        FROM table_refs 
        ( where_clause )? 
        ( group_by_clause )?
        ( having_clause )?       
        ( order_by_clause )?
        ( limit_clause )?  
        ;

insert_clause
        : INSERT INTO sql_id sub_query
        | INSERT INTO sql_id VALUES LPAREN values_list RPAREN
        | INSERT INTO sql_id LPAREN column_list RPAREN sub_query
        | INSERT INTO sql_id LPAREN column_list RPAREN VALUES LPAREN values_list RPAREN
        ;
        
update_clause: UPDATE sql_id SET set_list (where_clause)?;

delete_clause: DELETE FROM sql_id (where_clause)?;

values_list: expression (COMMA expression)* ;
select_list: ( display_column ( COMMA display_column )*) ;
column_list: sql_id (COMMA sql_id)*;
set_list: set_clause(COMMA set_clause)*;
set_clause: sql_id EQ expression;        
where_clause: WHERE criteria ;
having_clause: HAVING criteria ;
group_by_clause: GROUP_BY group_by_item (COMMA group_by_item)*  ;
group_by_item: sql_id | INT ;
order_by_clause: ORDER_BY order_by_item (COMMA order_by_item)* ;
order_by_item: (sql_id | INT) (ASC | DESC)? ;
limit_clause: LIMIT ((INT COMMA)? INT);

display_column 
        : expression
        | expression(sql_id)? 
        | expression(AS sql_id)?
        | case_when_clause
        | sql_id DOT ASTERISK
        | ASTERISK
        | sql_id
        ;
        
criteria
        : criteria ((AND|OR)  criteria)+
        | LPAREN criteria RPAREN
        | NOT criteria
        | expression (EQ|GT|LT|GE|LE|LIKE) expression
        | between_expr
        | in_expr
        | exist_expr  
        ;
        
between_expr  
        : expression BETWEEN  expression AND expression
        ;
        
exist_expr
        : EXIST sub_query
        | EXIST LPAREN sub_query RPAREN
        ;
        
in_expr
        : expression IN LPAREN values_list RPAREN
        | expression IN sub_query
        | expression IN LPAREN sub_query RPAREN
        ;
        
expression
        : expression (ASTERISK|DIV) expression
        | expression (PLUS|MINUS) expression  
        | LPAREN expression RPAREN
        | sql_id LPAREN expression(COMMA expression)* RPAREN
        | sql_id LPAREN RPAREN 
        | char_literal
        | number
        | sql_id  
        ;
        
case_when_clause
        : case_when_clause_0 
        | case_when_clause_1
        ;
        
case_when_clause_0:
        CASE
        ( WHEN expression THEN expression)+
        ( ELSE expression )?
        END
        ;
        
case_when_clause_1:
        CASE expression
        ( WHEN expression THEN expression )+
        ( ELSE expression )?
        END
        ;
        
table_refs: table_atom (COMMA table_atom)*;
        
table_atom
        : sql_id (sql_id)?
        | sql_id (AS sql_id)?
        | sub_query (sql_id)?
        | sub_query (AS sql_id)?
        | table_atom (  (LEFT|RIGHT) (OUTER)? JOIN table_atom join_condition)+
        ;
        
join_condition: ON criteria;

sub_query
        : LPAREN select_clause RPAREN
        ;
        
literal_value
        : char_literal 
        | (PLUS|MINUS)?(INT|FLOAT)
        | HEX 
        | BOOLEAN 
        | BIT 
        | NULL
        ;
        
//number:(INT DOT INT | INT DOT | DOT INT | INT  )(E_SYM(PLUS | MINUS )? INT)? ;    
number: (PLUS|MINUS)? (INT| FLOAT) ; 
char_literal: CHAR_LITERAL;

/**DDL**/

sql_id :( ( ID DOT )? ID DOT )? (ID|ASTERISK) ; 