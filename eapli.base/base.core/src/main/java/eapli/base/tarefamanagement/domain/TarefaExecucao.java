package eapli.base.tarefamanagement.domain;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipaManagement.domain.Equipa;
import eapli.base.servicomanagement.domain.Formulario;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class TarefaExecucao implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(unique = false, nullable = true)
    private boolean manual;

    @ManyToMany
    private Set<Equipa> equipaList;

    //nullable se automatico
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = true)
    private Formulario formulario;

    @OneToOne(cascade = CascadeType.ALL)
    private Script script;



    public TarefaExecucao() {
    }

    public TarefaExecucao(boolean manual, Set<Equipa> equipaList, Formulario formulario, Script script) {
        this.manual = manual;
        this.equipaList = equipaList;
        this.formulario = formulario;
        this.script = script;
    }



    public Set<Equipa> equipas(){
        return equipaList;
    }


    public Formulario formulario(){
        return formulario;
    }



    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Long identity() {
        return id;
    }

    public boolean manual() {
        return manual;
    }


    public Script script() {
        return script;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TarefaExecucao that = (TarefaExecucao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "(ID): " + id +"\n";
    }
}
