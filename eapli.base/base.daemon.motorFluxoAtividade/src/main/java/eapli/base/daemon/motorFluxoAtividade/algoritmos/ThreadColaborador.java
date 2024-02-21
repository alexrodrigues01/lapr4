package eapli.base.daemon.motorFluxoAtividade.algoritmos;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.daemon.motorFluxoAtividade.MotorFluxoAtividadeDaemon;
import eapli.base.equipaManagement.domain.Equipa;
import eapli.base.fluxotarefaresolucao.domain.TarefaExecRes;
import eapli.base.fluxotarefaresolucao.repositories.TarefaExecResRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Pedido;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class ThreadColaborador extends Thread {
    public Colaborador colaborador;
    private boolean fcfs;
    public static final Object lock = new Object();
    private static final Logger LOGGER = LogManager.getLogger(ThreadColaborador.class);
    public TarefaExecRes tarefaExecRes;

    public ThreadColaborador(Colaborador colaborador, boolean fcfs) {
        this.colaborador = colaborador;
        this.fcfs = fcfs;
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
                if (fcfs) {
                    synchronized (lock) {
                        while (MotorFluxoAtividadeDaemon.proxTarefa == null) {
//                            LOGGER.info("Esta thread");
//                            System.out.println("Waiting for new task");
                            lock.wait();
                        }
                    }
                } else {
                    synchronized (this) {
                        while (true) {
//                            LOGGER.info("Esta thread");
                            synchronized (MotorFluxoAtividadeDaemon.algoritmo) {
                                MotorFluxoAtividadeDaemon.algoritmo.notify();
                            }
                            this.wait();
                            break;
                        }
//                        LOGGER.info(tarefaExecRes);
                    }
                }

                TarefaExecRes tarefaExecRes = null;

                if (fcfs) {
                    if (podeAtribuir()) {
                        synchronized (lock) {
                            atribuirTarefa(tarefaExecRes);
                        }
                    }
                } else {
                    synchronized (this) {
                        atribuirTarefa(tarefaExecRes);
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void atribuirTarefa(TarefaExecRes tarefaExecRes) {
        if (!fcfs) {
            tarefaExecRes = this.tarefaExecRes;
            if (tarefaExecRes != null) {
//            MotorFluxoAtividadeDaemon.proxTarefa = null;
                tarefaExecRes.definirColaboradorAtribuido(colaborador);
                tarefaExecRes.setEstado(TarefaExecRes.EstadoTarefaExecucao.Atribuida);
                TarefaExecResRepository tarefaExecResRepository = PersistenceContext.repositories().tarefaExecRes();
                tarefaExecResRepository.save(tarefaExecRes);
                MotorFluxoAtividadeDaemon.lista.remove(colaborador);

//            LOGGER.info("O colaborador {} ficou com a tarefa {}",colaborador.identity(),tarefaExecRes.identity());
            }
        } else {
            tarefaExecRes = MotorFluxoAtividadeDaemon.proxTarefa;
            if (tarefaExecRes != null) {
                MotorFluxoAtividadeDaemon.proxTarefa = null;
                tarefaExecRes.definirColaboradorAtribuido(colaborador);
                LOGGER.info("O colaborador {} ficou com a tarefa {} | Size Colaboradores: {}", colaborador.identity(), tarefaExecRes.identity(), MotorFluxoAtividadeDaemon.lista.size() + 1);
                tarefaExecRes.setEstado(TarefaExecRes.EstadoTarefaExecucao.Atribuida);
                TarefaExecResRepository tarefaExecResRepository = PersistenceContext.repositories().tarefaExecRes();
                tarefaExecResRepository.save(tarefaExecRes);
                MotorFluxoAtividadeDaemon.lista.remove(colaborador);
            }
        }

    }

    public boolean podeAtribuir() {
        if (MotorFluxoAtividadeDaemon.proxTarefa == null)
            return false;
        for (Equipa equipa : MotorFluxoAtividadeDaemon.proxTarefa.tarefaExecucao().equipas()) {
            if (MotorFluxoAtividadeDaemon.lista.contains(colaborador) && equipa.getColaboradores().contains(colaborador)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThreadColaborador that = (ThreadColaborador) o;
        return Objects.equals(colaborador, that.colaborador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colaborador);
    }
}
