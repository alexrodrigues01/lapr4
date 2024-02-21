package eapli.base.daemon.motorFluxoAtividade.protocol;

import eapli.base.daemon.motorFluxoAtividade.Utils.Constantes;

public class EndRequest extends SDP2021ProtocolRequest{

    public EndRequest(String inputline){
        super(inputline,true);
    }
    @Override
    public byte [] execute() {
        byte [] resposta=new byte[2];
        resposta[Constantes.VERSAO_POS]=Constantes.VERSAO;
        resposta[Constantes.CODE_POS]=Constantes.ENTENDIDO;
        return resposta;
    }

    @Override
    protected String messageType() {
        return "";
    }
}
