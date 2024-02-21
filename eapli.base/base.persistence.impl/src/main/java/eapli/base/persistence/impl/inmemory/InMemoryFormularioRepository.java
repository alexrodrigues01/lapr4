package eapli.base.persistence.impl.inmemory;

import eapli.base.servicomanagement.domain.Formulario;
import eapli.base.servicomanagement.repositories.FormularioRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryFormularioRepository extends InMemoryDomainRepository<Formulario, Long> implements FormularioRepository {
}
