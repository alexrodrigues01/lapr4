// Generated from C:/Users/User/Documents/lei20_21_s4_2dj_03/eapli.base/base.core/src/main/java/gramaticas/script\GramaticaScript.g4 by ANTLR 4.9.1
package gramaticas.script;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GramaticaScriptParser extends Parser {
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
	public static final int
		RULE_start = 0, RULE_continuee = 1, RULE_consultar = 2, RULE_opcoesFicheiro = 3, 
		RULE_realizar = 4, RULE_operacao = 5, RULE_se = 6, RULE_verificarCondicao = 7, 
		RULE_opcoes = 8, RULE_operadores = 9, RULE_funcionalidade = 10, RULE_enviar = 11, 
		RULE_corpo = 12, RULE_fulltext = 13, RULE_adquirir = 14, RULE_adquirirOpcoes = 15, 
		RULE_atribuir = 16, RULE_atribuirOpcoes = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "continuee", "consultar", "opcoesFicheiro", "realizar", "operacao", 
			"se", "verificarCondicao", "opcoes", "operadores", "funcionalidade", 
			"enviar", "corpo", "fulltext", "adquirir", "adquirirOpcoes", "atribuir", 
			"atribuirOpcoes"
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

	@Override
	public String getGrammarFileName() { return "GramaticaScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GramaticaScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public ContinueeContext continuee() {
			return getRuleContext(ContinueeContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			continuee();
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

	public static class ContinueeContext extends ParserRuleContext {
		public ConsultarContext consultar() {
			return getRuleContext(ConsultarContext.class,0);
		}
		public ContinueeContext continuee() {
			return getRuleContext(ContinueeContext.class,0);
		}
		public RealizarContext realizar() {
			return getRuleContext(RealizarContext.class,0);
		}
		public EnviarContext enviar() {
			return getRuleContext(EnviarContext.class,0);
		}
		public AtribuirContext atribuir() {
			return getRuleContext(AtribuirContext.class,0);
		}
		public ContinueeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continuee; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterContinuee(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitContinuee(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitContinuee(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueeContext continuee() throws RecognitionException {
		ContinueeContext _localctx = new ContinueeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_continuee);
		try {
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case FICHEIRO_TOKEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				consultar();
				setState(40);
				continuee();
				}
				break;
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case SE:
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				realizar();
				setState(43);
				continuee();
				}
				break;
			case REMETENTE:
				enterOuterAlt(_localctx, 4);
				{
				setState(45);
				enviar();
				setState(46);
				continuee();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 5);
				{
				setState(48);
				atribuir();
				setState(49);
				continuee();
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

	public static class ConsultarContext extends ParserRuleContext {
		public Token varFicheiro;
		public TerminalNode FICHEIRO_TOKEN() { return getToken(GramaticaScriptParser.FICHEIRO_TOKEN, 0); }
		public OpcoesFicheiroContext opcoesFicheiro() {
			return getRuleContext(OpcoesFicheiroContext.class,0);
		}
		public TerminalNode TEXTO() { return getToken(GramaticaScriptParser.TEXTO, 0); }
		public ConsultarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_consultar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterConsultar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitConsultar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitConsultar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConsultarContext consultar() throws RecognitionException {
		ConsultarContext _localctx = new ConsultarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_consultar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(FICHEIRO_TOKEN);
			setState(54);
			match(T__0);
			setState(55);
			((ConsultarContext)_localctx).varFicheiro = match(TEXTO);
			setState(56);
			match(T__0);
			setState(57);
			opcoesFicheiro();
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

	public static class OpcoesFicheiroContext extends ParserRuleContext {
		public OpcoesFicheiroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opcoesFicheiro; }
	 
		public OpcoesFicheiroContext() { }
		public void copyFrom(OpcoesFicheiroContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConsultarFileContext extends OpcoesFicheiroContext {
		public Token idVar;
		public Token parametroVar;
		public TerminalNode CONSULTAR() { return getToken(GramaticaScriptParser.CONSULTAR, 0); }
		public TerminalNode INT() { return getToken(GramaticaScriptParser.INT, 0); }
		public TerminalNode WORD() { return getToken(GramaticaScriptParser.WORD, 0); }
		public ConsultarFileContext(OpcoesFicheiroContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterConsultarFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitConsultarFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitConsultarFile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtualizarFileContext extends OpcoesFicheiroContext {
		public Token idVar;
		public Token parametroVar;
		public Token idVar2;
		public TerminalNode ATUALIZAR() { return getToken(GramaticaScriptParser.ATUALIZAR, 0); }
		public TerminalNode NOVA_INFO() { return getToken(GramaticaScriptParser.NOVA_INFO, 0); }
		public List<TerminalNode> INT() { return getTokens(GramaticaScriptParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(GramaticaScriptParser.INT, i);
		}
		public TerminalNode WORD() { return getToken(GramaticaScriptParser.WORD, 0); }
		public AtualizarFileContext(OpcoesFicheiroContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterAtualizarFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitAtualizarFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitAtualizarFile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtualizarSomaFileContext extends OpcoesFicheiroContext {
		public Token parametroVar;
		public Token parametroVar2;
		public FulltextContext fulltext() {
			return getRuleContext(FulltextContext.class,0);
		}
		public TerminalNode INT() { return getToken(GramaticaScriptParser.INT, 0); }
		public List<TerminalNode> WORD() { return getTokens(GramaticaScriptParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(GramaticaScriptParser.WORD, i);
		}
		public AtualizarSomaFileContext(OpcoesFicheiroContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterAtualizarSomaFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitAtualizarSomaFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitAtualizarSomaFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpcoesFicheiroContext opcoesFicheiro() throws RecognitionException {
		OpcoesFicheiroContext _localctx = new OpcoesFicheiroContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_opcoesFicheiro);
		try {
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONSULTAR:
				_localctx = new ConsultarFileContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				match(CONSULTAR);
				setState(60);
				((ConsultarFileContext)_localctx).idVar = match(INT);
				setState(61);
				match(T__0);
				setState(62);
				((ConsultarFileContext)_localctx).parametroVar = match(WORD);
				setState(63);
				match(T__0);
				}
				break;
			case ATUALIZAR:
				_localctx = new AtualizarFileContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(ATUALIZAR);
				setState(65);
				((AtualizarFileContext)_localctx).idVar = match(INT);
				setState(66);
				match(T__0);
				setState(67);
				((AtualizarFileContext)_localctx).parametroVar = match(WORD);
				setState(68);
				match(T__0);
				setState(69);
				match(NOVA_INFO);
				setState(70);
				((AtualizarFileContext)_localctx).idVar2 = match(INT);
				}
				break;
			case T__1:
				_localctx = new AtualizarSomaFileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				match(T__1);
				setState(72);
				match(T__0);
				setState(73);
				((AtualizarSomaFileContext)_localctx).parametroVar = match(WORD);
				setState(74);
				match(T__0);
				setState(75);
				match(T__0);
				setState(76);
				fulltext();
				setState(77);
				match(T__0);
				setState(78);
				match(T__0);
				setState(79);
				((AtualizarSomaFileContext)_localctx).parametroVar2 = match(WORD);
				setState(80);
				match(T__0);
				setState(81);
				match(INT);
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

	public static class RealizarContext extends ParserRuleContext {
		public RealizarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_realizar; }
	 
		public RealizarContext() { }
		public void copyFrom(RealizarContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CalculoContext extends RealizarContext {
		public Token op;
		public OperacaoContext operacao() {
			return getRuleContext(OperacaoContext.class,0);
		}
		public CalculoContext(RealizarContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterCalculo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitCalculo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitCalculo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfContext extends RealizarContext {
		public TerminalNode SE() { return getToken(GramaticaScriptParser.SE, 0); }
		public SeContext se() {
			return getRuleContext(SeContext.class,0);
		}
		public IfContext(RealizarContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RealizarContext realizar() throws RecognitionException {
		RealizarContext _localctx = new RealizarContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_realizar);
		int _la;
		try {
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__3:
			case T__4:
			case T__5:
				_localctx = new CalculoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				((CalculoContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5))) != 0)) ) {
					((CalculoContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(86);
				operacao();
				}
				break;
			case SE:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				match(SE);
				setState(88);
				se();
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

	public static class OperacaoContext extends ParserRuleContext {
		public List<OpcoesContext> opcoes() {
			return getRuleContexts(OpcoesContext.class);
		}
		public OpcoesContext opcoes(int i) {
			return getRuleContext(OpcoesContext.class,i);
		}
		public OperacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterOperacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitOperacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitOperacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperacaoContext operacao() throws RecognitionException {
		OperacaoContext _localctx = new OperacaoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_operacao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			opcoes();
			setState(92);
			opcoes();
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

	public static class SeContext extends ParserRuleContext {
		public VerificarCondicaoContext verificarCondicao() {
			return getRuleContext(VerificarCondicaoContext.class,0);
		}
		public FuncionalidadeContext funcionalidade() {
			return getRuleContext(FuncionalidadeContext.class,0);
		}
		public SeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_se; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterSe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitSe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitSe(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeContext se() throws RecognitionException {
		SeContext _localctx = new SeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_se);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			verificarCondicao();
			setState(95);
			funcionalidade();
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

	public static class VerificarCondicaoContext extends ParserRuleContext {
		public List<OpcoesContext> opcoes() {
			return getRuleContexts(OpcoesContext.class);
		}
		public OpcoesContext opcoes(int i) {
			return getRuleContext(OpcoesContext.class,i);
		}
		public OperadoresContext operadores() {
			return getRuleContext(OperadoresContext.class,0);
		}
		public VerificarCondicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verificarCondicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterVerificarCondicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitVerificarCondicao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitVerificarCondicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VerificarCondicaoContext verificarCondicao() throws RecognitionException {
		VerificarCondicaoContext _localctx = new VerificarCondicaoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_verificarCondicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			opcoes();
			setState(98);
			operadores();
			setState(99);
			opcoes();
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

	public static class OpcoesContext extends ParserRuleContext {
		public OpcoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opcoes; }
	 
		public OpcoesContext() { }
		public void copyFrom(OpcoesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TextoOpcaoContext extends OpcoesContext {
		public TerminalNode WORD() { return getToken(GramaticaScriptParser.WORD, 0); }
		public TextoOpcaoContext(OpcoesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterTextoOpcao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitTextoOpcao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitTextoOpcao(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtribuirOpContext extends OpcoesContext {
		public FulltextContext fulltext() {
			return getRuleContext(FulltextContext.class,0);
		}
		public AtribuirOpContext(OpcoesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterAtribuirOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitAtribuirOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitAtribuirOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InteiroContext extends OpcoesContext {
		public TerminalNode INT() { return getToken(GramaticaScriptParser.INT, 0); }
		public InteiroContext(OpcoesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterInteiro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitInteiro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitInteiro(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberFileContext extends OpcoesContext {
		public Token varFicheiro;
		public Token idVar;
		public Token parametroVar;
		public TerminalNode FICHEIRO_TOKEN() { return getToken(GramaticaScriptParser.FICHEIRO_TOKEN, 0); }
		public TerminalNode CONSULTAR() { return getToken(GramaticaScriptParser.CONSULTAR, 0); }
		public TerminalNode TEXTO() { return getToken(GramaticaScriptParser.TEXTO, 0); }
		public TerminalNode INT() { return getToken(GramaticaScriptParser.INT, 0); }
		public TerminalNode WORD() { return getToken(GramaticaScriptParser.WORD, 0); }
		public NumberFileContext(OpcoesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterNumberFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitNumberFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitNumberFile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtributoFormContext extends OpcoesContext {
		public Token idVar;
		public TerminalNode INT() { return getToken(GramaticaScriptParser.INT, 0); }
		public AtributoFormContext(OpcoesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterAtributoForm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitAtributoForm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitAtributoForm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpcoesContext opcoes() throws RecognitionException {
		OpcoesContext _localctx = new OpcoesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_opcoes);
		try {
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FICHEIRO_TOKEN:
				_localctx = new NumberFileContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				match(FICHEIRO_TOKEN);
				setState(102);
				match(T__0);
				setState(103);
				((NumberFileContext)_localctx).varFicheiro = match(TEXTO);
				setState(104);
				match(T__0);
				setState(105);
				match(CONSULTAR);
				setState(106);
				((NumberFileContext)_localctx).idVar = match(INT);
				setState(107);
				match(T__0);
				setState(108);
				((NumberFileContext)_localctx).parametroVar = match(WORD);
				setState(109);
				match(T__0);
				}
				break;
			case T__6:
				_localctx = new AtributoFormContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(T__6);
				setState(111);
				((AtributoFormContext)_localctx).idVar = match(INT);
				}
				break;
			case INT:
				_localctx = new InteiroContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
				match(INT);
				}
				break;
			case T__0:
				_localctx = new TextoOpcaoContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(113);
				match(T__0);
				setState(114);
				match(WORD);
				setState(115);
				match(T__0);
				}
				break;
			case T__7:
				_localctx = new AtribuirOpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(116);
				match(T__7);
				setState(117);
				fulltext();
				setState(118);
				match(T__0);
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

	public static class OperadoresContext extends ParserRuleContext {
		public OperadoresContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operadores; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterOperadores(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitOperadores(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitOperadores(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperadoresContext operadores() throws RecognitionException {
		OperadoresContext _localctx = new OperadoresContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_operadores);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) ) {
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

	public static class FuncionalidadeContext extends ParserRuleContext {
		public ConsultarContext consultar() {
			return getRuleContext(ConsultarContext.class,0);
		}
		public EnviarContext enviar() {
			return getRuleContext(EnviarContext.class,0);
		}
		public RealizarContext realizar() {
			return getRuleContext(RealizarContext.class,0);
		}
		public AtribuirContext atribuir() {
			return getRuleContext(AtribuirContext.class,0);
		}
		public FuncionalidadeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcionalidade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterFuncionalidade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitFuncionalidade(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitFuncionalidade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncionalidadeContext funcionalidade() throws RecognitionException {
		FuncionalidadeContext _localctx = new FuncionalidadeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funcionalidade);
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FICHEIRO_TOKEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				consultar();
				}
				break;
			case REMETENTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				enviar();
				}
				break;
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case SE:
				enterOuterAlt(_localctx, 3);
				{
				setState(126);
				realizar();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 4);
				{
				setState(127);
				atribuir();
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

	public static class EnviarContext extends ParserRuleContext {
		public EnviarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enviar; }
	 
		public EnviarContext() { }
		public void copyFrom(EnviarContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EmailContext extends EnviarContext {
		public Token varEmail;
		public FulltextContext varPassword;
		public FulltextContext varAssunto;
		public Token idVar;
		public TerminalNode REMETENTE() { return getToken(GramaticaScriptParser.REMETENTE, 0); }
		public TerminalNode PASSWORD() { return getToken(GramaticaScriptParser.PASSWORD, 0); }
		public TerminalNode ASSUNTO() { return getToken(GramaticaScriptParser.ASSUNTO, 0); }
		public TerminalNode CORPO() { return getToken(GramaticaScriptParser.CORPO, 0); }
		public CorpoContext corpo() {
			return getRuleContext(CorpoContext.class,0);
		}
		public TerminalNode DESTINATARIO() { return getToken(GramaticaScriptParser.DESTINATARIO, 0); }
		public TerminalNode EMAIL() { return getToken(GramaticaScriptParser.EMAIL, 0); }
		public List<FulltextContext> fulltext() {
			return getRuleContexts(FulltextContext.class);
		}
		public FulltextContext fulltext(int i) {
			return getRuleContext(FulltextContext.class,i);
		}
		public TerminalNode INT() { return getToken(GramaticaScriptParser.INT, 0); }
		public EmailContext(EnviarContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterEmail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitEmail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitEmail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnviarContext enviar() throws RecognitionException {
		EnviarContext _localctx = new EnviarContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_enviar);
		try {
			_localctx = new EmailContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(REMETENTE);
			setState(131);
			match(T__0);
			setState(132);
			((EmailContext)_localctx).varEmail = match(EMAIL);
			setState(133);
			match(T__0);
			setState(134);
			match(PASSWORD);
			setState(135);
			match(T__0);
			setState(136);
			((EmailContext)_localctx).varPassword = fulltext();
			setState(137);
			match(T__0);
			setState(138);
			match(ASSUNTO);
			setState(139);
			match(T__0);
			setState(140);
			((EmailContext)_localctx).varAssunto = fulltext();
			setState(141);
			match(T__0);
			setState(142);
			match(CORPO);
			setState(143);
			match(T__0);
			setState(144);
			corpo();
			setState(145);
			match(T__0);
			setState(146);
			match(DESTINATARIO);
			setState(147);
			((EmailContext)_localctx).idVar = match(INT);
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

	public static class CorpoContext extends ParserRuleContext {
		public CorpoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_corpo; }
	 
		public CorpoContext() { }
		public void copyFrom(CorpoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TextoContext extends CorpoContext {
		public FulltextContext fulltext() {
			return getRuleContext(FulltextContext.class,0);
		}
		public CorpoContext corpo() {
			return getRuleContext(CorpoContext.class,0);
		}
		public TextoContext(CorpoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterTexto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitTexto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitTexto(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlankContext extends CorpoContext {
		public BlankContext(CorpoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterBlank(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitBlank(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitBlank(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OpcoesAdquirirContext extends CorpoContext {
		public AdquirirContext adquirir() {
			return getRuleContext(AdquirirContext.class,0);
		}
		public CorpoContext corpo() {
			return getRuleContext(CorpoContext.class,0);
		}
		public OpcoesAdquirirContext(CorpoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterOpcoesAdquirir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitOpcoesAdquirir(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitOpcoesAdquirir(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CorpoContext corpo() throws RecognitionException {
		CorpoContext _localctx = new CorpoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_corpo);
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new BlankContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case INT:
			case WORD:
			case TEXTO:
			case SPECIAL:
				_localctx = new TextoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				fulltext();
				setState(151);
				corpo();
				}
				break;
			case ADQUIRIR:
				_localctx = new OpcoesAdquirirContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(153);
				adquirir();
				setState(154);
				corpo();
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

	public static class FulltextContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(GramaticaScriptParser.INT, 0); }
		public TerminalNode TEXTO() { return getToken(GramaticaScriptParser.TEXTO, 0); }
		public TerminalNode WORD() { return getToken(GramaticaScriptParser.WORD, 0); }
		public TerminalNode SPECIAL() { return getToken(GramaticaScriptParser.SPECIAL, 0); }
		public FulltextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fulltext; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterFulltext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitFulltext(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitFulltext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FulltextContext fulltext() throws RecognitionException {
		FulltextContext _localctx = new FulltextContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_fulltext);
		try {
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				match(INT);
				setState(159);
				match(TEXTO);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				match(WORD);
				setState(161);
				match(TEXTO);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(162);
				match(WORD);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(163);
				match(TEXTO);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(164);
				match(SPECIAL);
				setState(165);
				match(TEXTO);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(166);
				match(INT);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(167);
				match(SPECIAL);
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

	public static class AdquirirContext extends ParserRuleContext {
		public TerminalNode ADQUIRIR() { return getToken(GramaticaScriptParser.ADQUIRIR, 0); }
		public AdquirirOpcoesContext adquirirOpcoes() {
			return getRuleContext(AdquirirOpcoesContext.class,0);
		}
		public AdquirirContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_adquirir; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterAdquirir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitAdquirir(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitAdquirir(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdquirirContext adquirir() throws RecognitionException {
		AdquirirContext _localctx = new AdquirirContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_adquirir);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(ADQUIRIR);
			setState(171);
			match(T__12);
			setState(172);
			adquirirOpcoes();
			setState(173);
			match(T__13);
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

	public static class AdquirirOpcoesContext extends ParserRuleContext {
		public OpcoesContext opcoes() {
			return getRuleContext(OpcoesContext.class,0);
		}
		public RealizarContext realizar() {
			return getRuleContext(RealizarContext.class,0);
		}
		public ConsultarContext consultar() {
			return getRuleContext(ConsultarContext.class,0);
		}
		public AtribuirContext atribuir() {
			return getRuleContext(AtribuirContext.class,0);
		}
		public AdquirirOpcoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_adquirirOpcoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterAdquirirOpcoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitAdquirirOpcoes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitAdquirirOpcoes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdquirirOpcoesContext adquirirOpcoes() throws RecognitionException {
		AdquirirOpcoesContext _localctx = new AdquirirOpcoesContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_adquirirOpcoes);
		try {
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				opcoes();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				realizar();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(177);
				consultar();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(178);
				atribuir();
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

	public static class AtribuirContext extends ParserRuleContext {
		public FulltextContext fulltext() {
			return getRuleContext(FulltextContext.class,0);
		}
		public AtribuirOpcoesContext atribuirOpcoes() {
			return getRuleContext(AtribuirOpcoesContext.class,0);
		}
		public AtribuirContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuir; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterAtribuir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitAtribuir(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitAtribuir(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtribuirContext atribuir() throws RecognitionException {
		AtribuirContext _localctx = new AtribuirContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_atribuir);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(T__14);
			setState(182);
			match(T__7);
			setState(183);
			fulltext();
			setState(184);
			match(T__0);
			setState(185);
			atribuirOpcoes();
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

	public static class AtribuirOpcoesContext extends ParserRuleContext {
		public OpcoesContext opcoes() {
			return getRuleContext(OpcoesContext.class,0);
		}
		public RealizarContext realizar() {
			return getRuleContext(RealizarContext.class,0);
		}
		public AtribuirOpcoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuirOpcoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).enterAtribuirOpcoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaScriptListener ) ((GramaticaScriptListener)listener).exitAtribuirOpcoes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaScriptVisitor ) return ((GramaticaScriptVisitor<? extends T>)visitor).visitAtribuirOpcoes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtribuirOpcoesContext atribuirOpcoes() throws RecognitionException {
		AtribuirOpcoesContext _localctx = new AtribuirOpcoesContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_atribuirOpcoes);
		try {
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__6:
			case T__7:
			case FICHEIRO_TOKEN:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				opcoes();
				}
				break;
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case SE:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				realizar();
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u00c2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\5\3\66\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5V\n"+
		"\5\3\6\3\6\3\6\3\6\5\6\\\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\5\n{\n\n\3\13\3\13\3\f\3\f\3\f\3\f\5\f\u0083\n\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\5\16\u009f\n\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\5\17\u00ab\n\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\5\21\u00b6\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\5\23"+
		"\u00c0\n\23\3\23\2\2\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\4"+
		"\3\2\5\b\3\2\13\16\2\u00c9\2&\3\2\2\2\4\65\3\2\2\2\6\67\3\2\2\2\bU\3\2"+
		"\2\2\n[\3\2\2\2\f]\3\2\2\2\16`\3\2\2\2\20c\3\2\2\2\22z\3\2\2\2\24|\3\2"+
		"\2\2\26\u0082\3\2\2\2\30\u0084\3\2\2\2\32\u009e\3\2\2\2\34\u00aa\3\2\2"+
		"\2\36\u00ac\3\2\2\2 \u00b5\3\2\2\2\"\u00b7\3\2\2\2$\u00bf\3\2\2\2&\'\5"+
		"\4\3\2\'\3\3\2\2\2(\66\3\2\2\2)*\5\6\4\2*+\5\4\3\2+\66\3\2\2\2,-\5\n\6"+
		"\2-.\5\4\3\2.\66\3\2\2\2/\60\5\30\r\2\60\61\5\4\3\2\61\66\3\2\2\2\62\63"+
		"\5\"\22\2\63\64\5\4\3\2\64\66\3\2\2\2\65(\3\2\2\2\65)\3\2\2\2\65,\3\2"+
		"\2\2\65/\3\2\2\2\65\62\3\2\2\2\66\5\3\2\2\2\678\7\22\2\289\7\3\2\29:\7"+
		"\37\2\2:;\7\3\2\2;<\5\b\5\2<\7\3\2\2\2=>\7\23\2\2>?\7\34\2\2?@\7\3\2\2"+
		"@A\7\35\2\2AV\7\3\2\2BC\7\24\2\2CD\7\34\2\2DE\7\3\2\2EF\7\35\2\2FG\7\3"+
		"\2\2GH\7\25\2\2HV\7\34\2\2IJ\7\4\2\2JK\7\3\2\2KL\7\35\2\2LM\7\3\2\2MN"+
		"\7\3\2\2NO\5\34\17\2OP\7\3\2\2PQ\7\3\2\2QR\7\35\2\2RS\7\3\2\2ST\7\34\2"+
		"\2TV\3\2\2\2U=\3\2\2\2UB\3\2\2\2UI\3\2\2\2V\t\3\2\2\2WX\t\2\2\2X\\\5\f"+
		"\7\2YZ\7\26\2\2Z\\\5\16\b\2[W\3\2\2\2[Y\3\2\2\2\\\13\3\2\2\2]^\5\22\n"+
		"\2^_\5\22\n\2_\r\3\2\2\2`a\5\20\t\2ab\5\26\f\2b\17\3\2\2\2cd\5\22\n\2"+
		"de\5\24\13\2ef\5\22\n\2f\21\3\2\2\2gh\7\22\2\2hi\7\3\2\2ij\7\37\2\2jk"+
		"\7\3\2\2kl\7\23\2\2lm\7\34\2\2mn\7\3\2\2no\7\35\2\2o{\7\3\2\2pq\7\t\2"+
		"\2q{\7\34\2\2r{\7\34\2\2st\7\3\2\2tu\7\35\2\2u{\7\3\2\2vw\7\n\2\2wx\5"+
		"\34\17\2xy\7\3\2\2y{\3\2\2\2zg\3\2\2\2zp\3\2\2\2zr\3\2\2\2zs\3\2\2\2z"+
		"v\3\2\2\2{\23\3\2\2\2|}\t\3\2\2}\25\3\2\2\2~\u0083\5\6\4\2\177\u0083\5"+
		"\30\r\2\u0080\u0083\5\n\6\2\u0081\u0083\5\"\22\2\u0082~\3\2\2\2\u0082"+
		"\177\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0081\3\2\2\2\u0083\27\3\2\2\2"+
		"\u0084\u0085\7\27\2\2\u0085\u0086\7\3\2\2\u0086\u0087\7\36\2\2\u0087\u0088"+
		"\7\3\2\2\u0088\u0089\7\30\2\2\u0089\u008a\7\3\2\2\u008a\u008b\5\34\17"+
		"\2\u008b\u008c\7\3\2\2\u008c\u008d\7\31\2\2\u008d\u008e\7\3\2\2\u008e"+
		"\u008f\5\34\17\2\u008f\u0090\7\3\2\2\u0090\u0091\7\32\2\2\u0091\u0092"+
		"\7\3\2\2\u0092\u0093\5\32\16\2\u0093\u0094\7\3\2\2\u0094\u0095\7\33\2"+
		"\2\u0095\u0096\7\34\2\2\u0096\31\3\2\2\2\u0097\u009f\3\2\2\2\u0098\u0099"+
		"\5\34\17\2\u0099\u009a\5\32\16\2\u009a\u009f\3\2\2\2\u009b\u009c\5\36"+
		"\20\2\u009c\u009d\5\32\16\2\u009d\u009f\3\2\2\2\u009e\u0097\3\2\2\2\u009e"+
		"\u0098\3\2\2\2\u009e\u009b\3\2\2\2\u009f\33\3\2\2\2\u00a0\u00a1\7\34\2"+
		"\2\u00a1\u00ab\7\37\2\2\u00a2\u00a3\7\35\2\2\u00a3\u00ab\7\37\2\2\u00a4"+
		"\u00ab\7\35\2\2\u00a5\u00ab\7\37\2\2\u00a6\u00a7\7 \2\2\u00a7\u00ab\7"+
		"\37\2\2\u00a8\u00ab\7\34\2\2\u00a9\u00ab\7 \2\2\u00aa\u00a0\3\2\2\2\u00aa"+
		"\u00a2\3\2\2\2\u00aa\u00a4\3\2\2\2\u00aa\u00a5\3\2\2\2\u00aa\u00a6\3\2"+
		"\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\35\3\2\2\2\u00ac\u00ad"+
		"\7\"\2\2\u00ad\u00ae\7\17\2\2\u00ae\u00af\5 \21\2\u00af\u00b0\7\20\2\2"+
		"\u00b0\37\3\2\2\2\u00b1\u00b6\5\22\n\2\u00b2\u00b6\5\n\6\2\u00b3\u00b6"+
		"\5\6\4\2\u00b4\u00b6\5\"\22\2\u00b5\u00b1\3\2\2\2\u00b5\u00b2\3\2\2\2"+
		"\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6!\3\2\2\2\u00b7\u00b8\7"+
		"\21\2\2\u00b8\u00b9\7\n\2\2\u00b9\u00ba\5\34\17\2\u00ba\u00bb\7\3\2\2"+
		"\u00bb\u00bc\5$\23\2\u00bc#\3\2\2\2\u00bd\u00c0\5\22\n\2\u00be\u00c0\5"+
		"\n\6\2\u00bf\u00bd\3\2\2\2\u00bf\u00be\3\2\2\2\u00c0%\3\2\2\2\13\65U["+
		"z\u0082\u009e\u00aa\u00b5\u00bf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}