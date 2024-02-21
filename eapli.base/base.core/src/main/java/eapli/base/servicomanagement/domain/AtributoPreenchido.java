package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AtributoPreenchido implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private NomeAtributo nome;

    private Label label;

    private DescricaoAtributo descricao;

    private ExpressaoRegular expressaoRegular;

    private TipoDados tipoDados;

    private Resposta resposta;

    private boolean obrigatoriedade;


    public AtributoPreenchido(NomeAtributo nome, Label label, DescricaoAtributo descricao, ExpressaoRegular expressaoRegular, TipoDados tipoDados, boolean obrigatoriedade, Resposta resposta) {
        this.nome = nome;
        this.label = label;
        this.descricao = descricao;
        this.expressaoRegular = expressaoRegular;
        this.tipoDados = tipoDados;
        this.resposta = resposta;
        this.obrigatoriedade = obrigatoriedade;
    }

    public AtributoPreenchido() {

    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Long identity() {
        return this.id;
    }

    public Resposta resposta() {
        return resposta;
    }

    public String info(){
        return nome.nomeAtributo() + ";" + expressaoRegular.expressaoRegular() + ";" + tipoDados.tipoDados() + ";" + resposta.resposta() + ";" + obrigatoriedade + ";";
    }

    @Override
    public String toString() {
        return nome.nomeAtributo();
    }
}
