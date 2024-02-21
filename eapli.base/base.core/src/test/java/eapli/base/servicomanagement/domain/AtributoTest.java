package eapli.base.servicomanagement.domain;

import junit.framework.TestCase;

public class AtributoTest extends TestCase {

    public void testTestEquals() {
        NomeAtributo nome = new NomeAtributo("teste");
        Label label = new Label("teste");
        DescricaoAtributo descricao = new DescricaoAtributo("teste");
        ExpressaoRegular expr = new ExpressaoRegular("teste");
        TipoDados t = new TipoDados("dado");

        Atributo exp = new Atributo(nome, label, descricao, expr, t, true);

        Atributo act = new Atributo(nome, label, descricao, expr, t, true);

        assertTrue(exp.equals(act));

        nome = new NomeAtributo("sheeesh");

        act = new Atributo(nome, label, descricao, expr, t, true);

        assertFalse(exp.equals(act));
    }

    public void testTestToString() {
        NomeAtributo nome = new NomeAtributo("teste");
        Label label = new Label("teste");
        DescricaoAtributo descricao = new DescricaoAtributo("teste");
        ExpressaoRegular expr = new ExpressaoRegular("teste");
        TipoDados t = new TipoDados("dado");

        Atributo exp = new Atributo(nome, label, descricao, expr, t, true);

        assertEquals("teste | teste | Tipo de dados: dado\n" +
                "Descrição: teste", exp.toString());
    }
}