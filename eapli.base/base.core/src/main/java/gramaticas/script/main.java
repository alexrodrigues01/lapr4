package gramaticas.script;

import eapli.base.servicomanagement.domain.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.util.ArrayList;



public class main {

    public static void main(String[] args) throws IOException {
        GramaticaScriptLexer lexer = new GramaticaScriptLexer(CharStreams.fromString("-ATRIBUIR -\"total\" -MUL P_1 -FICHEIRO \"produto.xml\" -CONSULTAR P_2 \"preco\"\n" +
                "-ATRIBUIR -\"desconto\" 0\n" +
                "-SE -\"total\" -MAIOR 5 -ATRIBUIR -\"desconto\" 1\n" +
                "-ATRIBUIR -\"desconto\" -DIV -\"desconto\" 100\n" +
                "-ATRIBUIR -\"desconto\" -MUL -\"desconto\" -\"total\"\n" +
                "-ATRIBUIR -\"totalDesconto\" -SUB -\"total\" -\"desconto\"\n" +
                "\n" +
                "\n" +
                "-SE P_5 -MESMO \"NACIONAL\"\n" +
                "-REMETENTE \"lapr4g3@gmail.com\"\n" +
                "-PASSWORD \"pessego2001 \" \n" +
                "-ASSUNTO \"Pedido atualizacao\" \n" +
                "-CORPO \"Boa tarde, #Valor total antes do desconto: ~~(-\"total\").#Valor desconto: ~~(-\"desconto\").#Valor total com desconto: ~~(-\"totalDesconto\").##Cumprimentos,#Lapr4\" \n" +
                "-DESTINATARIO P_3\n" +
                "\n" +
                "-SE P_5 -MESMO \"EUROPEU\"\n" +
                "-REMETENTE \"lapr4g3@gmail.com\"\n" +
                "-PASSWORD \"pessego2001 \" \n" +
                "-ASSUNTO \"Order Update\" \n" +
                "-CORPO \"Good afternoon, #Total amount before discount: ~~(-\"total\").#Discount amount: ~~(-\"desconto\").#Total amount with discount: ~~(-\"totalDesconto\").##Best Regards ,#Lapr4\" \n" +
                "-DESTINATARIO P_3\n" +
                "\n" +
                "-SE P_5 -MESMO \"MUNDO\"\n" +
                "-REMETENTE \"lapr4g3@gmail.com\"\n" +
                "-PASSWORD \"pessego2001 \" \n" +
                "-ASSUNTO \"Order Update\" \n" +
                "-CORPO \"Good afternoon, #Total amount before discount: ~~(-\"total\").#Discount amount: ~~(-\"desconto\").#Total amount with discount: ~~(-\"totalDesconto\").##Best Regards ,#Lapr4\" \n" +
                "-DESTINATARIO P_3"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GramaticaScriptParser parser = new GramaticaScriptParser(tokens);
        ParseTree tree = parser.start(); // parse
        GramaticaScriptVisitorImplement eval = new GramaticaScriptVisitorImplement(true);
        ArrayList<AtributoPreenchido> atributoPreenchidos = new ArrayList<>();
        atributoPreenchidos.add(new AtributoPreenchido(new NomeAtributo("Valor "),null,null,null,new TipoDados("Inteiro"),false,new Resposta("10")));
        atributoPreenchidos.add(new AtributoPreenchido(new NomeAtributo("Carro"),null,null,null,new TipoDados("Inteiro"),false,new Resposta("1001")));
        atributoPreenchidos.add(new AtributoPreenchido(new NomeAtributo("Email"),null,null,null,new TipoDados("Inteiro"),false,new Resposta("1191042@isep.ipp.pt")));
        atributoPreenchidos.add(new AtributoPreenchido(new NomeAtributo("Nome"),null,null,null,new TipoDados("Inteiro"),false,new Resposta("Rui Pedro")));
        atributoPreenchidos.add(new AtributoPreenchido(new NomeAtributo("Nome"),null,null,null,new TipoDados("Inteiro"),false,new Resposta("Europeu")));
        FormularioP formularioP=new FormularioP(new NomeFormulario("Nome"),atributoPreenchidos);
        eval.setFormularioP(formularioP);
        GramaticaScriptListenerImplement testeListenerImplement = new GramaticaScriptListenerImplement(true);
        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        testeListenerImplement.setFormularioP(formularioP);
//        parseTreeWalker.walk(testeListenerImplement,tree);
        eval.visit(tree);
    }

}
