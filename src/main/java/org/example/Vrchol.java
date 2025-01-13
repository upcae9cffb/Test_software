package org.example;

import java.io.*;
import java.util.*;


class Vrchol {
    private String jmeno;
    private Set<Vrchol> sousede;

    Vrchol(String jmeno) {
        this.jmeno = jmeno;
        this.sousede = new HashSet<>();
    }

    public String dejJmeno() {
        return jmeno;
    }

    public Set<Vrchol> vratSouseda() {
        return sousede;
    }

    public void pridejSouseda(Vrchol v) {
        sousede.add(v);
    }

    public boolean jeSousedem(Vrchol v) {
        return sousede.contains(v);
    }

    public boolean existujeCestaDo(Vrchol v) {
        Set<Vrchol> navstivene = new HashSet<>();
        return existujeCestaDo(v, navstivene);
    }

    private boolean existujeCestaDo(Vrchol v, Set<Vrchol> navstivene) {
        if (this.equals(v)) {
            return true;
        }
        navstivene.add(this);
        for (Vrchol soused : sousede) {
            if (!navstivene.contains(soused) && soused.existujeCestaDo(v, navstivene)) {
                return true;
            }
        }
        return false;
    }
}

