package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.repositories.CatalogoRepository;
import eapli.base.fluxotarefaresolucao.domain.TarefaExecRes;
import eapli.base.servicomanagement.domain.EmailColaborador;
import eapli.base.tarefamanagement.domain.TarefaExecucao;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JpaCatalogoRepository  extends JpaAutoTxRepository<Catalogo, Long, Long> implements CatalogoRepository {


    public JpaCatalogoRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }
    public JpaCatalogoRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Application.settings().getPersistenceUnitName());
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    @Override
    public List<Catalogo> getCatalogos() {
        Query query= getEntityManager().createQuery("SELECT e FROM Catalogo e");

        return query.getResultList();

    }

//    @Override
//    public Catalogo getCatalogoByTarefa(TarefaExecucao tarefaExecucao) {
//        final Map<String,Object> params= new HashMap<>();
//        params.put("tarefa",tarefaExecucao);
//        return matchOne("e.servicos.fluxoTarefa.tarefaExecucao=:tarefa",params).get();
//    }
}
