package eapli.base.servicomanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.EstadoPedido;
import eapli.base.servicomanagement.domain.Pedido;
import eapli.base.servicomanagement.domain.PedidoDTO;
import eapli.base.servicomanagement.repositories.PedidoRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.*;

public class ConsultarPedidosController {
    public Map<TreeSet<PedidoDTO>, TreeSet<PedidoDTO>> getPedidosUser() {
        Map<TreeSet<PedidoDTO>, TreeSet<PedidoDTO>> ret= new HashMap<>();
        AuthorizationService authz = AuthzRegistry.authorizationService();
        UserSession userSession = authz.session().orElseThrow(IllegalStateException::new);
        SystemUser systemUser = userSession.authenticatedUser();
        EmailAddress email = systemUser.email();
        PedidoRepository pedidoRepository = PersistenceContext.repositories().pedido();
        List<Pedido> listaPedidosUser = pedidoRepository.getPedidosUser(email.toString());
        List<Pedido> listaPedidosEmCurso = pedidosEmCurso(listaPedidosUser);
        List<Pedido> listPedidosHistorico = pedidosHistorico(listaPedidosUser);
        TreeSet<PedidoDTO> listaPedidosEmCursoDTO= new TreeSet<>(new Comparator<PedidoDTO>() {
            @Override
            public int compare(PedidoDTO o1, PedidoDTO o2) {
                return o2.dataHoraSolicitacao().dataHoraSolicitacao().compareTo(o1.dataHoraSolicitacao().dataHoraSolicitacao());
            }
        });

        TreeSet<PedidoDTO> listPedidosHistoricoDTO= new TreeSet<>(new Comparator<PedidoDTO>() {
            @Override
            public int compare(PedidoDTO o1, PedidoDTO o2) {
                return o2.dataHoraSolicitacao().dataHoraSolicitacao().compareTo(o1.dataHoraSolicitacao().dataHoraSolicitacao());
            }
        });
        for(Pedido p : listaPedidosEmCurso){
            listaPedidosEmCurso.forEach(e->listaPedidosEmCursoDTO.add(e.toDTO()));
        }

        for(Pedido p : listPedidosHistorico){
            listPedidosHistorico.forEach(e->listPedidosHistoricoDTO.add(e.toDTO()));
        }

        ret.put(listaPedidosEmCursoDTO,listPedidosHistoricoDTO);

        return ret;

    }

    private List<Pedido> pedidosEmCurso(List<Pedido> listaPedidosUser) {
        List<Pedido> listaPedidosEmCurso = new LinkedList<>();
        for (Pedido pedido : listaPedidosUser) {
            if (pedido.getEstadoPedido().estadoPedidoEnum().equals(EstadoPedido.EstadoPedidoEnum.APROVADO) || pedido.getEstadoPedido().estadoPedidoEnum().equals(EstadoPedido.EstadoPedidoEnum.SUBMETIDO)) {
                listaPedidosEmCurso.add(pedido);
            }
        }
        return listaPedidosEmCurso;
    }

    private List<Pedido> pedidosHistorico(List<Pedido> listaPedidosUser) {
        List<Pedido> listaPedidosHistorico = new LinkedList<>();
        for (Pedido pedido : listaPedidosUser) {
            if (pedido.getEstadoPedido().estadoPedidoEnum().equals(EstadoPedido.EstadoPedidoEnum.CONCLUIDO) ||  pedido.getEstadoPedido().estadoPedidoEnum().equals(EstadoPedido.EstadoPedidoEnum.RESOLVIDO)) {
                listaPedidosHistorico.add(pedido);
            }
        }
        return listaPedidosHistorico;
    }


}
