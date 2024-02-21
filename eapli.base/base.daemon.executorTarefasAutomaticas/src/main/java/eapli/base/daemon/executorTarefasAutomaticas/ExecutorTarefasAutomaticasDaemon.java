package eapli.base.daemon.executorTarefasAutomaticas;



import eapli.base.Application;
import eapli.base.daemon.executorTarefasAutomaticas.algoritmos.Algoritmo;
import eapli.base.daemon.executorTarefasAutomaticas.algoritmos.AlgoritmoCarga;
import eapli.base.daemon.executorTarefasAutomaticas.algoritmos.AlgoritmoFCFS;
import eapli.base.daemon.executorTarefasAutomaticas.presentation.ExecutorTarefasAutomaticasServer;
import eapli.base.servicomanagement.domain.Pedido;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class ExecutorTarefasAutomaticasDaemon {

   public static List<Pedido> tarefaExecResProv = new ArrayList<>();
   public static List<Pedido> tarefaExecRes = Collections.synchronizedList(tarefaExecResProv);
   public static List<Pedido> tarefasFeitas = new ArrayList<>();
   public static Pedido proxTarefa;
   public static Algoritmo algoritmo;

    // TODO read port number from property file
    private static final int PORT = 32705;
    private static final Logger LOGGER = LogManager.getLogger(ExecutorTarefasAutomaticasDaemon.class);

    /**
     * Avoid instantiation of this class.
     */
    private ExecutorTarefasAutomaticasDaemon() {
    }

    public static void setProxTarefa(Pedido proxTarefa) {
        ExecutorTarefasAutomaticasDaemon.proxTarefa = proxTarefa;
    }

    public static void main(final String[] args) {
        LOGGER.info("Configuring the daemon");

        new Thread(()->{
            if(Application.settings().isFCFS()){
                algoritmo=new AlgoritmoFCFS();
                try {
                    algoritmo.run();
                } catch (InterruptedException e) {
                    LOGGER.error(e.getMessage());
                }
            }else{
                if(Application.settings().isCarga()){
                    algoritmo=new AlgoritmoCarga();
                    try {
                        algoritmo.run();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                        LOGGER.error(e.getMessage());
                    }
                }
            }
        }).start();

        LOGGER.info("Starting the server socket");
        final ExecutorTarefasAutomaticasServer server = new ExecutorTarefasAutomaticasServer();
        server.start(PORT, true);



        LOGGER.info("Exiting the daemon");
        System.exit(0);
    }

}
