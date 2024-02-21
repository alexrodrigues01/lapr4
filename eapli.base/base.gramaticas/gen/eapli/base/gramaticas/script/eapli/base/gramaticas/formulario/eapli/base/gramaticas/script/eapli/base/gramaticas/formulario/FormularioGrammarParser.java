// Generated from C:/Users/35191/Documents/lei20_21_s4_2dj_03/eapli.base/base.gramaticas/src/main/java/eapli/base/gramaticas/script/eapli/base/gramaticas/formulario/eapli/base/gramaticas/script/eapli/base/gramaticas/formulario\FormularioGrammar.g4 by ANTLR 4.9.1
package eapli.base.gramaticas.script.eapli.base.gramaticas.formulario.eapli.base.gramaticas.script.eapli.base.gramaticas.formulario;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FormularioGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, PERIODO=14, DATA=15, FRASE=16, 
		PONTO=17, ESPACO=18, HIFEN=19, CHAVETAS=20, WORD=21, LETRA=22, SPECIAL=23, 
		INT=24;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_linha = 2, RULE_regraNome = 3, RULE_regraExpressao = 4, 
		RULE_regraTipo = 5, RULE_regraResposta = 6, RULE_alternativa = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stat", "linha", "regraNome", "regraExpressao", "regraTipo", 
			"regraResposta", "alternativa"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'String'", "'Inteiro'", "'InteiroUnico'", "'Boolean'", 
			"'Data'", "'Ficheiro'", "'Periodo'", "'Soma'", "'Igual'", "'Ate Data Limite'", 
			"'Unica'", "'Justificada'", null, null, null, null, "' '", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "PERIODO", "DATA", "FRASE", "PONTO", "ESPACO", "HIFEN", "CHAVETAS", 
			"WORD", "LETRA", "SPECIAL", "INT"
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

	@Override
	public String getGrammarFileName() { return "FormularioGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FormularioGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormularioGrammarListener ) ((FormularioGrammarListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormularioGrammarListener ) ((FormularioGrammarListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormularioGrammarVisitor ) return ((FormularioGrammarVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			stat();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public LinhaContext linha() {
			return getRuleContext(LinhaContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormularioGrammarListener ) ((FormularioGrammarListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormularioGrammarListener ) ((FormularioGrammarListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormularioGrammarVisitor ) return ((FormularioGrammarVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(22);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				linha();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(19);
				linha();
				setState(20);
				stat();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LinhaContext extends ParserRuleContext {
		public RegraNomeContext nome;
		public RegraExpressaoContext expressaoRegular;
		public RegraTipoContext tipo;
		public RegraRespostaContext resposta;
		public Token obrigatoriedade;
		public RegraNomeContext regraNome() {
			return getRuleContext(RegraNomeContext.class,0);
		}
		public RegraExpressaoContext regraExpressao() {
			return getRuleContext(RegraExpressaoContext.class,0);
		}
		public RegraTipoContext regraTipo() {
			return getRuleContext(RegraTipoContext.class,0);
		}
		public RegraRespostaContext regraResposta() {
			return getRuleContext(RegraRespostaContext.class,0);
		}
		public TerminalNode WORD() { return getToken(FormularioGrammarParser.WORD, 0); }
		public LinhaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linha; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormularioGrammarListener ) ((FormularioGrammarListener)listener).enterLinha(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormularioGrammarListener ) ((FormularioGrammarListener)listener).exitLinha(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormularioGrammarVisitor ) return ((FormularioGrammarVisitor<? extends T>)visitor).visitLinha(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LinhaContext linha() throws RecognitionException {
		LinhaContext _localctx = new LinhaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_linha);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			((LinhaContext)_localctx).nome = regraNome();
			setState(25);
			match(T__0);
			setState(26);
			((LinhaContext)_localctx).expressaoRegular = regraExpressao();
			setState(27);
			match(T__0);
			setState(28);
			((LinhaContext)_localctx).tipo = regraTipo();
			setState(29);
			match(T__0);
			setState(30);
			((LinhaContext)_localctx).resposta = regraResposta();
			setState(31);
			match(T__0);
			setState(32);
			((LinhaContext)_localctx).obrigatoriedade = match(WORD);
			setState(33);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegraNomeContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(FormularioGrammarParser.WORD, 0); }
		public TerminalNode FRASE() { return getToken(FormularioGrammarParser.FRASE, 0); }
		public RegraNomeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regraNome; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormularioGrammarListener ) ((FormularioGrammarListener)listener).enterRegraNome(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormularioGrammarListener ) ((FormularioGrammarListener)listener).exitRegraNome(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormularioGrammarVisitor ) return ((FormularioGrammarVisitor<? extends T>)visitor).visitRegraNome(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegraNomeContext regraNome() throws RecognitionException {
		RegraNomeContext _localctx = new RegraNomeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_regraNome);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_la = _input.LA(1);
			if ( !(_la==FRASE || _la==WORD) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegraExpressaoContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(FormularioGrammarParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(FormularioGrammarParser.WORD, i);
		}
		public List<TerminalNode> SPECIAL() { return getTokens(FormularioGrammarParser.SPECIAL); }
		public TerminalNode SPECIAL(int i) {
			return getToken(FormularioGrammarParser.SPECIAL, i);
		}
		public RegraExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regraExpressao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormularioGrammarListener ) ((FormularioGrammarListener)listener).enterRegraExpressao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormularioGrammarListener ) ((FormularioGrammarListener)listener).exitRegraExpressao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormularioGrammarVisitor ) return ((FormularioGrammarVisitor<? extends T>)visitor).visitRegraExpressao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegraExpressaoContext regraExpressao() throws RecognitionException {
		RegraExpressaoContext _localctx = new RegraExpressaoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_regraExpressao);
		int _la;
		try {
			setState(43);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case WORD:
			case SPECIAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(38);
					_la = _input.LA(1);
					if ( !(_la==WORD || _la==SPECIAL) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(41); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WORD || _la==SPECIAL );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegraTipoContext extends ParserRuleContext {
		public RegraTipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regraTipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormularioGrammarListener ) ((FormularioGrammarListener)listener).enterRegraTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormularioGrammarListener ) ((FormularioGrammarListener)listener).exitRegraTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormularioGrammarVisitor ) return ((FormularioGrammarVisitor<? extends T>)visitor).visitRegraTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegraTipoContext regraTipo() throws RecognitionException {
		RegraTipoContext _localctx = new RegraTipoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_regraTipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegraRespostaContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(FormularioGrammarParser.WORD, 0); }
		public TerminalNode INT() { return getToken(FormularioGrammarParser.INT, 0); }
		public TerminalNode DATA() { return getToken(FormularioGrammarParser.DATA, 0); }
		public TerminalNode PERIODO() { return getToken(FormularioGrammarParser.PERIODO, 0); }
		public TerminalNode FRASE() { return getToken(FormularioGrammarParser.FRASE, 0); }
		public AlternativaContext alternativa() {
			return getRuleContext(AlternativaContext.class,0);
		}
		public RegraRespostaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regraResposta; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormularioGrammarListener ) ((FormularioGrammarListener)listener).enterRegraResposta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormularioGrammarListener ) ((FormularioGrammarListener)listener).exitRegraResposta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormularioGrammarVisitor ) return ((FormularioGrammarVisitor<? extends T>)visitor).visitRegraResposta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegraRespostaContext regraResposta() throws RecognitionException {
		RegraRespostaContext _localctx = new RegraRespostaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_regraResposta);
		try {
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case WORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				match(WORD);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(49);
				match(INT);
				}
				break;
			case DATA:
				enterOuterAlt(_localctx, 4);
				{
				setState(50);
				match(DATA);
				}
				break;
			case PERIODO:
				enterOuterAlt(_localctx, 5);
				{
				setState(51);
				match(PERIODO);
				}
				break;
			case FRASE:
				enterOuterAlt(_localctx, 6);
				{
				setState(52);
				match(FRASE);
				}
				break;
			case T__10:
			case T__11:
			case T__12:
				enterOuterAlt(_localctx, 7);
				{
				setState(53);
				alternativa();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlternativaContext extends ParserRuleContext {
		public AlternativaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alternativa; }
	 
		public AlternativaContext() { }
		public void copyFrom(AlternativaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MudarObrigatoriedadeContext extends AlternativaContext {
		public MudarObrigatoriedadeContext(AlternativaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormularioGrammarListener ) ((FormularioGrammarListener)listener).enterMudarObrigatoriedade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormularioGrammarListener ) ((FormularioGrammarListener)listener).exitMudarObrigatoriedade(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormularioGrammarVisitor ) return ((FormularioGrammarVisitor<? extends T>)visitor).visitMudarObrigatoriedade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlternativaContext alternativa() throws RecognitionException {
		AlternativaContext _localctx = new AlternativaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_alternativa);
		try {
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				_localctx = new MudarObrigatoriedadeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(T__10);
				}
				break;
			case T__11:
				_localctx = new MudarObrigatoriedadeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				match(T__11);
				}
				break;
			case T__12:
				_localctx = new MudarObrigatoriedadeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(58);
				match(T__12);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\32@\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\5\3\31\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\6\6*\n\6\r\6\16\6+\5\6.\n\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\5\b9\n\b\3\t\3\t\3\t\5\t>\n\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\5\4\2\22"+
		"\22\27\27\4\2\27\27\31\31\3\2\4\f\2B\2\22\3\2\2\2\4\30\3\2\2\2\6\32\3"+
		"\2\2\2\b%\3\2\2\2\n-\3\2\2\2\f/\3\2\2\2\168\3\2\2\2\20=\3\2\2\2\22\23"+
		"\5\4\3\2\23\3\3\2\2\2\24\31\5\6\4\2\25\26\5\6\4\2\26\27\5\4\3\2\27\31"+
		"\3\2\2\2\30\24\3\2\2\2\30\25\3\2\2\2\31\5\3\2\2\2\32\33\5\b\5\2\33\34"+
		"\7\3\2\2\34\35\5\n\6\2\35\36\7\3\2\2\36\37\5\f\7\2\37 \7\3\2\2 !\5\16"+
		"\b\2!\"\7\3\2\2\"#\7\27\2\2#$\7\3\2\2$\7\3\2\2\2%&\t\2\2\2&\t\3\2\2\2"+
		"\'.\3\2\2\2(*\t\3\2\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,.\3\2\2"+
		"\2-\'\3\2\2\2-)\3\2\2\2.\13\3\2\2\2/\60\t\4\2\2\60\r\3\2\2\2\619\3\2\2"+
		"\2\629\7\27\2\2\639\7\32\2\2\649\7\21\2\2\659\7\20\2\2\669\7\22\2\2\67"+
		"9\5\20\t\28\61\3\2\2\28\62\3\2\2\28\63\3\2\2\28\64\3\2\2\28\65\3\2\2\2"+
		"8\66\3\2\2\28\67\3\2\2\29\17\3\2\2\2:>\7\r\2\2;>\7\16\2\2<>\7\17\2\2="+
		":\3\2\2\2=;\3\2\2\2=<\3\2\2\2>\21\3\2\2\2\7\30+-8=";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}