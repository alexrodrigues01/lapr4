package gramaticas.formulario;

import eapli.base.servicomanagement.domain.FormularioP;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class ValidacaoFormulario {
    public String validarFormularioVisitor(FormularioP formulario){
        try{
            return lexerParser(true, formulario);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "NotOK";
        }
    }

    public String validarFormularioListener(FormularioP formularioP){
        try{
            return lexerParser(false, formularioP);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "NotOK";
        }
    }

    private String lexerParser(boolean isVisitor, FormularioP formulario){
        FormularioGrammarLexer lexer = new FormularioGrammarLexer(CharStreams.fromString(formulario.infoValidacao()));

        lexer.removeErrorListeners();
        lexer.addErrorListener(new FormularioGrammarError());

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        FormularioGrammarParser parser = new FormularioGrammarParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new FormularioGrammarError());

        ParseTree tree = parser.stat();

        if(isVisitor){
            FormularioVisitorImplement visitor = new FormularioVisitorImplement();

            visitor.visit(tree);

            return visitor.getResultado();
        }else{
            FormularioListenerImplement listener = new FormularioListenerImplement();

            ParseTreeWalker parseTreeWalker = new ParseTreeWalker();

            parseTreeWalker.walk(listener,tree);

            return listener.getResultado();
        }
    }
}
