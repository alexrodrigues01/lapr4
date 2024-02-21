package eapli.base.catalogomanagement.domain;


import eapli.base.nivelcriticidademanagement.domain.NivelCriticidade;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;

@Entity
public class SLA implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=false, nullable = false)
    private String descricao;

    @OneToOne(cascade=CascadeType.ALL)
    private NivelCriticidade nivelCriticidade;

    public SLA(String descricao) {
        this.descricao = descricao;
    }

    public SLA(String descricao, NivelCriticidade nivelCriticidade) {
        this.descricao = descricao;
        this.nivelCriticidade = nivelCriticidade;
    }

    public NivelCriticidade nivelCriticidade() {
        return nivelCriticidade;
    }

    public SLA() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Contrato SLA: \n" +
                "ID: " + id + "\n" +
                "Descricao: " + descricao + "\n\n";
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this,other);
    }

    @Override
    public Long identity() {
        return this.id;
    }
}
