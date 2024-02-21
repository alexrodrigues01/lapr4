package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.repositories.ColaboradorRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaTransactionalRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * a base class for all transactional repositories to use the same persistence
 * unit
 *
 * @param <T>
 * @param <K>
 *
 * @author Paulo Gandra de Sousa
 */
class JpaColaboradorRepository
        extends JpaAutoTxRepository<Colaborador, Integer, Integer> implements ColaboradorRepository {

    public JpaColaboradorRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }
    public JpaColaboradorRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }


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
        final Map<String,Object> params= new HashMap<>();
        params.put("emailColab",email);
        return matchOne("e.email=:emailColab",params);
    }

}
