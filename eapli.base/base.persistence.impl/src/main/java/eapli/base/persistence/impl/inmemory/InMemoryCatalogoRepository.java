package eapli.base.persistence.impl.inmemory;

import eapli.base.Application;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.repositories.CatalogoRepository;
import eapli.base.tarefamanagement.domain.TarefaExecucao;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class InMemoryCatalogoRepository extends InMemoryDomainRepository<Catalogo,Long> implements CatalogoRepository {


    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Application.settings().getPersistenceUnitName());
        EntityManager manager = factory.createEntityManager();
        return manager;
    }


    @Override
    public List<Catalogo> getCatalogos() {
        Query query= getEntityManager().createQuery("SELECT e FROM Catalogo e");

        return query.getResultList();
    }

//    @Override
//    public Catalogo getCatalogoByTarefa(TarefaExecucao tarefaExecucao) {
//        return null;
//    }
}
