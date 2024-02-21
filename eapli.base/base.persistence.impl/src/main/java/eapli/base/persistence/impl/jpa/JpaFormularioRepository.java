package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.servicomanagement.domain.Formulario;
import eapli.base.servicomanagement.repositories.FormularioRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaFormularioRepository extends JpaAutoTxRepository<Formulario, Long, Long> implements FormularioRepository {

    public JpaFormularioRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaFormularioRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }
}
