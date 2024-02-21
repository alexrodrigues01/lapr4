// Generated from C:/Users/35191/Documents/lei20_21_s4_2dj_03/eapli.base/base.gramaticas/src/main/java/eapli/base/gramaticas/script/eapli/base/gramaticas/formulario/eapli/base/gramaticas/script/eapli/base/gramaticas/formulario\FormularioGrammar.g4 by ANTLR 4.9.1
package eapli.base.gramaticas.script.eapli.base.gramaticas.formulario.eapli.base.gramaticas.script.eapli.base.gramaticas.formulario;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FormularioGrammarParser}.
 */
public interface FormularioGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FormularioGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(FormularioGrammarParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormularioGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(FormularioGrammarParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormularioGrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(FormularioGrammarParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormularioGrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(FormularioGrammarParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormularioGrammarParser#linha}.
	 * @param ctx the parse tree
	 */
	void enterLinha(FormularioGrammarParser.LinhaContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormularioGrammarParser#linha}.
	 * @param ctx the parse tree
	 */
	void exitLinha(FormularioGrammarParser.LinhaContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormularioGrammarParser#regraNome}.
	 * @param ctx the parse tree
	 */
	void enterRegraNome(FormularioGrammarParser.RegraNomeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormularioGrammarParser#regraNome}.
	 * @param ctx the parse tree
	 */
	void exitRegraNome(FormularioGrammarParser.RegraNomeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormularioGrammarParser#regraExpressao}.
	 * @param ctx the parse tree
	 */
	void enterRegraExpressao(FormularioGrammarParser.RegraExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormularioGrammarParser#regraExpressao}.
	 * @param ctx the parse tree
	 */
	void exitRegraExpressao(FormularioGrammarParser.RegraExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormularioGrammarParser#regraTipo}.
	 * @param ctx the parse tree
	 */
	void enterRegraTipo(FormularioGrammarParser.RegraTipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormularioGrammarParser#regraTipo}.
	 * @param ctx the parse tree
	 */
	void exitRegraTipo(FormularioGrammarParser.RegraTipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormularioGrammarParser#regraResposta}.
	 * @param ctx the parse tree
	 */
	void enterRegraResposta(FormularioGrammarParser.RegraRespostaContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormularioGrammarParser#regraResposta}.
	 * @param ctx the parse tree
	 */
	void exitRegraResposta(FormularioGrammarParser.RegraRespostaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mudarObrigatoriedade}
	 * labeled alternative in {@link FormularioGrammarParser#alternativa}.
	 * @param ctx the parse tree
	 */
	void enterMudarObrigatoriedade(FormularioGrammarParser.MudarObrigatoriedadeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mudarObrigatoriedade}
	 * labeled alternative in {@link FormularioGrammarParser#alternativa}.
	 * @param ctx the parse tree
	 */
	void exitMudarObrigatoriedade(FormularioGrammarParser.MudarObrigatoriedadeContext ctx);
}