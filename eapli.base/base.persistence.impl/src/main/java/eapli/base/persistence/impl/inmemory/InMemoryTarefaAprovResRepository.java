package eapli.base.persistence.impl.inmemory;

import eapli.base.fluxotarefaresolucao.domain.TarefaAprovRes;
import eapli.base.fluxotarefaresolucao.repositories.TarefaAprovResRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryTarefaAprovResRepository extends InMemoryDomainRepository<TarefaAprovRes,Long> implements TarefaAprovResRepository {
    @Override
    public List<TarefaAprovRes> getTarefasColaboradorPendentes(String email, TarefaAprovRes.EstadoTarefaAprovacao atribuida) {
        return (List<TarefaAprovRes>) match(e -> e.colaborador().email().equals(email));
    }

    @Override
    public List<TarefaAprovRes> getTarefasPendentes() {
        return null;
    }

    @Override
    public List<TarefaAprovRes> getTarefasWithEstado(TarefaAprovRes.EstadoTarefaAprovacao estado) {
        return null;
    }
}
