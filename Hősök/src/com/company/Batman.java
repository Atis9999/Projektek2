package com.company;

public class Batman implements Szuperhős, Milliárodos {

    public double leleményesség;

    public Batman (){
        this.leleményesség=100;
    }
    public boolean legyőzie (Szuperhős o){
        return o.mekkoraAzEreje()< this.leleményesség ? true:false;
    }
    public double mekkoraAzereje(){
        return  this.leleményesség*2;
    }
    public void kutyutkészit(){
        this.leleményesség+=50;
    }

    @Override
    public String toString() {
        return "Batman{" +
                "leleményesség=" + leleményesség +
                '}';
    }

    @Override
    public void kutyukészít() {

    }

    @Override
    public boolean legyőziE(Szuperhős o) {
        return false;
    }

    @Override
    public double mekkoraAzEreje() {
        return 0;
    }

}
