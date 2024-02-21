package eapli.base.persistence.impl.inmemory;

import eapli.base.Application;
import eapli.base.equipaManagement.domain.TipoEquipa;
import eapli.base.equipaManagement.repositories.TipoEquipaRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InMemoryTipoEquipaRepository extends InMemoryDomainRepository<TipoEquipa,Integer> implements TipoEquipaRepository {

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Application.settings().getPersistenceUnitName());
        EntityManager manager = factory.createEntityManager();
        return manager;
    }
}
