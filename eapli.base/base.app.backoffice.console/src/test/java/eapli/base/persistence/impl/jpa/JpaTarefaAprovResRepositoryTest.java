package eapli.base.persistence.impl.jpa;

import eapli.base.fluxotarefaresolucao.domain.TarefaAprovRes;
import eapli.base.fluxotarefaresolucao.repositories.TarefaAprovResRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import junit.framework.TestCase;

public class JpaTarefaAprovResRepositoryTest extends TestCase {

    public void testGetTarefasColaboradorPendentes() {
        TarefaAprovResRepository tarefaAprovResRepository = PersistenceContext.repositories().tarefaAprovRes();
        System.out.println(tarefaAprovResRepository.getTarefasColaboradorPendentes("email1@email.pt", TarefaAprovRes.EstadoTarefaAprovacao.Atribuida));
    }
}