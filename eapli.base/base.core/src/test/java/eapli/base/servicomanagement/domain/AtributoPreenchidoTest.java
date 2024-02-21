package eapli.base.servicomanagement.domain;

import junit.framework.TestCase;

public class AtributoPreenchidoTest extends TestCase {

    public void testInfo() {
        String expResult = "Codigo Postal;[0-9]{4}-[0-9]{3};String;4470-666;true;";

        NomeAtributo nome = new NomeAtributo("Codigo Postal");
        Label label = new Label("irrelevante");
        DescricaoAtributo desc = new DescricaoAtributo("irrelevante");
        ExpressaoRegular expressaoRegular = new ExpressaoRegular("[0-9]{4}-[0-9]{3}");
        TipoDados tipo = new TipoDados("String");
        Resposta resposta = new Resposta("4470-666");

        AtributoPreenchido atributo = new AtributoPreenchido(nome, label, desc, expressaoRegular, tipo, true, resposta);

        assertEquals(expResult, atributo.info());
    }
}