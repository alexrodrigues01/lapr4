//package eapli.base.daemon.motorFluxoAtividade.protocol;
//
//import Utils.LocalDateConverter;
//import eapli.base.infrastructure.persistence.PersistenceContext;
//import eapli.base.servicomanagement.domain.FluxoTarefa;
//import eapli.base.servicomanagement.domain.Servico;
//import eapli.base.servicomanagement.repositories.ServicoRepository;
//import eapli.base.tarefamanagement.domain.TarefaAprovacao;
//import eapli.base.tarefamanagement.domain.TarefaExecucao;
//
//import java.nio.charset.StandardCharsets;
//import java.time.Duration;
//import java.time.LocalDate;
//import java.util.ArrayList;
//
//public class GetTarefasAssignadasRequest extends SDP2021ProtocolRequest {
//    private final String userId;
//
//    /**
//     * Se for 1 : Tarefas Pendentes
//     * Se for 2: Tarefas Pendentes Terminadas
//     * Se for 3: Tarefas Pendentes A Terminar Em Breve
//     */
//
//    private final int estadoTarefaPendente;
//
//    public GetTarefasAssignadasRequest(final String request,
//                                       final String userId, final int estadoTarefaPendente, boolean goodBye) {
//        super(request, goodBye);
//        this.userId = userId;
//        this.estadoTarefaPendente = estadoTarefaPendente;
//    }
//
//    @Override
//    public byte [] execute() {
//        try {
//
//            ArrayList<TarefaAprovacao> tarefasAprovacao = new ArrayList<>();
//            ArrayList<TarefaExecucao> tarefaExecucao = new ArrayList<>();
//            ServicoRepository servicoRepository = PersistenceContext.repositories().servicos();
//            Iterable<Servico> servicos = servicoRepository.findAll();
//
//            if (estadoTarefaPendente == 1) {
//                for (Servico servico : servicos) {
//                    FluxoTarefa fluxoTarefa = servico.fluxoTarefa();
//                    TarefaAprovacao aprovacao = fluxoTarefa.tarefaAprovacao();
//                    TarefaExecucao resolucao = fluxoTarefa.tarefaExecucao();
//                    if (aprovacao.colaborador().email().equalsIgnoreCase(userId)) {
//                        tarefasAprovacao.add(aprovacao);
//                    }
//                    if (resolucao.colaborador().email().equalsIgnoreCase(userId)) {
//                        tarefaExecucao.add(resolucao);
//                    }
//                }
//
//            } else if (estadoTarefaPendente == 2) {
//                LocalDate date = java.time.LocalDate.now();
//                for (Servico servico : servicos) {
//                    FluxoTarefa fluxoTarefa = servico.fluxoTarefa();
//                    TarefaAprovacao aprovacao = fluxoTarefa.tarefaAprovacao();
//                    TarefaExecucao resolucao = fluxoTarefa.tarefaExecucao();
//                    if (aprovacao.colaborador().email().equalsIgnoreCase(userId) && aprovacao.estado() == TarefaAprovacao.EstadoTarefaAprovacao.Atribuida && LocalDateConverter.convertToLocalDateViaMilisecond(aprovacao.dataLimite()).isAfter(date)) {
//                        tarefasAprovacao.add(aprovacao);
//                    }
//                    if (resolucao.colaborador().email().equalsIgnoreCase(userId) && resolucao.estado() == TarefaExecucao.EstadoTarefaResolucao.Atribuida && LocalDateConverter.convertToLocalDateViaMilisecond(resolucao.dataLimite()).isAfter(date)) {
//                        tarefaExecucao.add(resolucao);
//                    }
//                }
//            } else {
//                LocalDate date = java.time.LocalDate.now();
//                for (Servico servico : servicos) {
//                    FluxoTarefa fluxoTarefa = servico.fluxoTarefa();
//                    TarefaAprovacao aprovacao = fluxoTarefa.tarefaAprovacao();
//                    TarefaExecucao resolucao = fluxoTarefa.tarefaExecucao();
//                    Duration duration = Duration.between(LocalDateConverter.convertToLocalDateViaMilisecond(aprovacao.dataLimite()), date);
//                    if (aprovacao.colaborador().email().equalsIgnoreCase(userId) && duration.toHours() < 1) {
//                        tarefasAprovacao.add(aprovacao);
//                    }
//
//                    duration = Duration.between(LocalDateConverter.convertToLocalDateViaMilisecond(resolucao.dataLimite()), date);
//                    if (resolucao.colaborador().email().equalsIgnoreCase(userId) && duration.toHours() < 1) {
//                        tarefaExecucao.add(resolucao);
//                    }
//                }
//
//            }
//            return buildResponse(tarefasAprovacao, tarefaExecucao).getBytes(StandardCharsets.UTF_8);
//
//        } catch (final Exception e) {
//            // we should be careful about exposing the Exception to the outside!
//            return buildServerError(e.getMessage()).getBytes(StandardCharsets.UTF_8);
//        }
//    }
//
//    @Override
//    protected String messageType() {
//        return null;
//    }
//
//    private String buildResponse(ArrayList<TarefaAprovacao> tarefasAprovacao, ArrayList<TarefaExecucao> tarefaExecucao) {
//        return "" + (tarefaExecucao.size() + tarefasAprovacao.size());
//    }
//}
