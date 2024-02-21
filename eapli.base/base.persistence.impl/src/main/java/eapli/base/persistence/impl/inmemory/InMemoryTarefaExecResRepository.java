package eapli.base.persistence.impl.inmemory;

import eapli.base.fluxotarefaresolucao.domain.TarefaExecRes;
import eapli.base.fluxotarefaresolucao.repositories.TarefaExecResRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryTarefaExecResRepository extends InMemoryDomainRepository<TarefaExecRes,Long> implements TarefaExecResRepository {
    @Override
    public List<TarefaExecRes> getTarefasColaboradorPendentes(String email, TarefaExecRes.EstadoTarefaExecucao atribuida) {
        return (List<TarefaExecRes>) match(e -> e.colaborador().email().equals(email));
    }

    @Override
    public List<TarefaExecRes> getTarefasPendentes() {
        return null;
    }

    @Override
    public List<TarefaExecRes> getTarefasPendentesManual() {
        return null;
    }

    @Override
    public List<TarefaExecRes> getTarefasByEmailColabWithEstado(String email, TarefaExecRes.EstadoTarefaExecucao estado) {
        return null;
    }

    @Override
    public List<TarefaExecRes> getTarefasWithEstado(TarefaExecRes.EstadoTarefaExecucao estado) {
        return null;
    }
}
