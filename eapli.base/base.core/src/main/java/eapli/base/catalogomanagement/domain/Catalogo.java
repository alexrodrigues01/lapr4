package eapli.base.catalogomanagement.domain;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipaManagement.domain.Equipa;
import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
public class Catalogo implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = false, nullable = false)
    private String iconeCatalogo;

    @Column(unique=false, nullable = false)
    private String descricaoCompleta;

    @Column(unique=false, nullable = false)
    private String descricaoSimples;

    @Column(unique=false, nullable = false)
    private String tituloCatologo;

    @Column(unique=false, nullable = false)
    private String identificadorUnico;

    @Column(unique=false, nullable = false)
    private String criterioAcesso;

    @OneToOne(cascade=CascadeType.ALL)
    private SLA contrato;

    @ManyToMany
    private List<Servico> servicos;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Objetivo> objetivos;

    @OneToOne
    private Colaborador colaboradorResponsavel;

    @ManyToMany
    private List<Equipa> equipas;


    public Catalogo(String iconeCatalogo,String descricaoCompleta,String descricaoSimples,String tituloCatologo,String identificadorUnico,String criterioAcesso){
        this.iconeCatalogo=iconeCatalogo;
        this.descricaoCompleta=descricaoCompleta;
        this.descricaoSimples=descricaoSimples;
        this.tituloCatologo=tituloCatologo;
        this.identificadorUnico=identificadorUnico;
        this.criterioAcesso=criterioAcesso;
        this.servicos= new ArrayList<>();
        this.objetivos= new ArrayList<>();
        this.equipas=new ArrayList<>();

    }

    public Catalogo() {

    }

    public boolean adicionarServico(Servico servico){
        return servicos.add(servico);
    }

    public boolean adicionarObjetivo(Objetivo objetivo){
        return objetivos.add(objetivo);
    }

    public void adicionarColaborador(Colaborador colaborador){
        this.colaboradorResponsavel =colaborador;
    }

    public boolean adicionarEquipa(Equipa equipa){
        return equipas.add(equipa);
    }

    public void definirContrato(SLA contrato){
        this.contrato=contrato;
    }

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


    public String tituloCatologo() {
        return tituloCatologo;
    }

    public String identificadorUnico() {
        return identificadorUnico;
    }

    public List<Servico> servicos() {
        return servicos;
    }

    public List<Objetivo> objetivos() {
        return objetivos;
    }

    public List<Equipa> equipas() {
        return equipas;
    }

    public Colaborador colaboradorResponsavel() {
        return colaboradorResponsavel;
    }

    public SLA contrato() {
        return contrato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalogo catalogo = (Catalogo) o;
        return  Objects.equals(iconeCatalogo, catalogo.iconeCatalogo) && Objects.equals(descricaoCompleta, catalogo.descricaoCompleta) && Objects.equals(descricaoSimples, catalogo.descricaoSimples) && Objects.equals(tituloCatologo, catalogo.tituloCatologo) && Objects.equals(identificadorUnico, catalogo.identificadorUnico) && Objects.equals(criterioAcesso, catalogo.criterioAcesso) && Objects.equals(contrato, catalogo.contrato) && Objects.equals(servicos, catalogo.servicos) && Objects.equals(objetivos, catalogo.objetivos) && Objects.equals(colaboradorResponsavel, catalogo.colaboradorResponsavel) && Objects.equals(equipas, catalogo.equipas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iconeCatalogo, descricaoCompleta, descricaoSimples, tituloCatologo, identificadorUnico, criterioAcesso, contrato, servicos, objetivos, colaboradorResponsavel, equipas);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Catálogo | Identificador: ").append(identificadorUnico).append(" | Titulo: ").append(tituloCatologo).append("\n\n");
        stringBuilder.append("++================================++\n");
        stringBuilder.append("              SERVICOS\n");
        stringBuilder.append("++================================++\n");
        for (Servico servico:servicos) {
            stringBuilder.append(servico.toString()+"\n");
            stringBuilder.append("++================================++\n");
        }
        return stringBuilder.toString();
    }
}
