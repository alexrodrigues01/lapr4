package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.equipaManagement.domain.Equipa;
import eapli.base.equipaManagement.repositories.EquipaRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class JpaEquipaRepository extends JpaAutoTxRepository<Equipa,Integer,Integer> implements EquipaRepository {
    public JpaEquipaRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaEquipaRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }

    @Override
    public Optional<Equipa> ofIdentity(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteOfIdentity(Long entityId) {

    }

    @Override
    public List<Equipa> getEquipas() {
        Query query = getEntityManager().createQuery("SELECT e FROM Equipa e");

        return query.getResultList();
    }


    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Application.settings().getPersistenceUnitName());
        EntityManager manager = factory.createEntityManager();
        return manager;
    }
}