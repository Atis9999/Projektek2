package com.company;

public class Egyenlet {

    int elsoSzam;
    String operator;
    int masodikSzam;

    Egyenlet(int elsoSzam, String operator, int masodikSzam) {
        this.elsoSzam = elsoSzam;
        this.operator = operator;
        this.masodikSzam = masodikSzam;
    }



    public String toString() {
        return "" + elsoSzam + " " + operator + " " + masodikSzam;
    }

}