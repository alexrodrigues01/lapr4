package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.fluxotarefaresolucao.domain.TarefaExecRes;
import eapli.base.servicomanagement.domain.EmailColaborador;
import eapli.base.servicomanagement.domain.Pedido;
import eapli.base.servicomanagement.repositories.PedidoRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JpaPedidoRepository extends JpaAutoTxRepository<Pedido, String, String> implements PedidoRepository {
    public JpaPedidoRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }
    public JpaPedidoRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }

    @Override
    public List<Pedido> getPedidosUser(String email) {
        final Map<String,Object> params= new HashMap<>();
        EmailColaborador emailColaborador=new EmailColaborador(email);
        params.put("emailColaboradorr",emailColaborador);
        return match("e.emailColaborador=:emailColaboradorr",params);
    }

    @Override
    public Pedido getPedidosById(String id) {
        final Map<String,Object> params= new HashMap<>();
        params.put("idP",id);
        return matchOne("e.id=:idP",params).get();
    }


}
