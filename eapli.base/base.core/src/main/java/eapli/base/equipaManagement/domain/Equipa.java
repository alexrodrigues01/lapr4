package eapli.base.equipaManagement.domain;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
public class Equipa implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=false, nullable = false)
    private String identificadorUnico;

    @Column(unique=false, nullable = false)
    private String acronimoUnico;

    @Column(unique=false, nullable = false)
    private String descricao;

    @OneToOne
    private TipoEquipa tipoEquipa;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Colaborador> colaboradores;

//    @ManyToMany(fetch = FetchType.EAGER)
//    private List<Colaborador> colaboradoresResponsaveis;


    public Equipa(String identificadorUnico, String acronimoUnico, String descricao) {
        this.identificadorUnico = identificadorUnico;
        this.acronimoUnico = acronimoUnico;
        this.descricao = descricao;
        this.colaboradores=new LinkedList<>();
//        this.colaboradoresResponsaveis=new LinkedList<>();
    }

    public Equipa() {

    }

    public void adicionarTipoEquipa(TipoEquipa tipoEquipa){
        this.tipoEquipa=tipoEquipa;
    }

    public void adicionarColaborador(Colaborador colaborador){
        colaboradores.add(colaborador);
    }

//    public void adicionarColaboradorResponsavel(Colaborador colaboradorResponsavel){
//        colaboradoresResponsaveis.add(colaboradorResponsavel);
//    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this,other);
    }

    @Override
    public Long identity() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public TipoEquipa getTipoEquipa() {
        return tipoEquipa;
    }

    public List<Colaborador> getColaboradores() {
        return colaboradores;
    }

//    public List<Colaborador> getColaboradoresResponsaveis() {
//        return colaboradoresResponsaveis;
//    }

    public String identificadorUnico() {
        return identificadorUnico;
    }

    @Override
    public String toString() {
        return "Equipa{" +
                "identificadorUnico='" + identificadorUnico + '\'' +
                ", acronimoUnico='" + acronimoUnico + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipa equipa = (Equipa) o;
        return Objects.equals(identificadorUnico, equipa.identificadorUnico) && Objects.equals(acronimoUnico, equipa.acronimoUnico) && Objects.equals(descricao, equipa.descricao) && Objects.equals(tipoEquipa, equipa.tipoEquipa) && Objects.equals(colaboradores, equipa.colaboradores) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificadorUnico, acronimoUnico, descricao, tipoEquipa, colaboradores);
    }
}
