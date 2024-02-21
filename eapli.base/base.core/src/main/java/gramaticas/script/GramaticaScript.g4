grammar GramaticaScript;



FICHEIRO_TOKEN: '-FICHEIRO';

CONSULTAR:'-CONSULTAR P_';
ATUALIZAR:'-ATUALIZAR P_';
NOVA_INFO:'-INFO P_';

SE : '-SE';

REMETENTE: '-REMETENTE';
PASSWORD: '-PASSWORD';
ASSUNTO:'-ASSUNTO';
CORPO: '-CORPO';
DESTINATARIO: '-DESTINATARIO P_';


INT: '0'|[1-9][0-9]*;

WORD: [a-zA-Z]+;

EMAIL: TEXTO'@'TEXTO'.'TEXTO;

TEXTO:  WORD (' '?(WORD | SPECIAL | INT)+)*;

SPECIAL: [\\:€£$#%&!?.,];

UNDER:'_';

ADQUIRIR: '~~';

SPACE: [ ]+ ->skip;
WS: [\t\r\n]+ -> skip;

start: continuee;

continuee: /* vazio */ | consultar continuee | realizar continuee | enviar continuee | atribuir continuee;

consultar: FICHEIRO_TOKEN '"' varFicheiro=TEXTO '"' opcoesFicheiro ;
opcoesFicheiro: CONSULTAR idVar=INT '"' parametroVar=WORD  '"' #consultarFile
               | ATUALIZAR idVar=INT '"' parametroVar=WORD '"' NOVA_INFO idVar2=INT #atualizarFile
               | '-ATUALIZAR' '"' parametroVar=WORD  '"'  '"' fulltext  '"'  '"' parametroVar2=WORD '"' INT #atualizarSomaFile;


realizar : op=('-SUM'| '-DIV' | '-SUB' | '-MUL') operacao #calculo| SE se #if;
operacao:  opcoes  opcoes;
se: verificarCondicao funcionalidade;
verificarCondicao:opcoes operadores opcoes ;
opcoes: FICHEIRO_TOKEN  '"'varFicheiro=TEXTO'"'  CONSULTAR idVar=INT '"'parametroVar=WORD'"'  #numberFile
        | 'P_'  idVar=INT #atributoForm | INT #inteiro | '"'WORD '"' #textoOpcao | '-"'fulltext'"' #atribuirOp;
operadores: '-MAIOR'| '-MENOR' | '-IGUAL' | '-MESMO';
funcionalidade: consultar | enviar | realizar | atribuir;



enviar: REMETENTE '"' varEmail = EMAIL '"'  PASSWORD '"'varPassword=fulltext'"' ASSUNTO '"'varAssunto=fulltext'"' CORPO '"'corpo'"' DESTINATARIO idVar=INT #email;
corpo: #blank| fulltext corpo #texto| adquirir corpo #opcoesAdquirir;
fulltext: INT TEXTO| WORD TEXTO | WORD |TEXTO | SPECIAL TEXTO | INT | SPECIAL;
adquirir: ADQUIRIR '(' adquirirOpcoes ')';
adquirirOpcoes: opcoes | realizar | consultar | atribuir;

atribuir: '-ATRIBUIR' '-"'fulltext'"' atribuirOpcoes;
atribuirOpcoes:opcoes | realizar ;