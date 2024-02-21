package eapli.base.daemon.motorFluxoAtividade.algoritmos;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.fluxotarefaresolucao.domain.TarefaExecRes;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public interface Algoritmo {
    public void run() throws InterruptedException;
}
