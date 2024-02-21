package eapli.base.catalogomanagement.domain;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipaManagement.domain.Equipa;
import eapli.base.servicomanagement.domain.CodigoServico;
import eapli.base.servicomanagement.domain.Keyword;
import eapli.base.servicomanagement.domain.NomeServico;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.usermanagement.domain.BaseRoles;
import junit.framework.TestCase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CatalogoTest extends TestCase {

    public void testAdicionarServico() {
        Catalogo catalogo= new Catalogo("Icone","Descricao Completa","Descricao Simples","Titulo","Identificador Unico","Criterio acesso");

        NomeServico nome = new NomeServico("Nome");
        CodigoServico codigo = new CodigoServico("codigo");
        List<Keyword> keywords= new ArrayList<>();

        catalogo.adicionarServico(new Servico(nome, codigo, "descSimples","descCompleta", keywords));
        Servico expResult= new Servico(nome, codigo, "descSimples","descCompleta", keywords);
        assertEquals(expResult,catalogo.servicos().get(0));

    }

    public void testAdicionarObjetivo() {
        System.out.println("Teste adicionar objetivo ao catalogo");
        Catalogo catalogo= new Catalogo("Icone","Descricao Completa","Descricao Simples","Titulo","Identificador Unico","Criterio acesso");
        catalogo.adicionarObjetivo(new Objetivo(3,4,5,3));
        Objetivo expResult= new Objetivo(3,4,5,3);
        assertEquals(expResult,catalogo.objetivos().get(0));
    }


    public void testAdicionarColaborador() {
        System.out.println("Teste adicionar objetivo ao catalogo");
        Catalogo catalogo= new Catalogo("Icone","Descricao Completa","Descricao Simples","Titulo","Identificador Unico","Criterio acesso");
        catalogo.adicionarColaborador(new Colaborador( "email","Joao","Joao Maria","Rua 1","933431903", LocalDate.of(1997,10,10),Colaborador.Funcao.Comercial,null));
        Colaborador expResult=new Colaborador("email","Joao","Joao Maria","Rua 1","933431903", LocalDate.of(1997,10,10), Colaborador.Funcao.Comercial,null);
        assertEquals(expResult,catalogo.colaboradorResponsavel());
    }


//    public void testTestToString() {
//        System.out.println("Teste toString Catalogo");
//        Catalogo catalogo= new Catalogo("Icone","Descricao Completa","Descricao Simples","Titulo","Identificador Unico","Criterio acesso");
//        String expResult= "Catalogo: \n" +
//                "   ID: null\n" +
//                "   Identificador Único: Identificador Unico\n" +
//                "   Titulo:Titulo\n" +
//                "   Descricao Simples: Descricao Simples\n" +
//                "   Servicos: []\n" +
//                "   Objetivos: []\n\n";
//        assertEquals(expResult,catalogo.toString());
//    }


    public void testAdicionarEquipa() {
        System.out.println("Teste adicionar equipa ao catalago");
        Catalogo catalogo= new Catalogo("Icone","Descricao Completa","Descricao Simples","Titulo","Identificador Unico","Criterio acesso");
        catalogo.adicionarEquipa(new Equipa("equipa1","EQP","A equipa 1"));
        Equipa expResult= new Equipa("equipa1","EQP","A equipa 1");
        assertEquals(expResult,catalogo.equipas().get(0));

    }
}