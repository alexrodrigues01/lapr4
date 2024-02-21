package eapli.base.persistence.impl.inmemory;

import eapli.base.Application;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.repositories.ColaboradorRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class InMemoryColaboradorRepository extends InMemoryDomainRepository<Colaborador, Integer>
        implements ColaboradorRepository {


    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Application.settings().getPersistenceUnitName());
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    @Override
    public List<Colaborador> getColaboradores() {
        Query query= getEntityManager().createQuery("SELECT e FROM Colaborador e");

        return query.getResultList();
    }

    @Override
    public Optional<Colaborador> getColaboradorByEmail(String email) {
        return null;
    }
}
