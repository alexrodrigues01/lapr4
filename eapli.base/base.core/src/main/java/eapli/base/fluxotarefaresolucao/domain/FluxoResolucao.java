package eapli.base.fluxotarefaresolucao.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;

@Entity
public class FluxoResolucao implements AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(nullable = true)
    private TarefaAprovRes tarefaAprovRes;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(nullable = true)
    private TarefaExecRes tarefaExecRes;

    public FluxoResolucao(){}

    public FluxoResolucao(TarefaAprovRes tarefaAprovRes, TarefaExecRes tarefaExecRes) {
        this.tarefaAprovRes = tarefaAprovRes;
        this.tarefaExecRes = tarefaExecRes;
    }

    public TarefaExecRes tarefaExecucaoResolucao(){
        return tarefaExecRes;
    }
    public TarefaAprovRes tarefaAprovacaoResolucao(){
        return tarefaAprovRes;
    }

    public void definirTarefaExecucaoResolucao(TarefaExecRes tarefaExecRes) {
        this.tarefaExecRes = tarefaExecRes;
    }

    public void definirTarefaAprovacaoResolucao(TarefaAprovRes tarefaAprovRes) {
        this.tarefaAprovRes = tarefaAprovRes;
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Long identity() {
        return id;
    }
}
