package eapli.base.fluxotarefaresolucao.domain;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.servicomanagement.domain.FormularioP;
import eapli.base.tarefamanagement.domain.TarefaExecucao;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class TarefaExecRes implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToOne
    @JoinColumn(nullable = false)
    TarefaExecucao tarefaExecucao;

    @Column(unique = false, nullable = false)
    LocalDate dataLimiteTarefa;

    @OneToOne
    private Colaborador colaborador;

    @OneToOne(cascade = CascadeType.ALL)
    private FormularioP formulario;

    @Column(unique = false, nullable = false)
    private EstadoTarefaExecucao estado;

    public enum EstadoTarefaExecucao {
        Pendente,Atribuida,Doing,Concluida
    }

    public static EstadoTarefaExecucao getEstado(String estado) {
        if(estado.equalsIgnoreCase("Pendente")){
            return EstadoTarefaExecucao.Pendente;
        }else if(estado.equalsIgnoreCase("Atribuida")){
            return EstadoTarefaExecucao.Atribuida;
        }else if(estado.equalsIgnoreCase("Doing")){
            return EstadoTarefaExecucao.Doing;
        }else if(estado.equalsIgnoreCase("Concluida")) {
            return EstadoTarefaExecucao.Concluida;
        }
        return null;
    }

    public TarefaExecRes() { }

    public TarefaExecRes(TarefaExecucao tarefaExecucao, LocalDate dataLimiteTarefa) {
        this.tarefaExecucao = tarefaExecucao;
        this.dataLimiteTarefa = dataLimiteTarefa;
        this.estado = getEstado("Pendente");
    }
    public  LocalDate dataLimite(){
        return dataLimiteTarefa;
    }
    public TarefaExecucao tarefaExecucao(){
        return tarefaExecucao;
    }

    public EstadoTarefaExecucao estado(){
        return estado;
    }

    public Colaborador colaborador(){ return colaborador;}

    public void setEstado(EstadoTarefaExecucao estado) {
        this.estado = estado;
    }

    public void definirFormularioPreenchido(FormularioP formulario){
        this.formulario=formulario;
    }

    public void definirColaboradorAtribuido(Colaborador colaborador){
        this.colaborador=colaborador;
    }

    public TarefaExecResDTO toDTO(){
        return new TarefaExecResDTO(id,tarefaExecucao,dataLimiteTarefa,estado);
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Long identity() {
        return id;
    }

    public void doing(){estado= EstadoTarefaExecucao.Doing;}

    public void done(){estado= EstadoTarefaExecucao.Concluida;}

    public void pendente(){estado= EstadoTarefaExecucao.Pendente;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TarefaExecRes that = (TarefaExecRes) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TarefaExecRes{" +
                "id=" + id +
                ", tarefaExecucao=" + tarefaExecucao +
                ", estado=" + estado +
                '}';
    }
}
