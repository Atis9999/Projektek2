package com.company;

import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) {

        CalculatorDroid calculatorDroid = new CalculatorDroid();
        calculatorDroid.setFirstnumber(322);
        calculatorDroid.setSecondnumber(56);
        System.out.println(calculatorDroid.getFirstnumber());
        System.out.println(calculatorDroid.getSecondnumber());
        calculatorDroid.addNumbers();
        calculatorDroid.subtrackNumber();
        calculatorDroid.szorzás();
        calculatorDroid.osztás();
        calculatorDroid.maradéka();





    }
}
