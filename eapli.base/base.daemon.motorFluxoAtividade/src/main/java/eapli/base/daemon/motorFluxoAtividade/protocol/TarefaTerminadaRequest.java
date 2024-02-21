package eapli.base.daemon.motorFluxoAtividade.protocol;

import eapli.base.daemon.motorFluxoAtividade.Utils.Constantes;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Pedido;
import eapli.base.servicomanagement.repositories.PedidoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class TarefaTerminadaRequest extends SDP2021ProtocolRequest {
    private static final Logger LOGGER = LogManager.getLogger(TarefaTerminadaRequest.class);
    public TarefaTerminadaRequest(String s) {
        super(s,true);
    }

    @Override
    public byte[] execute() {
        byte [] tarefaTerminadaBytes = request.getBytes(StandardCharsets.UTF_8);
        byte[] tarefaBytes = new byte[tarefaTerminadaBytes[Constantes.SIZE_POS]];
        int j = 0;
        for (Byte b : tarefaTerminadaBytes) {
            if(j>=tarefaTerminadaBytes[Constantes.SIZE_POS]+3)
                break;
            if(j>=Constantes.DATA_POS)
                tarefaBytes[j-3] = b;
            j++;
        }
        ByteArrayInputStream bis = new ByteArrayInputStream(tarefaBytes);
        ObjectInput input = null;
        String pedido = new String(tarefaBytes, StandardCharsets.UTF_8);

        System.out.println(pedido);
        PedidoRepository pedidoRepository= PersistenceContext.repositories().pedido();
        Pedido pedido1 = pedidoRepository.getPedidosById(pedido);
        pedido1.mudarEstadoTarefaDone();
        pedidoRepository.save(pedido1);
        LOGGER.info("PEDIDO {} TERMINADO COM SUCESSO!",pedido);
        byte [] resposta=new byte[2];
        resposta[Constantes.VERSAO_POS]=Constantes.VERSAO;
        resposta[Constantes.CODE_POS]=Constantes.ENTENDIDO;
        return resposta;
    }

    @Override
    protected String messageType() {
        return null;
    }
}
