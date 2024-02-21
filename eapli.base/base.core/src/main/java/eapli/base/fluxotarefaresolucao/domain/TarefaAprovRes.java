package eapli.base.fluxotarefaresolucao.domain;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.servicomanagement.domain.FormularioP;
import eapli.base.tarefamanagement.domain.TarefaAprovacao;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class TarefaAprovRes implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToOne
    @JoinColumn(nullable = false)
    private TarefaAprovacao tarefaAprovacao;

    @Column(unique = false, nullable = false)
    LocalDate dataLimiteTarefa;

    @OneToOne
    private Colaborador colaborador;

    @OneToOne(cascade = CascadeType.ALL)
    private FormularioP formulario;

    @Column(unique = false, nullable = false)
    private EstadoTarefaAprovacao estado;

    public enum EstadoTarefaAprovacao{
        Pendente,Atribuida,Doing,Aprovada,Rejeitada
    }

    public static EstadoTarefaAprovacao getEstado(String estado) {
        if(estado.equalsIgnoreCase("Pendente")){
            return EstadoTarefaAprovacao.Pendente;
        }else if(estado.equalsIgnoreCase("Atribuida")){
            return EstadoTarefaAprovacao.Atribuida;
        }else if(estado.equalsIgnoreCase("Doing")){
            return EstadoTarefaAprovacao.Doing;
        }else if(estado.equalsIgnoreCase("Aprovada")){
            return EstadoTarefaAprovacao.Aprovada;
        }else if(estado.equalsIgnoreCase("Rejeitada")){
            return EstadoTarefaAprovacao.Rejeitada;
        }
        return null;
    }

    public TarefaAprovRes(){}

    public TarefaAprovRes(TarefaAprovacao tarefaAprovacao, LocalDate dataLimiteTarefa) {
        this.tarefaAprovacao = tarefaAprovacao;
        this.dataLimiteTarefa = dataLimiteTarefa;
        this.estado = getEstado("Pendente");
    }

    public  LocalDate dataLimite(){
        return dataLimiteTarefa;
    }

    public EstadoTarefaAprovacao estado(){
        return estado;
    }

    public TarefaAprovacao tarefaAprovacao(){
        return tarefaAprovacao;
    }

    public Colaborador colaborador(){ return colaborador;}

    public void definirColaboradorAtribuido(Colaborador colaborador){
        this.colaborador=colaborador;
    }

    public void setEstado(EstadoTarefaAprovacao estado) {
        this.estado = estado;
    }

    public void definirFormularioPreenchido(FormularioP formulario){
        this.formulario=formulario;
    }

    public TarefaAprovResDTO toDTO(){
        return new TarefaAprovResDTO(id,tarefaAprovacao,dataLimiteTarefa,estado);
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public String toString() {
        return "TarefaAprovRes{" +
                "id=" + id +
                ", tarefaAprovacao=" + tarefaAprovacao +
                ", estado=" + estado +
                '}';
    }
}
