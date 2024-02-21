package eapli.base.app.backoffice.console.presentation.servico;

import eapli.base.equipaManagement.domain.Equipa;
import eapli.base.servicomanagement.application.RetomarServicoController;
import eapli.base.servicomanagement.domain.Atributo;
import eapli.base.servicomanagement.domain.Keyword;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.tarefamanagement.domain.CodigoScript;
import eapli.base.tarefamanagement.domain.Script;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class RetomarServicoUI extends AbstractUI {
    @Override
    protected boolean doShow() {
        RetomarServicoController controller = new RetomarServicoController();

        List<Servico> lista = controller.getServicosPorPublicar();
        for(Servico servico : lista){
            System.out.println(servico.toString());
        }

        String codigo = Console.readLine("Introduza o codigo do servico que pretende alterar:");

        while(true){
            if(controller.servicoByCodigo(codigo) == null){
                codigo = Console.readLine("Não existe serviço com esse código! Introduza o código do serviço que pretende alterar:");
            }else{
                break;
            }
        }

        System.out.println("\nInicio da alteração do serviço com código " + codigo +"\n");

        codigo = Console.readLine("Novo código de serviço (ENTER para não alterar):");

        while(true){
            if(codigo.isBlank()){
                break;
            }

            if(controller.validarCodigo(codigo)){
                break;
            }else{
                codigo = Console.readLine("Já existe um serviço com esse código. Novo código de serviço (ENTER para não alterar):");
            }
        }

        String nome = Console.readLine("Novo nome de serviço (ENTER para não alterar):");

        while(true){
            if(nome.isBlank()){
                break;
            }

            if(controller.validarNome(nome)){
                break;
            }else{
                nome = Console.readLine("Já existe um serviço com esse nome. Novo nome de serviço (ENTER para não alterar):");
            }
        }

        String descSimples = Console.readLine("Nova descrição simples de serviço: (ENTER para não alterar)");

        String descCompleta = Console.readLine("Nova descrição completa de serviço: (ENTER para não alterar)");

        List<Keyword> keywords = controller.keywords();
        for(Keyword key : keywords){
            System.out.println(key.toString());
        }

        System.out.println();

        String keyword = Console.readLine("Escolha keyword para remover: (ENTER para não alterar)");

        while (!keyword.isBlank()) {
            controller.removerKeyword(keyword);
            keyword = Console.readLine("Escolha keyword para remover: (ENTER para não alterar)");
        }

        keyword = Console.readLine("Introduza keyword para adicionar: (ENTER para não alterar)");

        while (!keyword.isBlank()) {
            controller.adicionarKeyword(keyword);
            keyword = Console.readLine("Escolha keyword para adicionar: (ENTER para não alterar)");
        }

        controller.alterarDadosPrincipaisServico(codigo, nome, descSimples, descCompleta);

        System.out.println("== Formulário ==");

        System.out.println(controller.formulario().toString());

        codigo = Console.readLine("Novo código de formulário (ENTER para não alterar):");

        while(true){
            if(codigo.isBlank()){
                break;
            }

            if(controller.validarCodigoFormulario(codigo)){
                controller.definirCodigoFormulario(codigo);
                break;
            }else{
                codigo = Console.readLine("Já existe um formulário com esse código. Novo código de catálogo (ENTER para não alterar):");
            }
        }

        nome = Console.readLine("Novo nome de formulário (ENTER para não alterar):");

        while(true){
            if(nome.isBlank()){
                break;
            }

            if(controller.validarNomeFormulario(nome)){
                controller.definirNomeFormulario(nome);
                break;
            }else{
                nome = Console.readLine("Já existe um formulário com esse nome. Novo nome de formulário (ENTER para não alterar):");
            }
        }

        System.out.println();
        List<Atributo> atributos = controller.atributosFormulario();

        for(Atributo a : atributos){
            System.out.println(a.toString());
        }

        System.out.println();

        String nomeAtributo = Console.readLine("Introduza nome do atributo a remover: (ENTER para não alterar):");

        while (!nomeAtributo.isBlank()) {
            if(!controller.removerAtributo(nomeAtributo)){
                System.out.println("Não existe atributo com esse nome. Tente outra vez.");
            }
            nomeAtributo = Console.readLine("Introduza nome do atributo a remover: (ENTER para não alterar)");
        }

        int help;

        do{
            System.out.println("Quer adicionar atributos?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            help = Console.readInteger("Selecione uma opção:");
        }while(help != 1 && help!=2);

        if(help == 1){
            while(true) {
                nomeAtributo = Console.readLine("Nome (deixe em branco em qualquer momento para parar de inserir):");

                if (nomeAtributo.isBlank()) {
                    break;
                }

                String label = Console.readLine("Label (deixe em branco em qualquer momento para parar de inserir):");

                if (label.isBlank()) {
                    break;
                }

                String descricao = Console.readLine("Descrição (deixe em branco em qualquer momento para parar de inserir):");

                if (descricao.isBlank()) {
                    break;
                }

                String expressaoRegular = Console.readLine("Expressão Regular (deixe em branco em qualquer momento para parar de inserir):");

                if (expressaoRegular.isBlank()) {
                    break;
                }

                System.out.println("Introduza o Tipo de Dados do atributo (deixe em branco em qualquer momento para parar de inserir):");
                System.out.println("1 - Inteiro");
                System.out.println("2 - String");
                System.out.println("3 - Boolean");
                System.out.println("4 - Data");
                System.out.println("5 - Ficheiro");
                System.out.println("6 - Enum");

                String option = Console.readLine("Selecione uma opção:");

                String tipoDados = "";

                switch (option) {
                    case "1":
                        tipoDados = "Inteiro";
                        break;
                    case "2":
                        tipoDados = "String";
                        break;
                    case "3":
                        tipoDados = "Boolean";
                        break;
                    case "4":
                        tipoDados = "Data";
                        break;
                    case "5":
                        tipoDados = "Ficheiro";
                        break;
                    case "6":
                        tipoDados = "Enum";
                        break;
                    default:
                        System.out.println("Opção inválida");
                }

                if (tipoDados.isBlank()) {
                    break;
                }

                controller.adicionarAtributo(nomeAtributo, label, descricao, expressaoRegular, tipoDados, true);
            }
        }

        System.out.println("\n=== Fluxo Tarefas ===\n");

        System.out.println("Equipas da tarefa:");
        Set<Equipa> equipas = controller.equipasFluxo();

        int index = 0;

        for(Equipa e : equipas){
            index++;
            System.out.println("EQUIPA #" + index + " | " + e.toString());
        }

        System.out.println();

//        index = Console.readInteger("Selecione uma equipa para remover (0 se não quiser remover):");
//
//        while(!controller.removerEquipa(index)){
//            index = Console.readInteger("Index inválido. Selecione uma equipa:");
//        }

        System.out.println("Equipas do sistema:");
        List<Equipa> equipas1 = controller.equipas();

        index = 0;

        for(Equipa e : equipas1){
            index++;
            System.out.println("EQUIPA #" + index + " | " + e.toString());
        }

        System.out.println();

        index = Console.readInteger("Selecione uma equipa:");

        while(!controller.adicionarEquipa(index)){
            index = Console.readInteger("Index inválido. Selecione uma equipa:");
        }

        int a;

        do{
            System.out.println("Quer remover a Tarefa de Aprovação do Fluxo?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            a = Console.readInteger("Selecione uma opção:");
        }while(a != 1 && a!=2);

        if(a == 1){
            controller.removerTarefaAprovacao();

            do{
                System.out.println("Quer adicionar Tarefa de Aprovação ao Fluxo?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");

                a = Console.readInteger("Selecione uma opção:");
            }while(a != 1 && a!=2);

            if(a == 1){
                System.out.println("Ainda não disponivel!");
                //ainda por fazer
                controller.criarTarefaAprovacao();
            }
        }

        System.out.println();

        do{
            System.out.println("Quer alterar a Tarefa de Resolução do Fluxo?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            a = Console.readInteger("Selecione uma opção:");
        }while(a != 1 && a!=2);

        if(a == 1){
            int b;

            do{
                System.out.println("Que tipo de Tarefa de Resolução quer adicionar ao Fluxo?");
                System.out.println("1 - Manual");
                System.out.println("2 - Automática");

                b = Console.readInteger("Selecione uma opção:");
            }while(b != 1 && b!=2);

            if(b == 1){
                System.out.println("Formulário");

                String codigoUnico;

                while(true){
                    codigoUnico = Console.readLine("Código Único Formulário (obrigatório):");

                    if(!codigoUnico.isBlank()){
                        break;
                    }else{
                        System.out.println("Este campo é obrigatório. Por favor introduza um código válido.");
                    }
                }

                String nomeFormulario;

                while(true){
                    nomeFormulario = Console.readLine("Nome Formulário (obrigatório):");
                    if(!nomeFormulario.isBlank()){
                        break;
                    }else{
                        System.out.println("Este campo é obrigatório. Por favor introduza um nome válido.");
                    }
                }

                while(true) {
                    nomeAtributo = Console.readLine("Nome (deixe em branco em qualquer momento para parar de inserir):");

                    if (nomeAtributo.isBlank()) {
                        break;
                    }

                    String label = Console.readLine("Label (deixe em branco em qualquer momento para parar de inserir):");

                    if (label.isBlank()) {
                        break;
                    }

                    String descricao = Console.readLine("Descrição (deixe em branco em qualquer momento para parar de inserir):");

                    if (descricao.isBlank()) {
                        break;
                    }

                    String expressaoRegular = Console.readLine("Expressão Regular (deixe em branco em qualquer momento para parar de inserir):");

                    if (expressaoRegular.isBlank()) {
                        break;
                    }

                    System.out.println("Introduza o Tipo de Dados do atributo (deixe em branco em qualquer momento para parar de inserir):");
                    System.out.println("1 - Inteiro");
                    System.out.println("2 - String");
                    System.out.println("3 - Boolean");
                    System.out.println("4 - Data");
                    System.out.println("5 - Ficheiro");
                    System.out.println("6 - Enum");

                    String option = Console.readLine("Selecione uma opção:");

                    String tipoDados = "";

                    switch (option) {
                        case "1":
                            tipoDados = "Inteiro";
                            break;
                        case "2":
                            tipoDados = "String";
                            break;
                        case "3":
                            tipoDados = "Boolean";
                            break;
                        case "4":
                            tipoDados = "Data";
                            break;
                        case "5":
                            tipoDados = "Ficheiro";
                            break;
                        case "6":
                            tipoDados = "Enum";
                            break;
                        default:
                            System.out.println("Opção inválida");
                    }

                    if (tipoDados.isBlank()) {
                        break;
                    }

                    controller.adicionarAtributoFormularioTarefaResolucao(nomeAtributo, label, descricao, expressaoRegular, tipoDados, true);
                }

                Date data = Console.readDate("Introduza uma deadline (yyyy/MM/dd):");

                controller.criarTarefaResolucao(true, nomeFormulario, codigoUnico, data, null);

            }

            if(b == 2){
                System.out.println("Por enquanto o unico script disponivel no sistema é o ScriptExemplo. Futuramente mais Scripts estarão disponiveis.");

                Script script = new Script(new CodigoScript("exemplox"));

                Date data = Console.readDate("Introduza uma deadline (yyyy/MM/dd):");

                controller.criarTarefaResolucao(false, null, null, data, script);
            }

        }

        int x;

        do{
            System.out.println("Deseja publicar o serviço?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");

            x = Console.readInteger("Selecione uma opção:");
        }while(x != 1 && x!=2);


        if(x == 1){
            if(controller.publicarServico()){
                System.out.println("Serviço pronto a publicar.");
            }else{
                System.out.println("Ainda não é possível publicar o serviço pois a especificação do serviço ainda não está completa. Complete mais tarde.");
            }
        }

        int y;

        do{
            System.out.println("Deseja guardar o serviço na base de dados?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");

            y = Console.readInteger("Selecione uma opção:");
        }while(y != 1 && y!=2);

        if(y == 1){
//            controller.apagarServico();
            controller.registarServico();
        }

        return true;
    }

    @Override
    public String headline(){
        return "Escolha um serviço para continuar / alterar a sua especificação:";
    }
}
