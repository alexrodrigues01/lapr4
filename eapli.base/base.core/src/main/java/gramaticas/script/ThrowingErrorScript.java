package gramaticas.script;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class ThrowingErrorScript extends BaseErrorListener {
    private static final String MENSAGEM_ERRO = "Script Inválido";

    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        throw new ParseCancellationException(MENSAGEM_ERRO + "- linha " + line + ": " + charPositionInLine + " " + msg);
    }

    public static String prefixoMensagemErro(int linha) {
        return MENSAGEM_ERRO + "(Linha " + linha + ")";
    }
}
