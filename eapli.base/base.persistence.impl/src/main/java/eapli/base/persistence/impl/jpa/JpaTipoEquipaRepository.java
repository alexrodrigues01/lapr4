package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.equipaManagement.domain.TipoEquipa;
import eapli.base.equipaManagement.repositories.TipoEquipaRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

public class JpaTipoEquipaRepository extends JpaAutoTxRepository<TipoEquipa,Integer,Integer> implements TipoEquipaRepository {
    public JpaTipoEquipaRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaTipoEquipaRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Application.settings().getPersistenceUnitName());
        EntityManager manager = factory.createEntityManager();
        return manager;
    }




}
