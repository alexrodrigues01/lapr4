package eapli.base.daemon.executorTarefasAutomaticas.algoritmos;

import eapli.base.Application;
import eapli.base.daemon.executorTarefasAutomaticas.ExecutorTarefasAutomaticas;
import eapli.base.daemon.executorTarefasAutomaticas.ExecutorTarefasAutomaticasDaemon;
import eapli.base.servicomanagement.domain.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class AlgoritmoFCFS implements Algoritmo{
    @Override
    public void run() throws InterruptedException {
        ExecutorTarefasAutomaticas executorTarefasAutomaticasNot= new ExecutorTarefasAutomaticas(true);
        for(int i=0;i< Application.settings().numberOfThreads();i++){
           new ExecutorTarefasAutomaticas(true).start();
        }
      while (true){
          if(ExecutorTarefasAutomaticasDaemon.tarefaExecRes.isEmpty()) {
              synchronized (this) {
                  this.wait();
              }
          }
          Thread.sleep(100);
          if(!ExecutorTarefasAutomaticasDaemon.tarefaExecRes.isEmpty() && ExecutorTarefasAutomaticasDaemon.proxTarefa==null){
              System.out.println("TENHO UMA TAREFA PARA EXECUTAR");
                ExecutorTarefasAutomaticasDaemon.setProxTarefa(ExecutorTarefasAutomaticasDaemon.tarefaExecRes.remove(0));
              System.out.println("Vou notificar");
                executorTarefasAutomaticasNot.notAll();
          }
      }
    }
}
