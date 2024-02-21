package eapli.base.app.backoffice.console.presentation.pedido;

import eapli.base.servicomanagement.application.ConsultarPedidosController;
import eapli.base.servicomanagement.domain.PedidoDTO;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Map;
import java.util.TreeSet;

public class ConsultarPedidosUI extends AbstractUI {


    @Override
    protected boolean doShow() {
        ConsultarPedidosController consultarPedidosController= new ConsultarPedidosController();
        Map<TreeSet<PedidoDTO>, TreeSet<PedidoDTO>> listasPedidos=consultarPedidosController.getPedidosUser();


        System.out.println("Lista de Pedidos em Curso ordenada dos mais recentes para os mais antigos");
        for(PedidoDTO pedidoDTO: (TreeSet<PedidoDTO>) listasPedidos.keySet().toArray()[0]){
            System.out.println(pedidoDTO);
        }

        System.out.println("Lista de histórico de pedidos ordenada dos mais recentes para os mais antigos");
        for(PedidoDTO pedidoDTO: listasPedidos.get(listasPedidos.keySet().toArray()[0])){
            System.out.println(pedidoDTO);
        }

        return true;
    }

    @Override
    public String headline() {
        return "+= Consultar Pedidos ===============";
    }
}
