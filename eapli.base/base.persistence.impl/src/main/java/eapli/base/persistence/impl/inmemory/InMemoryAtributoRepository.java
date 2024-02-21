package eapli.base.persistence.impl.inmemory;

import eapli.base.servicomanagement.domain.Atributo;
import eapli.base.servicomanagement.repositories.AtributoRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryAtributoRepository extends InMemoryDomainRepository<Atributo, Long> implements AtributoRepository {
}
