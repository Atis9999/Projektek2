package com.company.loops;

public class SwitchDemo {

    public SwitchDemo() {
    }

    public  void switchDemo (String value){
        switch (value){
            case "alma":
                System.out.println("Almafa");
                break;
            case "körte":
                System.out.println("Körtefa");
                break;
            default:
                System.out.println("Semmise");
        }
    }
}
