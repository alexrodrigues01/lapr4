package eapli.base.persistence.impl.inmemory;

import eapli.base.servicomanagement.domain.Keyword;
import eapli.base.servicomanagement.repositories.KeywordRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryKeywordRepository extends InMemoryDomainRepository<Keyword, Long> implements KeywordRepository {
}
