package eapli.base.daemon.executorTarefasAutomaticas.algoritmos;

import eapli.base.Application;
import eapli.base.daemon.executorTarefasAutomaticas.ExecutorTarefasAutomaticas;
import eapli.base.daemon.executorTarefasAutomaticas.ExecutorTarefasAutomaticasDaemon;
import eapli.base.servicomanagement.domain.Pedido;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class AlgoritmoCarga implements Algoritmo {
    @Override
    public void run() throws InterruptedException {
        List<ExecutorTarefasAutomaticas> listThreads = new LinkedList<>();
        listThreads.add(new ExecutorTarefasAutomaticas(false));
        for (int i = 0; i < Application.settings().numberOfThreads(); i++) {
            ExecutorTarefasAutomaticas exec= new ExecutorTarefasAutomaticas(false);
            exec.start();
            listThreads.add(exec);
        }
        while (true) {
            if(ExecutorTarefasAutomaticasDaemon.tarefaExecRes.isEmpty()) {
                synchronized (this) {
                    this.wait();
                }
            }
            Thread.sleep(100);
            if (!ExecutorTarefasAutomaticasDaemon.tarefaExecRes.isEmpty() && ExecutorTarefasAutomaticasDaemon.proxTarefa == null) {
                listThreads.sort(new Comparator<ExecutorTarefasAutomaticas>() {
                    @Override
                    public int compare(ExecutorTarefasAutomaticas o1, ExecutorTarefasAutomaticas o2) {
                        return o1.getCarga() - o2.getCarga();
                    }
                });
                for (ExecutorTarefasAutomaticas exec : listThreads) {
                    if (exec.getState() == Thread.State.WAITING) {
                        ExecutorTarefasAutomaticasDaemon.setProxTarefa(ExecutorTarefasAutomaticasDaemon.tarefaExecRes.remove(0));
                        System.out.println(exec.getCarga());
//                        exec.setMenorCarga(true);
                        synchronized (exec) {
                            exec.notify();
                        }
                        break;
                    }
                }
            }
        }

    }
}
