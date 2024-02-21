package eapli.base.persistence.impl.inmemory;



import eapli.base.servicomanagement.domain.Pedido;
import eapli.base.servicomanagement.repositories.PedidoRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eapli.base.Application;
import eapli.base.servicomanagement.domain.Pedido;
import eapli.base.servicomanagement.repositories.PedidoRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;



public class InMemoryPedidoRepository extends InMemoryDomainRepository<Pedido,String> implements PedidoRepository {

    @Override
    public List<Pedido> getPedidosUser(String email) {
        final Map<String,Object> params= new HashMap<>();
        params.put("emailColaborador",email);
        return null;
    }

    @Override
    public Pedido getPedidosById(String id) {
        return null;
    }


}
