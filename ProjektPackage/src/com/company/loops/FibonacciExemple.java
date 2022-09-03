package com.company.loops;

public class FibonacciExemple {

    private int recursionFirstnumber= 0;
    private int recursionSecondnumber=1;
    private int recursionThirdNumber;


    public void fibonacciDemo(int number){
        int firstnumber =0;
        int secondnumber =1;
        int thirdNumber;
        System.out.println("Fibonacci példa:");
        System.out.print(firstnumber+", "+secondnumber);
        for (int i = 2; i <number ; i++) {
            thirdNumber=firstnumber+secondnumber;
            System.out.print(", "+thirdNumber);
            firstnumber=secondnumber;
            secondnumber=thirdNumber;

        }
    }
    public void fibonacciDemoWithRecursion(int number){
        if (number>0){
            recursionThirdNumber=recursionFirstnumber+recursionSecondnumber;
            recursionFirstnumber=recursionSecondnumber;
            recursionSecondnumber=recursionThirdNumber;
            System.out.print(", "+recursionThirdNumber);
            fibonacciDemoWithRecursion(number-1);

        }

    }

}
