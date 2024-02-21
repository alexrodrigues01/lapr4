package eapli.base.infrastructure.bootstrapers;

import eapli.base.catalogomanagement.application.CriarCatalogoController;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.repositories.CatalogoRepository;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipaManagement.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.nivelcriticidademanagement.application.DefinirNiveisCriticidadeController;
import eapli.base.nivelcriticidademanagement.domain.NivelCriticidade;
import eapli.base.servicomanagement.application.EspecificarServicoController;
import eapli.base.servicomanagement.application.SolicitarServicoController;
import eapli.base.servicomanagement.domain.Formulario;
import eapli.base.servicomanagement.domain.Keyword;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.tarefamanagement.domain.CodigoScript;
import eapli.base.tarefamanagement.domain.Script;
import eapli.framework.actions.Action;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CatalogoBootstrapper implements Action {
    private static final Logger LOGGER = LogManager.getLogger(CatalogoBootstrapper.class);

    private CriarCatalogoController catalogoController;
    private EspecificarServicoController especificarServicoController;
    private DefinirNiveisCriticidadeController definirNiveisCriticidadeController;
    private SolicitarServicoController solicitarServicoController;
    private List<Colaborador> colaboradores = new ArrayList<>();
    private List<Equipa> equipas = new ArrayList<>();
    private List<Servico> servicos = new ArrayList<>();

    @Override
    public boolean execute() {
        /*
           Criar Serviços
         */
        catalogoController = new CriarCatalogoController();

        registarServicoCenario1();
        registarServicoCenario2();
        registarServicoCenario3();
//        ArrayList<Keyword> keywords = new ArrayList<>();
//        registerNovoServico("SRV_1", "Servico1", "Este é o servico1", "Este é o servico1 completo", keywords, 1);
//        registerNovoServico("SRV_2", "Servico2", "Este é o servico2", "Este é o servico2 completo", keywords, 2);
//        registerNovoServico("SRV_3", "Servico3", "Este é o servico3", "Este é o servico3 completo", keywords, 3);
//        registerNovoServico("SRV_4", "Servico4", "Este é o servico4", "Este é o servico4 completo", keywords, 4);
//        registerNovoServico("SRV_5", "Servico5", "Este é o servico5", "Este é o servico5 completo", keywords, 5);
//        registerNovoServico("SRV_6", "Servico6", "Este é o servico6", "Este é o servico6 completo", keywords, 6);
//
//        registerNovoServico2("SRV_7", "Servico7", "Este é o servico7", "Este é o servico7 completo", keywords, 7);
//        registerNovoServico2("SRV_8", "Servico8", "Este é o servico8", "Este é o servico8 completo", keywords, 8);
//        registerNovoServico2("SRV_9", "Servico9", "Este é o servico9", "Este é o servico9 completo", keywords, 9);
//
//        registerNovoServicoCompleto("SRV_10", "Servico10", "Este é o servico10", "Este é o servico10 completo", keywords, 10);
//        registerNovoServicoCompleto2("SRV_11", "Servico11", "Este é o servico11", "Este é o servico11 completo", keywords, 11);


        servicos.addAll(catalogoController.getServicos());
        /* registar niveis criticidade */
        registerNivelCriticidade(1, "Amarelo", "Etiqueta1", 33, 23, 243, 153);
        registerNivelCriticidade(2, "Azul", "Etiqueta2", 31, 21, 241, 151);
        registerNivelCriticidade(3, "Verde", "Etiqueta3", 32, 22, 242, 152);
        registerNivelCriticidade(4, "Azul", "Etiqueta4", 34, 24, 244, 154);
        registerNivelCriticidade(5, "Verde", "Etiqueta5", 35, 25, 245, 155);
        /*
           Criar catalogo
         */
        List<Integer> listaservicos1= new LinkedList<>();
        listaservicos1.add(0);

        List<Integer> listaServicos2= new LinkedList<>();
        listaServicos2.add(1);
        listaServicos2.add(2);

        registerCatalogo("Icon1", "Assuntos Recursos Humanos", "Assuntos referentes a servicos para recursos humanos", "Recursos Humanos", "CAT1", "Todos", 30, 20, 240, 150, listaservicos1);
        registerCatalogo("Icon2", "Departamento de vendas", "Assuntos referentes ao departamento de vendas", "Vendas", "CAT2", "Equipa de Vendas", 31, 21, 241, 151, listaServicos2);


        //=============================================================================
        //pedido Servico 1
        solicitarServicoController = new SolicitarServicoController();
        CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogos();
        Iterable<Catalogo> catalogos = catalogoRepository.findAll();
        List<Catalogo> catalogos1 = new ArrayList<>();
        for (Catalogo catalogo : catalogos) {
            catalogos1.add(catalogo);
        }
        solicitarServicoController.setListaCatalogosColaborador(catalogos1);
        solicitarServicoController.getServicoByCodigoUnico("SRV_1_AUSENCIA");
        solicitarServicoController.setEmailColaborador("email1@email.pt");
        solicitarServicoController.novoPedido("Muito urgente", LocalDate.of(2022, 5, 22), LocalDate.of(2022, 5, 22), LocalDate.of(2022, 5, 22));
        solicitarServicoController.adicionarFicheiro("path");
        Formulario formulario = solicitarServicoController.getFormularioSolicitacao();
        List<String> respostas = new LinkedList<>();
        respostas.add("01/08/2022.05/08/2022");
        respostas.add("Ferias");
        respostas.add("");
        solicitarServicoController.guardarDadosFormularioSolicitacao(respostas);
        solicitarServicoController.registarPedido();


        //=============================================================================
        //pedido Servico 2
        solicitarServicoController = new SolicitarServicoController();

        solicitarServicoController.setListaCatalogosColaborador(catalogos1);
        solicitarServicoController.getServicoByCodigoUnico("SRV_2_DESCONTO");
        solicitarServicoController.setEmailColaborador("email2@email.pt");
        solicitarServicoController.novoPedido("Urgente", LocalDate.of(2022, 5, 22), LocalDate.of(2022, 5, 22), LocalDate.of(2022, 5, 22));
        solicitarServicoController.adicionarFicheiro("path2");
        formulario = solicitarServicoController.getFormularioSolicitacao();
        respostas = new LinkedList<>();
        respostas.add("ctv666");
        respostas.add("Miguel");
        respostas.add("Desconto");
        respostas.add("Unica");
        respostas.add("");
        respostas.add("5");
        respostas.add("Miguel");
        respostas.add("");
        respostas.add("Cliente insatisfeito");
        respostas.add("1191042@isep.ipp.pt");
        solicitarServicoController.guardarDadosFormularioSolicitacao(respostas);
        solicitarServicoController.registarPedido();

        //=============================================================================
        //pedido Servico 3
        solicitarServicoController = new SolicitarServicoController();

        solicitarServicoController.setListaCatalogosColaborador(catalogos1);
        solicitarServicoController.getServicoByCodigoUnico("SRV_3_RESIDENCIA");
        solicitarServicoController.setEmailColaborador("email3@email.pt");
        solicitarServicoController.novoPedido("Nao Urgente", LocalDate.of(2022, 5, 22), null, LocalDate.of(2022, 5, 22));
        solicitarServicoController.adicionarFicheiro("path3");
        formulario = solicitarServicoController.getFormularioSolicitacao();
        respostas = new LinkedList<>();
        respostas.add("4785-049");
        solicitarServicoController.guardarDadosFormularioSolicitacao(respostas);
        solicitarServicoController.registarPedido();


//        // Manual
//        solicitarServicoController = new SolicitarServicoController();
//        solicitarServicoController.setListaCatalogosColaborador(catalogos1);
//        solicitarServicoController.getServicoByCodigoUnico("SRV_10");
//        solicitarServicoController.setEmailColaborador("email1@email.pt");
//        solicitarServicoController.novoPedido("Muito urgente", LocalDate.of(2022, 5, 22), null, LocalDate.of(2022, 5, 22));
//        solicitarServicoController.adicionarFicheiro("path");
//        formulario = solicitarServicoController.getFormularioSolicitacao();
//        respostas = new LinkedList<>();
//        respostas.add("20/11/2021.20/11/2022");
//        solicitarServicoController.guardarDadosFormularioSolicitacao(respostas);
//        solicitarServicoController.registarPedido();
//
//        solicitarServicoController = new SolicitarServicoController();
//        solicitarServicoController.setListaCatalogosColaborador(catalogos1);
//        solicitarServicoController.getServicoByCodigoUnico("SRV_10");
//        solicitarServicoController.setEmailColaborador("email1@email.pt");
//        solicitarServicoController.novoPedido("Muito urgente", LocalDate.of(2022, 5, 22), null, LocalDate.of(2022, 5, 22));
//        solicitarServicoController.adicionarFicheiro("path");
//        formulario = solicitarServicoController.getFormularioSolicitacao();
//        respostas = new LinkedList<>();
//        respostas.add("20/11/2021.20/11/2022");
//        solicitarServicoController.guardarDadosFormularioSolicitacao(respostas);
//        solicitarServicoController.registarPedido();
//
//        solicitarServicoController = new SolicitarServicoController();
//        solicitarServicoController.setListaCatalogosColaborador(catalogos1);
//        solicitarServicoController.getServicoByCodigoUnico("SRV_10");
//        solicitarServicoController.setEmailColaborador("email1@email.pt");
//        solicitarServicoController.novoPedido("Muito urgente", LocalDate.of(2022, 5, 22), null, LocalDate.of(2022, 5, 22));
//        solicitarServicoController.adicionarFicheiro("path");
//        formulario = solicitarServicoController.getFormularioSolicitacao();
//        respostas = new LinkedList<>();
//        respostas.add("20/11/2021.20/11/2022");
//        solicitarServicoController.guardarDadosFormularioSolicitacao(respostas);
//        solicitarServicoController.registarPedido();
//
//        solicitarServicoController = new SolicitarServicoController();
//        solicitarServicoController.setListaCatalogosColaborador(catalogos1);
//        solicitarServicoController.getServicoByCodigoUnico("SRV_10");
//        solicitarServicoController.setEmailColaborador("email1@email.pt");
//        solicitarServicoController.novoPedido("Muito urgente", LocalDate.of(2022, 5, 22), null, LocalDate.of(2022, 5, 22));
//        solicitarServicoController.adicionarFicheiro("path");
//        formulario = solicitarServicoController.getFormularioSolicitacao();
//        respostas = new LinkedList<>();
//        respostas.add("20/11/2021.20/11/2022");
//        solicitarServicoController.guardarDadosFormularioSolicitacao(respostas);
//        solicitarServicoController.registarPedido();
//
//        solicitarServicoController = new SolicitarServicoController();
//        solicitarServicoController.setListaCatalogosColaborador(catalogos1);
//        solicitarServicoController.getServicoByCodigoUnico("SRV_10");
//        solicitarServicoController.setEmailColaborador("email1@email.pt");
//        solicitarServicoController.novoPedido("Muito urgente", LocalDate.of(2022, 5, 22), null, LocalDate.of(2022, 5, 22));
//        solicitarServicoController.adicionarFicheiro("path");
//        formulario = solicitarServicoController.getFormularioSolicitacao();
//        respostas = new LinkedList<>();
//        respostas.add("20/11/2021.20/11/2022");
//        solicitarServicoController.guardarDadosFormularioSolicitacao(respostas);
//        solicitarServicoController.registarPedido();
//
//        solicitarServicoController = new SolicitarServicoController();
//        solicitarServicoController.setListaCatalogosColaborador(catalogos1);
//        solicitarServicoController.getServicoByCodigoUnico("SRV_10");
//        solicitarServicoController.setEmailColaborador("email1@email.pt");
//        solicitarServicoController.novoPedido("Muito urgente", LocalDate.of(2022, 5, 22), null, LocalDate.of(2022, 5, 22));
//        solicitarServicoController.adicionarFicheiro("path");
//        formulario = solicitarServicoController.getFormularioSolicitacao();
//        respostas = new LinkedList<>();
//        respostas.add("20/11/2021.20/11/2022");
//        solicitarServicoController.guardarDadosFormularioSolicitacao(respostas);
//        solicitarServicoController.registarPedido();
//
//        solicitarServicoController = new SolicitarServicoController();
//        solicitarServicoController.setListaCatalogosColaborador(catalogos1);
//        solicitarServicoController.getServicoByCodigoUnico("SRV_10");
//        solicitarServicoController.setEmailColaborador("email1@email.pt");
//        solicitarServicoController.novoPedido("Muito urgente", LocalDate.of(2022, 5, 22), null, LocalDate.of(2022, 5, 22));
//        solicitarServicoController.adicionarFicheiro("path");
//        formulario = solicitarServicoController.getFormularioSolicitacao();
//        respostas = new LinkedList<>();
//        respostas.add("20/11/2021.20/11/2022");
//        solicitarServicoController.guardarDadosFormularioSolicitacao(respostas);
//        solicitarServicoController.registarPedido();


        return true;
    }

    private void registarServicoCenario1() {
        try {
            especificarServicoController = new EspecificarServicoController();

            /**
             * servico
             */

            List<Keyword> keywords = new ArrayList<>();
            keywords.add(new Keyword("Ausencia"));
            keywords.add(new Keyword("Futura"));
           especificarServicoController.novoServico("SRV_1_AUSENCIA", "Pedido de Ausencia Futura", "Pretende-se fazer um pedido de uma ausencia futura",
                    "Pretende-se fazer um pedido de uma ausencia futura indicando o periodo, tipo e a justificação da ausencia", keywords);

            /**
             * formulario de pedido
             */

            especificarServicoController.adicionarAtributo("Periodo de ausencia", "Ausencia", "Datas entre as quais vai estar ausente", "", "Periodo", true);
            List<String> opcoes = new ArrayList<>();
            opcoes.add("Ferias");
            opcoes.add("Justificada");
            opcoes.add("Nao Justificada");
            especificarServicoController.definirOpcoesEscolhaMultipla(opcoes);
            especificarServicoController.adicionarAtributo("Tipo de ausencia", "Tipo de Ausencia", "Tipo da sua Ausencia", "", "Multipla", true);
            especificarServicoController.adicionarAtributo("Justificacao", "Justificacao", "Justiifique, se necessário, a sua ausencia", "", "String", false);

            especificarServicoController.definirFormulario("FORM_AUSENCIA_PEDIDO", "Formulario de Pedido de Ausencia");

            /**
             * formulario tarefa aprovacao
             */

            Date deadline = null;
            try {
                deadline = new SimpleDateFormat("dd/MM/yyyy").parse("30/06/2021");
            } catch (ParseException e) {
                System.out.println("deadline falhou");
            }

            especificarServicoController.adicionarAtributoAprovacao("Decisao", "Decisao", "Decisao sobre o periodo de ausencia",
                    "", "String", true);
            especificarServicoController.adicionarAtributoAprovacao("Fundamentacao", "Fundamento", "Texto sobre a fundamentacao da decisao",
                    "", "String", true);
            especificarServicoController.criarTarefaAprovacao("Formulario de Aprovação do Pedido de Ausencia", "FORM_AUSENCIA_APROVACAO", false);

            /**
             * formulario tarefa resolucao
             */

            List<Equipa> equipas = especificarServicoController.equipas();
            especificarServicoController.selecionarEquipa(1);

            especificarServicoController.adicionarAtributoResolucao("Dias de ferias ja gozados no ano", "Ferias", "Dias de ferias ja gozados no ano",
                    "", "Soma", true);
            especificarServicoController.adicionarAtributoResolucao("Dias de ferias ja gozados no periodo", "Ferias", "Dias de ferias ja gozados no periodo",
                    "", "Soma", true);
            especificarServicoController.adicionarAtributoResolucao("Dias de ferias totais", "Ferias", "Dias de ferias totais",
                    "", "Igual", true);

            especificarServicoController.adicionarAtributoResolucao("Dias de falta justificada ja gozados no ano", "Faltas Justificadas", "Dias de falta justificada ja gozados no ano",
                    "", "Soma", true);
            especificarServicoController.adicionarAtributoResolucao("Dias de falta justificada ja gozados no periodo", "Faltas Justificadas", "Dias de falta justificada ja gozados no periodo",
                    "", "Soma", true);
            especificarServicoController.adicionarAtributoResolucao("Dias de falta justificada totais", "Faltas Justificadas", "Dias de falta justificada totais",
                    "", "Igual", true);

            especificarServicoController.adicionarAtributoResolucao("Dias de falta nao justificada ja gozados no ano", "Faltas nao Justificadas", "Dias de falta nao justificada ja gozados no ano",
                    "", "Soma", true);
            especificarServicoController.adicionarAtributoResolucao("Dias de falta nao justificada ja gozados no periodo", "Faltas nao Justificadas", "Dias de falta nao justificada ja gozados no periodo",
                    "", "Soma", true);
            especificarServicoController.adicionarAtributoResolucao("Dias de falta nao justificada totais", "Faltas nao Justificadas", "Dias de falta nao justificada totais",
                    "", "Igual", true);

            especificarServicoController.criarTarefaResolucao(true, "Formulario de Resolucao do Pedido de Ausencia", "FORM_AUSENCIA_RESOLUCAO",  null);

            /**
             * registar o servico
             */

            especificarServicoController.criarFluxoTarefa();

            especificarServicoController.publicarServico();
            especificarServicoController.registarServico();

            LOGGER.info("Serviço 1");

        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", "Serviço 1");
            LOGGER.trace("Assuming existing record", e);
        }
    }

    private void registarServicoCenario2() {
        try {
            especificarServicoController = new EspecificarServicoController();

            /**
             * servico
             */

            List<Keyword> keywords = new ArrayList<>();
            keywords.add(new Keyword("Autorizacao"));
            keywords.add(new Keyword("Desconto"));
            servicos.add(especificarServicoController.novoServico("SRV_2_DESCONTO", "Autorizacao para Aplicacao Desconto", "Pretende-se autorizar a aplicacao de um desconto",
                    "Pretende-se autorizar a aplicacao de um desconto indicando o codigo interno e nome do cliente, tipo de desconto, a recorrencia, a percentagem / valor de desconto, a identificacao de fatura / data limite e a fundamentacao do pedido", keywords));

            /**
             * formulario de pedido
             */

            especificarServicoController.adicionarAtributo("Codigo de Cliente", "Codigo Cliente", "Codigo do Cliente", "[bcdfghjklmnpqrstvxyz]{3}[0-9]{3}", "String", true);
            especificarServicoController.adicionarAtributo("Nome Interno de Cliente", "Nome Cliente", "Nome do Cliente", "", "String", true);
            especificarServicoController.adicionarAtributo("Tipo de Desconto", "Tipo Desconto", "Tipo de Desconto a aplicar", "", "String", true);
            List<String> opcoes = new ArrayList<>();
            opcoes.add("Unica");
            opcoes.add("Ate Data Limite");
            especificarServicoController.definirOpcoesEscolhaMultipla(opcoes);
            especificarServicoController.adicionarAtributo("Recorrencia", "Recorrencia", "Recorrencia da aplicacao do desconto", "", "Multipla", true);
            especificarServicoController.adicionarAtributo("Percentagem de Desconto", "Percentagem Desconto", "Percentagem de Desconto a aplicar", "", "InteiroUnico", false);
            especificarServicoController.adicionarAtributo("Valor de Desconto", "Valor Desconto", "Valor de Desconto a aplicar", "", "InteiroUnico", false);
            especificarServicoController.adicionarAtributo("Identificacao de Fatura", "Identificacao de Fatura", "Identificacao de Fatura", "", "String", false);
            especificarServicoController.adicionarAtributo("Data Limite", "Data Limite", "Data Limite para aplicar o desconto", "", "Data", false);
            especificarServicoController.adicionarAtributo("Fundamentacao do pedido", "Fundamentacao", "Fundamentacao do pedido", "", "String", true);
            especificarServicoController.adicionarAtributo("Email","Email","Email a enviar","","String",true);

            especificarServicoController.definirFormulario("FORM_APLICARDESCONTO_PEDIDO", "Formulario de Autorizacao de Aplicacao de Desconto");

            /**
             * formulario tarefa aprovacao
             */

            Date deadline = null;
            try {
                deadline = new SimpleDateFormat("dd/MM/yyyy").parse("30/06/2021");
            } catch (ParseException e) {
                System.out.println("deadline falhou");
            }

            especificarServicoController.adicionarAtributoAprovacao("Decisao sobre desconto", "Decisao", "Decisao sobre a autorizacao do desconto",
                    "", "String", true);
            especificarServicoController.adicionarAtributoAprovacao("Fundamentacao da autorizacao", "Fundamento", "Texto sobre a fundamentacao da autorizacao",
                    "", "String", true);
            especificarServicoController.adicionarAtributoAprovacao("Percentagem de Desconto", "Percentagem Desconto", "Percentagem de Desconto a aplicar", "", "InteiroUnico", false);
            especificarServicoController.adicionarAtributoAprovacao("Valor de Desconto", "Valor Desconto", "Valor de Desconto a aplicar", "", "InteiroUnico", false);
            especificarServicoController.adicionarAtributoAprovacao("Data Limite", "Data Limite", "Data Limite para aplicar o desconto", "", "Data", false);

            especificarServicoController.criarTarefaAprovacao("Formulario de Aprovacao da Autorizacao", "FORM_AUTORIZACAO_APROVACAO", false);

            /**
             * tarefa resolucao
             */


            //NAO PODE SER NULL O SCRIPT
            especificarServicoController.criarTarefaResolucao(false, null, null, new Script(new CodigoScript( "-REMETENTE \"lapr4g3@gmail.com\" \n" +
                    "                -PASSWORD \"pessego2001\" \n" +
                    "                -ASSUNTO \"Desconto aplicado\" \n" +
                    "                -CORPO \"Boa tarde, o seu desconto sera de ~~(P_6) \" \n" +
                    "                -DESTINATARIO P_10")));

            /**
             * registar o servico
             */

            especificarServicoController.criarFluxoTarefa();

            especificarServicoController.publicarServico();
            especificarServicoController.registarServico();

            LOGGER.info("Serviço 2");

        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", "Serviço 2");
            LOGGER.trace("Assuming existing record", e);
        }
    }

    private void registarServicoCenario3() {
        try {
            especificarServicoController = new EspecificarServicoController();

            /**
             * servico
             */

            List<Keyword> keywords = new ArrayList<>();
            keywords.add(new Keyword("Comunicacao"));
            keywords.add(new Keyword("Residencia"));
            servicos.add(especificarServicoController.novoServico("SRV_3_RESIDENCIA", "Comunicacao da alteracao de morada", "Pretende-se comunicar a alteracao de morada",
                    "Pretende-se comunicar a alteracao de morada indicando a nova morada", keywords));

            /**
             * formulario de pedido
             */


            especificarServicoController.adicionarAtributo("Codigo Postal", "Codigo Postal", "Codigo Postal da nova morada", "[0-9]{4}-[0-9]{3}", "String", true);

            especificarServicoController.definirFormulario("FORM_MORADA_PEDIDO", "Formulario de Comunicacao de Alteracao de Morada");

            /**
             * formulario tarefa aprovacao
             */

            //nao existe tarefa de aprovacao

            /**
             * formulario tarefa resolucao
             */

            Date deadline = null;
            try {
                deadline = new SimpleDateFormat("dd/MM/yyyy").parse("30/06/2021");
            } catch (ParseException e) {
                System.out.println("deadline falhou");
            }

            //tem que ser a equipa de recursos humanos

            List<Equipa> equipas = especificarServicoController.equipas();
            especificarServicoController.selecionarEquipa(1);

            especificarServicoController.adicionarAtributoResolucao("Observacoes", "Observacoes", "Observacoes sobre a comunicacao de alteracao de morada", "", "String", true);

            especificarServicoController.criarTarefaResolucao(true, "Formulario de Resolucao da Alteracao de Morada", "FORM_MORADA_RESOLUCAO", null);

            especificarServicoController.criarFluxoTarefa();

            /**
             * registar o servico
             */

            especificarServicoController.publicarServico();
            especificarServicoController.registarServico();

            LOGGER.info("Serviço 3");

        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", "Serviço 3");
            LOGGER.trace("Assuming existing record", e);
        }
    }

    private void registerNovoServico(String codigo, String titulo, String desc, String descC, ArrayList<Keyword> keywords, int i) {
        try {
            especificarServicoController = new EspecificarServicoController();
            keywords = new ArrayList<>();
            keywords.add(new Keyword(titulo));
            servicos.add(especificarServicoController.novoServico(codigo, titulo, desc, descC, keywords));
            List<String> opcoes = new ArrayList<>();
            opcoes.add("1191042@isep.ipp.pt");
            opcoes.add("konur");
            especificarServicoController.definirOpcoesEscolhaMultipla(opcoes);
            especificarServicoController.adicionarAtributo("Nome" + i, "label" + i, "descricao" + i, "", "Multipla", true);
            especificarServicoController.definirFormulario("codigo" + i, "Formulario" + i);
            List<Equipa> equipas = especificarServicoController.equipas();
            especificarServicoController.selecionarEquipa(1);
            especificarServicoController.criarTarefaResolucao(false, "nomef" + i, "codigof" + i,  new Script(new CodigoScript("-REMETENTE \"lapr4g3@gmail.com\" \n" +
                    "                -PASSWORD \"pessego2001\" \n" +
                    "                -ASSUNTO \"Assuntooo\" \n" +
                    "                -CORPO  \" Boa tarde, o seu pedido esta a ser executado \" \n" +
                    "                -DESTINATARIO P_1")));
            especificarServicoController.criarFluxoTarefa();
            especificarServicoController.publicarServico();
            especificarServicoController.registarServico();
            LOGGER.info(codigo);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", codigo);
            LOGGER.trace("Assuming existing record", e);
        }
    }

    private void registerNovoServico2(String codigo, String titulo, String desc, String descC, ArrayList<Keyword> keywords, int i) {
        try {
            especificarServicoController = new EspecificarServicoController();
            keywords = new ArrayList<>();
            keywords.add(new Keyword(titulo));
            servicos.add(especificarServicoController.novoServico(codigo, titulo, desc, descC, keywords));
            especificarServicoController.adicionarAtributo("Nome" + i, "label" + i, "descricao" + i, "", "Periodo", true);
            especificarServicoController.definirFormulario("codigo" + i, "Formulario" + i);
            List<Equipa> equipas = especificarServicoController.equipas();
            especificarServicoController.selecionarEquipa(1);
            especificarServicoController.adicionarAtributoResolucao("NomeTrf" + i, "labelTrf" + i, "descricaoTrf" + i, "expressaoRegularTrf" + i, "String", true);
            especificarServicoController.criarTarefaResolucao(true, "nomef" + i, "codigof" + i,  null);
            especificarServicoController.criarFluxoTarefa();
            especificarServicoController.publicarServico();
            especificarServicoController.registarServico();
            LOGGER.info(codigo);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", codigo);
            LOGGER.trace("Assuming existing record", e);
        }
    }

    private void registerNovoServicoCompleto(String codigo, String titulo, String desc, String descC, ArrayList<Keyword> keywords, int i) {
        try {
            especificarServicoController = new EspecificarServicoController();
            keywords = new ArrayList<>();
            keywords.add(new Keyword(titulo));
            servicos.add(especificarServicoController.novoServico(codigo, titulo, desc, descC, keywords));
            especificarServicoController.adicionarAtributo("Nome" + i, "label" + i, "descricao" + i, "", "Periodo", true);
            especificarServicoController.definirFormulario("codigo" + i, "Formulario" + i);
            List<Equipa> equipas = especificarServicoController.equipas();
            especificarServicoController.selecionarEquipa(1);
            especificarServicoController.adicionarAtributoResolucao("NomeTrf" + i, "labelTrf" + i, "descricaoTrf" + i, "expressaoRegularTrf" + i, "String", true);
            especificarServicoController.criarTarefaResolucao(true, "nomef" + i, "codigof" + i,  null);
            especificarServicoController.criarTarefaAprovacao("Apr.nome" + i, "Apr.codigof" + i,  false);
            especificarServicoController.criarFluxoTarefa();
            especificarServicoController.publicarServico();
            especificarServicoController.registarServico();
            LOGGER.info(codigo);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", codigo);
            LOGGER.trace("Assuming existing record", e);
        }
    }

    private void registerNovoServicoCompleto2(String codigo, String titulo, String desc, String descC, ArrayList<Keyword> keywords, int i) {
        try {
            especificarServicoController = new EspecificarServicoController();
            keywords = new ArrayList<>();
            keywords.add(new Keyword(titulo));
            servicos.add(especificarServicoController.novoServico(codigo, titulo, desc, descC, keywords));
            especificarServicoController.adicionarAtributo("Nome" + i, "label" + i, "descricao" + i, "", "Periodo", true);
            especificarServicoController.definirFormulario("codigo" + i, "Formulario" + i);
            List<Equipa> equipas = especificarServicoController.equipas();
            especificarServicoController.selecionarEquipa(1);
            especificarServicoController.adicionarAtributoResolucao("NomeTrf" + i, "labelTrf" + i, "descricaoTrf" + i, "expressaoRegularTrf" + i, "String", true);
            especificarServicoController.criarTarefaResolucao(true, "nomef" + i, "codigof" + i,  null);
            especificarServicoController.criarTarefaAprovacao("Apr.nome" + i, "Apr.codigof" + i, true);
            especificarServicoController.criarFluxoTarefa();
            especificarServicoController.publicarServico();
            especificarServicoController.registarServico();
            LOGGER.info(codigo);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", codigo);
            LOGGER.trace("Assuming existing record", e);
        }
    }

    private void registerCatalogo(String icon, String desc, String descC, String titulo, String identificador, String criterioAcesso, int tempAMedio, int tempAMax, int tempRMax, int tempRMedio, List<Integer> listaServicos) {
        try {
            catalogoController = new CriarCatalogoController();

            catalogoController.novoCatalogo(icon, descC, desc, titulo, identificador, criterioAcesso);
            List<List<Double>> objetivos = new LinkedList<>();
            List<Double> objetivos1 = new LinkedList<>();
            objetivos1.add(2.0);
            objetivos1.add(2.0);
            objetivos1.add(2.0);
            objetivos1.add(2.0);
            objetivos.add(objetivos1);
            catalogoController.definirContratoSLA(desc, 1, "Vermelho", "Etiqueta", objetivos);
            catalogoController.adicionarObjetivo(tempAMax, tempAMedio, tempRMax, tempRMedio);

            int randomNum = ThreadLocalRandom.current().nextInt(0, servicos.size());
            catalogoController.getColaboradores();
            catalogoController.adicionarColaborador("email1@email.pt");

            catalogoController.getEquipas();
            catalogoController.adicionarEquipa("123");

            catalogoController.getServicos();
            for(Integer serv: listaServicos){
                catalogoController.adicionarServico(servicos.get(serv).codigo());
            }

            catalogoController.registarCatalogo();

            LOGGER.info(titulo);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", titulo);
            LOGGER.trace("Assuming existing record", e);
        }
    }

    public void registerNivelCriticidade(int i, String cor, String label, int tempAMedio, int tempAMax, int tempRMax, int tempRMedio) {
        definirNiveisCriticidadeController = new DefinirNiveisCriticidadeController();

        NivelCriticidade n = definirNiveisCriticidadeController.novoNivel(i, cor, label);
        definirNiveisCriticidadeController.definirObjetivo2(n, tempAMax, tempAMedio, tempRMax, tempRMedio);
        definirNiveisCriticidadeController.registarNiveisEObjetivos();
    }
}
