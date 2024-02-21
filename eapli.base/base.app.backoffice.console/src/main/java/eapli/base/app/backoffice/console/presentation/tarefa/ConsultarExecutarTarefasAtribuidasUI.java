package eapli.base.app.backoffice.console.presentation.tarefa;

import eapli.base.fluxotarefaresolucao.application.ConsultarExecutarTarefasAtribuidasController;
import eapli.base.fluxotarefaresolucao.domain.TarefaAprovResDTO;
import eapli.base.fluxotarefaresolucao.domain.TarefaExecResDTO;
import eapli.base.servicomanagement.domain.Atributo;
import eapli.base.servicomanagement.domain.Formulario;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.LinkedList;
import java.util.List;

public class ConsultarExecutarTarefasAtribuidasUI extends AbstractUI {
    @Override
    protected boolean doShow() {
        ConsultarExecutarTarefasAtribuidasController controller = new ConsultarExecutarTarefasAtribuidasController();

        List<TarefaAprovResDTO> tarefaAprovacaoList = controller.getTarefasAtribuidasAprovacao();
        for(TarefaAprovResDTO ta : tarefaAprovacaoList){
            System.out.println(ta);
        }

        List<TarefaExecResDTO> tarefaExecucaoList = controller.getTarefasAtribuidasExecucao();
        for(TarefaExecResDTO te : tarefaExecucaoList){
            System.out.println(te);
        }

        if(!tarefaAprovacaoList.isEmpty() || !tarefaExecucaoList.isEmpty()){
            String consulta= Console.readLine(String.format("Deseja executar uma das tarefas?\n" +
                    "1 - Sim\n" + "0 - Não"));
            if(consulta.equalsIgnoreCase("1")){
                String idTarefa=Console.readLine("Insira o id da tarefa que pretende executar");
                if(controller.setTarefa(idTarefa)){
                    Formulario formulario= controller.getFormulario();
                    List<String> atributosPreenchidos= preencherFormulario(formulario);

                    while (controller.guardarDadosFormularioAprov(atributosPreenchidos)==null){
                        atributosPreenchidos=preencherFormulario(formulario);
                    }
                    String aprov = Console.readLine(String.format("A tarefa foi aprovada?\n" + "1 - Sim\n" + "0 - Não"));
                    while(!aprov.equals("1") && !aprov.equals("0")){
                        aprov = Console.readLine(String.format("A tarefa foi aprovada?\n" + "1 - Sim\n" + "0 - Não"));
                    }
                    controller.registarResolucaoAprov(aprov);
                }else{
                    Formulario formulario= controller.getFormulario();
                    List<String> atributosPreenchidos= preencherFormulario(formulario);

                    while (controller.guardarDadosFormularioExec(atributosPreenchidos)==null){
                        atributosPreenchidos=preencherFormulario(formulario);
                    }
                    controller.registarResolucaoExec();
                }

            }else if(consulta.equalsIgnoreCase("0")){
                System.out.println("Ok! Obrigado");
            }else{
                System.out.println("Comando inválido");
            }
        }

        return true;
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
        return "+= Consultar e Executar Tarefas Atribuídas =====";
    }
}
