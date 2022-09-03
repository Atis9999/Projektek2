package com.company.repositori;

import com.company.data.TransporterShip;

import java.util.ArrayList;

public class TransporterShipRepositori {

    private ArrayList<TransporterShip> list = new ArrayList<>();

    public TransporterShipRepositori() {
    }

    public void add(TransporterShip transporterShip) {
        list.add(transporterShip);
    }

    public void printAll() {
        for (TransporterShip ship : list) {
            System.out.print(" Azonosító Értéke:" + ship.getId());
            System.out.print(" Név Értéke:" + ship.getName());
            System.out.print(" Tipus  Értéke:" + ship.getType());
            System.out.print(" Kapacitás Értéke:" + ship.getCapacity());
            System.out.println();
        }
    }
    public  void remove (Long id){
        boolean hasThatId=false;
        for (TransporterShip ship:list) {
            if (ship.getId()==id){
                list.remove(ship);
                hasThatId=true;
                break;

            }
            if (!hasThatId){
                System.out.println("Nincs ez az azonosító.");
            }

        }
    }
    public  void printOnenamebyId (Long id){
        boolean hasThatId=false;
        for (TransporterShip ship:list) {
            if (ship.getId()==id){
                System.out.println("Az objektum neve:" + ship.getName());
                hasThatId=true;
                break;

            }
            if (!hasThatId){
                System.out.println("Nincs ez az azonosító.");
            }

        }
    }
}

