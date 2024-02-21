package eapli.base.app.backoffice.console.presentation.equipa;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipaManagement.application.EquipaController;
import eapli.base.equipaManagement.domain.Equipa;
import eapli.base.equipaManagement.domain.TipoEquipa;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;


public class EquipaUI extends AbstractUI {


    public EquipaUI() {
    }

    @Override
    protected boolean doShow() {
        EquipaController equipaController = new EquipaController();
        final String identificadorUnico = Console.readLine("Identificador: ");
        final String acronimoUnico = Console.readLine("Acronimo: ");
        final String descricao = Console.readLine("Descricao: ");

        Equipa equipa = equipaController.novaEquipa(identificadorUnico, acronimoUnico, descricao);

        System.out.println("Adicionar Tipo de Equipa");
        List<TipoEquipa> tiposEquipa = equipaController.getTiposEquipa();
        System.out.println("Lista de Tipos de Equipa: ");
        for (TipoEquipa tipoEquipa : tiposEquipa) {
            System.out.println(tipoEquipa.toString());
        }
        final String codigoUnico = Console.readLine("Escolha o codigo Unico do tipo de Equipa (ou deixe em branco): ");
        if (!codigoUnico.isBlank()) {
            equipaController.adicionarTipoEquipa(codigoUnico);
        }

        /*System.out.println("Adicionar Colaboradores à Equipa");
        String flag = "1";
        while (flag.equalsIgnoreCase("1")) {
            flag = "0";
            List<Colaborador> colaboradores = equipaController.getColaboradores();
            System.out.println("Lista de Colaboradores da Organização: ");
            for (Colaborador colaborador : colaboradores) {
                System.out.println(colaborador.toString());
            }
            final String email = Console.readLine("Escolha o email do colaborador da organização que quer adicionar (ou deixe em branco): ");
            if (!email.isBlank()) {
                equipaController.adicionarColaborador(email);
            }
            flag = Console.readLine("Deseja inserir mais colaboradores à equipa? (1-Sim, 0-Nao)");
        }

        System.out.println("Adicionar Colaboradores Responsáveis");
        String flag2 = "1";
        while (flag2.equalsIgnoreCase("1")) {
            flag2 = "0";
            List<Colaborador> colaboradoresEquipa = equipaController.getColaboradoresEquipa();
            System.out.println("Lista de Colaboradores da Equipa: ");
            for (Colaborador colaboradorEquipa : colaboradoresEquipa) {
                System.out.println(colaboradorEquipa.toString());
            }
            final String emailCE = Console.readLine("Escolha o email do colaborador da equipa que quer adicionar como responsável (ou deixe em branco): ");
            if (!emailCE.isBlank()) {
                equipaController.adicionarColaboradorResponsavel(emailCE);
            }
            flag2 = Console.readLine("Deseja inserir mais colaboradores responsáveis? (1-Sim, 0-Nao)");
        }*/

        System.out.println(equipa.toString());
        int escolha;
        do {
            escolha = Console.readInteger("Confirmar:\nSim[1]\nNão[2]");
        } while (escolha != 1 && escolha != 2);
        if (escolha == 1) {
            equipaController.registarEquipa();
        }
        System.out.println("+=Fim Registar Equipa =============== ");
        return true;
    }

    @Override
    public String headline() {
        return "+= Registar Equipa ===============";
    }
}
