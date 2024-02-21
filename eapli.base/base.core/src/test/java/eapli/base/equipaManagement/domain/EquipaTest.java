package eapli.base.equipaManagement.domain;

import eapli.base.colaboradormanagement.domain.Colaborador;
import junit.framework.TestCase;
import java.time.LocalDate;

public class EquipaTest extends TestCase {

    public void testAdicionarTipoEquipa() {
        System.out.println("Teste adicionar tipo de equipa");
        Equipa equipa = new Equipa("equipa1","EQP","A equipa 1");
        equipa.adicionarTipoEquipa(new TipoEquipa(1));
        TipoEquipa expResult=new TipoEquipa(1);
        assertEquals(expResult,equipa.getTipoEquipa());
    }

    public void testAdicionarColaborador() {
        System.out.println("Teste adicionar colaborador à equipa");
        Equipa equipa = new Equipa("equipa1","EQP","A equipa 1");
        equipa.adicionarColaborador(new Colaborador( "email","Joao","Joao Maria","Rua 1","933431903", LocalDate.of(1997,10,10), null,null));
        Colaborador expResult=new Colaborador("email","Joao","Joao Maria","Rua 1","933431903", LocalDate.of(1997,10,10),null,null);
        assertEquals(expResult,equipa.getColaboradores().get(0));
    }
}