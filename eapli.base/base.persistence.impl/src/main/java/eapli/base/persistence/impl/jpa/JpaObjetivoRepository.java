package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.catalogomanagement.domain.Objetivo;
import eapli.base.catalogomanagement.repositories.ObjetivoRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaObjetivoRepository extends JpaAutoTxRepository<Objetivo, Long, Long> implements ObjetivoRepository {
    public JpaObjetivoRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }
    public JpaObjetivoRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }
}
