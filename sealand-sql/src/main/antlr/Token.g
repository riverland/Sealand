lexer grammar Token;

fragment DIGIT:[0-9] ;      
fragment FIRST_ID_CHAR :[a-zA-Z_$] ;
fragment ID_CHAR : [a-zA-Z_0-9] ;
fragment HEX_DIGIT:[a-fA-F0-9] ;
fragment APOSTROPHE: '\'';
fragment QUOT:'\"';
fragment A_ :        'a' | 'A';
fragment B_ :        'b' | 'B';
fragment C_ :        'c' | 'C';
fragment D_ :        'd' | 'D';
fragment E_ :        'e' | 'E';
fragment F_ :        'f' | 'F';
fragment G_ :        'g' | 'G';
fragment H_ :        'h' | 'H';
fragment I_ :        'i' | 'I';
fragment J_ :        'j' | 'J';
fragment K_ :        'k' | 'K';
fragment L_ :        'l' | 'L';
fragment M_ :        'm' | 'M';
fragment N_ :        'n' | 'N';
fragment O_ :        'o' | 'O';
fragment P_ :        'p' | 'P';
fragment Q_ :        'q' | 'Q';
fragment R_ :        'r' | 'R';
fragment S_ :        's' | 'S';
fragment T_ :        't' | 'T';
fragment U_ :        'u' | 'U';
fragment V_ :        'v' | 'V';
fragment W_ :        'w' | 'W';
fragment X_ :        'x' | 'X';
fragment Y_ :        'y' | 'Y';
fragment Z_ :        'z' | 'Z';

/*charset*/ 
ARMSCII8: A_ R_ M_ S_ C_ I_ I_ '8';
ASCII: A_ S_ C_ I_ I_ ;
BIG5: B_ I_ G_ '5';
BINARY: B_ I_ N_ A_ R_ Y_ ;
CP1250: C_ P_ '1250';
CP1251: C_ P_ '1251';
CP1256: C_ P_ '1256';
CP1257: C_ P_ '1257';
CP850: C_ P_ '850';
CP852: C_ P_ '852';
CP866: C_ P_ '866';
CP932: C_ P_ '932';
DEC8: D_ E_ C_ '8';
EUCJPMS: E_ U_ C_ J_ P_ M_ S_ ;
EUCKR: E_ U_ C_ K_ R_ ;
GB2312: G_ B_ '2312';
GBK: G_ B_ K_ ;
GEOSTD8: G_ E_ O_ S_ T_ D_ '8';
GREEK: G_ R_ E_ E_ K_ ;
HEBREW: H_ E_ B_ R_ E_ W_ ;
HP8: H_ P_ '8';
KEYBCS2: K_ E_ Y_ B_ C_ S_ '2';
KOI8R: K_ O_ I_ '8'R_ ;
KOI8U: K_ O_ I_ '8'U_ ;
LATIN1: L_ A_ T_ I_ N_ '1';
LATIN2: L_ A_ T_ I_ N_ '2';
LATIN5: L_ A_ T_ I_ N_ '5';
LATIN7: L_ A_ T_ I_ N_ '7';
MACCE: M_ A_ C_ C_ E_ ;
MACROMAN: M_ A_ C_ R_ O_ M_ A_ N_ ;
SJIS: S_ J_ I_ S_ ;
SWE7: S_ W_ E_ '7';
TIS620: T_ I_ S_ '620';
UCS2: U_ C_ S_ '2';
UJIS: U_ J_ I_ S_ ;
UTF8: U_ T_ F_ '8';

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
E_SYM:E_ ;      
SELECT:   S_ E_ L_ E_ C_ T_ ;
INSERT:   I_ N_ S_ E_ R_ T_ ;
UPDATE:   U_ P_ D_ A_ T_ E_ ;
DELETE:   D_ E_ L_ E_ T_ E_ ;
INTO:     I_ N_ T_ O_ ;
SET:      S_ E_ T_ ;
FROM:     F_ R_ O_ M_ ;
UNION:    U_ N_ I_ O_ N_ ;
UNION_ALL:U_ N_ I_ O_ N_ (' '|'\t')+A_ L_ L_ ;
ALL:      A_ L_ L_ ;
DISTINCT: D_ I_ S_ T_ I_ N_ C_ T_ ;
GROUP_BY: G_ R_ O_ U_ P_ (' '|'\t')+B_ Y_ ;
HAVING:   H_ A_ V_ I_ N_ G_ ;
WHERE:    W_ H_ E_ R_ E_ ;
ON:       O_ N_ ;
ORDER_BY: O_ R_ D_ E_ R_ (' '|'\t')+B_ Y_ ;
LIMIT:    L_ I_ M_ I_ T_ ;
AS:       A_ S_ ;
CASE:     C_ A_ S_ E_ ;
WHEN:     W_ H_ E_ N_ ;
ELSE:     E_ L_ S_ E_ ;
THEN:     T_ H_ E_ N_ ;
INNER:    I_ N_ N_ E_ R_ ;
JOIN:     J_ O_ I_ N_ ;
ASC:      A_ S_ C_ ;
DESC:     D_ E_ S_ C_ ;
END:      E_ N_ D_ ;
LEFT:     L_ E_ F_ T_ ;
RIGHT:    R_ I_ G_ H_ T_ ;
OUTER:    O_ U_ T_ E_ R_ ;
NOT:      N_ O_ T_ ;
AND:      A_ N_ D_ ;
OR:       O_ R_ ;
IN:       I_ N_ ;
EXIST:    E_ X_ I_ S_ T_ ;
BETWEEN:  B_ E_ T_ W_ E_ E_ N_ ;
NULL:     N_ U_ L_ L_ ;
VALUES:   V_ A_ L_ U_ E_ S_ ;

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
