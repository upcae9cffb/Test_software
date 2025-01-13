package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class GrafTest {
    @Test
    public void testPrazdnyGraf() {
        System.out.println("test jestli jde vytvorit prazdny graf:");
        Graf graf = new Graf();
        assertNotNull(graf);
    }

    @Test
    public void testGrafSJednimVrcholem() {
        System.out.println("test jestli je mozne vytvorit graf s jednim vrcholem:");
        Graf graf = new Graf();
        Vrchol a = graf.dejVrchol("A");
        assertNotNull(a);
        assertEquals("A", a.dejJmeno());
    }

    @Test
    public void testGrafSJednouHranou() {
        System.out.println("test jestli je mozne vytvorit graf s jednou hranou:");
        Graf graf = new Graf();
        Vrchol a = graf.dejVrchol("A");
        Vrchol b = graf.dejVrchol("B");
        a.pridejSouseda(b);
        assertTrue(a.jeSousedem(b));
        assertFalse(b.jeSousedem(a));
    }

    @Test
    public void testSousedstvi() {
        System.out.println("test jestli je sousedstvi rozvrzeno spravne:");
        Graf graf = new Graf();
        Vrchol a = graf.dejVrchol("A");
        Vrchol b = graf.dejVrchol("B");
        Vrchol c = graf.dejVrchol("C");
        a.pridejSouseda(b);
        b.pridejSouseda(c);

        assertTrue(a.jeSousedem(b));
        assertTrue(b.jeSousedem(c));
        assertFalse(a.jeSousedem(c));
    }
}
