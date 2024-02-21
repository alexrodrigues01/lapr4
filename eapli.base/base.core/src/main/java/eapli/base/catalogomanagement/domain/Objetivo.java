package eapli.base.catalogomanagement.domain;


import eapli.base.nivelcriticidademanagement.domain.NivelCriticidade;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Objetivo implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=false, nullable = false)
    double tempoMaximoAprovacao;

    @Column(unique=false, nullable = false)
    double tempoMedioAprovacao;

    @Column(unique=false, nullable = false)
    double tempoMaximoResolucao;

    @Column(unique=false, nullable = false)
    double tempoMedioResolucao;

    public Objetivo(){}

    public Objetivo(double tempoMaximoAprovacao, double tempoMedioAprovacao, double tempoMaximoResolucao, double tempoMedioResolucao){
        this.tempoMaximoAprovacao=tempoMaximoAprovacao;
        this.tempoMedioAprovacao=tempoMedioAprovacao;
        this.tempoMaximoResolucao = tempoMaximoResolucao;
        this.tempoMedioResolucao = tempoMedioResolucao;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this,other);
    }

    @Override
    public Long identity() {
        return this.id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Objetivo objetivo = (Objetivo) o;
        return Double.compare(objetivo.tempoMaximoAprovacao, tempoMaximoAprovacao) == 0 && Double.compare(objetivo.tempoMedioAprovacao, tempoMedioAprovacao) == 0 && Double.compare(objetivo.tempoMaximoResolucao, tempoMaximoResolucao) == 0 && Double.compare(objetivo.tempoMedioResolucao, tempoMedioResolucao) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tempoMaximoAprovacao, tempoMedioAprovacao, tempoMaximoResolucao, tempoMedioResolucao);
    }

    public double getTempoMedioResolucao() {
        return tempoMedioResolucao;
    }

    @Override
    public String toString() {
        return "Objetivo: \n" +
                "ID: " + id + "\n"+
                "Tempo Maximo de Aprovacao: " + tempoMaximoAprovacao + "\n"+
                "Tempo Medio de Aprovacao: " + tempoMedioAprovacao + "\n"+
                "Tempo Maximo Aceitacao: " + tempoMaximoResolucao + "\n" +
                "Tempo Medio Aceitacao: " + tempoMedioResolucao + "\n\n";
    }
}
