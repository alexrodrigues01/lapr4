package eapli.base.colaboradormanagement.domain;

import eapli.base.usermanagement.domain.BaseRoles;
import junit.framework.TestCase;

import java.time.LocalDate;

public class ColaboradorTest extends TestCase {

    public void testSameAs() {
        Colaborador colaborador1=new Colaborador("email","Joao","Joao Maria","Rua 1","933431903", LocalDate.of(1997,10,10),Colaborador.Funcao.Comercial,null);
        Colaborador colaborador2=new Colaborador("email","Joao","Joao Maria","Rua 1","933431903", LocalDate.of(1997,10,10),Colaborador.Funcao.Comercial,null);
        assertTrue(colaborador1.sameAs(colaborador2));
    }

    public void testTestToString() {
        Colaborador colaborador=new Colaborador("email","Joao","Joao Maria","Rua 1","933431903", LocalDate.of(1997,10,10), Colaborador.Funcao.Comercial,null);
        String expectedValue="Nome Completo:Joao Maria\nNome Comum:Joao\nLocal Residência: Rua 1\nTelemovel: 933431903\nData Nascimento: 1997-10-10\nFunção: Comercial\n"+"Email:email\n";
        System.out.println(expectedValue);
        assertEquals(expectedValue,colaborador.toString());
    }

    public void testEmail() {
        Colaborador colaborador=new Colaborador("email","Joao","Joao Maria","Rua 1","933431903", LocalDate.of(1997,10,10),Colaborador.Funcao.Comercial,null);
    assertEquals(colaborador.email(),"email");
    }

    public void testNomeCompleto() {
        Colaborador colaborador=new Colaborador("email","Joao","Joao Maria","Rua 1","933431903", LocalDate.of(1997,10,10),Colaborador.Funcao.Comercial,null);
        assertEquals(colaborador.nomeCompleto(),"Joao Maria");
    }

    public void testFirstName() {
        Colaborador colaborador=new Colaborador("email","Joao","Joao Maria","Rua 1","933431903", LocalDate.of(1997,10,10),Colaborador.Funcao.Comercial,null);
        assertEquals(colaborador.firstName(),"Joao");
    }

    public void testLastName() {
        Colaborador colaborador=new Colaborador("email","Joao","Joao Maria","Rua 1","933431903", LocalDate.of(1997,10,10),Colaborador.Funcao.Comercial,null);
        assertEquals(colaborador.lastName(),"Maria");
    }

    public void testGetFuncao() {
        Colaborador colaborador=new Colaborador("email","Joao","Joao Maria","Rua 1","933431903", LocalDate.of(1997,10,10),Colaborador.Funcao.Comercial,null);
        assertEquals(Colaborador.getFuncao("Comercial"),colaborador.funcao());
    }

    public void testFuncao() {
        Colaborador colaborador=new Colaborador("email","Joao","Joao Maria","Rua 1","933431903", LocalDate.of(1997,10,10),Colaborador.Funcao.Comercial,null);
        assertEquals(colaborador.funcao(), Colaborador.Funcao.Comercial);
    }

    public void testIdentity() {
        Colaborador colaborador=new Colaborador("email","Joao","Joao Maria","Rua 1","933431903", LocalDate.of(1997,10,10),Colaborador.Funcao.Comercial,null);
        assertEquals(colaborador.identity(),null);
    }

}