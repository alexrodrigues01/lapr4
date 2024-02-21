// Generated from C:/Users/RALEX/Documents/Reposit�rios 4� Semestre/LAPR4/lei20_21_s4_2dj_03/eapli.base/base.gramaticas/src/main/java/eapli/base/gramaticas/script/eapli/base/gramaticas/script\GramaticaScript.g4 by ANTLR 4.9.1
package eapli.base.gramaticas.script.eapli.base.gramaticas.script;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GramaticaScriptLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, FICHEIRO_TOKEN=14, CONSULTAR=15, 
		ATUALIZAR=16, NOVA_INFO=17, SE=18, REMETENTE=19, PASSWORD=20, ASSUNTO=21, 
		CORPO=22, DESTINATARIO=23, INT=24, WORD=25, EMAIL=26, TEXTO=27, SPECIAL=28, 
		UNDER=29, ADQUIRIR=30, SPACE=31, WS=32;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "FICHEIRO_TOKEN", "CONSULTAR", "ATUALIZAR", 
			"NOVA_INFO", "SE", "REMETENTE", "PASSWORD", "ASSUNTO", "CORPO", "DESTINATARIO", 
			"INT", "WORD", "EMAIL", "TEXTO", "SPECIAL", "UNDER", "ADQUIRIR", "SPACE", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\"'", "'-ATUALIZAR'", "'-SUM'", "'-DIV'", "'-SUB'", "'-MUL'", 
			"'P_'", "'-MAIOR'", "'-MENOR'", "'-IGUAL'", "'-MESMO'", "'('", "')'", 
			"'-FICHEIRO'", "'-CONSULTAR P_'", "'-ATUALIZAR P_'", "'-INFO P_'", "'-SE'", 
			"'-REMETENTE'", "'-PASSWORD'", "'-ASSUNTO'", "'-CORPO'", "'-DESTINATARIO P_'", 
			null, null, null, null, null, "'_'", "'~~'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "FICHEIRO_TOKEN", "CONSULTAR", "ATUALIZAR", "NOVA_INFO", 
			"SE", "REMETENTE", "PASSWORD", "ASSUNTO", "CORPO", "DESTINATARIO", "INT", 
			"WORD", "EMAIL", "TEXTO", "SPECIAL", "UNDER", "ADQUIRIR", "SPACE", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public GramaticaScriptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GramaticaScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\"\u0127\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\7\31\u00f3\n\31\f\31"+
		"\16\31\u00f6\13\31\3\32\6\32\u00f9\n\32\r\32\16\32\u00fa\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\5\34\u0105\n\34\3\34\3\34\3\34\6\34\u010a\n"+
		"\34\r\34\16\34\u010b\7\34\u010e\n\34\f\34\16\34\u0111\13\34\3\35\3\35"+
		"\3\36\3\36\3\37\3\37\3\37\3 \6 \u011b\n \r \16 \u011c\3 \3 \3!\6!\u0122"+
		"\n!\r!\16!\u0123\3!\3!\2\2\"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"\3\2\b\3\2\63;\3\2\62;\4\2C\\c|\16"+
		"\2##%(..\60\60<<AA^^\u00a5\u00a5\u00ae\u00ae\u00c4\u00c4\u00e4\u00e4\u201c"+
		"\u201c\3\2\"\"\4\2\13\f\17\17\2\u012f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"+
		"\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3"+
		"\2\2\2\3C\3\2\2\2\5E\3\2\2\2\7P\3\2\2\2\tU\3\2\2\2\13Z\3\2\2\2\r_\3\2"+
		"\2\2\17d\3\2\2\2\21g\3\2\2\2\23n\3\2\2\2\25u\3\2\2\2\27|\3\2\2\2\31\u0083"+
		"\3\2\2\2\33\u0085\3\2\2\2\35\u0087\3\2\2\2\37\u0091\3\2\2\2!\u009f\3\2"+
		"\2\2#\u00ad\3\2\2\2%\u00b6\3\2\2\2\'\u00ba\3\2\2\2)\u00c5\3\2\2\2+\u00cf"+
		"\3\2\2\2-\u00d8\3\2\2\2/\u00df\3\2\2\2\61\u00f0\3\2\2\2\63\u00f8\3\2\2"+
		"\2\65\u00fc\3\2\2\2\67\u0102\3\2\2\29\u0112\3\2\2\2;\u0114\3\2\2\2=\u0116"+
		"\3\2\2\2?\u011a\3\2\2\2A\u0121\3\2\2\2CD\7$\2\2D\4\3\2\2\2EF\7/\2\2FG"+
		"\7C\2\2GH\7V\2\2HI\7W\2\2IJ\7C\2\2JK\7N\2\2KL\7K\2\2LM\7\\\2\2MN\7C\2"+
		"\2NO\7T\2\2O\6\3\2\2\2PQ\7/\2\2QR\7U\2\2RS\7W\2\2ST\7O\2\2T\b\3\2\2\2"+
		"UV\7/\2\2VW\7F\2\2WX\7K\2\2XY\7X\2\2Y\n\3\2\2\2Z[\7/\2\2[\\\7U\2\2\\]"+
		"\7W\2\2]^\7D\2\2^\f\3\2\2\2_`\7/\2\2`a\7O\2\2ab\7W\2\2bc\7N\2\2c\16\3"+
		"\2\2\2de\7R\2\2ef\7a\2\2f\20\3\2\2\2gh\7/\2\2hi\7O\2\2ij\7C\2\2jk\7K\2"+
		"\2kl\7Q\2\2lm\7T\2\2m\22\3\2\2\2no\7/\2\2op\7O\2\2pq\7G\2\2qr\7P\2\2r"+
		"s\7Q\2\2st\7T\2\2t\24\3\2\2\2uv\7/\2\2vw\7K\2\2wx\7I\2\2xy\7W\2\2yz\7"+
		"C\2\2z{\7N\2\2{\26\3\2\2\2|}\7/\2\2}~\7O\2\2~\177\7G\2\2\177\u0080\7U"+
		"\2\2\u0080\u0081\7O\2\2\u0081\u0082\7Q\2\2\u0082\30\3\2\2\2\u0083\u0084"+
		"\7*\2\2\u0084\32\3\2\2\2\u0085\u0086\7+\2\2\u0086\34\3\2\2\2\u0087\u0088"+
		"\7/\2\2\u0088\u0089\7H\2\2\u0089\u008a\7K\2\2\u008a\u008b\7E\2\2\u008b"+
		"\u008c\7J\2\2\u008c\u008d\7G\2\2\u008d\u008e\7K\2\2\u008e\u008f\7T\2\2"+
		"\u008f\u0090\7Q\2\2\u0090\36\3\2\2\2\u0091\u0092\7/\2\2\u0092\u0093\7"+
		"E\2\2\u0093\u0094\7Q\2\2\u0094\u0095\7P\2\2\u0095\u0096\7U\2\2\u0096\u0097"+
		"\7W\2\2\u0097\u0098\7N\2\2\u0098\u0099\7V\2\2\u0099\u009a\7C\2\2\u009a"+
		"\u009b\7T\2\2\u009b\u009c\7\"\2\2\u009c\u009d\7R\2\2\u009d\u009e\7a\2"+
		"\2\u009e \3\2\2\2\u009f\u00a0\7/\2\2\u00a0\u00a1\7C\2\2\u00a1\u00a2\7"+
		"V\2\2\u00a2\u00a3\7W\2\2\u00a3\u00a4\7C\2\2\u00a4\u00a5\7N\2\2\u00a5\u00a6"+
		"\7K\2\2\u00a6\u00a7\7\\\2\2\u00a7\u00a8\7C\2\2\u00a8\u00a9\7T\2\2\u00a9"+
		"\u00aa\7\"\2\2\u00aa\u00ab\7R\2\2\u00ab\u00ac\7a\2\2\u00ac\"\3\2\2\2\u00ad"+
		"\u00ae\7/\2\2\u00ae\u00af\7K\2\2\u00af\u00b0\7P\2\2\u00b0\u00b1\7H\2\2"+
		"\u00b1\u00b2\7Q\2\2\u00b2\u00b3\7\"\2\2\u00b3\u00b4\7R\2\2\u00b4\u00b5"+
		"\7a\2\2\u00b5$\3\2\2\2\u00b6\u00b7\7/\2\2\u00b7\u00b8\7U\2\2\u00b8\u00b9"+
		"\7G\2\2\u00b9&\3\2\2\2\u00ba\u00bb\7/\2\2\u00bb\u00bc\7T\2\2\u00bc\u00bd"+
		"\7G\2\2\u00bd\u00be\7O\2\2\u00be\u00bf\7G\2\2\u00bf\u00c0\7V\2\2\u00c0"+
		"\u00c1\7G\2\2\u00c1\u00c2\7P\2\2\u00c2\u00c3\7V\2\2\u00c3\u00c4\7G\2\2"+
		"\u00c4(\3\2\2\2\u00c5\u00c6\7/\2\2\u00c6\u00c7\7R\2\2\u00c7\u00c8\7C\2"+
		"\2\u00c8\u00c9\7U\2\2\u00c9\u00ca\7U\2\2\u00ca\u00cb\7Y\2\2\u00cb\u00cc"+
		"\7Q\2\2\u00cc\u00cd\7T\2\2\u00cd\u00ce\7F\2\2\u00ce*\3\2\2\2\u00cf\u00d0"+
		"\7/\2\2\u00d0\u00d1\7C\2\2\u00d1\u00d2\7U\2\2\u00d2\u00d3\7U\2\2\u00d3"+
		"\u00d4\7W\2\2\u00d4\u00d5\7P\2\2\u00d5\u00d6\7V\2\2\u00d6\u00d7\7Q\2\2"+
		"\u00d7,\3\2\2\2\u00d8\u00d9\7/\2\2\u00d9\u00da\7E\2\2\u00da\u00db\7Q\2"+
		"\2\u00db\u00dc\7T\2\2\u00dc\u00dd\7R\2\2\u00dd\u00de\7Q\2\2\u00de.\3\2"+
		"\2\2\u00df\u00e0\7/\2\2\u00e0\u00e1\7F\2\2\u00e1\u00e2\7G\2\2\u00e2\u00e3"+
		"\7U\2\2\u00e3\u00e4\7V\2\2\u00e4\u00e5\7K\2\2\u00e5\u00e6\7P\2\2\u00e6"+
		"\u00e7\7C\2\2\u00e7\u00e8\7V\2\2\u00e8\u00e9\7C\2\2\u00e9\u00ea\7T\2\2"+
		"\u00ea\u00eb\7K\2\2\u00eb\u00ec\7Q\2\2\u00ec\u00ed\7\"\2\2\u00ed\u00ee"+
		"\7R\2\2\u00ee\u00ef\7a\2\2\u00ef\60\3\2\2\2\u00f0\u00f4\t\2\2\2\u00f1"+
		"\u00f3\t\3\2\2\u00f2\u00f1\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2"+
		"\2\2\u00f4\u00f5\3\2\2\2\u00f5\62\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f9"+
		"\t\4\2\2\u00f8\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fb\64\3\2\2\2\u00fc\u00fd\5\67\34\2\u00fd\u00fe\7B\2"+
		"\2\u00fe\u00ff\5\67\34\2\u00ff\u0100\7\60\2\2\u0100\u0101\5\67\34\2\u0101"+
		"\66\3\2\2\2\u0102\u010f\5\63\32\2\u0103\u0105\7\"\2\2\u0104\u0103\3\2"+
		"\2\2\u0104\u0105\3\2\2\2\u0105\u0109\3\2\2\2\u0106\u010a\5\63\32\2\u0107"+
		"\u010a\59\35\2\u0108\u010a\5\61\31\2\u0109\u0106\3\2\2\2\u0109\u0107\3"+
		"\2\2\2\u0109\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u0109\3\2\2\2\u010b"+
		"\u010c\3\2\2\2\u010c\u010e\3\2\2\2\u010d\u0104\3\2\2\2\u010e\u0111\3\2"+
		"\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u01108\3\2\2\2\u0111\u010f"+
		"\3\2\2\2\u0112\u0113\t\5\2\2\u0113:\3\2\2\2\u0114\u0115\7a\2\2\u0115<"+
		"\3\2\2\2\u0116\u0117\7\u0080\2\2\u0117\u0118\7\u0080\2\2\u0118>\3\2\2"+
		"\2\u0119\u011b\t\6\2\2\u011a\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011a"+
		"\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011f\b \2\2\u011f"+
		"@\3\2\2\2\u0120\u0122\t\7\2\2\u0121\u0120\3\2\2\2\u0122\u0123\3\2\2\2"+
		"\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0126"+
		"\b!\2\2\u0126B\3\2\2\2\13\2\u00f4\u00fa\u0104\u0109\u010b\u010f\u011c"+
		"\u0123\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}