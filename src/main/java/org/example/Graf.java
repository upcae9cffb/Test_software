package org.example;
import java.io.*;
import java.util.*;

public class Graf {
    private Map<String, Vrchol> vrcholy;

    public Graf() {
        this.vrcholy = new HashMap<>();
    }

    public Graf(String jmenoSouboru) throws IOException {
        this();
        try (BufferedReader reader = new BufferedReader(new FileReader(jmenoSouboru))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" -> ");
                if (parts.length == 2) {
                    String jmeno1 = parts[0];
                    String jmeno2 = parts[1];
                    Vrchol v1 = dejVrchol(jmeno1);
                    Vrchol v2 = dejVrchol(jmeno2);
                    v1.pridejSouseda(v2);
                }
            }
        }
    }

    public Vrchol dejVrchol(String jmeno) {
        return vrcholy.computeIfAbsent(jmeno, Vrchol::new);
    }

    public void ulozGrafDoSouboru(String jmenoSouboru) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(jmenoSouboru))) {
            for (Vrchol v : vrcholy.values()) {
                for (Vrchol soused : v.vratSouseda()) {
                    writer.write(v.dejJmeno() + " -> " + soused.dejJmeno());
                    writer.newLine();
                }
            }
        }
    }
}
