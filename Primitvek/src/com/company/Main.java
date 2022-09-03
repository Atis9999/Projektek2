package com.company;

public class Main {

    public static void main(String[] args) {

        int primitveValue =5;
        Integer objectValue= null;
        System.out.println("Primitve value: " +primitveValue);
        System.out.println("Objekt Value: " + objectValue);
        objectValue=primitveValue+8;
        System.out.println("object value: "+objectValue);
        primitveValue=objectValue;
        System.out.println("Primitve value: " + primitveValue);

        long primitvelongvalue=4L;
        Long objetValueLong =5L;
        objetValueLong=primitvelongvalue+primitveValue;
        System.out.println("ObjektLongValue: " +objetValueLong);


    }
}
