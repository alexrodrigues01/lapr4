package eapli.base.persistence.impl.jpa;

import eapli.base.catalogomanagement.repositories.CatalogoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import junit.framework.TestCase;

public class JpaCatalogoRepositoryTest extends TestCase {

    public void testGetCatalogoByTarefa() {
        CatalogoRepository catalogoRepository  = PersistenceContext.repositories().catalogos();
//        catalogoRepository.getCatalogoByTarefa(null);
    }
}