package eapli.base.persistence.impl.inmemory;

import eapli.base.Application;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repositories.ServicoRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class InMemoryServicoRepository extends InMemoryDomainRepository<Servico, Long> implements ServicoRepository {
    static {
        InMemoryInitializer.init();
    }
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Application.settings().getPersistenceUnitName());
        EntityManager manager = factory.createEntityManager();
        return manager;
    }


    @Override
    public List<Servico> getServicos() {
        Query query= getEntityManager().createQuery("SELECT e FROM Servico e");

        return query.getResultList();
    }

}
