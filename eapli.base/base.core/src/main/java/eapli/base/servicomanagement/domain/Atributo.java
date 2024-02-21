package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Atributo implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private NomeAtributo nome;

    private Label label;

    private DescricaoAtributo descricao;

    private ExpressaoRegular expressaoRegular;

    private TipoDados tipoDados;

    private boolean obrigatoriedade;

    /*@OneToMany(cascade = CascadeType.ALL)
    @Nullable
    private List<Opcao> opcoes;*/

    @ElementCollection
    @Nullable
    private List<String> opcoes;

    public Atributo(NomeAtributo nome, Label label, DescricaoAtributo descricao, ExpressaoRegular expressaoRegular, TipoDados tipoDados, boolean obrigatoriedade) {
        this.nome = nome;
        this.label = label;
        this.descricao = descricao;
        this.expressaoRegular = expressaoRegular;
        this.tipoDados = tipoDados;
        this.obrigatoriedade = obrigatoriedade;
    }

    public Atributo() {

    }

    public String nome() {
        return nome.nomeAtributo();
    }

    public String label() {
        return label.label();
    }

    public String descricao() {
        return descricao.descricao();
    }

    public String expressaoRegular() {
        if(expressaoRegular == null){
            return "";
        }
        return expressaoRegular.expressaoRegular();
    }

    public String tipoDados() {
        return tipoDados.tipoDados();
    }

    public List<String> opcoes() {
        return opcoes;
    }

    public void definirOpcoes(List<String> opcoes) {
        this.opcoes = new ArrayList<>(opcoes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atributo atributo = (Atributo) o;
        return Objects.equals(id, atributo.id) && Objects.equals(nome, atributo.nome) && Objects.equals(label, atributo.label) && Objects.equals(descricao, atributo.descricao) && Objects.equals(expressaoRegular, atributo.expressaoRegular) && Objects.equals(tipoDados, atributo.tipoDados);
    }

    @Override
    public String toString() {
        return nome.nomeAtributo() + " | " + label.label() + " | Tipo de dados: " + tipoDados.tipoDados() + "\nDescrição: " + descricao.descricao() + "";
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Long identity() {
        return id;
    }

    public boolean obrigatoriedade() {
        return obrigatoriedade;
    }
}
