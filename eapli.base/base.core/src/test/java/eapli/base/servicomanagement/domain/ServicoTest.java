package eapli.base.servicomanagement.domain;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class ServicoTest extends TestCase {


    public void testDefinirFluxoTarefa() {
        NomeServico nome = new NomeServico("Nome");
        CodigoServico codigo = new CodigoServico("codigo");
        List<Keyword> keywords= new ArrayList<>();
        Servico servico = new Servico(nome, codigo, "descSimples","descCompleta", keywords);

        FluxoTarefa fluxo = new FluxoTarefa();

        servico.definirFluxoTarefa(fluxo);
        assertEquals(fluxo, servico.fluxoTarefa());
    }

    public void testAdicionarAtributoFormulario() {
        NomeServico nome = new NomeServico("Nome");
        CodigoServico codigo = new CodigoServico("codigo");
        List<Keyword> keywords= new ArrayList<>();

        Servico servico = new Servico(nome, codigo, "descSimples","descCompleta", keywords);

        List<Atributo> atributos = new ArrayList<>();

        NomeFormulario nomeF = new NomeFormulario("nome");
        CodigoUnicoFormulario codigoUnico = new CodigoUnicoFormulario("codigo");

        Formulario form = new Formulario(nomeF, codigoUnico, atributos);

        NomeAtributo nomeA = new NomeAtributo("teste");
        Label label = new Label("teste");
        DescricaoAtributo descricao = new DescricaoAtributo("teste");
        ExpressaoRegular expr = new ExpressaoRegular("teste");
        TipoDados t = new TipoDados("dado");

        Atributo atributo = new Atributo(nomeA, label, descricao, expr, t, true);

        servico.definirFormulario(form);
        servico.adicionarAtributoFormulario(atributo);

        atributos.add(atributo);

        assertEquals(servico.formulario(), form);
    }

    public void testDefinirFormulario() {
        NomeServico nome = new NomeServico("Nome");
        CodigoServico codigo = new CodigoServico("codigo");
        List<Keyword> keywords= new ArrayList<>();

        Servico servico = new Servico(nome, codigo, "descSimples","descCompleta", keywords);

        List<Atributo> atributos = new ArrayList<>();

        NomeFormulario nomeF = new NomeFormulario("nome");
        CodigoUnicoFormulario codigoUnico = new CodigoUnicoFormulario("codigo");

        Formulario form = new Formulario(nomeF, codigoUnico, atributos);

        servico.definirFormulario(form);

        assertEquals(servico.formulario(), form);
    }

    public void testVerificarPublicacao() {
        NomeServico nome = new NomeServico("Nome");
        CodigoServico codigo = new CodigoServico("codigo");
        List<Keyword> keywords= new ArrayList<>();

        Servico servico = new Servico(nome, codigo, "descSimples","descCompleta", keywords);

        assertTrue(servico.verificarPublicacao());
    }
//
//    public void testTestToString() {
//        NomeServico nome = new NomeServico("Nome");
//        CodigoServico codigo = new CodigoServico("codigo");
//        List<Keyword> keywords= new ArrayList<>();
//
//        Servico servico = new Servico(nome, codigo, "descSimples","descCompleta", keywords);
//
//        assertEquals("codigo | Nome : Serviço ainda não disponível.", servico.toString());
//    }
}