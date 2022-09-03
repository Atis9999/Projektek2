package com.company;

public class Felfedezes {

    String ev;
    String nev;
    String vegyjel;
    int rendszam;
    String felfedezoNeve;

    public Felfedezes(String ev, String nev, String vegyjel, int rendszam, String felfedezoNeve) {
        this.ev = ev;
        this.nev = nev;
        this.vegyjel = vegyjel;
        this.rendszam = rendszam;
        this.felfedezoNeve = felfedezoNeve;
    }


    public boolean vegyjelEquals(String s) {
        if(this.vegyjel.equalsIgnoreCase(s)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Felfedezes{" +
                "ev='" + ev + '\'' +
                ", nev='" + nev + '\'' +
                ", vegyjel='" + vegyjel + '\'' +
                ", rendszam=" + rendszam +
                ", felfedezoNeve='" + felfedezoNeve + '\'' +
                '}';
    }
}