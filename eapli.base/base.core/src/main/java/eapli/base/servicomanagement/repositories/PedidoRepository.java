package eapli.base.servicomanagement.repositories;

import eapli.base.fluxotarefaresolucao.domain.TarefaExecRes;
import eapli.base.servicomanagement.domain.Pedido;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends DomainRepository<String, Pedido> {
        public List<Pedido> getPedidosUser(String email);
        public Pedido getPedidosById(String id);
}
