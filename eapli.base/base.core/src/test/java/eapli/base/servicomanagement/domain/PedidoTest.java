package eapli.base.servicomanagement.domain;

import eapli.base.fluxotarefaresolucao.domain.FluxoResolucao;
import eapli.base.fluxotarefaresolucao.domain.TarefaAprovRes;
import eapli.base.fluxotarefaresolucao.domain.TarefaExecRes;
import eapli.base.nivelcriticidademanagement.domain.NivelCriticidade;
import eapli.base.tarefamanagement.domain.TarefaAprovacao;
import eapli.base.tarefamanagement.domain.TarefaExecucao;
import junit.framework.TestCase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static eapli.base.servicomanagement.domain.EstadoPedido.EstadoPedidoEnum.APROVADO;

public class PedidoTest extends TestCase {

    public void testAdicionarFicheiro() {
        NivelCriticidade nivel = new NivelCriticidade(1, "cor","label");
        EmailColaborador email = new EmailColaborador("email");

        NomeServico nome = new NomeServico("Nome");
        CodigoServico codigo = new CodigoServico("codigo");
        List<Keyword> keywords= new ArrayList<>();
        Servico servico = new Servico(nome, codigo, "descSimples","descCompleta", keywords);
        TarefaExecucao tarefaExecucao = new TarefaExecucao();
        TarefaAprovacao tarefaAprovacao = new TarefaAprovacao();

        UrgenciaPedido urg = new UrgenciaPedido("deveras urgente");

        LocalDate ld = LocalDate.of(2021,10, 11);

        DataLimitePedido dataLimite = new DataLimitePedido(ld);

        Pedido ped = new Pedido("id", nivel, email, servico, urg, dataLimite, new FluxoResolucao(new TarefaAprovRes(tarefaAprovacao,LocalDate.of(2021,10, 11)),new TarefaExecRes(tarefaExecucao,LocalDate.of(2021,10, 11))));

        PathFile file = new PathFile("path/files.txt");

        List<PathFile> files = new LinkedList<>();

        assertEquals(files, ped.getPathFiles());

        files.add(file);

        ped.adicionarFicheiro(file);

        assertEquals(files, ped.getPathFiles());
    }

    public void testDefinirFormulario() {
        NivelCriticidade nivel = new NivelCriticidade(1, "cor","label");
        EmailColaborador email = new EmailColaborador("email");

        NomeServico nome = new NomeServico("Nome");
        CodigoServico codigo = new CodigoServico("codigo");
        List<Keyword> keywords= new ArrayList<>();
        Servico servico = new Servico(nome, codigo, "descSimples","descCompleta", keywords);
        TarefaExecucao tarefaExecucao = new TarefaExecucao();
        TarefaAprovacao tarefaAprovacao = new TarefaAprovacao();

        UrgenciaPedido urg = new UrgenciaPedido("deveras urgente");

        LocalDate ld = LocalDate.of(2021,10, 11);

        DataLimitePedido dataLimite = new DataLimitePedido(ld);

        Pedido ped = new Pedido("id", nivel, email, servico, urg, dataLimite, new FluxoResolucao(new TarefaAprovRes(tarefaAprovacao,LocalDate.of(2021,10, 11)),new TarefaExecRes(tarefaExecucao,LocalDate.of(2021,10, 11))));

        NomeFormulario nomeF = new NomeFormulario("nome");

        List<AtributoPreenchido> atributos = new ArrayList<>();

        FormularioP form = new FormularioP(nomeF, atributos);

        assertNull(ped.getFormulario());

        ped.definirFormulario(form);

        assertEquals(ped.getFormulario(), form);
    }

    public void testGuardarDataHoraSolicitacao() {
        NivelCriticidade nivel = new NivelCriticidade(1, "cor","label");
        EmailColaborador email = new EmailColaborador("email");

        NomeServico nome = new NomeServico("Nome");
        CodigoServico codigo = new CodigoServico("codigo");
        List<Keyword> keywords= new ArrayList<>();
        Servico servico = new Servico(nome, codigo, "descSimples","descCompleta", keywords);
        TarefaExecucao tarefaExecucao = new TarefaExecucao();
        TarefaAprovacao tarefaAprovacao = new TarefaAprovacao();

        UrgenciaPedido urg = new UrgenciaPedido("deveras urgente");

        LocalDate ld = LocalDate.of(2021,10, 11);

        DataLimitePedido dataLimite = new DataLimitePedido(ld);

        Pedido ped = new Pedido("id", nivel, email, servico, urg, dataLimite, new FluxoResolucao(new TarefaAprovRes(tarefaAprovacao,LocalDate.of(2021,10, 11)),new TarefaExecRes(tarefaExecucao,LocalDate.of(2021,10, 11))));

        LocalTime lt = LocalTime.of(4, 20);

        LocalDateTime ldt = LocalDateTime.of(ld, lt);

        DataHoraSolicitacao data = new DataHoraSolicitacao(ldt);

        ped.guardarDataHoraSolicitacao(data);

        assertEquals(data, ped.getDataHoraSolicitacao());
    }

    public void testDefinirEstado() {
        NivelCriticidade nivel = new NivelCriticidade(1, "cor","label");
        EmailColaborador email = new EmailColaborador("email");

        NomeServico nome = new NomeServico("Nome");
        CodigoServico codigo = new CodigoServico("codigo");
        List<Keyword> keywords= new ArrayList<>();
        Servico servico = new Servico(nome, codigo, "descSimples","descCompleta", keywords);
        TarefaExecucao tarefaExecucao = new TarefaExecucao();
        TarefaAprovacao tarefaAprovacao = new TarefaAprovacao();

        UrgenciaPedido urg = new UrgenciaPedido("deveras urgente");

        LocalDate ld = LocalDate.of(2021,10, 11);

        DataLimitePedido dataLimite = new DataLimitePedido(ld);

        Pedido ped = new Pedido("id", nivel, email, servico, urg, dataLimite, new FluxoResolucao(new TarefaAprovRes(tarefaAprovacao,LocalDate.of(2021,10, 11)),new TarefaExecRes(tarefaExecucao,LocalDate.of(2021,10, 11))));

        EstadoPedido estado = new EstadoPedido(APROVADO);

        ped.definirEstado(estado);

        assertEquals(ped.getEstadoPedido(), estado);
    }

    public void testServico() {
        NivelCriticidade nivel = new NivelCriticidade(1, "cor","label");
        EmailColaborador email = new EmailColaborador("email");

        NomeServico nome = new NomeServico("Nome");
        CodigoServico codigo = new CodigoServico("codigo");
        List<Keyword> keywords= new ArrayList<>();
        Servico servico = new Servico(nome, codigo, "descSimples","descCompleta", keywords);
        TarefaExecucao tarefaExecucao = new TarefaExecucao();
        TarefaAprovacao tarefaAprovacao = new TarefaAprovacao();

        UrgenciaPedido urg = new UrgenciaPedido("deveras urgente");

        LocalDate ld = LocalDate.of(2021,10, 11);

        DataLimitePedido dataLimite = new DataLimitePedido(ld);

        Pedido ped = new Pedido("id", nivel, email, servico, urg, dataLimite, new FluxoResolucao(new TarefaAprovRes(tarefaAprovacao,LocalDate.of(2021,10, 11)),new TarefaExecRes(tarefaExecucao,LocalDate.of(2021,10, 11))));

        assertEquals(servico, ped.servico());
    }

    public void testEmailColaborador() {
        NivelCriticidade nivel = new NivelCriticidade(1, "cor","label");
        EmailColaborador email = new EmailColaborador("email");

        NomeServico nome = new NomeServico("Nome");
        CodigoServico codigo = new CodigoServico("codigo");
        List<Keyword> keywords= new ArrayList<>();
        Servico servico = new Servico(nome, codigo, "descSimples","descCompleta", keywords);
        TarefaExecucao tarefaExecucao = new TarefaExecucao();
        TarefaAprovacao tarefaAprovacao = new TarefaAprovacao();

        UrgenciaPedido urg = new UrgenciaPedido("deveras urgente");

        LocalDate ld = LocalDate.of(2021,10, 11);

        DataLimitePedido dataLimite = new DataLimitePedido(ld);

        Pedido ped = new Pedido("id", nivel, email, servico, urg, dataLimite, new FluxoResolucao(new TarefaAprovRes(tarefaAprovacao,LocalDate.of(2021,10, 11)),new TarefaExecRes(tarefaExecucao,LocalDate.of(2021,10, 11))));

        assertEquals(ped.emailColaborador(), email);
    }
}