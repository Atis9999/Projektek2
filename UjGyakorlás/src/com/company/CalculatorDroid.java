package com.company;

public class CalculatorDroid {

    private int firstnumber;
    private  int secondnumber;

    public CalculatorDroid() {
    }

    public void addNumbers(){
        System.out.println("Két szám értéke:"+(firstnumber+secondnumber));
    }
    public void subtrackNumber(){
        System.out.println("Két szám kivonása egymásból:"+(firstnumber-secondnumber));
    }
    public void szorzás(){
        System.out.println("Két Szám szorzata:"+(firstnumber*secondnumber));
    }
    public void osztás(){
        System.out.println("Két szám osztása:"+(firstnumber/secondnumber));
    }
    public void maradéka(){
        System.out.println("Két szám maradéka:"+ (firstnumber%secondnumber));
    }
    public void setFirstnumber(int c){
        firstnumber= c;

    }
    public int getFirstnumber(){
        return firstnumber;
    }
    public void setSecondnumber(int c){
        secondnumber=c;
    }
    public int getSecondnumber(){
        return secondnumber;
    }




}
