package eapli.base.app.backoffice.console.presentation.catalogo;

import eapli.base.catalogomanagement.application.CriarCatalogoController;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipaManagement.domain.Equipa;
import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.presentation.console.AbstractUI;

import eapli.framework.io.util.Console;

import java.util.LinkedList;
import java.util.List;

public class CriarCatalogoUI extends AbstractUI {

    public CriarCatalogoUI(){

    }

    @Override
    protected boolean doShow() {
        CriarCatalogoController criarCatalogoController=new CriarCatalogoController();
        final String iconeCatalogo= Console.readLine("Icone Catalogo");
        final String descricaoCompleta= Console.readLine("Descricao Completa");
        final String descricaoSimples= Console.readLine("Descricao Simples");
        final String titulo= Console.readLine("Titulo");
        final String identificadorUnico= Console.readLine("Identificador Unico");
        final String criterioAcesso= Console.readLine("Criterio acesso");
        criarCatalogoController.novoCatalogo(iconeCatalogo,descricaoCompleta,descricaoSimples,titulo,identificadorUnico,criterioAcesso);
        List<Servico> listaServicos=criarCatalogoController.getServicos();
        for(Servico s: listaServicos){
            System.out.println(s);
        }
        System.out.println("Adicionar Servicos");
        String opcao="1";
        while(opcao.equalsIgnoreCase("1")) {
            opcao="0";
            String codigoUnico = Console.readLine("Insira o codigo unico do servico que pretende adicionar");
            criarCatalogoController.adicionarServico(codigoUnico);
            opcao=Console.readLine("Deseja inserir mais serviços? (1-Sim, 0-Nao)");
        }

        System.out.println("Definir Contrato Sla");

        String descricaoSla= Console.readLine("Introduza a descricao do Contrato SLA: \n");
        int escalaNumerica=Console.readInteger("Introduza a escala numerica do nivel de criticidade: \n");
        String cor= Console.readLine("Introduza a cor do nível de criticidade : \n");
        String etiqueta= Console.readLine("Insira a etiqueta do nível de criticidade: \n");
        System.out.println("Dados dos objetivos");
        List<List<Double>> dadosObjetivos= new LinkedList<>();
        String opcao8="1";

        while(opcao8.equalsIgnoreCase("1")) {
            List<Double> objetivo= new LinkedList<>();
            opcao8="0";
            double tempoMaximoAprovacao=Console.readDouble("Tempo maximo Aprovacao");
            double tempoMedioAprovacao=Console.readDouble("Tempo medio aprovacao");
            double tempoMaximoResolucao=Console.readDouble("Tempo maximo resolucao");
            double tempoMedioResolucao=Console.readDouble("Tempo medio resolucao");
            objetivo.add(tempoMaximoAprovacao);
            objetivo.add(tempoMedioAprovacao);
            objetivo.add(tempoMaximoResolucao);
            objetivo.add(tempoMedioResolucao);
            dadosObjetivos.add(objetivo);
            opcao8=Console.readLine("Deseja inserir mais objetivos ao nivel de criticidade? (1-Sim, 0-Nao)");
        }
        criarCatalogoController.definirContratoSLA(descricaoSla,escalaNumerica,cor,etiqueta,dadosObjetivos);

        System.out.println("Adicionar Objetivos");
        String opcao2="1";
        while(opcao2.equalsIgnoreCase("1")){
            opcao2="0";
            double tempoMaximoAprovacao=Console.readDouble("Tempo maximo Aprovacao");
            double tempoMedioAprovacao=Console.readDouble("Tempo medio aprovacao");
            double tempoMaximoResolucao=Console.readDouble("Tempo maximo resolucao");
            double tempoMedioResolucao=Console.readDouble("Tempo medio resolucao");
            criarCatalogoController.adicionarObjetivo(tempoMaximoAprovacao,tempoMedioAprovacao,tempoMaximoResolucao,tempoMedioResolucao);
            opcao2=Console.readLine("Deseja inserir mais objetivos? (1-Sim, 0-Nao)");
        }

        List<Colaborador> listaColaboradores= criarCatalogoController.getColaboradores();

        for(Colaborador colaborador: listaColaboradores){
            System.out.println(colaborador);
        }
        String emailColaborador=Console.readLine("Insira o email do colaborador que pretende selecionar como responsavel do catalogo");
        criarCatalogoController.adicionarColaborador(emailColaborador);

        List<Equipa> listaEquipas= criarCatalogoController.getEquipas();

        for(Equipa equipa: listaEquipas){
            System.out.println(equipa);
        }
        String opcao3="1";
        while (opcao3.equalsIgnoreCase("1")){
            opcao3="0";
            String identificadorUnicoEquipa=Console.readLine("Insira o identificador unico da equipa que pretende adicionar ao catalogo");
            criarCatalogoController.adicionarEquipa(identificadorUnicoEquipa);
            opcao3=Console.readLine("Deseja inserir mais equipas? (1-Sim, 0-Nao)");
        }
        Catalogo catalogo= criarCatalogoController.getCatalogo();

        System.out.println("Catálogo criado:");
        System.out.println();
        System.out.println(catalogo);
        String confirmacao=Console.readLine ("Prentende registar este catalogo? (1-Sim, 0-Nao");
        if(confirmacao.equalsIgnoreCase("1")){
            criarCatalogoController.registarCatalogo();
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String headline() {
        return "+= Criar Catálogo ===============";
    }
}
