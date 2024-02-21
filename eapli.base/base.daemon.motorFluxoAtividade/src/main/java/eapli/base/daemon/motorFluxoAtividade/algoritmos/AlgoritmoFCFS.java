package eapli.base.daemon.motorFluxoAtividade.algoritmos;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.repositories.ColaboradorRepository;
import eapli.base.daemon.motorFluxoAtividade.MotorFluxoAtividadeDaemon;
import eapli.base.equipaManagement.domain.Equipa;
import eapli.base.fluxotarefaresolucao.domain.TarefaAprovRes;
import eapli.base.fluxotarefaresolucao.domain.TarefaExecRes;
import eapli.base.fluxotarefaresolucao.repositories.TarefaExecResRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Pedido;
import eapli.base.servicomanagement.repositories.PedidoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Thread.sleep;

public class AlgoritmoFCFS implements Algoritmo {


    private static final Logger LOGGER = LogManager.getLogger(AlgoritmoFCFS.class);

    @Override
    public void run() throws InterruptedException {
        List<ThreadColaborador> listaThread = new ArrayList<>();

        ThreadColaborador exec = new ThreadColaborador(null, true);
        // Criar instancias de Colaborador

        while (true) {
            MotorFluxoAtividadeDaemon.lista = new ArrayList<>();
            synchronized (this) {
                this.wait();
            }

            LOGGER.info("---------------------------------------");

            List<TarefaExecRes> list = listaTarefas();
            if(MotorFluxoAtividadeDaemon.lista!=null) {
                for (Colaborador colaborador : MotorFluxoAtividadeDaemon.lista) {
                    ThreadColaborador threadColaborador = new ThreadColaborador(colaborador, true);
                    if (!listaThread.contains(threadColaborador)) {
                        threadColaborador.start();
                        listaThread.add(threadColaborador);
                    }
                }

                MotorFluxoAtividadeDaemon.proxTarefa = null;
                for (TarefaExecRes tarefaExecRes : list) {
                    int nr = 0;
                    for (Equipa equipa : tarefaExecRes.tarefaExecucao().equipas()) {
                        nr += equipa.getColaboradores().size();
                    }
                    MotorFluxoAtividadeDaemon.proxTarefa = tarefaExecRes;

                    while (MotorFluxoAtividadeDaemon.proxTarefa != null) {
                        exec.notAll();
                        sleep(300);
                        nr--;
                        if (nr <= 0) {
                            int b = 0;
                            for (Equipa equipa : tarefaExecRes.tarefaExecucao().equipas()) {
                                MotorFluxoAtividadeDaemon.lista.addAll(equipa.getColaboradores());
                                b += equipa.getColaboradores().size();
                            }
                            nr = b;
                        }
                    }
                }
            }

        }
    }


    private List<TarefaExecRes> listaTarefas() {
        TarefaExecResRepository tarefaExecResRepository = PersistenceContext.repositories().tarefaExecRes();
        List<TarefaExecRes> aprovadas = new ArrayList<>();
        for (Pedido pedido : PersistenceContext.repositories().pedido().findAll()) {
            if ( pedido.fluxoResolucao().tarefaExecucaoResolucao().tarefaExecucao().manual() && pedido.fluxoResolucao().tarefaExecucaoResolucao().estado()== TarefaExecRes.EstadoTarefaExecucao.Pendente && pedido.fluxoResolucao().tarefaAprovacaoResolucao() != null && pedido.fluxoResolucao().tarefaAprovacaoResolucao().estado() == TarefaAprovRes.EstadoTarefaAprovacao.Aprovada) {
                aprovadas.add(pedido.fluxoResolucao().tarefaExecucaoResolucao());
                for (Equipa equipa : pedido.fluxoResolucao().tarefaExecucaoResolucao().tarefaExecucao().equipas()) {
                    for (Colaborador colaborador: equipa.getColaboradores()) {
                        if(!MotorFluxoAtividadeDaemon.lista.contains(colaborador))
                            MotorFluxoAtividadeDaemon.lista.add(colaborador);
                    }
                }
            }
            if ( pedido.fluxoResolucao().tarefaExecucaoResolucao().estado()== TarefaExecRes.EstadoTarefaExecucao.Pendente && pedido.fluxoResolucao().tarefaExecucaoResolucao().tarefaExecucao().manual() &&  pedido.fluxoResolucao().tarefaAprovacaoResolucao() == null) {
                aprovadas.add(pedido.fluxoResolucao().tarefaExecucaoResolucao());
                for (Equipa equipa : pedido.fluxoResolucao().tarefaExecucaoResolucao().tarefaExecucao().equipas()) {
                    for (Colaborador colaborador: equipa.getColaboradores()) {
                        if(!MotorFluxoAtividadeDaemon.lista.contains(colaborador))
                            MotorFluxoAtividadeDaemon.lista.add(colaborador);
                    }
                }
            }
        }


        return aprovadas;
    }

}
