grammar FormularioGrammar;

prog: stat;

stat: linha | linha stat;

linha: nome = regraNome ';' expressaoRegular = regraExpressao ';' tipo = regraTipo ';' resposta = regraResposta ';' obrigatoriedade = WORD ';';

regraNome: WORD | FRASE;
regraExpressao: | (WORD | SPECIAL)+;
regraTipo: 'String' | 'Inteiro' | 'InteiroUnico' | 'Boolean' | 'Data' | 'Ficheiro' | 'Periodo' | 'Soma' | 'Subtracao' | 'Igual' | 'Multipla';
regraResposta: | WORD | INT | DATA | PERIODO | FRASE | alternativa;

alternativa: 'Ate Data Limite' #mudarObrigatoriedade | 'Unica' #mudarObrigatoriedade | 'Justificada' #mudarObrigatoriedade;


PERIODO: DATA PONTO DATA;
DATA: INT'/'INT'/'INT;

FRASE: (WORD ESPACO WORD)+;

PONTO: '.' | ',';
ESPACO: ' ';
HIFEN: '-';
CHAVETAS: '[' | ']' | '{' | '}';
ARROBA: '@';

WORD: (LETRA | INT | HIFEN | CHAVETAS | PONTO | ARROBA)+;

LETRA: [a-zA-Z]+;
//SPECIAL: [\\:€£$#%&!?._];
SPECIAL: [\\:€£$#%&!?_];
INT: [0-9]+;

