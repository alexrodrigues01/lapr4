// Generated from C:/Users/35191/Documents/lei20_21_s4_2dj_03/eapli.base/base.gramaticas/src/main/java/eapli/base/gramaticas/script/eapli/base/gramaticas/formulario/eapli/base/gramaticas/script/eapli/base/gramaticas/formulario\FormularioGrammar.g4 by ANTLR 4.9.1
package eapli.base.gramaticas.script.eapli.base.gramaticas.formulario.eapli.base.gramaticas.script.eapli.base.gramaticas.formulario;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FormularioGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FormularioGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FormularioGrammarParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(FormularioGrammarParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormularioGrammarParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(FormularioGrammarParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormularioGrammarParser#linha}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLinha(FormularioGrammarParser.LinhaContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormularioGrammarParser#regraNome}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegraNome(FormularioGrammarParser.RegraNomeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormularioGrammarParser#regraExpressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegraExpressao(FormularioGrammarParser.RegraExpressaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormularioGrammarParser#regraTipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegraTipo(FormularioGrammarParser.RegraTipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormularioGrammarParser#regraResposta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegraResposta(FormularioGrammarParser.RegraRespostaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mudarObrigatoriedade}
	 * labeled alternative in {@link FormularioGrammarParser#alternativa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMudarObrigatoriedade(FormularioGrammarParser.MudarObrigatoriedadeContext ctx);
}