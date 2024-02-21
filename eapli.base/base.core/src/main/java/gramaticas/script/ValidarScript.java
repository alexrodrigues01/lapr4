package gramaticas.script;

import eapli.base.servicomanagement.domain.FormularioP;
import eapli.base.tarefamanagement.domain.Script;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class ValidarScript {
    public static void visitor(FormularioP formularioP, Script script, boolean interpretacao)
    {
        GramaticaScriptLexer lexer = new GramaticaScriptLexer(CharStreams.fromString(script.toString()));

        lexer.removeErrorListeners();
        lexer.addErrorListener(new ThrowingErrorScript());

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        GramaticaScriptParser parser = new GramaticaScriptParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new ThrowingErrorScript());

        ParseTree tree = parser.start(); // parse
        GramaticaScriptVisitorImplement eval = new GramaticaScriptVisitorImplement(interpretacao);

        eval.setFormularioP(formularioP);

        eval.visit(tree);
    }
    public static void listener(FormularioP formularioP,Script script,boolean interpretacao){
        GramaticaScriptLexer lexer = new GramaticaScriptLexer(CharStreams.fromString(script.toString()));

        lexer.removeErrorListeners();
        lexer.addErrorListener(new ThrowingErrorScript());

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        GramaticaScriptParser parser = new GramaticaScriptParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new ThrowingErrorScript());

        ParseTree tree = parser.start(); // parse

        GramaticaScriptListenerImplement testeListenerImplement = new GramaticaScriptListenerImplement(interpretacao);

        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();

        testeListenerImplement.setFormularioP(formularioP);
        parseTreeWalker.walk(testeListenerImplement,tree);

    }
}
