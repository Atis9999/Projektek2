package com.company.loops;

public class LoopDemo {
    public LoopDemo() {
    }

    public void forloopdemo (int size){
        for (int j=0;j<size;j++){
            System.out.println(j+"Futása for  ciklussal");
        }
    }
    public void whileloopdemo (int size){
        int j=0;
        while (j <size){
            System.out.println(j+"futása while ciklussal.");
            //j++;
            j+=1;
        }

    }


}
