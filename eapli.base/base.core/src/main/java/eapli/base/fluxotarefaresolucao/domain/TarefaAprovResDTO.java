package eapli.base.fluxotarefaresolucao.domain;

import eapli.base.tarefamanagement.domain.TarefaAprovacao;

import java.time.LocalDate;

public class TarefaAprovResDTO {

    Long id;

    TarefaAprovacao tarefaAprovacao;

    LocalDate dataLimiteTarefa;

    TarefaAprovRes.EstadoTarefaAprovacao estado;

    public TarefaAprovResDTO(Long id, TarefaAprovacao tarefaAprovacao, LocalDate dataLimiteTarefa, TarefaAprovRes.EstadoTarefaAprovacao estado) {
        this.id = id;
        this.tarefaAprovacao = tarefaAprovacao;
        this.dataLimiteTarefa = dataLimiteTarefa;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tarefa Aprovacao Resolucao\n" +
                "ID: " + id +
                "\nTarefa Aprovacao " + tarefaAprovacao +
                "Data Limite: " + dataLimiteTarefa +
                "\nEstado: " + estado +
                '\n';
    }
}
