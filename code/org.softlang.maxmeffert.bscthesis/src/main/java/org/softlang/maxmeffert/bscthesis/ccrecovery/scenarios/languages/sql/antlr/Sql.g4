grammar Sql;

sqlDocument
    : sqlStatements
    ;

sqlStatement
    : sqlDdlStatement
    |.?
    ;

sqlStatements
    : sqlStatement ( NEWLINE sqlStatement )*
    ;

sqlDdlStatement
    : sqlCreateTableStatement
    ;

sqlDmlStatement
    : sqlInsertStatement
    ;

sqlCreateTableStatement
    : K_CREATE K_TABLE sqlTableName OPEN_PAR sqlColumnDefinitions (COMMA sqlTableConstraints)? CLOSE_PAR sqlTableEngine?
    ;

sqlTableName
    : identifier
    ;

sqlColumnDefinitions
    : sqlColumnDefinition ( COMMA sqlColumnDefinition )*
    ;

sqlColumnDefinition
    : sqlColumnName sqlColumnType sqlColumnConstrain?
    ;

sqlColumnName
    : identifier
    ;

sqlColumnNames
    : sqlColumnName ( COMMA sqlColumnName )*
    ;

sqlColumnType
    : sqlColumnTypeName ( OPEN_PAR signedNumber CLOSE_PAR )?
    ;

sqlColumnTypeName
    : identifier+
    ;

sqlColumnConstrain
    : K_NOT? K_NULL
    ;

sqlTableConstraint
    : K_PRIMARY K_KEY OPEN_PAR sqlColumnName ( COMMA sqlColumnName )* CLOSE_PAR
    | .?
    ;
sqlTableConstraints
    : sqlTableConstraint (COMMA sqlTableConstraint)*
    ;

sqlTableEngine
    : K_ENGINE ASSIGN sqlTableEngineName
    ;

sqlTableEngineName
    : identifier
    ;

sqlAlterTableStatement
    : K_ALTER K_TABLE sqlTableName sqlAddTableConstraint
    ;

sqlAddTableConstraint
    : K_ADD K_CONSTRAIN identifier K_FOREIGN K_KEY OPEN_PAR sqlColumnNames CLOSE_PAR K_REFERENCES sqlTableName OPEN_PAR sqlColumnNames CLOSE_PAR
    ;

sqlInsertStatement
    : K_INSERT K_INTO sqlTableName K_VALUES OPEN_PAR signedNumber ( COMMA signedNumber )* CLOSE_PAR
    ;

identifier
    : IDENTIFIER
    ;

signedNumber
 : ( '+' | '-' )? NUMERIC_LITERAL
 ;

K_ALTER : A L T E R;
K_ADD : A D D;
K_CREATE : C R E A T E;
K_COLUMN : C O L U M N;
K_CONSTRAIN : C O N S T R A I N T;
K_FOREIGN : F O R E I G N;
K_REFERENCES : R E F E R E N C E S;
K_TABLE : T A B L E;
K_ENGINE : E N G I N E;
K_NOT : N O T;
K_NULL : N U L L;
K_PRIMARY : P R I M A R Y;
K_KEY : K E Y;
K_INSERT : I N S E R T;
K_INTO : I N T O;
K_VALUES : V A L U E S;

SCOL : ';';
DOT : '.';
OPEN_PAR : '(';
CLOSE_PAR : ')';
COMMA : ',';
ASSIGN : '=';
STAR : '*';
PLUS : '+';
MINUS : '-';
TILDE : '~';
PIPE2 : '||';
DIV : '/';
MOD : '%';
LT2 : '<<';
GT2 : '>>';
AMP : '&';
PIPE : '|';
LT : '<';
LT_EQ : '<=';
GT : '>';
GT_EQ : '>=';
EQ : '==';
NOT_EQ1 : '!=';
NOT_EQ2 : '<>';
NEWLINE : [\r\n];


IDENTIFIER
 : '"' (~'"' | '""')* '"'
 | '`' (~'`' | '``')* '`'
 | '[' ~']'* ']'
 | [a-zA-Z_] [a-zA-Z_0-9]* // TODO check: needs more chars in set
 ;

 NUMERIC_LITERAL
  : DIGIT+ ( '.' DIGIT* )? ( E [-+]? DIGIT+ )?
  | '.' DIGIT+ ( E [-+]? DIGIT+ )?
  ;

SPACES
    : [ \u000B\t\r\n] -> channel(HIDDEN)
    ;

fragment DIGIT : [0-9];

fragment A : [aA];
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];