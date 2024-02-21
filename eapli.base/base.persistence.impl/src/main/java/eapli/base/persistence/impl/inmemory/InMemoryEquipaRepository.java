package eapli.base.persistence.impl.inmemory;

import eapli.base.Application;
import eapli.base.equipaManagement.domain.Equipa;
import eapli.base.equipaManagement.repositories.EquipaRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class InMemoryEquipaRepository extends InMemoryDomainRepository<Equipa,Long> implements EquipaRepository {

    @Override
    public List<Equipa> getEquipas() {
        Query query= getEntityManager().createQuery("SELECT e FROM Equipa e");

        return query.getResultList();
    }


    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Application.settings().getPersistenceUnitName());
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

}
