package eapli.base.servicomanagement.domain;

import eapli.base.tarefamanagement.domain.TarefaExecucao;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Formulario implements AggregateRoot<Long> {


    @OneToOne(mappedBy = "formulario")
    private TarefaExecucao tarefaExecucao;


    @OneToOne(mappedBy = "formulario")
    private Servico servico;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private CodigoUnicoFormulario codigoUnico;

    private NomeFormulario nome;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Atributo> atributos;

    public Formulario(NomeFormulario nome, CodigoUnicoFormulario codigoUnico, List<Atributo> atributos) {
        this.nome = nome;
        this.codigoUnico = codigoUnico;
        this.atributos = atributos;
    }

    public Formulario() {

    }

    public String codigoUnicoFormulario() {
        return codigoUnico.codigoUnico();
    }

    public void definirCodigoUnico(String codigoUnicoString) {
        this.codigoUnico = new CodigoUnicoFormulario(codigoUnicoString);
    }

    public String nome() {
        return nome.nome();
    }

    public void definirNome(String nome) {
        this.nome = new NomeFormulario(nome);
    }

    public void adicionarAtributo(Atributo atributo){
        atributos.add(atributo);
    }

    public boolean removerAtributoByNome(String nomeAtributo){
        for(Atributo a : atributos){
            if(a.nome().equalsIgnoreCase(nomeAtributo)){
                atributos.remove(a);
                return true;
            }
        }
        return false;
    }

    public List<Atributo> atributos() {
        return atributos;
    }

    public boolean verificarPublicacao(){
        if(nome != null && codigoUnico != null && !atributos.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formulario that = (Formulario) o;
        return Objects.equals(codigoUnico, that.codigoUnico) && Objects.equals(nome, that.nome) && Objects.equals(atributos, that.atributos);
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
