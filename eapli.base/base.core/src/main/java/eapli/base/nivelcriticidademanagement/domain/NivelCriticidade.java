package eapli.base.nivelcriticidademanagement.domain;

import eapli.base.catalogomanagement.domain.Objetivo;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class NivelCriticidade implements AggregateRoot<Long> {

    @Id
    private Long id;

    @Column(unique = false, nullable = false)
    private String cor;

    @Column(unique = false, nullable = false)
    private String etiqueta;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Objetivo> objetivos;

    public NivelCriticidade(long escalaNumerica, String cor, String etiqueta) {
        this.id = escalaNumerica;
        this.cor = cor;
        this.etiqueta = etiqueta;
        this.objetivos = new LinkedList<>();
    }

    public NivelCriticidade(long escalaNumerica, String cor, String etiqueta, List<Objetivo> objetivos) {
        this.id = escalaNumerica;
        this.cor = cor;
        this.etiqueta = etiqueta;
        this.objetivos = objetivos;
    }

    public NivelCriticidade() {

    }

    public void definirObjetivo(Objetivo objetivo) {
        this.objetivos.add(objetivo);
    }

    public List<Objetivo> objetivo() {
        return objetivos;
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Long identity() {
        return this.id;
    }
}
