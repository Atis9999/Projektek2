package com.company;

public class Main {

    public static void main(String[] args) {
        Ship ship = new Ship(5L,"UnShinkalbe");
        System.out.println("Hajó neve: " + ship.getName());
        ship.getName();

        Car car = new Car();
        car.setName("Audi");
        car.setId(4L);
        car.setDoorNumbers(5);
        System.out.println("Az autó neve: " +car.getName());
        System.out.println("Az ajtók száma: " +car.getDoorNumbers());
        System.out.println("Az autó ID-je: " +car.getId());

        Plane plane = new Plane(10L,"HidegVágó");
        plane.getId();
        plane.getName();
        System.out.println("A repülő neve:" + plane.getName()+" "+ "A repülő azonosítója: " +plane.getId());

        switch (plane.getType()){
            case SHIP:
                System.out.println("Én egy hajó vagyok");
                break;
            case CAR:
                System.out.println("Én egy autó vagyok");
                break;
            case PLANE:
                System.out.println("Én egy repülő vagyok");
                 break;
        }




    }
}
