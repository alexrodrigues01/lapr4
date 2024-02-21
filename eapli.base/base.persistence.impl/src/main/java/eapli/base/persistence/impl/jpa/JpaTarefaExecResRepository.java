package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.fluxotarefaresolucao.domain.TarefaAprovRes;
import eapli.base.fluxotarefaresolucao.domain.TarefaExecRes;
import eapli.base.fluxotarefaresolucao.repositories.TarefaExecResRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JpaTarefaExecResRepository extends JpaAutoTxRepository<TarefaExecRes,Long,Long> implements TarefaExecResRepository {

    public JpaTarefaExecResRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }
    public JpaTarefaExecResRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }

    @Override
    public List<TarefaExecRes> getTarefasColaboradorPendentes(String email, TarefaExecRes.EstadoTarefaExecucao atribuida) {
        final Map<String,Object> params= new HashMap<>();
        params.put("email",email);
        params.put("estado", atribuida);
        return match("e.colaborador.email=:email AND e.estado=:estado",params);
    }

    @Override
    public List<TarefaExecRes> getTarefasPendentes() {
        final Map<String,Object> params= new HashMap<>();
        params.put("estado", TarefaExecRes.EstadoTarefaExecucao.Pendente);
        return match("e.estado=:estado",params);
    }

    @Override
    public List<TarefaExecRes> getTarefasPendentesManual() {
        final Map<String,Object> params= new HashMap<>();
        params.put("estado", TarefaExecRes.EstadoTarefaExecucao.Pendente);
        params.put("bool",true);
        return match("e.estado=:estado AND e.tarefaExecucao.manual=:bool",params);
    }

    @Override
    public List<TarefaExecRes> getTarefasByEmailColabWithEstado(String email, TarefaExecRes.EstadoTarefaExecucao estado) {
        final Map<String,Object> params= new HashMap<>();
        params.put("email",email);
        params.put("estado",estado);
        return match("e.colaborador.email=:email AND e.estado=:estado",params);
    }

    @Override
    public List<TarefaExecRes> getTarefasWithEstado(TarefaExecRes.EstadoTarefaExecucao estado) {
        final Map<String,Object> params= new HashMap<>();
        params.put("estado",estado);
        return match("e.estado=:estado",params);
    }

}
