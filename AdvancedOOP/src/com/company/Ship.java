package com.company;

public class Ship extends AbstraktVehicle implements VehicleTypeAware {

    public Ship() {
    }

    public Ship(long id, String name) {
        super(id, name);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.SHIP;
    }
}
