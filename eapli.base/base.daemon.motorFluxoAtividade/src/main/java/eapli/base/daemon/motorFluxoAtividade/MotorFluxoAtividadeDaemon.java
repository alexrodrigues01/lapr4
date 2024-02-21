package eapli.base.daemon.motorFluxoAtividade;



import eapli.base.Application;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.daemon.motorFluxoAtividade.algoritmos.Algoritmo;
import eapli.base.daemon.motorFluxoAtividade.algoritmos.AlgoritmoCarga;
import eapli.base.daemon.motorFluxoAtividade.algoritmos.AlgoritmoFCFS;
import eapli.base.daemon.motorFluxoAtividade.presentation.MotorFluxoAtividadeServer;
import eapli.base.fluxotarefaresolucao.domain.TarefaExecRes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class MotorFluxoAtividadeDaemon {
    // TODO read port number from property file
    private static final int PORT = 7475;
    private static final Logger LOGGER = LogManager.getLogger(MotorFluxoAtividadeDaemon.class);
    public static TarefaExecRes proxTarefa=null;
    public static List<Colaborador> lista=null;
    public static  Algoritmo algoritmo;
    /**
     * Avoid instantiation of this class.
     */
    private MotorFluxoAtividadeDaemon() {
    }

    public static void main(final String[] args) {
        LOGGER.info("Configuring the daemon");
    /*
        AuthzRegistry.configure(PersistenceContext.repositories().users(),
                new CafeteriaPasswordPolicy(),
                new PlainTextEncoder());
    */
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
                    System.out.println("CARGA");
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
        final MotorFluxoAtividadeServer server = new MotorFluxoAtividadeServer();
        server.start(PORT, true);
        
        LOGGER.info("Exiting the daemon");
        System.exit(0);
    }
}
