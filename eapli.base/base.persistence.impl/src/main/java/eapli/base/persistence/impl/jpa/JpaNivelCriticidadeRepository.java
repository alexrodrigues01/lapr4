package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.nivelcriticidademanagement.domain.NivelCriticidade;
import eapli.base.nivelcriticidademanagement.repositories.NivelCriticidadeRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaNivelCriticidadeRepository extends JpaAutoTxRepository<NivelCriticidade, Long, Long> implements NivelCriticidadeRepository {

    public JpaNivelCriticidadeRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaNivelCriticidadeRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }
}
