package eapli.base.app.backoffice.console.presentation.pedido;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.servicomanagement.application.SolicitarServicoController;
import eapli.base.servicomanagement.domain.Atributo;
import eapli.base.servicomanagement.domain.Formulario;
import eapli.base.servicomanagement.domain.Pedido;
import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;


import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class SolicitarServicoUI extends AbstractUI {

    public SolicitarServicoUI() {
    }

    @Override
    protected boolean doShow() {
        SolicitarServicoController solicitarServicoController = new SolicitarServicoController();
        List<Catalogo> listaCatalogos = solicitarServicoController.getCatalogos();
        for (Catalogo catalogo : listaCatalogos) {
            System.out.println(catalogo);
        }
        String codigoUnico = Console.readLine("Introduza o código único do serviço que pretende solicitar: \n");

        Servico servico = solicitarServicoController.getServicoByCodigoUnico(codigoUnico);
        System.out.println("Serviço selecionado: \n");
        System.out.println(servico);
        String opcaoSolicitar = Console.readLine("Pretende solicitar este servico: (1-Sim) (2-Nao) \n");
        if (opcaoSolicitar.equalsIgnoreCase("1") && solicitarServicoController.hasTarefaAprovacao()) {
            String urgenciaPedido = Console.readLine("Introduza a urgencia do pedido: \n");
            String data = Console.readLine("Introduza a data limite de resolução do pedido: dd/mm/aaaa \n");
            String[] dataArray = data.split("[/]");
            LocalDate dataLimitePedido = LocalDate.of(Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[1]), Integer.parseInt(dataArray[0]));
            String data2 = Console.readLine("Introduza a data limite de resolução da tarefa de aprovação: dd/mm/aaaa \n");
            String[] dataArray2 = data2.split("[/]");
            LocalDate dataLimTrfAprov = LocalDate.of(Integer.parseInt(dataArray2[2]), Integer.parseInt(dataArray2[1]), Integer.parseInt(dataArray2[0]));
            String data3 = Console.readLine("Introduza a data limite de resolução da tarefa de execução: dd/mm/aaaa \n");
            String[] dataArray3 = data3.split("[/]");
            LocalDate dataLimTrfExec = LocalDate.of(Integer.parseInt(dataArray3[2]), Integer.parseInt(dataArray3[1]), Integer.parseInt(dataArray3[0]));

            Pedido pedido = solicitarServicoController.novoPedido(urgenciaPedido, dataLimitePedido,dataLimTrfAprov,dataLimTrfExec);

            System.out.println("Anexar ficheiros ao pedido");
            String opcao2 = "1";
            while (opcao2.equalsIgnoreCase("1")) {
                opcao2 = "0";
                String filepath= Console.readLine("Introduza o path do ficheiro que pretende adicionar: \n");
                if(solicitarServicoController.adicionarFicheiro(filepath)){
                    System.out.println("Ficheiro anexado");
                }else{
                    System.out.println("Ficheiro não anexado");
                }
                opcao2 = Console.readLine("Deseja anexar mais ficheiros? (1-Sim, 0-Nao)");
            }
            Formulario formulario= solicitarServicoController.getFormularioSolicitacao();
            List<String> atributosPreenchidos= preencherFormulario(formulario);

            while (solicitarServicoController.guardarDadosFormularioSolicitacao(atributosPreenchidos)==null){
                atributosPreenchidos=preencherFormulario(formulario);
            }
            solicitarServicoController.registarPedido();
            System.out.println("Pedido Guardado com sucesso");
            return true;
        }else if(opcaoSolicitar.equalsIgnoreCase("1") && !solicitarServicoController.hasTarefaAprovacao()){
            String urgenciaPedido = Console.readLine("Introduza a urgencia do pedido: \n");
            String data = Console.readLine("Introduza a data limite de resolução do pedido: dd/mm/aaaa \n");
            String[] dataArray = data.split("[/]");
            LocalDate dataLimitePedido = LocalDate.of(Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[1]), Integer.parseInt(dataArray[0]));

            String data3 = Console.readLine("Introduza a data limite de resolução da tarefa de execução: dd/mm/aaaa \n");
            String[] dataArray3 = data3.split("[/]");
            LocalDate dataLimTrfExec = LocalDate.of(Integer.parseInt(dataArray3[2]), Integer.parseInt(dataArray3[1]), Integer.parseInt(dataArray3[0]));

            Pedido pedido = solicitarServicoController.novoPedido(urgenciaPedido, dataLimitePedido,null,dataLimTrfExec);

            System.out.println("Anexar ficheiros ao pedido");
            String opcao2 = "1";
            while (opcao2.equalsIgnoreCase("1")) {
                opcao2 = "0";
                String filepath= Console.readLine("Introduza o path do ficheiro que pretende adicionar: \n");
                if(solicitarServicoController.adicionarFicheiro(filepath)){
                    System.out.println("Ficheiro anexado");
                }else{
                    System.out.println("Ficheiro não anexado");
                }
                opcao2 = Console.readLine("Deseja anexar mais ficheiros? (1-Sim, 0-Nao)");
            }
            Formulario formulario= solicitarServicoController.getFormularioSolicitacao();
            List<String> atributosPreenchidos= preencherFormulario(formulario);

            while (solicitarServicoController.guardarDadosFormularioSolicitacao(atributosPreenchidos)==null){
                System.out.println("Erro na validação do formulário, por favor volte a preencher.");
                atributosPreenchidos=preencherFormulario(formulario);
            }
            System.out.println("Formulário preenchido com sucesso");
            solicitarServicoController.registarPedido();
            System.out.println("Pedido Guardado com sucesso");
            return true;
        }else{
            System.out.println("A sair da solicitacao do servico");
            return true;
        }
    }

    private String preencherAtributo(Atributo atributo){
        String pergunta = atributo.nome();
        String tipoDados = atributo.tipoDados();

        System.out.println(pergunta + ": (" + tipoDados + ")");

        if(tipoDados.equalsIgnoreCase("Periodo")){
            String inicio;
            while(true){
                inicio = Console.readLine("Introduza a data de inicio (dd/MM/yyyy): \n");

                if(inicio.matches("(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/[0-9]{4}") || inicio.isEmpty() || inicio.isBlank()){
                    break;
                }

                System.out.println("Data inválida. Por favor volte a introduzir.");
            }

            String fim;
            while(true){
                fim = Console.readLine("Introduza a data final (dd/MM/yyyy): \n");

                if(fim.matches("(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/[0-9]{4}") || fim.isEmpty() || fim.isBlank()){
                    break;
                }

                System.out.println("Data inválida. Por favor volte a introduzir.");
            }

            if(fim.isEmpty() || fim.isBlank() || inicio.isEmpty() || inicio.isBlank()){
                return "";
            }

            return inicio + "." + fim;
        }else if(tipoDados.equalsIgnoreCase("Multipla")){
            List<String> opcoes = atributo.opcoes();
            System.out.println("Opções de resposta: " + opcoes);

            String resposta;
            while(true){
                resposta = Console.readLine("Introduza a resposta: \n");

                if(opcoes.contains(resposta) || resposta.isEmpty() || resposta.isBlank()){
                    break;
                }

                System.out.println("Resposta não pertence ao leque de opções. Por favor volte a introduzir (tenha em atenção as letras maisculas e minusculas).");
            }

            return resposta;
        }else{
            return Console.readLine("Introduza a resposta: \n");
        }

    }

    private List<String> preencherFormulario(Formulario formulario){
        System.out.println("Preencher o formulario com o código único : "+formulario.codigoUnicoFormulario()+" com o nome: "+formulario.nome());
        List<Atributo> atributos= formulario.atributos();
        List<String> atributosPreenchidos= new LinkedList<>();
        System.out.println("Introduza os seguintes dados: ");
        for (Atributo atributo: atributos){
            atributosPreenchidos.add(preencherAtributo(atributo));
        }
        return atributosPreenchidos;
    }

    @Override
    public String headline() {
        return "=== Solicitar serviço ===";
    }
}
