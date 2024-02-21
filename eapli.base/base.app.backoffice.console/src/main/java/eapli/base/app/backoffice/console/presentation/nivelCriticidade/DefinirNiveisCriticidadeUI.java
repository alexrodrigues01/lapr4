package eapli.base.app.backoffice.console.presentation.nivelCriticidade;

import eapli.base.nivelcriticidademanagement.application.DefinirNiveisCriticidadeController;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class DefinirNiveisCriticidadeUI extends AbstractUI{


    @Override
    protected boolean doShow()  {
       DefinirNiveisCriticidadeController controller = new DefinirNiveisCriticidadeController();

        for(int i = 1; i < 6; i++){
            System.out.printf("Introduza os dados do %d nível de criticidade\n", i);

            final String cor = Console.readLine("Cor:");

            final String label = Console.readLine("Label:");

            controller.novoNivel(i, cor, label);

            String opcao2 = "1";
            while (opcao2.equalsIgnoreCase("1")) {
                opcao2 = "0";
                final double tempoMaximoAprovacao = Console.readDouble("Tempo máximo de aprovação:");

                final double tempoMedioAprovacao = Console.readDouble("Tempo médio de aprovação:");

                final double tempoMaximoResolucao = Console.readDouble("Tempo máximo de resolução:");

                final double tempoMedioResolucao = Console.readDouble("Tempo tempo médio de resolução:");

                controller.definirObjetivo(i, tempoMaximoAprovacao, tempoMedioAprovacao, tempoMaximoResolucao, tempoMedioResolucao);

                System.out.println();
                opcao2 = Console.readLine("Deseja adicionar mais objetivos a este nível de criticidade? (1-Sim, 0-Nao)");
            }
        }

        int y;

        do{
            System.out.println("Niveis de Criticidade e respetivos Objetivos criados com sucesso");
            System.out.println("Pretende registar no sistema?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");

            y = Console.readInteger("Selecione uma opção:");
        }while(y != 1 && y!=2);

        if(y == 1){
            controller.registarNiveisEObjetivos();

            System.out.println("Registado com sucesso.");
        }

        return false;
    }

    @Override
    public String headline() {
        return "=== Niveis de Criticidade ===";
    }
}
