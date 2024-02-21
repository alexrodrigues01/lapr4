package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.servicomanagement.domain.Atributo;
import eapli.base.servicomanagement.repositories.AtributoRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaAtributoRepository extends JpaAutoTxRepository<Atributo, Long, Long> implements AtributoRepository {
    public JpaAtributoRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }
    public JpaAtributoRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }
}
