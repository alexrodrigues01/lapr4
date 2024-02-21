package eapli.base.daemon.executorTarefasAutomaticas.protocol;


import eapli.base.daemon.executorTarefasAutomaticas.utils.Constantes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.StandardCharsets;

public class SDP2021ProtocolMessageParserExecutor {

    private SDP2021ProtocolMessageParserExecutor(){}

    private static final Logger LOGGER = LogManager.getLogger(ProtocolMessageParser.class);
    // as a fallback make sure we return unknown


    // parse to determine which type of request and if it is sintactally valid
    public static SDP2021ProtocolRequest parse(final byte [] bytes) {
        String inputLine = new String(bytes);
        SDP2021ProtocolRequest request = new UnknownRequest(inputLine);

        if(bytes[Constantes.VERSAO_POS] != Constantes.VERSAO){
            request= new EndRequest(inputLine);
        }

        if(bytes[Constantes.CODE_POS]==Constantes.TESTE_REQUEST){
            System.out.println(parseMessage(bytes));
            request=new EndRequest(inputLine);
        }else if(bytes[Constantes.CODE_POS]==Constantes.END_REQUEST){
            request=new EndRequest(inputLine);
        }else if(bytes[Constantes.CODE_POS]==Constantes.ENTENDIDO) {

        }else if(bytes[Constantes.CODE_POS]==Constantes.RECEBER_TAREFA){
            request=new ExecutarTarefaRequest(inputLine,parseMessage(bytes),1,false);
        }else{
            request= new ErrorInRequest(inputLine,"Invalid Code");

        }
        return request;
    }

    public static String parseMessage(byte [] bytes) {
        byte [] data=new byte[bytes[2]];
        for (int i = 0; i < bytes[2]; i++) {
            data[i]=bytes[i+3];
        }
        return new String(data,StandardCharsets.UTF_8);
    }
}
