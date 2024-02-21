package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.fluxotarefaresolucao.domain.TarefaAprovRes;
import eapli.base.fluxotarefaresolucao.repositories.TarefaAprovResRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JpaTarefaAprovResRepository extends JpaAutoTxRepository<TarefaAprovRes,Long,Long> implements TarefaAprovResRepository {

    public JpaTarefaAprovResRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }
    public JpaTarefaAprovResRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }


    @Override
    public List<TarefaAprovRes> getTarefasColaboradorPendentes(String email, TarefaAprovRes.EstadoTarefaAprovacao atribuida) {
        final Map<String,Object> params= new HashMap<>();
        params.put("email",email);
        params.put("estado",atribuida);
        return match("e.colaborador.email=:email AND e.estado=:estado",params);
    }

    @Override
    public List<TarefaAprovRes> getTarefasPendentes() {
        final Map<String,Object> params= new HashMap<>();
        params.put("estado",TarefaAprovRes.EstadoTarefaAprovacao.Pendente);
        return match("e.estado=:estado",params);
    }

    @Override
    public List<TarefaAprovRes> getTarefasWithEstado(TarefaAprovRes.EstadoTarefaAprovacao estado) {
        final Map<String,Object> params= new HashMap<>();
        params.put("estado",estado);
        return match("e.estado=:estado",params);
    }

}