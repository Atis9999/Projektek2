package com.company;

import java.util.ArrayList;

public class Képregény {

    public static ArrayList<Szuperhős> list = new ArrayList<Szuperhős>();

    public static void szereplők(Szuperhős input) {
        list.add(input);
    }

    public static void szuperhösök() {
        for (Szuperhős szuperhős : list) {
            System.out.println(szuperhős);
            System.out.println();


        }
    }

}






