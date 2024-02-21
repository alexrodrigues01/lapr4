package eapli.base.app.backoffice.console.presentation.equipa;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipaManagement.application.AssociarColaboradorEquipaController;
import eapli.base.equipaManagement.domain.Equipa;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class AssociarColaboradorEquipaUI extends AbstractUI {
    @Override
    protected boolean doShow() {
        AssociarColaboradorEquipaController controller = new AssociarColaboradorEquipaController();

        System.out.println("Adicionar Colaboradores à Equipa");

        List<Equipa> equipas = controller.getEquipas();
        System.out.println("Lista de Equipas da Organização: ");
        for(Equipa e : equipas){
            System.out.println(e.toString());
        }
        String identificadorUnicoEquipa=Console.readLine("Insira o identificador unico da equipa a que pretende adicionar colaboradores");

        String flag = "1";
        while (flag.equalsIgnoreCase("1")) {
            flag = "0";
            List<Colaborador> colaboradores = controller.getColaboradores();
            System.out.println("Lista de Colaboradores da Organização: ");
            for (Colaborador colaborador : colaboradores) {
                System.out.println(colaborador.toString());
            }
            final String email = Console.readLine("Escolha o email do colaborador da organização que quer adicionar (ou deixe em branco): ");
            if (!email.isBlank()) {
                controller.adicionarColaboradorEquipa(email,identificadorUnicoEquipa);
            }

            /*String flag1= Console.readLine("Quer adicioná-lo como responsável? (1-Sim, 0-Nao)");
            if(flag1.equals("1")){
                List<Colaborador> colaboradoresEquipa = controller.getColaboradoresEquipa();
                controller.adicionarColaboradorResponsavel(email);
            }*/

            flag = Console.readLine("Deseja inserir mais colaboradores à equipa? (1-Sim, 0-Nao)");
        }

        /*System.out.println("Adicionar Colaboradores Responsáveis");
        String flag2 = "1";
        while (flag2.equalsIgnoreCase("1")) {
            flag2 = "0";
            List<Colaborador> colaboradoresEquipa = controller.getColaboradoresEquipa();
            System.out.println("Lista de Colaboradores da Equipa: ");
            for (Colaborador colaboradorEquipa : colaboradoresEquipa) {
                System.out.println(colaboradorEquipa.toString());
            }
            final String emailCE = Console.readLine("Escolha o email do colaborador da equipa que quer adicionar como responsável (ou deixe em branco): ");
            if (!emailCE.isBlank()) {
                controller.adicionarColaboradorResponsavel(emailCE);
            }

            flag2 = Console.readLine("Deseja inserir mais colaboradores responsáveis? (1-Sim, 0-Nao)");
        }*/

        int escolha;
        do {
            escolha = Console.readInteger("Confirmar:\nSim[1]\nNão[2]");
        } while (escolha != 1 && escolha != 2);
        if (escolha == 1) {
            controller.registarColaboradoresEquipa();
        }

        System.out.println("+=Fim Associar Colaboradores à equipa =============== ");
        return true;
    }

    @Override
    public String headline() {
        return "+= Associar Colaboradores à equipa ===============";
    }
}
