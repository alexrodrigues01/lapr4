package eapli.base.daemon.executorTarefasAutomaticas;

import eapli.base.Application;
import eapli.base.daemon.executorTarefasAutomaticas.protocol.SendPacket;
import eapli.base.servicomanagement.domain.Pedido;
import gramaticas.script.ValidarScript;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExecutorTarefasAutomaticas extends Thread {

    public int carga=0;
    public boolean FCFS;
    private static final Object lock= new Object();
    private static final Logger LOGGER = LogManager.getLogger(ExecutorTarefasAutomaticas.class);


    public ExecutorTarefasAutomaticas(boolean FCFS){
        this.FCFS=FCFS;
    }
    public void notAll() {
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    @Override
    public void run() {

        while (true) {
            try {
                if(FCFS){
                    synchronized (lock){
                        while (ExecutorTarefasAutomaticasDaemon.proxTarefa == null) {
                            LOGGER.info("Esta thread");
                            System.out.println("Waiting for new task");
                            lock.wait();
                        }
                    }
                }else {
                    synchronized (this) {
                        while (ExecutorTarefasAutomaticasDaemon.proxTarefa == null) {
                            LOGGER.info("Esta thread");
                            System.out.println("Waiting for new task");
                            this.wait();
                        }
                    }
                }


                Pedido pedido;
                if(FCFS){
                    synchronized (lock) {
                        pedido = ExecutorTarefasAutomaticasDaemon.proxTarefa;
                        ExecutorTarefasAutomaticasDaemon.setProxTarefa(null);
                        carga++;
                    }
                }else {
                    synchronized (this) {
                        pedido = ExecutorTarefasAutomaticasDaemon.proxTarefa;
                        ExecutorTarefasAutomaticasDaemon.setProxTarefa(null);
                        carga++;
                    }
                }
                if(pedido!=null) {
                    Thread.sleep(1000);
                    LOGGER.info("Vou alterar");
                    if(Application.settings().isVisitor()) {
                        ValidarScript.visitor(pedido.getFormulario(), pedido.fluxoResolucao().tarefaExecucaoResolucao().tarefaExecucao().script(), true);
                    }else {
                        ValidarScript.listener(pedido.getFormulario(), pedido.fluxoResolucao().tarefaExecucaoResolucao().tarefaExecucao().script(), true);
                    }
                    new Thread(() -> {
                        SendPacket.sendPacketTarefaTerminou(pedido);
                    }).start();
                }
            } catch (Exception e) {
               LOGGER.error(e.getMessage());
            }
        }
    }

    public int getCarga() {
        return carga;
    }

}



