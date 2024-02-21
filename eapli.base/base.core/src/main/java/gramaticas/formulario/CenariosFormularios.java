package gramaticas.formulario;

import eapli.base.servicomanagement.domain.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CenariosFormularios {

    public static void main(String[] args) throws IOException {
        cenario1();
        cenario2();
        cenario3();
        cenario4();
    }

    private static void cenario1(){
        System.out.println("====== Cenários do Serviço 1 ======");

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Formulário do Serviço:");

        System.out.println("#1 - Ao atributo 'Tipo de ausência' responde 'Justificada' mas não responde ao atributo 'Justificação'");
        List<AtributoPreenchido> atributos = new ArrayList<>();

        NomeAtributo nome = new NomeAtributo("Periodo de Ausencia");
        Label label = new Label("irrelevante");
        DescricaoAtributo descricaoAtributo = new DescricaoAtributo("irrelevante");
        ExpressaoRegular expressaoRegular = new ExpressaoRegular("");
        TipoDados tipoDados = new TipoDados("Periodo");
        boolean obrigatoriedade = true;
        Resposta resposta = new Resposta("05/02/2021.09/02/2021");

        AtributoPreenchido atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Tipo de Ausencia");
        tipoDados = new TipoDados("String");
        obrigatoriedade = true;
        resposta = new Resposta("Justificada");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Justificacao");
        tipoDados = new TipoDados("String");
        obrigatoriedade = false;
        resposta = new Resposta("");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        FormularioP formulario = new FormularioP(new NomeFormulario("Servico 1"), atributos);

        ValidacaoFormulario validacaoFormulario = new ValidacaoFormulario();


        String resultado = validacaoFormulario.validarFormularioVisitor(formulario);

        System.out.println("Visitor: " + resultado + "\n");

        String listener = validacaoFormulario.validarFormularioListener(formulario);

        System.out.println("Listener: " + listener + "\n");

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("#2 - Ao atributo 'Tipo de ausência' responde 'Justificada' e responde ao atributo 'Justificação'");

        atributos = new ArrayList<>();

        nome = new NomeAtributo("Periodo de Ausencia");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("Periodo");
        obrigatoriedade = true;
        resposta = new Resposta("05/02/2021.09/02/2021");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Tipo de Ausencia");
        tipoDados = new TipoDados("String");
        obrigatoriedade = true;
        resposta = new Resposta("Justificada");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Justificacao");
        tipoDados = new TipoDados("String");
        obrigatoriedade = false;
        resposta = new Resposta("Motivo Pessoal");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        formulario = new FormularioP(new NomeFormulario("Servico 1"), atributos);

        resultado = validacaoFormulario.validarFormularioVisitor(formulario);

        System.out.println("Visitor: " + resultado + "\n");

        listener = validacaoFormulario.validarFormularioListener(formulario);

        System.out.println("Listener: " + listener + "\n");

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("#3 - Ao atributo 'Tipo de ausência' responde 'Ferias' ou 'Nao Justificada' tornando a resposta ao atributo 'Justificação' irrelevante");

        atributos = new ArrayList<>();

        nome = new NomeAtributo("Periodo de Ausencia");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("Periodo");
        obrigatoriedade = true;
        resposta = new Resposta("05/02/2021.09/02/2021");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Tipo de Ausencia");
        tipoDados = new TipoDados("String");
        obrigatoriedade = true;
        resposta = new Resposta("Ferias");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Justificacao");
        tipoDados = new TipoDados("String");
        obrigatoriedade = false;
        resposta = new Resposta("");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        formulario = new FormularioP(new NomeFormulario("Servico 1"), atributos);

        resultado = validacaoFormulario.validarFormularioVisitor(formulario);

        System.out.println("Visitor: " + resultado + "\n");

        listener = validacaoFormulario.validarFormularioListener(formulario);

        System.out.println("Listener: " + listener + "\n");

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Formulário de Aprovação:");

        System.out.println("#1 - Responde à decisão e fundamentacao");

        System.out.println("AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");

        atributos = new ArrayList<>();

        nome = new NomeAtributo("Decisao");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("String");
        obrigatoriedade = true;
        resposta = new Resposta("Sim");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Fundamentacao");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("String");
        obrigatoriedade = true;
        resposta = new Resposta("Sim");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        formulario = new FormularioP(new NomeFormulario("Aprovacao 1"), atributos);

        resultado = validacaoFormulario.validarFormularioVisitor(formulario);

        System.out.println("Visitor: " + resultado + "\n");

        listener = validacaoFormulario.validarFormularioListener(formulario);

        System.out.println("Listener: " + listener + "\n");

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("#2 - Não responde à decisão");

        atributos = new ArrayList<>();

        nome = new NomeAtributo("Decisao");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("String");
        obrigatoriedade = true;
        resposta = new Resposta("");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        formulario = new FormularioP(new NomeFormulario("Aprovacao 1"), atributos);

        resultado = validacaoFormulario.validarFormularioVisitor(formulario);

        System.out.println("Visitor: " + resultado + "\n");

        listener = validacaoFormulario.validarFormularioListener(formulario);

        System.out.println("Listener: " + listener + "\n");

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Formulário de Realização:");
        System.out.println("#1 - Responde a tudo correto");

        atributos = new ArrayList<>();

        nome = new NomeAtributo("Dias de ferias ja gozados no ano");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("Soma");
        obrigatoriedade = true;
        resposta = new Resposta("5");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Dias de ferias ja gozados no periodo");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("Soma");
        obrigatoriedade = true;
        resposta = new Resposta("2");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Dias de ferias totais");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("Igual");
        obrigatoriedade = true;
        resposta = new Resposta("7");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Dias de falta justificadas ja gozados no ano");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("Soma");
        obrigatoriedade = true;
        resposta = new Resposta("5");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Dias de falta justificadas ja gozados periodo");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("Soma");
        obrigatoriedade = true;
        resposta = new Resposta("2");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Dias de falta justificadas totais");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("Igual");
        obrigatoriedade = true;
        resposta = new Resposta("7");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Dias de falta nao justificadas ja gozados no ano");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("Soma");
        obrigatoriedade = true;
        resposta = new Resposta("5");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Dias de falta nao justificadas ja gozados periodo");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("Soma");
        obrigatoriedade = true;
        resposta = new Resposta("2");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Dias de falta nao justificadas totais");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("Igual");
        obrigatoriedade = true;
        resposta = new Resposta("7");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Comentario");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("String");
        obrigatoriedade = false;
        resposta = new Resposta("");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        formulario = new FormularioP(new NomeFormulario("Realização 1"), atributos);

        resultado = validacaoFormulario.validarFormularioVisitor(formulario);

        System.out.println("Visitor: " + resultado + "\n");

        listener = validacaoFormulario.validarFormularioListener(formulario);

        System.out.println("Listener: " + listener + "\n");

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("#2 - Responde a tudo mal");

        atributos = new ArrayList<>();

        nome = new NomeAtributo("Dias de ferias ja gozados no ano");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("Soma");
        obrigatoriedade = true;
        resposta = new Resposta("5");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Dias de ferias ja gozados periodo");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("Soma");
        obrigatoriedade = true;
        resposta = new Resposta("2");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Dias de ferias totais");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("Igual");
        obrigatoriedade = true;
        resposta = new Resposta("8");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Dias de falta justificadas ja gozados no ano");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("Soma");
        obrigatoriedade = true;
        resposta = new Resposta("5");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Dias de falta justificadas ja gozados periodo");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("Soma");
        obrigatoriedade = true;
        resposta = new Resposta("2");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Dias de falta justificadas totais");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("Igual");
        obrigatoriedade = true;
        resposta = new Resposta("8");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Dias de falta nao justificadas ja gozados no ano");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("Soma");
        obrigatoriedade = true;
        resposta = new Resposta("5");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Dias de falta nao justificadas ja gozados periodo");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("Soma");
        obrigatoriedade = true;
        resposta = new Resposta("2");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Dias de falta nao justificadas totais");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("Igual");
        obrigatoriedade = true;
        resposta = new Resposta("8");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Comentario");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("String");
        obrigatoriedade = false;
        resposta = new Resposta("");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        formulario = new FormularioP(new NomeFormulario("Realização 1"), atributos);

        resultado = validacaoFormulario.validarFormularioVisitor(formulario);

        System.out.println("Visitor: " + resultado + "\n");

        listener = validacaoFormulario.validarFormularioListener(formulario);

        System.out.println("Listener: " + listener + "\n");

    }

    private static void cenario2(){
        System.out.println("====== Cenários do Serviço 2 ======");

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Formulário do Serviço:");


        System.out.println("#1 - Codigo Interno do Cliente não está de acordo com a expressão regular");
        List<AtributoPreenchido> atributos = new ArrayList<>();

        NomeAtributo nome = new NomeAtributo("Codigo Interno Cliente");
        Label label = new Label("irrelevante");
        DescricaoAtributo descricaoAtributo = new DescricaoAtributo("irrelevante");
        ExpressaoRegular expressaoRegular = new ExpressaoRegular("[bcdfghjklmnpqrstvxyz]{3}[0-9]{3}");
        TipoDados tipoDados = new TipoDados("String");
        boolean obrigatoriedade = true;
        Resposta resposta = new Resposta("ctv66");

        AtributoPreenchido atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        FormularioP formulario = new FormularioP(new NomeFormulario("Servico 1"), atributos);

        ValidacaoFormulario validacaoFormulario = new ValidacaoFormulario();


        String resultado = validacaoFormulario.validarFormularioVisitor(formulario);

        System.out.println("Visitor: " + resultado + "\n");

        String listener = validacaoFormulario.validarFormularioListener(formulario);

        System.out.println("Listener: " + listener + "\n");

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("#2 - Percentagem de Desconto e Valor de Desconto estão preenchidos, em vez de estar apenas um");
        atributos = new ArrayList<>();

        nome = new NomeAtributo("Percentagem de Desconto");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("InteiroUnico");
        obrigatoriedade = false;
        resposta = new Resposta("5");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Valor de Desconto");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("InteiroUnico");
        obrigatoriedade = false;
        resposta = new Resposta("5");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        formulario = new FormularioP(new NomeFormulario("Servico 1"), atributos);

        validacaoFormulario = new ValidacaoFormulario();

        resultado = validacaoFormulario.validarFormularioVisitor(formulario);

        System.out.println("Visitor: " + resultado + "\n");

        listener = validacaoFormulario.validarFormularioListener(formulario);

        System.out.println("Listener: " + listener + "\n");

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("#3 - A recorrência apenas assume 2 valores possíveis: Única ou Até Data Limite. " +
                                "Em caso de ser única é obrigatório identificar a fatura em causa. Caso contrário é obrigatório indicar a data limite de aplicação do desconto: "
                                + "Insucesso.");
        atributos = new ArrayList<>();

        nome = new NomeAtributo("Codigo Interno Cliente");
        expressaoRegular = new ExpressaoRegular("[bcdfghjklmnpqrstvxyz]{3}[0-9]{3}");
        tipoDados = new TipoDados("String");
        obrigatoriedade = true;
        resposta = new Resposta("ctv666");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Nome Interno Cliente");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("String");
        obrigatoriedade = true;
        resposta = new Resposta("Miguel");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Tipo de Desconto");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("String");
        obrigatoriedade = true;
        resposta = new Resposta("Desconto");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Recorrencia");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("String");
        obrigatoriedade = true;
        resposta = new Resposta("Unica");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Percentagem de Desconto");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("InteiroUnico");
        obrigatoriedade = false;
        resposta = new Resposta("5");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Valor de Desconto");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("InteiroUnico");
        obrigatoriedade = false;
        resposta = new Resposta("");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Identificacao Fatura");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("String");
        obrigatoriedade = false;
        resposta = new Resposta("");        //idfatura

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Data Limite");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("Data");
        obrigatoriedade = false;
        resposta = new Resposta("05/02/2021");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Fundamentacao");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("String");
        obrigatoriedade = true;
        resposta = new Resposta("fundamentado");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        formulario = new FormularioP(new NomeFormulario("Servico 1"), atributos);

        validacaoFormulario = new ValidacaoFormulario();

        resultado = validacaoFormulario.validarFormularioVisitor(formulario);

        System.out.println("Visitor: " + resultado + "\n");

        listener = validacaoFormulario.validarFormularioListener(formulario);

        System.out.println("Listener: " + listener + "\n");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("#4 - Correto");

        atributos.remove(6);

        nome = new NomeAtributo("Identificacao Fatura");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("String");
        obrigatoriedade = false;
        resposta = new Resposta("idfatura");        //idfatura

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        //atributos.add(atributoPreenchido);
        atributos.add(6,atributoPreenchido);

        formulario = new FormularioP(new NomeFormulario("Servico 1"), atributos);

        validacaoFormulario = new ValidacaoFormulario();

        resultado = validacaoFormulario.validarFormularioVisitor(formulario);

        System.out.println("Visitor: " + resultado + "\n");

        listener = validacaoFormulario.validarFormularioListener(formulario);

        System.out.println("Listener: " + listener + "\n");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Formulário de Aprovação:");
        System.out.println("#1 - Fundamentação sem resposta & Valor Desconto e Percentagem Desconto preenchidas");


        atributos = new ArrayList<>();

        nome = new NomeAtributo("Decisao");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("String");
        obrigatoriedade = true;
        resposta = new Resposta("Sim");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Fundamentacao");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("String");
        obrigatoriedade = true;
        resposta = new Resposta("");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Percentagem Desconto");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("InteiroUnico");
        obrigatoriedade = false;
        resposta = new Resposta("10");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Valor Desconto");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("InteiroUnico");
        obrigatoriedade = false;
        resposta = new Resposta("10");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Data");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("Data");
        obrigatoriedade = false;
        resposta = new Resposta("05/02/2021");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        formulario = new FormularioP(new NomeFormulario("Servico 1"), atributos);

        validacaoFormulario = new ValidacaoFormulario();

        resultado = validacaoFormulario.validarFormularioVisitor(formulario);

        System.out.println("Visitor: " + resultado + "\n");

        listener = validacaoFormulario.validarFormularioListener(formulario);

        System.out.println("Listener: " + listener + "\n");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("#2 - Correto");

        atributos.remove(1);

        nome = new NomeAtributo("Fundamentacao");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("String");
        obrigatoriedade = true;
        resposta = new Resposta("fundamentado");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(1, atributoPreenchido);

        atributos.remove(3);

        nome = new NomeAtributo("Valor Desconto");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("InteiroUnico");
        obrigatoriedade = false;
        resposta = new Resposta("");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(3, atributoPreenchido);

        formulario = new FormularioP(new NomeFormulario("Servico 1"), atributos);

        validacaoFormulario = new ValidacaoFormulario();

        resultado = validacaoFormulario.validarFormularioVisitor(formulario);

        System.out.println("Visitor: " + resultado + "\n");

        listener = validacaoFormulario.validarFormularioListener(formulario);

        System.out.println("Listener: " + listener + "\n");

    }

    private static void cenario3(){

        System.out.println("====== Cenários do Serviço 3 ======");

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Formulário do Serviço:");


        System.out.println("#1 - Código Postal inválido");
        List<AtributoPreenchido> atributos = new ArrayList<>();

        NomeAtributo nome = new NomeAtributo("Codigo Postal");
        Label label = new Label("irrelevante");
        DescricaoAtributo descricaoAtributo = new DescricaoAtributo("irrelevante");
        ExpressaoRegular expressaoRegular = new ExpressaoRegular("[0-9]{4}-[0-9]{3}");
        TipoDados tipoDados = new TipoDados("String");
        boolean obrigatoriedade = true;
        Resposta resposta = new Resposta("4470-66");

        AtributoPreenchido atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        FormularioP formulario = new FormularioP(new NomeFormulario("Servico 3"), atributos);

        ValidacaoFormulario validacaoFormulario = new ValidacaoFormulario();

        String resultado = validacaoFormulario.validarFormularioVisitor(formulario);

        System.out.println("Visitor: " + resultado + "\n");

        String listener = validacaoFormulario.validarFormularioListener(formulario);

        System.out.println("Listener: " + listener + "\n");

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("#2 - Código Postal válido");

        atributos = new ArrayList<>();

        nome = new NomeAtributo("Codigo Postal");
        expressaoRegular = new ExpressaoRegular("[0-9]{4}-[0-9]{3}");
        tipoDados = new TipoDados("String");
        obrigatoriedade = true;
        resposta = new Resposta("4470-666");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        formulario = new FormularioP(new NomeFormulario("Servico 3"), atributos);

        validacaoFormulario = new ValidacaoFormulario();

        resultado = validacaoFormulario.validarFormularioVisitor(formulario);

        System.out.println("Visitor: " + resultado + "\n");

        listener = validacaoFormulario.validarFormularioListener(formulario);

        System.out.println("Listener: " + listener + "\n");

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Formulário de Resolução:");
        System.out.println("#1 - Não responde");

        atributos = new ArrayList<>();

        nome = new NomeAtributo("Observacoes");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("String");
        obrigatoriedade = true;
        resposta = new Resposta("");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        formulario = new FormularioP(new NomeFormulario("Servico 3"), atributos);

        validacaoFormulario = new ValidacaoFormulario();

        resultado = validacaoFormulario.validarFormularioVisitor(formulario);

        System.out.println("Visitor: " + resultado + "\n");

        listener = validacaoFormulario.validarFormularioListener(formulario);

        System.out.println("Listener: " + listener + "\n");

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("#2 - Responde");

        atributos = new ArrayList<>();

        nome = new NomeAtributo("Observacoes");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("String");
        obrigatoriedade = true;
        resposta = new Resposta("observado");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        formulario = new FormularioP(new NomeFormulario("Servico 3"), atributos);

        validacaoFormulario = new ValidacaoFormulario();

        resultado = validacaoFormulario.validarFormularioVisitor(formulario);

        System.out.println("Visitor: " + resultado + "\n");

        listener = validacaoFormulario.validarFormularioListener(formulario);

        System.out.println("Listener: " + listener + "\n");

    }

    private static void cenario4(){
        System.out.println("====== Cenários do Serviço 4 ======");

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Formulário do Serviço:");


        System.out.println("#1 - Correto");
        List<AtributoPreenchido> atributos = new ArrayList<>();

        NomeAtributo nome = new NomeAtributo("Codigo Produto");
        Label label = new Label("irrelevante");
        DescricaoAtributo descricaoAtributo = new DescricaoAtributo("irrelevante");
        ExpressaoRegular expressaoRegular = new ExpressaoRegular("");
        TipoDados tipoDados = new TipoDados("Inteiro");
        boolean obrigatoriedade = true;
        Resposta resposta = new Resposta("218");

        AtributoPreenchido atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Quantidade Pretendida");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("Inteiro");
        obrigatoriedade = true;
        resposta = new Resposta("55.100000");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        nome = new NomeAtributo("Tipo de Cliente");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("String");
        obrigatoriedade = true;
        resposta = new Resposta("Europeu");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(atributoPreenchido);

        FormularioP formulario = new FormularioP(new NomeFormulario("Servico 4"), atributos);

        ValidacaoFormulario validacaoFormulario = new ValidacaoFormulario();

        String resultado = validacaoFormulario.validarFormularioVisitor(formulario);

        System.out.println("Visitor: " + resultado + "\n");

        String listener = validacaoFormulario.validarFormularioListener(formulario);

        System.out.println("Listener: " + listener + "\n");

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("#2 - Parte decimal não significativa quando o código é começa por 20 ou 21");

        atributos.remove(1);

        nome = new NomeAtributo("Quantidade Pretendida");
        expressaoRegular = new ExpressaoRegular("");
        tipoDados = new TipoDados("Inteiro");
        obrigatoriedade = true;
        resposta = new Resposta("55.00000");

        atributoPreenchido = new AtributoPreenchido(nome, label, descricaoAtributo, expressaoRegular, tipoDados, obrigatoriedade, resposta);

        atributos.add(1, atributoPreenchido);

        formulario = new FormularioP(new NomeFormulario("Servico 4"), atributos);

        validacaoFormulario = new ValidacaoFormulario();

        resultado = validacaoFormulario.validarFormularioVisitor(formulario);

        System.out.println("Visitor: " + resultado + "\n");

        listener = validacaoFormulario.validarFormularioListener(formulario);

        System.out.println("Listener: " + listener + "\n");
    }
}
