package eapli.base.daemon.executorTarefasAutomaticas.protocol;


import eapli.base.daemon.executorTarefasAutomaticas.utils.Constantes;

public class EndRequest extends SDP2021ProtocolRequest{

    public EndRequest(String inputline){
        super(inputline,true);
    }
    @Override
    public String execute() {
        byte [] resposta=new byte[2];
        resposta[Constantes.VERSAO_POS]=Constantes.VERSAO;
        resposta[Constantes.CODE_POS]=Constantes.ENTENDIDO;
        return new String(resposta);
    }

    @Override
    protected String messageType() {
        return "";
    }
}
