package eapli.base.catalogomanagement.domain;

import junit.framework.TestCase;

public class ObjetivoTest extends TestCase {

    public void testToString() {
        System.out.println("Teste toString objetivo");
        Objetivo objetivo= new Objetivo(3,4,5,3);
        String expResult= "Objetivo: \n" +
                "ID: null\n" +
                "Tempo Maximo de Aprovacao: 3.0\n" +
                "Tempo Medio de Aprovacao: 4.0\n" +
                "Tempo Maximo Aceitacao: 5.0\n" +
                "Tempo Medio Aceitacao: 3.0\n\n";
        assertEquals(expResult,objetivo.toString());
    }
}