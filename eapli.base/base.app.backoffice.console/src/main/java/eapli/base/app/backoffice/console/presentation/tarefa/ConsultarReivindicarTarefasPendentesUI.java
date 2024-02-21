package eapli.base.app.backoffice.console.presentation.tarefa;

import eapli.base.fluxotarefaresolucao.domain.TarefaAprovRes;
import eapli.base.fluxotarefaresolucao.domain.TarefaAprovResDTO;
import eapli.base.fluxotarefaresolucao.domain.TarefaExecRes;
import eapli.base.fluxotarefaresolucao.domain.TarefaExecResDTO;
import eapli.base.tarefamanagement.application.ConsultarReivindicarTarefasPendentesController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class ConsultarReivindicarTarefasPendentesUI extends AbstractUI {

    @Override
    protected boolean doShow() {
        ConsultarReivindicarTarefasPendentesController controller = new ConsultarReivindicarTarefasPendentesController();

        List<TarefaAprovResDTO> tarefaAprovacaoList = controller.getTarefasPendentesAprovacao();
        for(TarefaAprovResDTO ta : tarefaAprovacaoList){
            System.out.println(ta);
        }

        List<TarefaExecResDTO> tarefaExecucaoList = controller.getTarefasPendentesExecucao();
        for(TarefaExecResDTO te : tarefaExecucaoList){
            System.out.println(te);
        }

        if(!tarefaAprovacaoList.isEmpty() || !tarefaExecucaoList.isEmpty()){
            String consulta= Console.readLine(String.format("Deseja reivindicar uma das tarefas pendentes?\n" +
                    "1 - Sim\n" + "0 - Não"));
            if(consulta.equalsIgnoreCase("1")){
                String idTarefa=Console.readLine("Insira o id da tarefa que pretende reivindicar");
                controller.reivindicarTarefa(idTarefa);
            }else if(consulta.equalsIgnoreCase("0")){
                System.out.println("Ok! Obrigado");
            }else{
                System.out.println("Comando inválido");
            }
        }

        return true;
    }

    @Override
    public String headline() {
        return "+= Consultar e Reivindicar Tarefas Pendentes ===============";
    }
}
