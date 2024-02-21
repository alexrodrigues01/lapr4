package eapli.base.colaboradormanagement.domain;

import eapli.base.equipaManagement.domain.Equipa;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Colaborador implements AggregateRoot<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(unique = false, nullable = false)
    private String email;

    @Column(unique = false, nullable = false)
    private String nomeComum;

    @Column(unique = false, nullable = false)
    private String nomeCompleto;

    @Column(unique = false, nullable = false)
    private String localResidencia;

    @Column(unique = false, nullable = false)
    private String telemovel;

    @Column(unique = false, nullable = false)
    private LocalDate dataNascimento;

    @Column(unique = false, nullable = false)
    private Funcao funcao;

    public enum Funcao{
        DiretorComercial,GestorClientes,AssistenteDirecao,Comercial,GestorHelpDesk
    }

    public static Funcao getFuncao(String funcao) {
        if(funcao.equals("DiretorComercial")){
            return Funcao.DiretorComercial;
        }else if(funcao.equals("GestorClientes")){
            return Funcao.GestorClientes;
        }else if(funcao.equals("AssistenteDirecao")){
            return Funcao.AssistenteDirecao;
        }else if(funcao.equals("Comercial")){
            return Funcao.Comercial;
        }else if(funcao.equals("GestorHelpDesk")){
            return Funcao.GestorHelpDesk;
        }
        return null;
    }
    @OneToOne
    private Colaborador responsável;

    public Colaborador(String email,String nomeComum, String nomeCompleto, String localResidencia, String telemovel, LocalDate dataNascimento, Funcao funcao ,Colaborador colaborador) {
        if (nomeComum == null || nomeCompleto == null || localResidencia == null || telemovel == null || dataNascimento == null ) {
            throw new IllegalArgumentException();
        }
        this.nomeComum = nomeComum;
        this.nomeCompleto = nomeCompleto;
        this.localResidencia = localResidencia;
        this.telemovel = telemovel;
        this.dataNascimento = dataNascimento;
        this.funcao = funcao;
        this.email=email;
        this.responsável=colaborador;
    }

    public Colaborador() {

    }
    public static Funcao[] funcoes(){
       return Funcao.values();
    }

    public String email(){
        return email;
    }

    public String nomeCompleto(){
        return nomeCompleto;
    }

    public String firstName(){
        String [] objeto=nomeCompleto.split("[ ]");
        return objeto[0];
    }

    public String lastName(){
        String [] objeto=nomeCompleto.split("[ ]");
        return objeto[objeto.length-1];
    }
    public Funcao funcao() {
        return funcao;
    }


    public Colaborador responsavel(){
        return responsável;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colaborador that = (Colaborador) o;
        return  Objects.equals(email, that.email) &&
                Objects.equals(nomeComum, that.nomeComum) &&
                Objects.equals(nomeCompleto, that.nomeCompleto) &&
                Objects.equals(localResidencia, that.localResidencia) &&
                Objects.equals(telemovel, that.telemovel) &&
                Objects.equals(dataNascimento, that.dataNascimento) &&
                Objects.equals(funcao, that.funcao) &&
                Objects.equals(responsável, that.responsável);
    }


    
    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Integer identity() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Nome Completo:"+nomeCompleto+"\nNome Comum:"+nomeComum+"\nLocal Residência: "+localResidencia+"\nTelemovel: "+ telemovel+"\nData Nascimento: "+dataNascimento+"\nFunção: "+funcao+"\n"+"Email:"+email+"\n";
    }
}
