package com.company;

public class Vasember extends Bosszuállo implements Milliárodos{


    public Vasember(){
        super(150,true);
    }
    public void kutyutkészít(){
        this.szuperero+=(Math.random()*10);
    }

    public boolean megmentiaVilágot(){
        return this.szuperero > 1000 ? true : false;
    }


    @Override
    public boolean megmentiAVilágot() {
        return false;
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

    @Override
    public String toString() {
        return "Vasember{" + super.toString();
    }

}
