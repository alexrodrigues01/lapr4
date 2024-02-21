package eapli.base.persistence.impl.inmemory;

import eapli.base.Application;
import eapli.base.servicomanagement.domain.FluxoTarefa;
import eapli.base.servicomanagement.repositories.FluxoTarefaRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InMemoryFluxoTarefaRepository extends InMemoryDomainRepository<FluxoTarefa,Long> implements FluxoTarefaRepository {
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Application.settings().getPersistenceUnitName());
        EntityManager manager = factory.createEntityManager();
        return manager;
    }
}
