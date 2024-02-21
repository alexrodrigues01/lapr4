package eapli.base.fluxotarefaresolucao.repositories;

import eapli.base.fluxotarefaresolucao.domain.TarefaAprovRes;
import eapli.base.fluxotarefaresolucao.domain.TarefaExecRes;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface TarefaExecResRepository extends DomainRepository<Long, TarefaExecRes> {

    public List<TarefaExecRes> getTarefasColaboradorPendentes(String email, TarefaExecRes.EstadoTarefaExecucao atribuida) ;
    public List<TarefaExecRes> getTarefasPendentes();
    public List<TarefaExecRes> getTarefasPendentesManual();
    public List<TarefaExecRes> getTarefasByEmailColabWithEstado(String email, TarefaExecRes.EstadoTarefaExecucao estado);
    public List<TarefaExecRes> getTarefasWithEstado(TarefaExecRes.EstadoTarefaExecucao estado);
}
