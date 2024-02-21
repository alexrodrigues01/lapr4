package eapli.base.servicomanagement.domain;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class FormularioPTest extends TestCase {

    public void testInfoValidacao() {
        String expResult = "Codigo Produto;;Inteiro;218;true;Quantidade pretendida;;Inteiro;55.100000;true;Tipo de Cliente;;String;Europeu;true;";

        List<AtributoPreenchido> atributos = new ArrayList<>();

        NomeAtributo nome = new NomeAtributo("Codigo Produto");
        Label label = new Label("irrelevante");
        DescricaoAtributo desc = new DescricaoAtributo("irrelevante");
        ExpressaoRegular expressaoRegular = new ExpressaoRegular("");
        TipoDados tipo = new TipoDados("Inteiro");
        Resposta resposta = new Resposta("218");

        AtributoPreenchido atributo = new AtributoPreenchido(nome, label, desc, expressaoRegular, tipo, true, resposta);

        atributos.add(atributo);

        nome = new NomeAtributo("Quantidade pretendida");
        label = new Label("irrelevante");
        desc = new DescricaoAtributo("irrelevante");
        expressaoRegular = new ExpressaoRegular("");
        tipo = new TipoDados("Inteiro");
        resposta = new Resposta("55.100000");

        atributo = new AtributoPreenchido(nome, label, desc, expressaoRegular, tipo, true, resposta);

        atributos.add(atributo);

        nome = new NomeAtributo("Tipo de Cliente");
        label = new Label("irrelevante");
        desc = new DescricaoAtributo("irrelevante");
        expressaoRegular = new ExpressaoRegular("");
        tipo = new TipoDados("String");
        resposta = new Resposta("Europeu");

        atributo = new AtributoPreenchido(nome, label, desc, expressaoRegular, tipo, true, resposta);

        atributos.add(atributo);

        NomeFormulario nomeF = new NomeFormulario("irrelevante");

        FormularioP formulario = new FormularioP(nomeF, atributos);

        assertEquals(expResult, formulario.infoValidacao());
    }
}