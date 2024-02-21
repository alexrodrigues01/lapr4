package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Servico implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private NomeServico nome;

    private CodigoServico codigo;

    @Column(nullable = true)
    private String descSimples;

    @Column(nullable = true)
    private String descCompleta;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Keyword> keywords;

    @OneToOne(cascade = CascadeType.ALL)
    private Formulario formulario;

    @Column(unique = false, nullable = false)
    private boolean publicar;

    @OneToOne(cascade=CascadeType.ALL)
    private FluxoTarefa fluxoTarefa;

    public Servico(NomeServico nome, CodigoServico codigo, String descSimples, String descCompleta, List<Keyword> keywords) {
        this.nome = nome;
        this.codigo = codigo;

        if(descSimples.isBlank()){
            this.descSimples = null;
        }else{
            this.descSimples = descSimples;
        }

        if(descCompleta.isBlank()){
            this.descCompleta = null;
        }else{
            this.descCompleta = descSimples;
        }

        if(keywords.isEmpty()){
            this.keywords = new ArrayList<>();
        }else{
            this.keywords = keywords;
        }
        
        this.publicar = false;
    }

    public Servico() {

    }

    public Long getId() {
        return id;
    }

    public String titulo() {
        return nome.nome();
    }

    public List<Keyword> keywords() {
        return keywords;
    }

    public FluxoTarefa fluxoTarefa(){
        return fluxoTarefa;
    }

    public void definirFluxoTarefa(FluxoTarefa fluxoTarefa) {
        this.fluxoTarefa = fluxoTarefa;
    }

    public String codigo() {
        return codigo.codigo();
    }

    public void definirNome(NomeServico nome) {
        this.nome = nome;
    }

    public void definirCodigo(CodigoServico codigo) {
        this.codigo = codigo;
    }

    public void definirDescSimples(String descSimples) {
        this.descSimples = descSimples;
    }

    public void definirDescCompleta(String descCompleta) {
        this.descCompleta = descCompleta;
    }

    public boolean definirKeyword(Keyword keyword){
        return keywords.add(keyword);
    }

    public void removerKeyword(Keyword keyword){
        for(Keyword k : keywords){
            if(k.keyword().equalsIgnoreCase(keyword.keyword())){
                keywords.remove(keyword);
            }
        }
    }

    public Atributo adicionarAtributoFormulario(Atributo atributo){
        formulario.adicionarAtributo(atributo);
        return atributo;
    }

    public Formulario formulario() {
        return formulario;
    }

    public void definirFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public boolean verificarPublicacao(){
        publicar = descSimples != null || descCompleta != null || !keywords.isEmpty() || formulario.verificarPublicacao();
        return publicar;
    }

    public boolean publicacao(){
        return publicar;
    }

    public String toString(){
        if(!publicar){
            return "Código Unico: " + codigo.codigo() + " | Nome: " + nome.nome() + " : " + "Serviço ainda não disponível.";
        }

        return "Código Unico: " + codigo.codigo() + " | Nome: " + nome.nome() + "\n" + descSimples + "\n" + descCompleta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servico servico = (Servico) o;
        return publicar == servico.publicar && Objects.equals(id, servico.id) && Objects.equals(nome, servico.nome) && Objects.equals(codigo, servico.codigo) && Objects.equals(descSimples, servico.descSimples) && Objects.equals(descCompleta, servico.descCompleta) && Objects.equals(keywords, servico.keywords) && Objects.equals(formulario, servico.formulario);
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
