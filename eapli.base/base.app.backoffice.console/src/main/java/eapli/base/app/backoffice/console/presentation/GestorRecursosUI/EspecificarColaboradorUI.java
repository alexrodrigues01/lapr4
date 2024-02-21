package eapli.base.app.backoffice.console.presentation.GestorRecursosUI;

import eapli.base.colaboradormanagement.application.EspecificarColaboradorController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class EspecificarColaboradorUI extends AbstractUI {

    public EspecificarColaboradorUI( ) {

    }

    @Override
    protected boolean doShow() {
        EspecificarColaboradorController colaboradorController = new EspecificarColaboradorController();
        List<Colaborador> colaboradores=colaboradorController.getColaboradores();

        System.out.println("Lista de Colaboradores: ");
        for (int i = 0; i < colaboradores.size(); i++) {
            System.out.println(colaboradores.get(i).toString());
        }

        final String id = Console.readLine("Escolha o email do Colaborador (ou deixe em branco): ");
        if(!id.isBlank()){
            Colaborador responsavel=colaboradorController.getColaboradorById(id);
        }
        final String email = Console.readLine("Email: ");
        final String nomeComum = Console.readLine("Nome Comum: ");
        final String nomeCompleto = Console.readLine("Nome Completo: ");
        final String localResidencia = Console.readLine("Local De Residencia: ");
        final String telemovel = Console.readLine("Telemovel: ");
        final String dataNascimento = Console.readLine("Data Nascimento (YYYY-MM-DD): ");

        System.out.println("Funcao: ");
        for (Colaborador.Funcao funcao:colaboradorController.getFuncoes()) {
            System.out.println(funcao);
        }
        final String funcao = Console.readLine("Escolha a função: ");
        Colaborador colaborador=colaboradorController.novoColaborador(email,nomeComum,nomeCompleto,localResidencia,telemovel,dataNascimento,funcao);
        System.out.println(colaborador.toString());
        int escolha;
        do {
            escolha =Console.readInteger("Confirmar:\nSim[1]\nNão[2]");
        }while(escolha!=1 && escolha!=2);
        if(escolha==1){
            colaboradorController.registarColaborador();
        }
        System.out.println("+=Fim Especificar Colaborador =============== ");
        return false;
    }

    @Override
    public String headline() {
        return "+= Especificar Colaborador ===============";
    }


}
