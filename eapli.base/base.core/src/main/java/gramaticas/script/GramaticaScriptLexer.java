// Generated from C:/Users/User/Documents/lei20_21_s4_2dj_03/eapli.base/base.core/src/main/java/gramaticas/script\GramaticaScript.g4 by ANTLR 4.9.1
package gramaticas.script;
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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, FICHEIRO_TOKEN=16, 
		CONSULTAR=17, ATUALIZAR=18, NOVA_INFO=19, SE=20, REMETENTE=21, PASSWORD=22, 
		ASSUNTO=23, CORPO=24, DESTINATARIO=25, INT=26, WORD=27, EMAIL=28, TEXTO=29, 
		SPECIAL=30, UNDER=31, ADQUIRIR=32, SPACE=33, WS=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "FICHEIRO_TOKEN", 
			"CONSULTAR", "ATUALIZAR", "NOVA_INFO", "SE", "REMETENTE", "PASSWORD", 
			"ASSUNTO", "CORPO", "DESTINATARIO", "INT", "WORD", "EMAIL", "TEXTO", 
			"SPECIAL", "UNDER", "ADQUIRIR", "SPACE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\"'", "'-ATUALIZAR'", "'-SUM'", "'-DIV'", "'-SUB'", "'-MUL'", 
			"'P_'", "'-\"'", "'-MAIOR'", "'-MENOR'", "'-IGUAL'", "'-MESMO'", "'('", 
			"')'", "'-ATRIBUIR'", "'-FICHEIRO'", "'-CONSULTAR P_'", "'-ATUALIZAR P_'", 
			"'-INFO P_'", "'-SE'", "'-REMETENTE'", "'-PASSWORD'", "'-ASSUNTO'", "'-CORPO'", 
			"'-DESTINATARIO P_'", null, null, null, null, null, "'_'", "'~~'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "FICHEIRO_TOKEN", "CONSULTAR", "ATUALIZAR", "NOVA_INFO", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u013b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\7\33"+
		"\u0105\n\33\f\33\16\33\u0108\13\33\5\33\u010a\n\33\3\34\6\34\u010d\n\34"+
		"\r\34\16\34\u010e\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\5\36\u0119\n"+
		"\36\3\36\3\36\3\36\6\36\u011e\n\36\r\36\16\36\u011f\7\36\u0122\n\36\f"+
		"\36\16\36\u0125\13\36\3\37\3\37\3 \3 \3!\3!\3!\3\"\6\"\u012f\n\"\r\"\16"+
		"\"\u0130\3\"\3\"\3#\6#\u0136\n#\r#\16#\u0137\3#\3#\2\2$\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$\3"+
		"\2\b\3\2\63;\3\2\62;\4\2C\\c|\16\2##%(..\60\60<<AA^^\u00a5\u00a5\u00ae"+
		"\u00ae\u00c4\u00c4\u00e4\u00e4\u201c\u201c\3\2\"\"\4\2\13\f\17\17\2\u0144"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2"+
		"\2\5I\3\2\2\2\7T\3\2\2\2\tY\3\2\2\2\13^\3\2\2\2\rc\3\2\2\2\17h\3\2\2\2"+
		"\21k\3\2\2\2\23n\3\2\2\2\25u\3\2\2\2\27|\3\2\2\2\31\u0083\3\2\2\2\33\u008a"+
		"\3\2\2\2\35\u008c\3\2\2\2\37\u008e\3\2\2\2!\u0098\3\2\2\2#\u00a2\3\2\2"+
		"\2%\u00b0\3\2\2\2\'\u00be\3\2\2\2)\u00c7\3\2\2\2+\u00cb\3\2\2\2-\u00d6"+
		"\3\2\2\2/\u00e0\3\2\2\2\61\u00e9\3\2\2\2\63\u00f0\3\2\2\2\65\u0109\3\2"+
		"\2\2\67\u010c\3\2\2\29\u0110\3\2\2\2;\u0116\3\2\2\2=\u0126\3\2\2\2?\u0128"+
		"\3\2\2\2A\u012a\3\2\2\2C\u012e\3\2\2\2E\u0135\3\2\2\2GH\7$\2\2H\4\3\2"+
		"\2\2IJ\7/\2\2JK\7C\2\2KL\7V\2\2LM\7W\2\2MN\7C\2\2NO\7N\2\2OP\7K\2\2PQ"+
		"\7\\\2\2QR\7C\2\2RS\7T\2\2S\6\3\2\2\2TU\7/\2\2UV\7U\2\2VW\7W\2\2WX\7O"+
		"\2\2X\b\3\2\2\2YZ\7/\2\2Z[\7F\2\2[\\\7K\2\2\\]\7X\2\2]\n\3\2\2\2^_\7/"+
		"\2\2_`\7U\2\2`a\7W\2\2ab\7D\2\2b\f\3\2\2\2cd\7/\2\2de\7O\2\2ef\7W\2\2"+
		"fg\7N\2\2g\16\3\2\2\2hi\7R\2\2ij\7a\2\2j\20\3\2\2\2kl\7/\2\2lm\7$\2\2"+
		"m\22\3\2\2\2no\7/\2\2op\7O\2\2pq\7C\2\2qr\7K\2\2rs\7Q\2\2st\7T\2\2t\24"+
		"\3\2\2\2uv\7/\2\2vw\7O\2\2wx\7G\2\2xy\7P\2\2yz\7Q\2\2z{\7T\2\2{\26\3\2"+
		"\2\2|}\7/\2\2}~\7K\2\2~\177\7I\2\2\177\u0080\7W\2\2\u0080\u0081\7C\2\2"+
		"\u0081\u0082\7N\2\2\u0082\30\3\2\2\2\u0083\u0084\7/\2\2\u0084\u0085\7"+
		"O\2\2\u0085\u0086\7G\2\2\u0086\u0087\7U\2\2\u0087\u0088\7O\2\2\u0088\u0089"+
		"\7Q\2\2\u0089\32\3\2\2\2\u008a\u008b\7*\2\2\u008b\34\3\2\2\2\u008c\u008d"+
		"\7+\2\2\u008d\36\3\2\2\2\u008e\u008f\7/\2\2\u008f\u0090\7C\2\2\u0090\u0091"+
		"\7V\2\2\u0091\u0092\7T\2\2\u0092\u0093\7K\2\2\u0093\u0094\7D\2\2\u0094"+
		"\u0095\7W\2\2\u0095\u0096\7K\2\2\u0096\u0097\7T\2\2\u0097 \3\2\2\2\u0098"+
		"\u0099\7/\2\2\u0099\u009a\7H\2\2\u009a\u009b\7K\2\2\u009b\u009c\7E\2\2"+
		"\u009c\u009d\7J\2\2\u009d\u009e\7G\2\2\u009e\u009f\7K\2\2\u009f\u00a0"+
		"\7T\2\2\u00a0\u00a1\7Q\2\2\u00a1\"\3\2\2\2\u00a2\u00a3\7/\2\2\u00a3\u00a4"+
		"\7E\2\2\u00a4\u00a5\7Q\2\2\u00a5\u00a6\7P\2\2\u00a6\u00a7\7U\2\2\u00a7"+
		"\u00a8\7W\2\2\u00a8\u00a9\7N\2\2\u00a9\u00aa\7V\2\2\u00aa\u00ab\7C\2\2"+
		"\u00ab\u00ac\7T\2\2\u00ac\u00ad\7\"\2\2\u00ad\u00ae\7R\2\2\u00ae\u00af"+
		"\7a\2\2\u00af$\3\2\2\2\u00b0\u00b1\7/\2\2\u00b1\u00b2\7C\2\2\u00b2\u00b3"+
		"\7V\2\2\u00b3\u00b4\7W\2\2\u00b4\u00b5\7C\2\2\u00b5\u00b6\7N\2\2\u00b6"+
		"\u00b7\7K\2\2\u00b7\u00b8\7\\\2\2\u00b8\u00b9\7C\2\2\u00b9\u00ba\7T\2"+
		"\2\u00ba\u00bb\7\"\2\2\u00bb\u00bc\7R\2\2\u00bc\u00bd\7a\2\2\u00bd&\3"+
		"\2\2\2\u00be\u00bf\7/\2\2\u00bf\u00c0\7K\2\2\u00c0\u00c1\7P\2\2\u00c1"+
		"\u00c2\7H\2\2\u00c2\u00c3\7Q\2\2\u00c3\u00c4\7\"\2\2\u00c4\u00c5\7R\2"+
		"\2\u00c5\u00c6\7a\2\2\u00c6(\3\2\2\2\u00c7\u00c8\7/\2\2\u00c8\u00c9\7"+
		"U\2\2\u00c9\u00ca\7G\2\2\u00ca*\3\2\2\2\u00cb\u00cc\7/\2\2\u00cc\u00cd"+
		"\7T\2\2\u00cd\u00ce\7G\2\2\u00ce\u00cf\7O\2\2\u00cf\u00d0\7G\2\2\u00d0"+
		"\u00d1\7V\2\2\u00d1\u00d2\7G\2\2\u00d2\u00d3\7P\2\2\u00d3\u00d4\7V\2\2"+
		"\u00d4\u00d5\7G\2\2\u00d5,\3\2\2\2\u00d6\u00d7\7/\2\2\u00d7\u00d8\7R\2"+
		"\2\u00d8\u00d9\7C\2\2\u00d9\u00da\7U\2\2\u00da\u00db\7U\2\2\u00db\u00dc"+
		"\7Y\2\2\u00dc\u00dd\7Q\2\2\u00dd\u00de\7T\2\2\u00de\u00df\7F\2\2\u00df"+
		".\3\2\2\2\u00e0\u00e1\7/\2\2\u00e1\u00e2\7C\2\2\u00e2\u00e3\7U\2\2\u00e3"+
		"\u00e4\7U\2\2\u00e4\u00e5\7W\2\2\u00e5\u00e6\7P\2\2\u00e6\u00e7\7V\2\2"+
		"\u00e7\u00e8\7Q\2\2\u00e8\60\3\2\2\2\u00e9\u00ea\7/\2\2\u00ea\u00eb\7"+
		"E\2\2\u00eb\u00ec\7Q\2\2\u00ec\u00ed\7T\2\2\u00ed\u00ee\7R\2\2\u00ee\u00ef"+
		"\7Q\2\2\u00ef\62\3\2\2\2\u00f0\u00f1\7/\2\2\u00f1\u00f2\7F\2\2\u00f2\u00f3"+
		"\7G\2\2\u00f3\u00f4\7U\2\2\u00f4\u00f5\7V\2\2\u00f5\u00f6\7K\2\2\u00f6"+
		"\u00f7\7P\2\2\u00f7\u00f8\7C\2\2\u00f8\u00f9\7V\2\2\u00f9\u00fa\7C\2\2"+
		"\u00fa\u00fb\7T\2\2\u00fb\u00fc\7K\2\2\u00fc\u00fd\7Q\2\2\u00fd\u00fe"+
		"\7\"\2\2\u00fe\u00ff\7R\2\2\u00ff\u0100\7a\2\2\u0100\64\3\2\2\2\u0101"+
		"\u010a\7\62\2\2\u0102\u0106\t\2\2\2\u0103\u0105\t\3\2\2\u0104\u0103\3"+
		"\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107"+
		"\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u0101\3\2\2\2\u0109\u0102\3\2"+
		"\2\2\u010a\66\3\2\2\2\u010b\u010d\t\4\2\2\u010c\u010b\3\2\2\2\u010d\u010e"+
		"\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f8\3\2\2\2\u0110"+
		"\u0111\5;\36\2\u0111\u0112\7B\2\2\u0112\u0113\5;\36\2\u0113\u0114\7\60"+
		"\2\2\u0114\u0115\5;\36\2\u0115:\3\2\2\2\u0116\u0123\5\67\34\2\u0117\u0119"+
		"\7\"\2\2\u0118\u0117\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011d\3\2\2\2\u011a"+
		"\u011e\5\67\34\2\u011b\u011e\5=\37\2\u011c\u011e\5\65\33\2\u011d\u011a"+
		"\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f"+
		"\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0122\3\2\2\2\u0121\u0118\3\2"+
		"\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124"+
		"<\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0127\t\5\2\2\u0127>\3\2\2\2\u0128"+
		"\u0129\7a\2\2\u0129@\3\2\2\2\u012a\u012b\7\u0080\2\2\u012b\u012c\7\u0080"+
		"\2\2\u012cB\3\2\2\2\u012d\u012f\t\6\2\2\u012e\u012d\3\2\2\2\u012f\u0130"+
		"\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132\3\2\2\2\u0132"+
		"\u0133\b\"\2\2\u0133D\3\2\2\2\u0134\u0136\t\7\2\2\u0135\u0134\3\2\2\2"+
		"\u0136\u0137\3\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0139"+
		"\3\2\2\2\u0139\u013a\b#\2\2\u013aF\3\2\2\2\f\2\u0106\u0109\u010e\u0118"+
		"\u011d\u011f\u0123\u0130\u0137\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}