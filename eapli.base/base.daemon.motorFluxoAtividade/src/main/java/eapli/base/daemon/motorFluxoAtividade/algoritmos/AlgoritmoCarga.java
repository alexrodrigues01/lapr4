package eapli.base.daemon.motorFluxoAtividade.algoritmos;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.Objetivo;
import eapli.base.catalogomanagement.repositories.CatalogoRepository;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.daemon.motorFluxoAtividade.MotorFluxoAtividadeDaemon;
import eapli.base.equipaManagement.domain.Equipa;
import eapli.base.fluxotarefaresolucao.domain.TarefaAprovRes;
import eapli.base.fluxotarefaresolucao.domain.TarefaExecRes;
import eapli.base.fluxotarefaresolucao.repositories.TarefaExecResRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Pedido;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.tarefamanagement.domain.TarefaExecucao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.data.util.Pair;

import java.util.*;

import static java.lang.Thread.sleep;

public class AlgoritmoCarga implements Algoritmo {
    private static final Logger LOGGER = LogManager.getLogger(AlgoritmoCarga.class);
    private Map<Colaborador, Integer> map = new HashMap<>();
    List<ThreadColaborador> listaThread = new ArrayList<>();

    @Override
    public void run() throws InterruptedException {


        MotorFluxoAtividadeDaemon.lista = new ArrayList<>();
        while (true) {


            synchronized (this) {
                this.wait();
            }


            List<TarefaExecRes> list = listaTarefas();
            if (list.size() == 0)
                continue;

            LOGGER.info("Foi encontrado {} tarefas", list.size());

            LOGGER.info("---------------------------------------");
            ThreadColaborador exec = new ThreadColaborador(null, false);
            // Criar instancias de Colaborador
            for (Colaborador colaborador : MotorFluxoAtividadeDaemon.lista) {
                ThreadColaborador threadColaborador = new ThreadColaborador(colaborador, false);
                if (!listaThread.contains(threadColaborador)) {
                    threadColaborador.start();
                    listaThread.add(threadColaborador);
                    synchronized (this) {
                        this.wait();
                    }
                }
            }


            MotorFluxoAtividadeDaemon.proxTarefa = null;


            ordernarLista(listaThread);

            for (TarefaExecRes tarefaExecRes : list) {
                int nr = 0;
                for (Equipa equipa : tarefaExecRes.tarefaExecucao().equipas()) {
                    nr += equipa.getColaboradores().size();
                }

                MotorFluxoAtividadeDaemon.proxTarefa = tarefaExecRes;


                while (MotorFluxoAtividadeDaemon.proxTarefa != null) {
                    boolean bool = false;
                    for (ThreadColaborador threadColaborador : listaThread) {
                        if (threadColaborador.podeAtribuir()) {
                            synchronized (threadColaborador) {
                                threadColaborador.tarefaExecRes = MotorFluxoAtividadeDaemon.proxTarefa;
                                MotorFluxoAtividadeDaemon.proxTarefa = null;
                                threadColaborador.notify();
                                MotorFluxoAtividadeDaemon.lista.removeIf(colaborador -> threadColaborador.colaborador.equals(colaborador));
                                LOGGER.info("O colaborador {} ficou com a tarefa {} | Size Colaboradores: {}", threadColaborador.colaborador.identity(), tarefaExecRes.identity(), MotorFluxoAtividadeDaemon.lista.size() + 1);
                            }
                            bool = true;
                            break;
                        }
                    }
                    if (bool)
                        break;

                    ordernarLista(listaThread);
                    for (ThreadColaborador threadColaborador : listaThread) {
                        System.out.println(threadColaborador.colaborador.identity());
                    }
                    LOGGER.info("Não existem mais colaboradores -> a colocar todos os colaboradores  {}", nr);
                    int b = 0;
                    for (Equipa equipa : tarefaExecRes.tarefaExecucao().equipas()) {
                        LOGGER.info("Adicionada equipa {}", equipa.identity());
                        MotorFluxoAtividadeDaemon.lista.addAll(equipa.getColaboradores());
                        b += equipa.getColaboradores().size();
                    }
                    nr = b;
                    LOGGER.info("Nr: {} {}", nr,MotorFluxoAtividadeDaemon.lista.size());
                }
            }

        }

    }

    private List<TarefaExecRes> listaTarefas() {
        List<TarefaExecRes> aprovadas = new ArrayList<>();
        for (Pedido pedido : PersistenceContext.repositories().pedido().findAll()) {
            if (pedido.fluxoResolucao().tarefaExecucaoResolucao().tarefaExecucao().manual() && pedido.fluxoResolucao().tarefaExecucaoResolucao().estado() == TarefaExecRes.EstadoTarefaExecucao.Pendente && pedido.fluxoResolucao().tarefaAprovacaoResolucao() != null && pedido.fluxoResolucao().tarefaAprovacaoResolucao().estado() == TarefaAprovRes.EstadoTarefaAprovacao.Aprovada) {
                aprovadas.add(pedido.fluxoResolucao().tarefaExecucaoResolucao());
                for (Equipa equipa : pedido.fluxoResolucao().tarefaExecucaoResolucao().tarefaExecucao().equipas()) {
                    for (Colaborador colaborador : equipa.getColaboradores()) {
                        if (!MotorFluxoAtividadeDaemon.lista.contains(colaborador))
                            MotorFluxoAtividadeDaemon.lista.add(colaborador);
                    }
                }
            }
            if (pedido.fluxoResolucao().tarefaExecucaoResolucao().estado() == TarefaExecRes.EstadoTarefaExecucao.Pendente && pedido.fluxoResolucao().tarefaExecucaoResolucao().tarefaExecucao().manual() && pedido.fluxoResolucao().tarefaAprovacaoResolucao() == null) {
                aprovadas.add(pedido.fluxoResolucao().tarefaExecucaoResolucao());
                for (Equipa equipa : pedido.fluxoResolucao().tarefaExecucaoResolucao().tarefaExecucao().equipas()) {
                    for (Colaborador colaborador : equipa.getColaboradores()) {
                        if (!MotorFluxoAtividadeDaemon.lista.contains(colaborador))
                            MotorFluxoAtividadeDaemon.lista.add(colaborador);
                    }
                }
            }
        }


        return aprovadas;
    }


    public void ordernarLista(List<ThreadColaborador> colaboradors) {
        Collections.sort(colaboradors, new Comparator<ThreadColaborador>() {
            @Override
            public int compare(ThreadColaborador o1, ThreadColaborador o2) {
                Pair<Double, Integer> pairO1 = getTempoMedio_NrTarefasAtribuidas(o1.colaborador);
                Pair<Double, Integer> pairO2 = getTempoMedio_NrTarefasAtribuidas(o2.colaborador);
                int compare = pairO1.getSecond().compareTo(pairO2.getSecond());
                if (compare == 0) {
                    return pairO1.getFirst().compareTo(pairO2.getFirst());
                } else {
                    return compare;
                }
            }
        });
    }

    public Pair<Double, Integer> getTempoMedio_NrTarefasAtribuidas(Colaborador colaborador) {
        Catalogo catalogo = null;
//        synchronized (this) {
//            catalogo = getCatalogoByTarefa(MotorFluxoAtividadeDaemon.proxTarefa.tarefaExecucao());
//        }
        TarefaExecResRepository tarefaExecResRepository = PersistenceContext.repositories().tarefaExecRes();
        List<TarefaExecRes> list = tarefaExecResRepository.getTarefasColaboradorPendentes(colaborador.email(), TarefaExecRes.EstadoTarefaExecucao.Atribuida);
        double media = 0;
        for (TarefaExecRes tarefaExecRes : list) {
            catalogo = getCatalogoByTarefa(tarefaExecRes.tarefaExecucao());
            double media_media = 0;
            for (Objetivo objetivo : catalogo.contrato().nivelCriticidade().objetivo()) {
                media_media += objetivo.getTempoMedioResolucao();
            }
            media_media = media_media / catalogo.contrato().nivelCriticidade().objetivo().size();
            media += media_media;
        }
        media = media / list.size();
        return Pair.of(media, list.size());
    }

    private Catalogo getCatalogoByTarefa(TarefaExecucao tarefaExecucao) {
        CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogos();
        for (Catalogo catalogo : catalogoRepository.findAll()) {
            for (Servico servico : catalogo.servicos()) {
                if (servico.fluxoTarefa().tarefaExecucao().equals(tarefaExecucao)) {
                    return catalogo;
                }
            }
        }
        return null;
    }

}
