package com.company;

public class Plane extends AbstraktVehicle implements VehicleTypeAware {


    public Plane() {
    }

    public Plane(long id, String name) {
        super(id, name);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.PLANE;
    }
}
