package eapli.base.persistence.impl.jpa;

import eapli.base.fluxotarefaresolucao.domain.TarefaExecRes;
import eapli.base.fluxotarefaresolucao.repositories.TarefaExecResRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import junit.framework.TestCase;

public class JpaTarefaExecResRepositoryTest extends TestCase {

    public void testGetTarefasPendentesManual() {
        TarefaExecResRepository tarefaExecResRepository= PersistenceContext.repositories().tarefaExecRes();
        System.out.println(tarefaExecResRepository.getTarefasPendentesManual());
    }

    public void testGetTarefasWithEstado() {
        TarefaExecResRepository tarefaExecResRepository= PersistenceContext.repositories().tarefaExecRes();
        System.out.println(tarefaExecResRepository.getTarefasWithEstado(TarefaExecRes.EstadoTarefaExecucao.Atribuida));
    }
}