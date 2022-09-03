package com.company.loops;

public class FaktorialExemple {

    public void faktorialdemo (int number){
        int result =1;
        for (int i = 1; i <= number; i++) {
            result=result*i;

        }
        System.out.println("Result értéke:"+result);
    }
    public int faktorialDemoRecursion (int number){
        if (number==1){
            return 1;
        }
        return (number* faktorialDemoRecursion(number -1));
    }

}
