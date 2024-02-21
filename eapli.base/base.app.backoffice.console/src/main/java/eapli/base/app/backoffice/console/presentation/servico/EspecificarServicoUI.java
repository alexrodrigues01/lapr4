package eapli.base.app.backoffice.console.presentation.servico;

import eapli.base.equipaManagement.domain.Equipa;
import eapli.base.servicomanagement.application.EspecificarServicoController;
import eapli.base.servicomanagement.domain.Keyword;
import eapli.base.tarefamanagement.domain.CodigoScript;
import eapli.base.tarefamanagement.domain.Script;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EspecificarServicoUI extends AbstractUI {

    @Override
    protected boolean doShow() {
        EspecificarServicoController controller = new EspecificarServicoController();

        /**
         * Inicio da especificação do serviço
         */

        String titulo;
        while (true) {
            titulo = Console.readLine("Titulo do Serviço (obrigatório):");
            if (!titulo.isBlank()) {
                break;
            } else {
                System.out.println("Este campo é obrigatório. Por favor introduza um titulo válido.");
            }
        }

        String codigo;
        while (true) {
            codigo = Console.readLine("Código do Serviço (obrigatório):");
            if (!codigo.isBlank()) {
                break;
            } else {
                System.out.println("Este campo é obrigatório. Por favor introduza um código válido.");
            }
        }

        final String descSimples = Console.readLine("Descrição simples do Serviço :");
        final String descCompleta = Console.readLine("Descrição completa  do Serviço :");

        List<Keyword> keywords = new ArrayList<>();
        while (true) {
            String kw = Console.readLine("Keyword (deixe em branco para parar de inserir):");

            if (kw.isBlank()) {
                break;
            }

            Keyword keyword = new Keyword(kw);

            keywords.add(keyword);
        }

        controller.novoServico(codigo, titulo, descSimples, descCompleta, keywords);

        /**
         * Inicio da especificação do formulário do serviço
         */

        String codigoUnico;
        while (true) {
            codigoUnico = Console.readLine("Código Único do Formulário (obrigatório):");
            if (!titulo.isBlank()) {
                break;
            } else {
                System.out.println("Este campo é obrigatório. Por favor introduza um código válido.");
            }
        }

        String nomeFormulario;
        while (true) {
            nomeFormulario = Console.readLine("Nome do Formulário (obrigatório):");
            if (!codigo.isBlank()) {
                break;
            } else {
                System.out.println("Este campo é obrigatório. Por favor introduza um nome válido.");
            }
        }

        runAtributo(controller, 1);

        controller.definirFormulario(codigoUnico, nomeFormulario);

        /**
         * Inicio da especificação do fluxo de atividades
         */

        System.out.println("Especificação do Fluxo de Atividade");

        runTarefaAprovacao(controller);

        runTarefaResolucao(controller);

        controller.criarFluxoTarefa();

        int x;

        do {
            System.out.println("Deseja publicar o serviço?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");

            x = Console.readInteger("Selecione uma opção:");
        } while (x != 1 && x != 2);


        if (x == 1) {
            if (controller.publicarServico()) {
                System.out.println("Serviço pronto a publicar.");
            } else {
                System.out.println("Ainda não é possível publicar o serviço pois a especificação do serviço ainda não está completa. Complete mais tarde.");
            }
        }

        int y;

        do {
            System.out.println("Deseja guardar o serviço na base de dados?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");

            y = Console.readInteger("Selecione uma opção:");
        } while (y != 1 && y != 2);

        if (y == 1) {
            controller.registarServico();
        }

        return false;
    }

    private void runAtributo(EspecificarServicoController controller, int flag) {
        System.out.println("Atributos");

        while (true) {

            boolean flag2 = true;

            System.out.println("Introduza o Tipo de Dados do atributo:");
            System.out.println("1 - Inteiro");
            System.out.println("2 - Inteiro Único");
            System.out.println("3 - Operação Matemática");
            System.out.println("4 - String");
            System.out.println("5 - Boolean");
            System.out.println("6 - Data");
            System.out.println("7 - Período de Datas");
            System.out.println("8 - Ficheiro");
            System.out.println("9 - Escolha Múltipla");

            String option = Console.readLine("Selecione uma opção:");

            String tipoDados = "";

            switch (option) {
                case "1":
                    tipoDados = "Inteiro";
                    break;
                case "2":
                    tipoDados = "InteiroUnico";
                    break;
                case "3":
                    flag2 = false;
                    atributoContaMatematica(controller, flag);
                    break;
                case "4":
                    tipoDados = "String";
                    break;
                case "5":
                    tipoDados = "Boolean";
                    break;
                case "6":
                    tipoDados = "Data";
                    break;
                case "7":
                    tipoDados = "Periodo";
                    break;
                case "8":
                    tipoDados = "Ficheiro";
                    break;
                case "9":
                    List<String> opcoes = new ArrayList<>();
                    while (true) {
                        String opcao = Console.readLine("Introduza uma opção de escolha múltipla (deixe em branco para parar de inserir):");

                        if (opcao.isBlank()) {
                            break;
                        }

                        opcoes.add(opcao);
                    }

                    if (!opcoes.isEmpty()) {
                        controller.definirOpcoesEscolhaMultipla(opcoes);
                    }

                    tipoDados = "Multipla";
                    break;
                default:
                    System.out.println("Opção inválida");
            }

            if (flag2) {
                String nomeAtributo = Console.readLine("Nome do Atributo (deixe em branco agora para não inserir atributos):");

                if (nomeAtributo.isBlank()) {
                    break;
                }

                String label = "";
                do {
                    label = Console.readLine("Label do Atributo:");
                } while (label.isBlank() || label.isEmpty());

                String descricao = "";
                do {
                    descricao = Console.readLine("Descrição do Atributo:");
                } while (descricao.isBlank() || descricao.isEmpty());

                String expressaoRegular = Console.readLine("Expressão Regular do Atributo (opcional):");

                int optionObg;
                do {
                    System.out.println("A resposta ao atributo é obrigatória?");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não");

                    optionObg = Console.readInteger("Selecione uma opção:");
                } while (optionObg != 1 && optionObg != 2);

                boolean obrigatoriedade;

                if (optionObg == 1) {
                    obrigatoriedade = true;
                } else {
                    obrigatoriedade = false;
                }

                if (flag == 1) {
                    controller.adicionarAtributo(nomeAtributo, label, descricao, expressaoRegular, tipoDados, obrigatoriedade);
                } else if (flag == 2) {
                    controller.adicionarAtributoAprovacao(nomeAtributo, label, descricao, expressaoRegular, tipoDados, obrigatoriedade);
                } else {
                    controller.adicionarAtributoResolucao(nomeAtributo, label, descricao, expressaoRegular, tipoDados, obrigatoriedade);
                }
            }

        }

    }

    private void atributoContaMatematica(EspecificarServicoController controller, int flag) {
        atributoContaMatematicaRecursivo(controller, 2, flag);
    }

    private void atributoContaMatematicaRecursivo(EspecificarServicoController controller, int contador, int flag) {
        String nomeAtributo = "";
        do {
            nomeAtributo = Console.readLine("Nome do Atributo da Operação Matemática:");
        } while (nomeAtributo.isBlank() || nomeAtributo.isEmpty());

        String label = "";
        do {
            label = Console.readLine("Label do Atributo:");
        } while (label.isBlank() || label.isEmpty());

        String descricao = "";
        do {
            descricao = Console.readLine("Descrição do Atributo:");
        } while (descricao.isBlank() || descricao.isEmpty());

        String expressaoRegular = Console.readLine("Expressão Regular do Atributo (opcional):");

        System.out.println("Introduza o Tipo de Dados do atributo:");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        if (contador == 0) {
            System.out.println("3 - Resultado");
        }

        String option = Console.readLine("Selecione uma opção:");

        String tipoDados = "";

        switch (option) {
            case "1":
                tipoDados = "Soma";
                contador--;
                break;
            case "2":
                tipoDados = "Subtracao";
                contador--;
                break;
            case "3":
                contador = Integer.MAX_VALUE;
                tipoDados = "Igual";
                break;
            default:
                System.out.println("Opção inválida");
        }

        int optionObg;
        do {
            System.out.println("A resposta ao atributo é obrigatória?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");

            optionObg = Console.readInteger("Selecione uma opção:");
        } while (optionObg != 1 && optionObg != 2);

        boolean obrigatoriedade;

        if (optionObg == 1) {
            obrigatoriedade = true;
        } else {
            obrigatoriedade = false;
        }

        if (flag == 1) {
            controller.adicionarAtributo(nomeAtributo, label, descricao, expressaoRegular, tipoDados, obrigatoriedade);
        } else if (flag == 2) {
            controller.adicionarAtributoAprovacao(nomeAtributo, label, descricao, expressaoRegular, tipoDados, obrigatoriedade);
        } else {
            controller.adicionarAtributoResolucao(nomeAtributo, label, descricao, expressaoRegular, tipoDados, obrigatoriedade);
        }

        if (contador != Integer.MAX_VALUE) {
            atributoContaMatematicaRecursivo(controller, contador, flag);
        }
    }

    private void runTarefaAprovacao(EspecificarServicoController controller) {
        int a;
        do {
            System.out.println("Quer adicionar Tarefa de Aprovação ao Fluxo?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");

            a = Console.readInteger("Selecione uma opção:");
        } while (a != 1 && a != 2);

        if (a == 1) {
            String codigoUnico;
            while (true) {
                codigoUnico = Console.readLine("Código Único do Formulário (obrigatório):");
                if (!codigoUnico.isBlank()) {
                    break;
                } else {
                    System.out.println("Este campo é obrigatório. Por favor introduza um código válido.");
                }
            }

            String nomeFormulario;
            while (true) {
                nomeFormulario = Console.readLine("Nome do Formulário (obrigatório):");
                if (!nomeFormulario.isBlank()) {
                    break;
                } else {
                    System.out.println("Este campo é obrigatório. Por favor introduza um nome válido.");
                }
            }

            runAtributo(controller, 2);


            do {
                System.out.println("Quem pode realizar a tarefa de aprovação?");
                System.out.println("1 - Eu (Responsável do Serviço)");
                System.out.println("2 - Responsável Hierárquico de quem efetua o pedido");

                a = Console.readInteger("Selecione uma opção:");
            } while (a != 1 && a != 2);

            boolean responsavel;
            if (a == 2) {
                responsavel = true;
            } else {
                responsavel = false;
            }

            controller.criarTarefaAprovacao(nomeFormulario, codigoUnico, responsavel);
        }
    }

    public void runTarefaResolucao(EspecificarServicoController controller) {
        int b;
        do {
            System.out.println("Que tipo de Tarefa de Resolução quer adicionar ao Fluxo?");
            System.out.println("1 - Manual");
            System.out.println("2 - Automática");

            b = Console.readInteger("Selecione uma opção:");
        } while (b != 1 && b != 2);

        if (b == 1) {
            String codigoUnico;
            while (true) {
                codigoUnico = Console.readLine("Código Único do Formulário (obrigatório):");
                if (!codigoUnico.isBlank()) {
                    break;
                } else {
                    System.out.println("Este campo é obrigatório. Por favor introduza um código válido.");
                }
            }

            String nomeFormulario;
            while (true) {
                nomeFormulario = Console.readLine("Nome do Formulário (obrigatório):");
                if (!nomeFormulario.isBlank()) {
                    break;
                } else {
                    System.out.println("Este campo é obrigatório. Por favor introduza um nome válido.");
                }
            }

            runAtributo(controller, 3);



            System.out.println("Escolha a(s) equipa(s) que podem realizar a tarefa:");

            List<Equipa> equipas = controller.equipas();

            int index = 0;

            for (Equipa e : equipas) {
                index++;
                System.out.println("EQUIPA #" + index);
                System.out.println(e.toString());
            }

            while (true) {
                index = Console.readInteger("Selecione uma equipa (ou 0 para parar):");

                if (index == 0) {
                    break;
                }

                controller.selecionarEquipa(index);
            }

            controller.criarTarefaResolucao(true, nomeFormulario, codigoUnico, null);

        }

        if (b == 2) {


            Script script;
            do {
                String scriptString = Console.readLine("Introduza o script a ser executado:");

                 script = new Script(new CodigoScript(scriptString));

            } while (!controller.criarTarefaResolucao(false, null, null, script));
        }
    }


    @Override
    public String headline() {
        return "=== Introduza os dados do serviço ===";
    }
}
