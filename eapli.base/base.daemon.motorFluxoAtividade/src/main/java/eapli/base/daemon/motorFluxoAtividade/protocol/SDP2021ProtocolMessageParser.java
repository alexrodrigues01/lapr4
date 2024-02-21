package eapli.base.daemon.motorFluxoAtividade.protocol;

import eapli.base.daemon.motorFluxoAtividade.Utils.Constantes;
import eapli.framework.csv.util.CsvLineMarshaler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;

public class SDP2021ProtocolMessageParser {

    private  SDP2021ProtocolMessageParser(){}


        private static final Logger LOGGER = LogManager.getLogger(ProtocolMessageParser.class);
        // as a fallback make sure we return unknown


        // parse to determine which type of request and if it is sintactally valid
        public static SDP2021ProtocolRequest parse(final byte [] bytes) {
            SDP2021ProtocolRequest request = new UnknownRequest(new String(bytes));
            if(bytes[Constantes.VERSAO_POS] != Constantes.VERSAO){
                request= new EndRequest(new String(bytes));
            }

            if(bytes[Constantes.CODE_POS]==Constantes.TESTE_REQUEST){
                System.out.println(parseMessage(bytes));
                request=new EndRequest(new String(bytes));
            }else if(bytes[Constantes.CODE_POS]==Constantes.END_REQUEST){
                request=new EndRequest(new String(bytes));
            }else if(bytes[Constantes.CODE_POS]==Constantes.ENTENDIDO){

            }else if(bytes[Constantes.CODE_POS]==Constantes.LOGIN){
                request= new LoginRequest(new String(bytes));
            }else if(bytes[Constantes.CODE_POS]==Constantes.TAREFA_FALHOU){
                request= new TarefaFalhouRequest(new String(bytes));
            }else if(bytes[Constantes.CODE_POS]==Constantes.TAREFA_TERMINADA){
                request= new TarefaTerminadaRequest(new String(bytes));
            }else{
                request= new ErrorInRequest(new String(bytes),"Invalid Code");
            }
        return request;
    }

    public static String parseMessage(byte [] bytes) {
        System.out.println("Tamanho: "+bytes[Constantes.SIZE_POS]);
        byte [] data=new byte[bytes[2]];
        for (int i = 0; i < bytes[2]; i++) {
           data[i]=bytes[i+3];
        }
        return new String(data,StandardCharsets.UTF_8);
    }

}

