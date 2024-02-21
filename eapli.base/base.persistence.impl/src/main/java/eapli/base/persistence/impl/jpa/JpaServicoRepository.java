package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repositories.ServicoRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;


class JpaServicoRepository extends JpaAutoTxRepository<Servico, Long, Long> implements ServicoRepository {

    public JpaServicoRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }
    public JpaServicoRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
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
