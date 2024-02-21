package eapli.base.fluxotarefaresolucao.repositories;

import eapli.base.fluxotarefaresolucao.domain.TarefaAprovRes;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface  TarefaAprovResRepository extends DomainRepository<Long, TarefaAprovRes> {
    public List<TarefaAprovRes> getTarefasColaboradorPendentes(String email, TarefaAprovRes.EstadoTarefaAprovacao atribuida);
    public List<TarefaAprovRes> getTarefasPendentes();
    public List<TarefaAprovRes> getTarefasWithEstado(TarefaAprovRes.EstadoTarefaAprovacao estado);
}
