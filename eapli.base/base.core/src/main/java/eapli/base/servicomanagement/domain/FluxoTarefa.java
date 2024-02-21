package eapli.base.servicomanagement.domain;

import eapli.base.tarefamanagement.domain.TarefaAprovacao;
import eapli.base.tarefamanagement.domain.TarefaExecucao;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class FluxoTarefa implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(nullable = true)
    private TarefaExecucao tarefaExecucao;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(nullable = true)
    private TarefaAprovacao tarefaAprovacao;

    public FluxoTarefa(TarefaExecucao tarefaExecucao, TarefaAprovacao tarefaAprovacao) {
        this.tarefaExecucao = tarefaExecucao;
        this.tarefaAprovacao = tarefaAprovacao;
    }

    public FluxoTarefa() {

    }

    public TarefaExecucao tarefaExecucao(){
        return tarefaExecucao;
    }
    public TarefaAprovacao tarefaAprovacao(){
        return tarefaAprovacao;
    }

    public void definirTarefaExecucao(TarefaExecucao tarefaExecucao) {
        this.tarefaExecucao = tarefaExecucao;
    }

    public void definirTarefaAprovacao(TarefaAprovacao tarefaAprovacao) {
        this.tarefaAprovacao = tarefaAprovacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FluxoTarefa that = (FluxoTarefa) o;
        return Objects.equals(id, that.id) && Objects.equals(tarefaExecucao, that.tarefaExecucao) && Objects.equals(tarefaAprovacao, that.tarefaAprovacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tarefaExecucao, tarefaAprovacao);
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
