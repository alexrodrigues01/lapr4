package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.List;

@Entity
public class FormularioP implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private NomeFormulario nomeFormulario;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<AtributoPreenchido> atributos;


    public FormularioP(NomeFormulario nomeFormulario, List<AtributoPreenchido> atributos) {
        this.nomeFormulario = nomeFormulario;
        this.atributos = atributos;
    }

    public FormularioP() {

    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<AtributoPreenchido> atributos() {
        return atributos;
    }

    public String infoValidacao(){
        StringBuilder result = new StringBuilder();

        for(AtributoPreenchido a : atributos){
            result.append(a.info());
        }

        return result.toString();
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
