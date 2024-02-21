// Generated from C:/Users/RALEX/Documents/Reposit�rios 4� Semestre/LAPR4/lei20_21_s4_2dj_03/eapli.base/base.gramaticas/src/main/java/eapli/base/gramaticas/script/eapli/base/gramaticas/script\GramaticaScript.g4 by ANTLR 4.9.1
package eapli.base.gramaticas.script.eapli.base.gramaticas.script;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GramaticaScriptParser}.
 */
public interface GramaticaScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GramaticaScriptParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(GramaticaScriptParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaScriptParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(GramaticaScriptParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaScriptParser#continuee}.
	 * @param ctx the parse tree
	 */
	void enterContinuee(GramaticaScriptParser.ContinueeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaScriptParser#continuee}.
	 * @param ctx the parse tree
	 */
	void exitContinuee(GramaticaScriptParser.ContinueeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaScriptParser#consultar}.
	 * @param ctx the parse tree
	 */
	void enterConsultar(GramaticaScriptParser.ConsultarContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaScriptParser#consultar}.
	 * @param ctx the parse tree
	 */
	void exitConsultar(GramaticaScriptParser.ConsultarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code consultarFile}
	 * labeled alternative in {@link GramaticaScriptParser#opcoesFicheiro}.
	 * @param ctx the parse tree
	 */
	void enterConsultarFile(GramaticaScriptParser.ConsultarFileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code consultarFile}
	 * labeled alternative in {@link GramaticaScriptParser#opcoesFicheiro}.
	 * @param ctx the parse tree
	 */
	void exitConsultarFile(GramaticaScriptParser.ConsultarFileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atualizarFile}
	 * labeled alternative in {@link GramaticaScriptParser#opcoesFicheiro}.
	 * @param ctx the parse tree
	 */
	void enterAtualizarFile(GramaticaScriptParser.AtualizarFileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atualizarFile}
	 * labeled alternative in {@link GramaticaScriptParser#opcoesFicheiro}.
	 * @param ctx the parse tree
	 */
	void exitAtualizarFile(GramaticaScriptParser.AtualizarFileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atualizarSomaFile}
	 * labeled alternative in {@link GramaticaScriptParser#opcoesFicheiro}.
	 * @param ctx the parse tree
	 */
	void enterAtualizarSomaFile(GramaticaScriptParser.AtualizarSomaFileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atualizarSomaFile}
	 * labeled alternative in {@link GramaticaScriptParser#opcoesFicheiro}.
	 * @param ctx the parse tree
	 */
	void exitAtualizarSomaFile(GramaticaScriptParser.AtualizarSomaFileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code calculo}
	 * labeled alternative in {@link GramaticaScriptParser#realizar}.
	 * @param ctx the parse tree
	 */
	void enterCalculo(GramaticaScriptParser.CalculoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code calculo}
	 * labeled alternative in {@link GramaticaScriptParser#realizar}.
	 * @param ctx the parse tree
	 */
	void exitCalculo(GramaticaScriptParser.CalculoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if}
	 * labeled alternative in {@link GramaticaScriptParser#realizar}.
	 * @param ctx the parse tree
	 */
	void enterIf(GramaticaScriptParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if}
	 * labeled alternative in {@link GramaticaScriptParser#realizar}.
	 * @param ctx the parse tree
	 */
	void exitIf(GramaticaScriptParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaScriptParser#operacao}.
	 * @param ctx the parse tree
	 */
	void enterOperacao(GramaticaScriptParser.OperacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaScriptParser#operacao}.
	 * @param ctx the parse tree
	 */
	void exitOperacao(GramaticaScriptParser.OperacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaScriptParser#se}.
	 * @param ctx the parse tree
	 */
	void enterSe(GramaticaScriptParser.SeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaScriptParser#se}.
	 * @param ctx the parse tree
	 */
	void exitSe(GramaticaScriptParser.SeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaScriptParser#verificarCondicao}.
	 * @param ctx the parse tree
	 */
	void enterVerificarCondicao(GramaticaScriptParser.VerificarCondicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaScriptParser#verificarCondicao}.
	 * @param ctx the parse tree
	 */
	void exitVerificarCondicao(GramaticaScriptParser.VerificarCondicaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberFile}
	 * labeled alternative in {@link GramaticaScriptParser#opcoes}.
	 * @param ctx the parse tree
	 */
	void enterNumberFile(GramaticaScriptParser.NumberFileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberFile}
	 * labeled alternative in {@link GramaticaScriptParser#opcoes}.
	 * @param ctx the parse tree
	 */
	void exitNumberFile(GramaticaScriptParser.NumberFileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atributoForm}
	 * labeled alternative in {@link GramaticaScriptParser#opcoes}.
	 * @param ctx the parse tree
	 */
	void enterAtributoForm(GramaticaScriptParser.AtributoFormContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atributoForm}
	 * labeled alternative in {@link GramaticaScriptParser#opcoes}.
	 * @param ctx the parse tree
	 */
	void exitAtributoForm(GramaticaScriptParser.AtributoFormContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inteiro}
	 * labeled alternative in {@link GramaticaScriptParser#opcoes}.
	 * @param ctx the parse tree
	 */
	void enterInteiro(GramaticaScriptParser.InteiroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inteiro}
	 * labeled alternative in {@link GramaticaScriptParser#opcoes}.
	 * @param ctx the parse tree
	 */
	void exitInteiro(GramaticaScriptParser.InteiroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code textoOpcao}
	 * labeled alternative in {@link GramaticaScriptParser#opcoes}.
	 * @param ctx the parse tree
	 */
	void enterTextoOpcao(GramaticaScriptParser.TextoOpcaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code textoOpcao}
	 * labeled alternative in {@link GramaticaScriptParser#opcoes}.
	 * @param ctx the parse tree
	 */
	void exitTextoOpcao(GramaticaScriptParser.TextoOpcaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaScriptParser#operadores}.
	 * @param ctx the parse tree
	 */
	void enterOperadores(GramaticaScriptParser.OperadoresContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaScriptParser#operadores}.
	 * @param ctx the parse tree
	 */
	void exitOperadores(GramaticaScriptParser.OperadoresContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaScriptParser#funcionalidade}.
	 * @param ctx the parse tree
	 */
	void enterFuncionalidade(GramaticaScriptParser.FuncionalidadeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaScriptParser#funcionalidade}.
	 * @param ctx the parse tree
	 */
	void exitFuncionalidade(GramaticaScriptParser.FuncionalidadeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code email}
	 * labeled alternative in {@link GramaticaScriptParser#enviar}.
	 * @param ctx the parse tree
	 */
	void enterEmail(GramaticaScriptParser.EmailContext ctx);
	/**
	 * Exit a parse tree produced by the {@code email}
	 * labeled alternative in {@link GramaticaScriptParser#enviar}.
	 * @param ctx the parse tree
	 */
	void exitEmail(GramaticaScriptParser.EmailContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blank}
	 * labeled alternative in {@link GramaticaScriptParser#corpo}.
	 * @param ctx the parse tree
	 */
	void enterBlank(GramaticaScriptParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link GramaticaScriptParser#corpo}.
	 * @param ctx the parse tree
	 */
	void exitBlank(GramaticaScriptParser.BlankContext ctx);
	/**
	 * Enter a parse tree produced by the {@code texto}
	 * labeled alternative in {@link GramaticaScriptParser#corpo}.
	 * @param ctx the parse tree
	 */
	void enterTexto(GramaticaScriptParser.TextoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code texto}
	 * labeled alternative in {@link GramaticaScriptParser#corpo}.
	 * @param ctx the parse tree
	 */
	void exitTexto(GramaticaScriptParser.TextoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code opcoesAdquirir}
	 * labeled alternative in {@link GramaticaScriptParser#corpo}.
	 * @param ctx the parse tree
	 */
	void enterOpcoesAdquirir(GramaticaScriptParser.OpcoesAdquirirContext ctx);
	/**
	 * Exit a parse tree produced by the {@code opcoesAdquirir}
	 * labeled alternative in {@link GramaticaScriptParser#corpo}.
	 * @param ctx the parse tree
	 */
	void exitOpcoesAdquirir(GramaticaScriptParser.OpcoesAdquirirContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaScriptParser#fulltext}.
	 * @param ctx the parse tree
	 */
	void enterFulltext(GramaticaScriptParser.FulltextContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaScriptParser#fulltext}.
	 * @param ctx the parse tree
	 */
	void exitFulltext(GramaticaScriptParser.FulltextContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaScriptParser#adquirir}.
	 * @param ctx the parse tree
	 */
	void enterAdquirir(GramaticaScriptParser.AdquirirContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaScriptParser#adquirir}.
	 * @param ctx the parse tree
	 */
	void exitAdquirir(GramaticaScriptParser.AdquirirContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaScriptParser#adquirirOpcoes}.
	 * @param ctx the parse tree
	 */
	void enterAdquirirOpcoes(GramaticaScriptParser.AdquirirOpcoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaScriptParser#adquirirOpcoes}.
	 * @param ctx the parse tree
	 */
	void exitAdquirirOpcoes(GramaticaScriptParser.AdquirirOpcoesContext ctx);
}