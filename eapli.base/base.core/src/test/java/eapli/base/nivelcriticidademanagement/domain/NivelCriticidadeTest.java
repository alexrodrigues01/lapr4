package eapli.base.nivelcriticidademanagement.domain;

import eapli.base.catalogomanagement.domain.Objetivo;
import junit.framework.TestCase;

public class NivelCriticidadeTest extends TestCase {

    public void testDefinirObjetivo() {
        NivelCriticidade nivel = new NivelCriticidade(1, "cor","label");

        Objetivo obj = new Objetivo(100, 100, 100, 100);

        nivel.definirObjetivo(obj);

        assertTrue(nivel.objetivo().get(0).equals(obj));
    }

    public void testObjetivo() {
        NivelCriticidade nivel = new NivelCriticidade(1, "cor","label");

        Objetivo obj = new Objetivo(100, 100, 100, 100);

        nivel.definirObjetivo(obj);

        assertTrue(nivel.objetivo().get(0).equals(obj));
    }
}