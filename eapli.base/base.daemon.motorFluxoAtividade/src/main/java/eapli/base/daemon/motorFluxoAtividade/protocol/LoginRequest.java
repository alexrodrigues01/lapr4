package eapli.base.daemon.motorFluxoAtividade.protocol;

import eapli.base.daemon.motorFluxoAtividade.Utils.Constantes;

public class LoginRequest extends SDP2021ProtocolRequest {
    public LoginRequest(String s) {
        super(s,false);
    }

    @Override
    public byte[] execute() {
        byte [] resposta=new byte[3];
        resposta[Constantes.VERSAO_POS]=Constantes.VERSAO;
        resposta[Constantes.CODE_POS]=Constantes.ENTENDIDO;
        resposta[Constantes.SIZE_POS]=0;
        return resposta;
    }

    @Override
    protected String messageType() {
        return null;
    }
}
