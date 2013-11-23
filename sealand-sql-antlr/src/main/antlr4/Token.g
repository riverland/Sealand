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
ARMSCII8: A_R_M_S_C_I_I_'8';
ASCII: A_S_C_I_I_;
BIG5: B_I_G_'5';
BINARY: B_I_N_A_R_Y_;
CP1250: C_P_'1250';
CP1251: C_P_'1251';
CP1256: C_P_'1256';
CP1257: C_P_'1257';
CP850: C_P_'850';
CP852: C_P_'852';
CP866: C_P_'866';
CP932: C_P_'932';
DEC8: D_E_C_'8';
EUCJPMS: E_U_C_J_P_M_S_;
EUCKR: E_U_C_K_R_;
GB2312: G_B_'2312';
GBK: G_B_K_;
GEOSTD8: G_E_O_S_T_D_'8';
GREEK: G_R_E_E_K_;
HEBREW: H_E_B_R_E_W_;
HP8: H_P_'8';
KEYBCS2: K_E_Y_B_C_S_'2';
KOI8R: K_O_I_'8'R_;
KOI8U: K_O_I_'8'U_;
LATIN1: L_A_T_I_N_'1';
LATIN2: L_A_T_I_N_'2';
LATIN5: L_A_T_I_N_'5';
LATIN7: L_A_T_I_N_'7';
MACCE: M_A_C_C_E_;
MACROMAN: M_A_C_R_O_M_A_N_;
SJIS: S_J_I_S_;
SWE7: S_W_E_'7';
TIS620: T_I_S_'620';
UCS2: U_C_S_'2';
UJIS: U_J_I_S_;
UTF8: U_T_F_'8';

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
E_SYM:E_;      
SELECT:   S_E_L_E_C_T_;
INSERT:   I_N_S_E_R_T_;
UPDATE:   U_P_D_A_T_E_;
DELETE:   D_E_L_E_T_E_;
INTO:     I_N_T_O_;
SET:      S_E_T_
FROM:     F_R_O_M_;
UNION:    U_N_I_O_N_;
UNION_ALL:U_N_I_O_N_(' '|'\t')+A_L_L_;
ALL:      A_L_L_;
DISTINCT: D_I_S_T_I_N_C_T_;
GROUP_BY: G_R_O_U_P_(' '|'\t')+B_Y_;
HAVING:   H_A_V_I_N_G_;
WHERE:    W_H_E_R_E_;
ON:       O_N_;
ORDER_BY: O_R_D_E_R_(' '|'\t')+B_Y_;
LIMIT:    L_I_M_I_T_;
AS:       A_S_;
CASE:     C_A_S_E_;
WHEN:     W_H_E_N_;
ELSE:     E_L_S_E_;
THEN:     T_H_E_N_;
INNER:    I_N_N_E_R_;
JOIN:     J_O_I_N_;
ASC:      A_S_C_;
DESC:     D_E_S_C_;
END:      E_N_D_;
LEFT:     L_E_F_T_;
RIGHT:    R_I_G_H_T_;
OUTER:    O_U_T_E_R_;
NOT:      N_O_T_;
AND:      A_N_D_;
OR:       O_R_;
IN:       I_N_;
EXIST:    E_X_I_S_T_;
BETWEEN:  B_E_T_W_E_E_N_;
NULL:     N_U_L_L_;
VALUES:   V_A_L_U_E_S_;

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
