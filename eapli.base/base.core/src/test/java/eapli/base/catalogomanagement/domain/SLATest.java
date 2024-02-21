package eapli.base.catalogomanagement.domain;

import junit.framework.TestCase;

public class SLATest extends TestCase {


    public void testTestToString() {
        System.out.println("Teste toString SLA");
        SLA contrato= new SLA("Contrato1");
        String expResult= "Contrato SLA: \n" +
                "ID: null\n" +
                "Descricao: Contrato1\n\n";
        assertEquals(expResult,contrato.toString());
    }
}