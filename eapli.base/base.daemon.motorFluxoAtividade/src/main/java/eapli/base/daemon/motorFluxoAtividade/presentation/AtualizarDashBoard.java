package eapli.base.daemon.motorFluxoAtividade.presentation;

import Utils.LocalDateConverter;
import eapli.base.app.other.console.http.HTTPmessage;
import eapli.base.daemon.motorFluxoAtividade.Utils.Constantes;
import eapli.base.fluxotarefaresolucao.domain.TarefaAprovRes;
import eapli.base.fluxotarefaresolucao.domain.TarefaExecRes;
import eapli.base.fluxotarefaresolucao.repositories.TarefaAprovResRepository;
import eapli.base.fluxotarefaresolucao.repositories.TarefaExecResRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.FluxoTarefa;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repositories.PedidoRepository;
import eapli.base.servicomanagement.repositories.ServicoRepository;
import eapli.base.tarefamanagement.domain.TarefaAprovacao;
import eapli.base.tarefamanagement.domain.TarefaExecucao;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Thread.sleep;

public class AtualizarDashBoard {
    private static final Logger LOGGER = LogManager.getLogger(AtualizarDashBoard.class);
    static final String KEYSTORE_PASS = "forgotten";
    static private int serverPort = 8980;
    private Socket clientSocket;

    public AtualizarDashBoard(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void start(byte[] bytes) throws IOException {

        byte[] email = new byte[bytes[Constantes.SIZE_POS]];
        int i;
        for (i = 0; i < bytes[Constantes.SIZE_POS]; i++) {
            email[i] = bytes[i + Constantes.DATA_POS];
        }
        String emailS = new String(email, StandardCharsets.UTF_8);
        LOGGER.debug("EMAIL: " + emailS);
        final InetAddress clientIP = clientSocket.getInetAddress();
        clientSocket.close();
        Role role = null;
        UserRepository userRepository = PersistenceContext.repositories().users();
        Iterable<SystemUser> systemUsers = userRepository.findAll();
        for (SystemUser su : systemUsers) {
            if (su.email().toString().equalsIgnoreCase(emailS)) {
                for (Role rolee : su.roleTypes()) {
                    role = rolee;
                }
            }
        }
        System.setProperty("javax.net.ssl.trustStore", "client2_J.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

        // Use this certificate and private key for client certificate when requested by the server
        System.setProperty("javax.net.ssl.keyStore", "client1_2.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

        i = 0;
        while (true) {
            try {

                SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();

                Socket sock = (SSLSocket) sf.createSocket(clientIP.getHostAddress(), serverPort);

                try {
                    ((SSLSocket) sock).startHandshake();
                } catch (NullPointerException | IOException n) {
                    System.out.println("Erro");
                }


                DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());

                HTTPmessage request = new HTTPmessage();
                request.setRequestMethod("PUT");
                request.setURI("/tarefasPendentes/" + getTarefasPendentes(emailS, role));
//                request.setURI("/tarefasPendentes/" + i + 3);
                request.send(sOut);

                sock.close();

                sock = (SSLSocket) sf.createSocket(clientIP.getHostAddress(), serverPort);

                try {
                    ((SSLSocket) sock).startHandshake();
                } catch (NullPointerException | IOException n) {
                    System.out.println("Erro");
                }

                sOut = new DataOutputStream(sock.getOutputStream());
                request = new HTTPmessage();
                request.setRequestMethod("PUT");
                request.setURI("/tarefasPendentesTerminadas/" + getTarefasPendentesTerminadas(emailS, role));
//                request.setURI("/tarefasPendentesTerminadas/" + i);
                request.send(sOut);

                sock.close();

                sock = (SSLSocket) sf.createSocket(clientIP.getHostAddress(), serverPort);

                try {
                    ((SSLSocket) sock).startHandshake();
                } catch (NullPointerException | IOException n) {
                    System.out.println("Erro");
                }

                sOut = new DataOutputStream(sock.getOutputStream());
                request = new HTTPmessage();
                request.setRequestMethod("PUT");
                request.setURI("/closeTerminar/" + getTarefasPendentesPorTerminar(emailS, role));
//                request.setURI("/closeTerminar/" + i + 2);
                request.send(sOut);

                sock.close();
                LOGGER.info("Atualizando Dashboard do {} {}", role, emailS);
                sleep(3000);
                i++;
            } catch (Exception e) {
                LOGGER.info("Conexao Fechada");
                clientSocket.close();
                return;
            }
        }
    }

//    private String getTarefasPendentes(String userId, Role role) {
//        ArrayList<TarefaAprovacao> tarefasAprovacao = new ArrayList<>();
//        ArrayList<TarefaExecucao> tarefaExecucao = new ArrayList<>();
//        ServicoRepository servicoRepository = PersistenceContext.repositories().servicos();
//        Iterable<Servico> servicos = servicoRepository.findAll();
//        for (Servico servico : servicos) {
//            FluxoTarefa fluxoTarefa = servico.fluxoTarefa();
//            TarefaAprovacao aprovacao = fluxoTarefa.tarefaAprovacao();
//            TarefaExecucao resolucao = fluxoTarefa.tarefaExecucao();
//            if (BaseRoles.USER.equals(role)) {
//                if (  aprovacao != null && aprovacao.estado()==TarefaAprovacao.EstadoTarefaAprovacao.Atribuida && aprovacao.colaborador() != null && aprovacao.colaborador().email().equalsIgnoreCase(userId)) {
//                    tarefasAprovacao.add(aprovacao);
//                }
//
//                if (  resolucao != null && resolucao.estado()== TarefaExecucao.EstadoTarefaResolucao.Atribuida  && resolucao.colaborador() != null && resolucao.colaborador().email().equalsIgnoreCase(userId)) {
//                    tarefaExecucao.add(resolucao);
//                }
//            } else {
//
//                if ( aprovacao != null&& aprovacao.estado()==TarefaAprovacao.EstadoTarefaAprovacao.Pendente ) {
//                    tarefasAprovacao.add(aprovacao);
//                }
//
//                if (resolucao != null && resolucao.estado()== TarefaExecucao.EstadoTarefaResolucao.Pendente  ) {
//                    tarefaExecucao.add(resolucao);
//                }
//
//            }
//        }
//        return "" + (tarefaExecucao.size() + tarefasAprovacao.size());
//    }

    private String getTarefasPendentes(String userId, Role role) {
        List<TarefaAprovRes> tarefasAprovacao = new ArrayList<>();
        List<TarefaExecRes> tarefaExecucao = new ArrayList<>();
        TarefaExecResRepository tarefaExecRepository = PersistenceContext.repositories().tarefaExecRes();
        TarefaAprovResRepository tarefaAprovResRepository = PersistenceContext.repositories().tarefaAprovRes();

        if (BaseRoles.USER.equals(role)) {
            tarefasAprovacao = tarefaAprovResRepository.getTarefasColaboradorPendentes(userId, TarefaAprovRes.EstadoTarefaAprovacao.Atribuida);
            tarefaExecucao = tarefaExecRepository.getTarefasColaboradorPendentes(userId, TarefaExecRes.EstadoTarefaExecucao.Atribuida);
        } else {
            tarefaExecucao = tarefaExecRepository.getTarefasPendentes();
            tarefasAprovacao = tarefaAprovResRepository.getTarefasPendentes();
        }
        return "" + (tarefaExecucao.size() + tarefasAprovacao.size());
    }

//    private String getTarefasPendentesTerminadas(String userId, Role role) {
//        ArrayList<TarefaAprovacao> tarefasAprovacao = new ArrayList<>();
//        ArrayList<TarefaExecucao> tarefaExecucao = new ArrayList<>();
//        ServicoRepository servicoRepository = PersistenceContext.repositories().servicos();
//        Iterable<Servico> servicos = servicoRepository.findAll();
//        LocalDate date = java.time.LocalDate.now();
//        for (Servico servico : servicos) {
//            FluxoTarefa fluxoTarefa = servico.fluxoTarefa();
//            TarefaAprovacao aprovacao = fluxoTarefa.tarefaAprovacao();
//            TarefaExecucao resolucao = fluxoTarefa.tarefaExecucao();
//            if (BaseRoles.USER.equals(role)) {
//                if (aprovacao != null && aprovacao.colaborador() != null && aprovacao.colaborador().email().equalsIgnoreCase(userId) && aprovacao.estado() == TarefaAprovacao.EstadoTarefaAprovacao.Atribuida && LocalDateConverter.convertToLocalDateViaMilisecond(aprovacao.dataLimite()).isBefore(date)) {
//                    tarefasAprovacao.add(aprovacao);
//                }
//                if (resolucao != null && resolucao.colaborador() != null && resolucao.colaborador().email().equalsIgnoreCase(userId) && resolucao.estado() == TarefaExecucao.EstadoTarefaResolucao.Atribuida && LocalDateConverter.convertToLocalDateViaMilisecond(resolucao.dataLimite()).isBefore(date)) {
//                    tarefaExecucao.add(resolucao);
//                }
//            } else {
//                if (aprovacao != null && aprovacao.estado() == TarefaAprovacao.EstadoTarefaAprovacao.Atribuida && LocalDateConverter.convertToLocalDateViaMilisecond(aprovacao.dataLimite()).isBefore(date)) {
//                    tarefasAprovacao.add(aprovacao);
//                }
//                if (resolucao != null && resolucao.estado() == TarefaExecucao.EstadoTarefaResolucao.Atribuida && LocalDateConverter.convertToLocalDateViaMilisecond(resolucao.dataLimite()).isBefore(date)) {
//                    tarefaExecucao.add(resolucao);
//                }
//            }
//        }
//        return "" + (tarefaExecucao.size() + tarefasAprovacao.size());
//    }

    private String getTarefasPendentesTerminadas(String userId, Role role) {
        List<TarefaAprovRes> tarefasAprovacao = new ArrayList<>();
        List<TarefaExecRes> tarefaExecucao = new ArrayList<>();
        TarefaExecResRepository tarefaExecRepository = PersistenceContext.repositories().tarefaExecRes();
        TarefaAprovResRepository tarefaAprovResRepository = PersistenceContext.repositories().tarefaAprovRes();

        LocalDate date = java.time.LocalDate.now();
        if (BaseRoles.USER.equals(role)) {
            tarefasAprovacao = tarefaAprovResRepository.getTarefasColaboradorPendentes(userId, TarefaAprovRes.EstadoTarefaAprovacao.Atribuida);
            tarefaExecucao = tarefaExecRepository.getTarefasColaboradorPendentes(userId, TarefaExecRes.EstadoTarefaExecucao.Atribuida);
        } else {
            tarefaExecucao = tarefaExecRepository.getTarefasPendentes();
            tarefasAprovacao = tarefaAprovResRepository.getTarefasPendentes();
        }
        tarefasAprovacao.removeIf(t -> t.dataLimite().isAfter(date));
        tarefaExecucao.removeIf(t -> t.dataLimite().isAfter(date));

        return "" + (tarefaExecucao.size() + tarefasAprovacao.size());
    }

//    private String getTarefasPendentesPorTerminar(String userId, Role role) {
//        ArrayList<TarefaAprovacao> tarefasAprovacao = new ArrayList<>();
//        ArrayList<TarefaExecucao> tarefaExecucao = new ArrayList<>();
//        ServicoRepository servicoRepository = PersistenceContext.repositories().servicos();
//        Iterable<Servico> servicos = servicoRepository.findAll();
//        LocalDate date = java.time.LocalDate.now();
//        for (Servico servico : servicos) {
//            FluxoTarefa fluxoTarefa = servico.fluxoTarefa();
//            TarefaAprovacao aprovacao = fluxoTarefa.tarefaAprovacao();
//            TarefaExecucao resolucao = fluxoTarefa.tarefaExecucao();
//            long duration;
//            if (BaseRoles.USER.equals(role)) {
//                if (aprovacao != null) {
//                    duration = aprovacao.dataLimite().getTime() - new Date(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth()).getTime();
//                    if (aprovacao.colaborador() != null && aprovacao.colaborador().email().equalsIgnoreCase(userId) && duration <= 3600000 && duration > 0) {
//                        tarefasAprovacao.add(aprovacao);
//                    }
//                }
//                if (resolucao != null) {
//                    duration = resolucao.dataLimite().getTime() - new Date(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth()).getTime();
//                    if (resolucao != null && resolucao.colaborador() != null && resolucao.colaborador().email().equalsIgnoreCase(userId) && duration <= 3600000 && duration > 0) {
//                        tarefaExecucao.add(resolucao);
//                    }
//                }
//
//
//            } else {
//                if (aprovacao != null) {
//                    duration = aprovacao.dataLimite().getTime() - new Date(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth()).getTime();
//                    if (duration < 3600000 && duration > 0) {
//                        tarefasAprovacao.add(aprovacao);
//                    }
//                }
//
//                if (resolucao != null) {
//                    duration = resolucao.dataLimite().getTime() - new Date(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth()).getTime();
//                    if (duration <= 3600000 && duration > 0) {
//                        tarefaExecucao.add(resolucao);
//                    }
//                }
//            }
//        }
//        return "" + (tarefaExecucao.size() + tarefasAprovacao.size());
//
//    }

    private String getTarefasPendentesPorTerminar(String userId, Role role) {
        List<TarefaAprovRes> tarefasAprovacao = new ArrayList<>();
        List<TarefaExecRes> tarefaExecucao = new ArrayList<>();

        List<TarefaAprovRes> tarefasAprovacaoCopia = new ArrayList<>();
        List<TarefaExecRes> tarefaExecucaoCopia = new ArrayList<>();
        TarefaExecResRepository tarefaExecRepository = PersistenceContext.repositories().tarefaExecRes();
        TarefaAprovResRepository tarefaAprovResRepository = PersistenceContext.repositories().tarefaAprovRes();
        LocalDate date = java.time.LocalDate.now();
        long hours;
        if (BaseRoles.USER.equals(role)) {
            tarefasAprovacao = tarefaAprovResRepository.getTarefasColaboradorPendentes(userId, TarefaAprovRes.EstadoTarefaAprovacao.Atribuida);
            tarefaExecucao = tarefaExecRepository.getTarefasColaboradorPendentes(userId, TarefaExecRes.EstadoTarefaExecucao.Atribuida);

        } else {
            tarefaExecucao = tarefaExecRepository.getTarefasPendentes();
            tarefasAprovacao = tarefaAprovResRepository.getTarefasPendentes();
        }

        for (TarefaAprovRes t : tarefasAprovacao) {
            Date date1 =new Date(t.dataLimite().getYear(), t.dataLimite().getMonthValue() - 1, t.dataLimite().getDayOfMonth());
            hours = Math.abs( new Date(t.dataLimite().getYear(), t.dataLimite().getMonthValue() - 1, t.dataLimite().getDayOfMonth()).getTime() - new Date(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth()).getTime());
            if((hours<3600000*24)){
                tarefasAprovacaoCopia.add(t);
            }
        }

        for (TarefaExecRes t : tarefaExecucao) {
            hours = Math.abs((int) (new Date(t.dataLimite().getYear(), t.dataLimite().getMonthValue() - 1, t.dataLimite().getDayOfMonth()).getTime() - new Date(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth()).getTime()));
            if((hours<3600000*24)){
                tarefaExecucaoCopia.add(t);
            }
        }

        return "" + (tarefaExecucaoCopia.size() + tarefasAprovacaoCopia.size());

    }

}
