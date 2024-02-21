package eapli.base.catalogomanagement.repositories;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.tarefamanagement.domain.TarefaExecucao;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface CatalogoRepository extends DomainRepository<Long, Catalogo> {
    List<Catalogo> getCatalogos();

//    Catalogo getCatalogoByTarefa(TarefaExecucao tarefaExecucao);
}
