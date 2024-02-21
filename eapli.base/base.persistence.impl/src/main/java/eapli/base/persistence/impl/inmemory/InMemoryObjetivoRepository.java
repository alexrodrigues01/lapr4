package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogomanagement.domain.Objetivo;
import eapli.base.catalogomanagement.repositories.ObjetivoRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryObjetivoRepository extends InMemoryDomainRepository<Objetivo,Long> implements ObjetivoRepository {

}
