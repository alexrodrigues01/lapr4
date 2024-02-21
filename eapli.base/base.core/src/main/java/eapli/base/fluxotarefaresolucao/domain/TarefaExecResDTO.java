package eapli.base.fluxotarefaresolucao.domain;

import eapli.base.tarefamanagement.domain.TarefaExecucao;

import java.time.LocalDate;

public class TarefaExecResDTO {

    Long id;

    TarefaExecucao tarefaExecucao;

    LocalDate dataLimiteTarefa;

    TarefaExecRes.EstadoTarefaExecucao estado;

    public TarefaExecResDTO(Long id, TarefaExecucao tarefaExecucao, LocalDate dataLimiteTarefa, TarefaExecRes.EstadoTarefaExecucao estado) {
        this.id = id;
        this.tarefaExecucao = tarefaExecucao;
        this.dataLimiteTarefa = dataLimiteTarefa;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tarefa Execucao Resolucao\n" +
                "ID: " + id +
                "\nTarefa Execucao " + tarefaExecucao +
                "Data Limite: " + dataLimiteTarefa +
                "\nEstado: " + estado +
                '\n';
    }
}
