package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<String>fruits = new HashSet<>();
        fruits.add("apple");
        fruits.add("orange");
        System.out.println(fruits.size());

        Set<Droid>droidSet =new HashSet<>();
        droidSet.add(new Droid(5L,"Laci"));
        droidSet.add(new Droid(11L,"Marci"));
        droidSet.add(new Droid(2L,"Dezső"));
        droidSet.add(new Droid(6L,"Kóra"));
        droidSet.add(new Droid(6L,"Kóra"));

        System.out.println(droidSet.size());


    }
}
