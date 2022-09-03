package com.company;

public class Car extends AbstraktVehicle implements VehicleTypeAware{

    private int doorNumbers;

    public Car (){

    }

    public Car(long id, String name, int doorNumbers) {
        super(id, name);
        this.doorNumbers = doorNumbers;
    }

    public int getDoorNumbers() {
        return doorNumbers;
    }

    public void setDoorNumbers(int doorNumbers) {
        this.doorNumbers = doorNumbers;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }
}
