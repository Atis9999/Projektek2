package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>();
        map.put("one",1);
        map.put("Two",2);
        System.out.println(map.get("one"));

        Map<String,Cat> catMap= new HashMap<>();

        Cat redcat =new Cat();
        redcat.setColor("red");
        redcat.setName("RedCat");
        catMap.put("RedCat",redcat);
        System.out.println(catMap.get("RedCat").getColor());

    }
}
