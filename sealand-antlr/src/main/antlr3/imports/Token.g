lexer grammar Token;

fragment DIGIT:[0-9] ;      
fragment FIRST_ID_CHAR :[a-zA-Z_$] ;
fragment ID_CHAR : [a-zA-Z_0-9] ;
fragment HEX_DIGIT:[a-fA-F0-9] ;
fragment APOSTROPHE: '\'';
fragment QUOT:'\"';

/*charset*/ 
ARMSCII8 :'armscii8'|'ARMSCII8';
ASCII :'ascii'|'ASCII';
BIG5  :'big5'|'BIG5';
BINARY :'binary'|'BINARY';
CP1250 :'cp1250'|'CP1250';
CP1251 :'cp1251'|'CP1251';
CP1256 :'cp1256'|'CP1256';
CP1257 :'cp1257'|'CP1257';
CP850  :'cp850' |'CP850';
CP852  :'cp852' |'CP852';
CP866  :'cp866' |'CP866';
CP932  :'cp932' |'CP932';
DEC8   :'dec8'  |'DEC8';
EUCJPMS:'eucjpms'|'EUCJPMS';
EUCKR  :'euckr' |'EUCKR';
GB2312 :'gb2312'|'GB2312';
GBK    :'gbk'   |'GBK';
GEOSTD8:'geostd8'|'GEOSTD8';
GREEK  :'greek' |'GREEK';
HEBREW :'hebrew'|'HEBREW';
HP8    :'hp8'   |'HP8';
KEYBCS2:'keybcs2'  |'KEYBCS2';
KOI8R  :'koi8r' |'KOI8R';
KOI8U  :'koi8u' |'KOI8U';
LATIN1 :'latin1'|'LATIN1';
LATIN2 :'latin2'|'LATIN2';
LATIN5 :'latin5'|'LATIN5';
LATIN7 :'latin7'|'LATIN7';
MACCE  :'macce' |'MACCE';
MACROMAN  :'macroman'|'MACROMAN';
SJIS   :'sjis' |'SJIS';
SWE7   :'swec' |'SWE7';
TIS620 :'tis620' |'TIS620';
UCS2   :'ucs2' |'UCS2';
UJIS   :'ujis' |'UJIS';
UTF8   :'utf8' |'UTF8';

CHARSET_NAME
        : ARMSCII8
        | ASCII
        | BIG5
        | BINARY
        | CP1250
        | CP1251
        | CP1256
        | CP1257
        | CP850
        | CP852
        | CP866
        | CP932
        | DEC8
        | EUCJPMS
        | EUCKR
        | GB2312
        | GBK
        | GEOSTD8
        | GREEK
        | HEBREW
        | HP8
        | KEYBCS2
        | KOI8R
        | KOI8U
        | LATIN1
        | LATIN2
        | LATIN5
        | LATIN7
        | MACCE
        | MACROMAN
        | SJIS
        | SWE7
        | TIS620
        | UCS2
        | UJIS
        | UTF8;
 
/**SQL keyword*/        
E_:'e'|'E';        
SELECT : 'select'|'SELECT';
INSERT: 'insert'|'INSERT';
UPDATE: 'update'|'UPDATE';
DELETE: 'delete'|'DELETE';
SET:'set'|'SET';
FROM:'from'|'FROM';
UNION  : 'union' | 'UNION';
ALL    : 'all'|'ALL';
DISTINCT :'distinct'|'DISTINCT';
GROUP_BY :'group by'|'GROUP BY';
HAVING :'having'|'HAVING';
WHERE  : 'where'|'WHERE';
ON:'on'|'ON';
ORDER_BY :'order by'|'ORDER BY';
LIMIT : 'limit'|'LIMIT';
AS : 'as'|'AS';
CASE: 'case'|'CASE';
WHEN: 'when'|'WHEN';
ELSE: 'else'|'ELSE';
THEN: 'then'|'THEN';
INNER: 'inner'|'INNER';
JOIN: 'join'|'JOIN';
ASC: 'asc'|'ASC';
DESC: 'desc'|'DESC';
END: 'end'|'END';
LEFT: 'left'|'LEFT';
RIGHT: 'right'|'RIGHT';
OUTER:'outer'|'OUTER';
NOT: 'not'|'NOT';
AND: 'and'|'AND';
OR:  'or'|'OR';
IN:  'in'|'IN';
EXIST:'exist'|'EXIST';
BETWEEN:'between'|'BETWEEN';
NULL:'null'|'NULL';
VALUES:'values'|'VALUES';

/**常见操作符*/
DOT :'.';
VERTICAL_BAR:'|';
DOUBLE_VERTICAL_BAR:'||';
PLUS:'+';
DIV:'/';
MINUS:'-';
PERCENT:'%';
COMMA:',';
SEMI: ';' ;
COLON: ':' ;
RBRACK: ']' ;
LBRACK: '[' ;
NEGATION: '~' ;
BITAND: '&' ;
POWER_OP: '^' ;
LPAREN: '(';
RPAREN: ')';
ASTERISK:'*';
GT:'>';
GE:'>=';
EQ:'=';
LT:'<';
LE:'<=';
LIKE:'like'|'LIKE'; 

/**标识符*/  
ID: FIRST_ID_CHAR+ DIGIT*; 
        
/**基本数据类型*/
INT : DIGIT+ ;
FLOAT: DIGIT+ '.' DIGIT+ ;

CHAR_LITERAL
        :('\''
            (
                ('\\' '\\')
                |('\'' '\'') 
                | ('\\' '\'') 
                | ~('\'') 
             )* '\''  
         )                
        |('\"'
            ( 
                ('\\' '\\') 
                | ('\"' '\"') 
                | ('\\' '\"') 
                | ~('\"') 
            )* '\"' 
        )
        ; 

HEX
        : '0x' (HEX_DIGIT)+ 
        | 'X' '\''(HEX_DIGIT)+ '\''
        ;

BIT
        :('0b'('0'|'1')+)
        |('B' '\'' ('0'|'1')+'\'') 
        ;
        
BOOLEAN:'true'|'TRUE'|'false'|'FALSE';

NEWLINE:  '\r'? '\n' ;
WS  : [ \t|\r|\n]+ -> skip;
