package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.servicomanagement.domain.Keyword;

import eapli.base.servicomanagement.repositories.KeywordRepository;
import eapli.framework.domain.repositories.TransactionalContext;

import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaKeywordRepository extends JpaAutoTxRepository<Keyword, Long, Long> implements KeywordRepository {

    public JpaKeywordRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }
    public JpaKeywordRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }
}
