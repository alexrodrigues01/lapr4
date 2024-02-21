package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.servicomanagement.domain.FluxoTarefa;
import eapli.base.servicomanagement.repositories.FluxoTarefaRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaFluxoTarefaRepository  extends JpaAutoTxRepository<FluxoTarefa, Long, Long> implements FluxoTarefaRepository {
    public JpaFluxoTarefaRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }
    public JpaFluxoTarefaRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Application.settings().getPersistenceUnitName());
        EntityManager manager = factory.createEntityManager();
        return manager;
    }
}
