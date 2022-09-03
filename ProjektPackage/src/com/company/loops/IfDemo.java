package com.company.loops;

public class IfDemo {
    public IfDemo() {
    }

    public void ifdemo (){
        boolean trueValue=true;
        boolean falseValuse=false;

        if (trueValue){
            System.out.println("Ez biztosan le fog futni. 1");
        }
        if (falseValuse){
            System.out.println("Ez nem fog lefutni. 2");
        }
        if (trueValue){
            System.out.println("Ez biztosan le fog futni. 3");
        }else {
            System.out.println("Ez biztos nem fog lefutni. 4");
        }
        if (falseValuse){
            System.out.println("Ez nem fog lefutni. 5");
        }else{
            System.out.println("Ez biztosan lefog futni. 6");
        }
        if (falseValuse){
            System.out.println("Ez nem fog lefutni. 7");
        }else if (trueValue){
            System.out.println("Ez biztos le fog lefutni. 8");

        }else{
            System.out.println("Ez biztos nem fog lefutni. 9 ");

        }
        if(trueValue && falseValuse){
            System.out.println("Ez Biztos nem fog lefutni ");

        }
        if(trueValue || falseValuse){
            System.out.println("Ez Biztos le fog lefutni ");

        }

    }
}
