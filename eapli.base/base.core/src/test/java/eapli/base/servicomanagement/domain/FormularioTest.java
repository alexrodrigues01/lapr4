package eapli.base.servicomanagement.domain;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class FormularioTest extends TestCase {

    public void testAdicionarAtributo() {
        NomeFormulario nomeF = new NomeFormulario("nome");
        CodigoUnicoFormulario codigoUnico = new CodigoUnicoFormulario("codigo");

        NomeAtributo nome = new NomeAtributo("teste");
        Label label = new Label("teste");
        DescricaoAtributo descricao = new DescricaoAtributo("teste");
        ExpressaoRegular expr = new ExpressaoRegular("teste");
        TipoDados t = new TipoDados("dado");

        Atributo atributo = new Atributo(nome, label, descricao, expr, t, true);

        List<Atributo> atributos = new ArrayList<>();

        Formulario form = form = new Formulario(nomeF, codigoUnico, atributos);

        atributos.add(atributo);

        form.adicionarAtributo(atributo);

        assertEquals(atributos, form.atributos());
    }

    public void testVerificarPublicacao() {
        NomeFormulario nomeF = new NomeFormulario("nome");
        CodigoUnicoFormulario codigoUnico = new CodigoUnicoFormulario("codigo");

        NomeAtributo nome = new NomeAtributo("teste");
        Label label = new Label("teste");
        DescricaoAtributo descricao = new DescricaoAtributo("teste");
        ExpressaoRegular expr = new ExpressaoRegular("teste");
        TipoDados t = new TipoDados("dado");

        Atributo atributo = new Atributo(nome, label, descricao, expr, t, true);

        List<Atributo> atribt = new ArrayList<>();

        Formulario form = new Formulario(nomeF, codigoUnico, atribt);

        assertFalse(form.verificarPublicacao());

        form.adicionarAtributo(atributo);

        assertTrue(form.verificarPublicacao());
    }

    public void testTestEquals() {
        Formulario form = new Formulario();

        Formulario form2 = new Formulario();

        assertEquals(form, form2);

        NomeFormulario nomeF = new NomeFormulario("nome");
        CodigoUnicoFormulario codigoUnico = new CodigoUnicoFormulario("codigo");

        NomeAtributo nome = new NomeAtributo("teste");
        Label label = new Label("teste");
        DescricaoAtributo descricao = new DescricaoAtributo("teste");
        ExpressaoRegular expr = new ExpressaoRegular("teste");
        TipoDados t = new TipoDados("dado");

        Atributo atributo = new Atributo(nome, label, descricao, expr, t, true);

        List<Atributo> atribt = new ArrayList<>();

        form = new Formulario(nomeF, codigoUnico, atribt);

        form.adicionarAtributo(atributo);

        assertFalse(form.equals(form2));
    }
}