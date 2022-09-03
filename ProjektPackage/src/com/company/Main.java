package com.company;

import com.company.data.TransporterShip;
import com.company.loops.*;
import com.company.repositori.TransporterShipRepositori;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        LoopDemo loopDemo = new LoopDemo();
        loopDemo.forloopdemo(10);
        loopDemo.whileloopdemo(7);
        IfDemo ifDemo = new IfDemo();
        ifDemo.ifdemo();
        SwitchDemo switchDemo = new SwitchDemo();
        switchDemo.switchDemo("alma");
        String value ="körte";
        switchDemo.switchDemo(value);
        String defaultvalue = new String("default");
        switchDemo.switchDemo(defaultvalue);
        FaktorialExemple faktorialExemple = new FaktorialExemple();
        faktorialExemple.faktorialdemo(6);
        System.out.println("Rekurzió értéke:"+faktorialExemple.faktorialDemoRecursion(6));
        FibonacciExemple fibonacciExemple = new FibonacciExemple();
        fibonacciExemple.fibonacciDemo(10);
        System.out.println();
        System.out.print("0, 1");
        fibonacciExemple.fibonacciDemoWithRecursion(10);

        String [] fruits = {"Apple","Watermelon","pearl"};
        System.out.println();
        System.out.print("Az első elemét szeretném kiirni:" + fruits[0]+","+fruits[1]);
        System.out.println();
        System.out.print("A Gyümölcsök hossza:"+fruits.length);
        System.out.println();
        System.out.print("Az Array utolsó indexe:"+(fruits.length-1));
        System.out.println();
        System.out.println("Az array utolsó eleme:"+fruits[(fruits.length-1)]);


        for (int i=0;i<fruits.length;i++){
            System.out.println("Az" +i+ "indexű elem értéke" +fruits[i]);
        }

        System.out.println();
        int [] numberarray={1,2,3,4,5,};
        for (int i = 0; i < numberarray.length; i++) {
            System.out.println("Az" +i+ "indexű elem értéke" +numberarray[i]);

        }
        Integer[] numberArraynotPrimitive= {1,2,3,4,5,6,7};
        for (int i = 0; i < numberArraynotPrimitive.length; i++) {
            System.out.println("Az" +i+ "indexű elem értéke:" + numberArraynotPrimitive [i]);

        }
        System.out.println();
        ArrayList<String> list = new ArrayList<String>();
        list.add("apple");
        list.add("Pearl");
        list.add("Watermelon");
        list.add("cherry");

        list.remove("cherry");

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Az" + i + "indexü elem értéke: (ArrayList): " + list.get(i));

        }
        System.out.println();
        ArrayList<Integer> numberlist = new ArrayList<Integer>();
        numberlist.add(1);
        numberlist.add(2);
        numberlist.add(3);
        numberlist.add(4);
        numberlist.add(5);

        numberlist.remove(1);
        for (int i = 0; i < numberlist.size(); i++) {
            System.out.println("Az" + i + "indexü eleme szamokkal:" + numberlist.get(i));

        }
        TransporterShipRepositori repositori=new TransporterShipRepositori();
        repositori.add(new TransporterShip(10L,"Spartacus","Type2",4));

        TransporterShip ship = new TransporterShip();
        ship.setId(11L);
        ship.setName("Lucas");
        ship.setType("Type1");
        ship.setCapacity(18);
        repositori.add(ship);
        repositori.printAll();
        repositori.remove(11L);
        repositori.printAll();
        repositori.printOnenamebyId(10L);
        repositori.printAll();













    }
}
