package eapli.base.servicomanagement.domain;

import eapli.base.tarefamanagement.domain.TarefaAprovacao;
import eapli.base.tarefamanagement.domain.TarefaExecucao;
import junit.framework.TestCase;

public class FluxoTarefaTest extends TestCase {

    public void testTarefaResolucao() {
        FluxoTarefa fluxo = new FluxoTarefa();

        TarefaAprovacao tarefaAprovacao = new TarefaAprovacao();
        TarefaExecucao tarefaExecucao = new TarefaExecucao();

        assertNull(fluxo.tarefaExecucao());

        fluxo.definirTarefaExecucao(tarefaExecucao);

        assertEquals(fluxo.tarefaExecucao(), tarefaExecucao);
    }

    public void testTarefaAprovacao() {
        FluxoTarefa fluxo = new FluxoTarefa();

        TarefaAprovacao tarefaAprovacao = new TarefaAprovacao();
        TarefaExecucao tarefaExecucao = new TarefaExecucao();

        assertNull(fluxo.tarefaAprovacao());

        fluxo.definirTarefaAprovacao(tarefaAprovacao);

        assertEquals(fluxo.tarefaAprovacao(), tarefaAprovacao);
    }

    public void testDefinirTarefaResolucao() {
        FluxoTarefa fluxo = new FluxoTarefa();

        TarefaAprovacao tarefaAprovacao = new TarefaAprovacao();
        TarefaExecucao tarefaExecucao = new TarefaExecucao();

        assertNull(fluxo.tarefaExecucao());

        fluxo.definirTarefaExecucao(tarefaExecucao);

        assertEquals(fluxo.tarefaExecucao(), tarefaExecucao);
    }

    public void testDefinirTarefaAprovacao() {
        FluxoTarefa fluxo = new FluxoTarefa();

        TarefaAprovacao tarefaAprovacao = new TarefaAprovacao();
        TarefaExecucao tarefaExecucao = new TarefaExecucao();

        assertNull(fluxo.tarefaAprovacao());

        fluxo.definirTarefaAprovacao(tarefaAprovacao);

        assertEquals(fluxo.tarefaAprovacao(), tarefaAprovacao);
    }
}