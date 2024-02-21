// Generated from C:/Users/35191/Documents/lei20_21_s4_2dj_03/eapli.base/base.gramaticas/src/main/java/eapli/base/gramaticas/script/eapli/base/gramaticas/formulario/eapli/base/gramaticas/script/eapli/base/gramaticas/formulario\FormularioGrammar.g4 by ANTLR 4.9.1
package eapli.base.gramaticas.script.eapli.base.gramaticas.formulario.eapli.base.gramaticas.script.eapli.base.gramaticas.formulario;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link FormularioGrammarVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class FormularioGrammarBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements FormularioGrammarVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitProg(FormularioGrammarParser.ProgContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitStat(FormularioGrammarParser.StatContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitLinha(FormularioGrammarParser.LinhaContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitRegraNome(FormularioGrammarParser.RegraNomeContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitRegraExpressao(FormularioGrammarParser.RegraExpressaoContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitRegraTipo(FormularioGrammarParser.RegraTipoContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitRegraResposta(FormularioGrammarParser.RegraRespostaContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitMudarObrigatoriedade(FormularioGrammarParser.MudarObrigatoriedadeContext ctx) { return visitChildren(ctx); }
}