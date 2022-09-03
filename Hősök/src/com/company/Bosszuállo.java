package com.company;

public abstract class Bosszuállo implements Szuperhős {

    protected double szuperero;
    protected boolean VaneGyengesége;

    public Bosszuállo(double szuperero, boolean vaneGyengesége) {
        this.szuperero = szuperero;
        this.VaneGyengesége = vaneGyengesége;
    }

    public abstract boolean megmentiAVilágot();

    public boolean legyőzie(Szuperhős o){
        if (o instanceof Batman){
            return true;
        }else if (o instanceof Bosszuállo){
            return (((Bosszuállo)o) .isVaneGyengesége() && o.mekkoraAzEreje()<this.szuperero) ? true :false;
        }else {
            return false;
        }
    }

    public double getSzuperero() {
        return szuperero;
    }

    public void setSzuperero(double szuperero) {
        this.szuperero = szuperero;
    }

    public boolean isVaneGyengesége() {
        return VaneGyengesége;
    }

    public void setVaneGyengesége(boolean vaneGyengesége) {
        VaneGyengesége = vaneGyengesége;
    }

    @Override
    public String toString() {
        return "Bosszuállo{" +
                "szuperero=" + szuperero +
                ", VaneGyengesége=" + VaneGyengesége +
                '}';
    }

}
