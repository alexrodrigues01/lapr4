package eapli.base.tarefamanagement.domain;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.servicomanagement.domain.Formulario;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TarefaAprovacao implements AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;





    /*@OneToMany
    private List<Equipa> equipas;*/

    @OneToOne(cascade=CascadeType.ALL)
    private Formulario formulario;

    private boolean responsavelHierarquico;

    public TarefaAprovacao(Formulario formulario, boolean responsavelHierarquico) {
        this.formulario = formulario;
        this.responsavelHierarquico = responsavelHierarquico;
    }

    public TarefaAprovacao() {
    }


    /*public List<Equipa> equipas() {
        return equipas;
    }*/


    public Formulario formulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }


    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Long identity() {
        return id;
    }

    public boolean isResponsavelHierarquico(){
        return responsavelHierarquico;
    }


    @Override
    public String toString() {
        return "(ID): " + id +"\n";
    }
}
