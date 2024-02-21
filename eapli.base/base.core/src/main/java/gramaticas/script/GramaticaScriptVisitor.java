// Generated from C:/Users/User/Documents/lei20_21_s4_2dj_03/eapli.base/base.core/src/main/java/gramaticas/script\GramaticaScript.g4 by ANTLR 4.9.1
package gramaticas.script;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GramaticaScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GramaticaScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GramaticaScriptParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(GramaticaScriptParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaScriptParser#continuee}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinuee(GramaticaScriptParser.ContinueeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaScriptParser#consultar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConsultar(GramaticaScriptParser.ConsultarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code consultarFile}
	 * labeled alternative in {@link GramaticaScriptParser#opcoesFicheiro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConsultarFile(GramaticaScriptParser.ConsultarFileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atualizarFile}
	 * labeled alternative in {@link GramaticaScriptParser#opcoesFicheiro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtualizarFile(GramaticaScriptParser.AtualizarFileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atualizarSomaFile}
	 * labeled alternative in {@link GramaticaScriptParser#opcoesFicheiro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtualizarSomaFile(GramaticaScriptParser.AtualizarSomaFileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code calculo}
	 * labeled alternative in {@link GramaticaScriptParser#realizar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalculo(GramaticaScriptParser.CalculoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link GramaticaScriptParser#realizar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(GramaticaScriptParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaScriptParser#operacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperacao(GramaticaScriptParser.OperacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaScriptParser#se}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSe(GramaticaScriptParser.SeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaScriptParser#verificarCondicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerificarCondicao(GramaticaScriptParser.VerificarCondicaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberFile}
	 * labeled alternative in {@link GramaticaScriptParser#opcoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberFile(GramaticaScriptParser.NumberFileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atributoForm}
	 * labeled alternative in {@link GramaticaScriptParser#opcoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtributoForm(GramaticaScriptParser.AtributoFormContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inteiro}
	 * labeled alternative in {@link GramaticaScriptParser#opcoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteiro(GramaticaScriptParser.InteiroContext ctx);
	/**
	 * Visit a parse tree produced by the {@code textoOpcao}
	 * labeled alternative in {@link GramaticaScriptParser#opcoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextoOpcao(GramaticaScriptParser.TextoOpcaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atribuirOp}
	 * labeled alternative in {@link GramaticaScriptParser#opcoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuirOp(GramaticaScriptParser.AtribuirOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaScriptParser#operadores}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperadores(GramaticaScriptParser.OperadoresContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaScriptParser#funcionalidade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncionalidade(GramaticaScriptParser.FuncionalidadeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code email}
	 * labeled alternative in {@link GramaticaScriptParser#enviar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmail(GramaticaScriptParser.EmailContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link GramaticaScriptParser#corpo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlank(GramaticaScriptParser.BlankContext ctx);
	/**
	 * Visit a parse tree produced by the {@code texto}
	 * labeled alternative in {@link GramaticaScriptParser#corpo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTexto(GramaticaScriptParser.TextoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code opcoesAdquirir}
	 * labeled alternative in {@link GramaticaScriptParser#corpo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpcoesAdquirir(GramaticaScriptParser.OpcoesAdquirirContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaScriptParser#fulltext}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFulltext(GramaticaScriptParser.FulltextContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaScriptParser#adquirir}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdquirir(GramaticaScriptParser.AdquirirContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaScriptParser#adquirirOpcoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdquirirOpcoes(GramaticaScriptParser.AdquirirOpcoesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaScriptParser#atribuir}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuir(GramaticaScriptParser.AtribuirContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaScriptParser#atribuirOpcoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuirOpcoes(GramaticaScriptParser.AtribuirOpcoesContext ctx);
}