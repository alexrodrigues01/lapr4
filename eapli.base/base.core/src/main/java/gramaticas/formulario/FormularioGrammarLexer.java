// Generated from C:/Users/35191/Documents/lei20_21_s4_2dj_03/eapli.base/base.core/src/main/java/gramaticas/formulario\FormularioGrammar.g4 by ANTLR 4.9.1
package gramaticas.formulario;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FormularioGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, PERIODO=16, 
		DATA=17, FRASE=18, PONTO=19, ESPACO=20, HIFEN=21, CHAVETAS=22, ARROBA=23, 
		WORD=24, LETRA=25, SPECIAL=26, INT=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "PERIODO", "DATA", 
			"FRASE", "PONTO", "ESPACO", "HIFEN", "CHAVETAS", "ARROBA", "WORD", "LETRA", 
			"SPECIAL", "INT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'String'", "'Inteiro'", "'InteiroUnico'", "'Boolean'", 
			"'Data'", "'Ficheiro'", "'Periodo'", "'Soma'", "'Subtracao'", "'Igual'", 
			"'Multipla'", "'Ate Data Limite'", "'Unica'", "'Justificada'", null, 
			null, null, null, "' '", "'-'", null, "'@'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "PERIODO", "DATA", "FRASE", "PONTO", "ESPACO", 
			"HIFEN", "CHAVETAS", "ARROBA", "WORD", "LETRA", "SPECIAL", "INT"
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


	public FormularioGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FormularioGrammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u00e7\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\6\23\u00c4\n\23\r\23\16\23\u00c5\3\24\3\24\3\25\3\25\3"+
		"\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\6\31\u00d8"+
		"\n\31\r\31\16\31\u00d9\3\32\6\32\u00dd\n\32\r\32\16\32\u00de\3\33\3\33"+
		"\3\34\6\34\u00e4\n\34\r\34\16\34\u00e5\2\2\35\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\35\3\2\7\4\2..\60\60\6\2]]__}}\177\177"+
		"\4\2C\\c|\r\2##%(<<AA^^aa\u00a5\u00a5\u00ae\u00ae\u00c4\u00c4\u00e4\u00e4"+
		"\u201c\u201c\3\2\62;\2\u00ef\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\39\3\2\2\2\5;\3\2\2\2\7B\3\2\2\2\tJ\3\2\2\2\13W\3\2\2\2\r"+
		"_\3\2\2\2\17d\3\2\2\2\21m\3\2\2\2\23u\3\2\2\2\25z\3\2\2\2\27\u0084\3\2"+
		"\2\2\31\u008a\3\2\2\2\33\u0093\3\2\2\2\35\u00a3\3\2\2\2\37\u00a9\3\2\2"+
		"\2!\u00b5\3\2\2\2#\u00b9\3\2\2\2%\u00c3\3\2\2\2\'\u00c7\3\2\2\2)\u00c9"+
		"\3\2\2\2+\u00cb\3\2\2\2-\u00cd\3\2\2\2/\u00cf\3\2\2\2\61\u00d7\3\2\2\2"+
		"\63\u00dc\3\2\2\2\65\u00e0\3\2\2\2\67\u00e3\3\2\2\29:\7=\2\2:\4\3\2\2"+
		"\2;<\7U\2\2<=\7v\2\2=>\7t\2\2>?\7k\2\2?@\7p\2\2@A\7i\2\2A\6\3\2\2\2BC"+
		"\7K\2\2CD\7p\2\2DE\7v\2\2EF\7g\2\2FG\7k\2\2GH\7t\2\2HI\7q\2\2I\b\3\2\2"+
		"\2JK\7K\2\2KL\7p\2\2LM\7v\2\2MN\7g\2\2NO\7k\2\2OP\7t\2\2PQ\7q\2\2QR\7"+
		"W\2\2RS\7p\2\2ST\7k\2\2TU\7e\2\2UV\7q\2\2V\n\3\2\2\2WX\7D\2\2XY\7q\2\2"+
		"YZ\7q\2\2Z[\7n\2\2[\\\7g\2\2\\]\7c\2\2]^\7p\2\2^\f\3\2\2\2_`\7F\2\2`a"+
		"\7c\2\2ab\7v\2\2bc\7c\2\2c\16\3\2\2\2de\7H\2\2ef\7k\2\2fg\7e\2\2gh\7j"+
		"\2\2hi\7g\2\2ij\7k\2\2jk\7t\2\2kl\7q\2\2l\20\3\2\2\2mn\7R\2\2no\7g\2\2"+
		"op\7t\2\2pq\7k\2\2qr\7q\2\2rs\7f\2\2st\7q\2\2t\22\3\2\2\2uv\7U\2\2vw\7"+
		"q\2\2wx\7o\2\2xy\7c\2\2y\24\3\2\2\2z{\7U\2\2{|\7w\2\2|}\7d\2\2}~\7v\2"+
		"\2~\177\7t\2\2\177\u0080\7c\2\2\u0080\u0081\7e\2\2\u0081\u0082\7c\2\2"+
		"\u0082\u0083\7q\2\2\u0083\26\3\2\2\2\u0084\u0085\7K\2\2\u0085\u0086\7"+
		"i\2\2\u0086\u0087\7w\2\2\u0087\u0088\7c\2\2\u0088\u0089\7n\2\2\u0089\30"+
		"\3\2\2\2\u008a\u008b\7O\2\2\u008b\u008c\7w\2\2\u008c\u008d\7n\2\2\u008d"+
		"\u008e\7v\2\2\u008e\u008f\7k\2\2\u008f\u0090\7r\2\2\u0090\u0091\7n\2\2"+
		"\u0091\u0092\7c\2\2\u0092\32\3\2\2\2\u0093\u0094\7C\2\2\u0094\u0095\7"+
		"v\2\2\u0095\u0096\7g\2\2\u0096\u0097\7\"\2\2\u0097\u0098\7F\2\2\u0098"+
		"\u0099\7c\2\2\u0099\u009a\7v\2\2\u009a\u009b\7c\2\2\u009b\u009c\7\"\2"+
		"\2\u009c\u009d\7N\2\2\u009d\u009e\7k\2\2\u009e\u009f\7o\2\2\u009f\u00a0"+
		"\7k\2\2\u00a0\u00a1\7v\2\2\u00a1\u00a2\7g\2\2\u00a2\34\3\2\2\2\u00a3\u00a4"+
		"\7W\2\2\u00a4\u00a5\7p\2\2\u00a5\u00a6\7k\2\2\u00a6\u00a7\7e\2\2\u00a7"+
		"\u00a8\7c\2\2\u00a8\36\3\2\2\2\u00a9\u00aa\7L\2\2\u00aa\u00ab\7w\2\2\u00ab"+
		"\u00ac\7u\2\2\u00ac\u00ad\7v\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7h\2\2"+
		"\u00af\u00b0\7k\2\2\u00b0\u00b1\7e\2\2\u00b1\u00b2\7c\2\2\u00b2\u00b3"+
		"\7f\2\2\u00b3\u00b4\7c\2\2\u00b4 \3\2\2\2\u00b5\u00b6\5#\22\2\u00b6\u00b7"+
		"\5\'\24\2\u00b7\u00b8\5#\22\2\u00b8\"\3\2\2\2\u00b9\u00ba\5\67\34\2\u00ba"+
		"\u00bb\7\61\2\2\u00bb\u00bc\5\67\34\2\u00bc\u00bd\7\61\2\2\u00bd\u00be"+
		"\5\67\34\2\u00be$\3\2\2\2\u00bf\u00c0\5\61\31\2\u00c0\u00c1\5)\25\2\u00c1"+
		"\u00c2\5\61\31\2\u00c2\u00c4\3\2\2\2\u00c3\u00bf\3\2\2\2\u00c4\u00c5\3"+
		"\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6&\3\2\2\2\u00c7\u00c8"+
		"\t\2\2\2\u00c8(\3\2\2\2\u00c9\u00ca\7\"\2\2\u00ca*\3\2\2\2\u00cb\u00cc"+
		"\7/\2\2\u00cc,\3\2\2\2\u00cd\u00ce\t\3\2\2\u00ce.\3\2\2\2\u00cf\u00d0"+
		"\7B\2\2\u00d0\60\3\2\2\2\u00d1\u00d8\5\63\32\2\u00d2\u00d8\5\67\34\2\u00d3"+
		"\u00d8\5+\26\2\u00d4\u00d8\5-\27\2\u00d5\u00d8\5\'\24\2\u00d6\u00d8\5"+
		"/\30\2\u00d7\u00d1\3\2\2\2\u00d7\u00d2\3\2\2\2\u00d7\u00d3\3\2\2\2\u00d7"+
		"\u00d4\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00d9\3\2"+
		"\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\62\3\2\2\2\u00db\u00dd"+
		"\t\4\2\2\u00dc\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00dc\3\2\2\2\u00de"+
		"\u00df\3\2\2\2\u00df\64\3\2\2\2\u00e0\u00e1\t\5\2\2\u00e1\66\3\2\2\2\u00e2"+
		"\u00e4\t\6\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e3\3\2"+
		"\2\2\u00e5\u00e6\3\2\2\2\u00e68\3\2\2\2\b\2\u00c5\u00d7\u00d9\u00de\u00e5"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}