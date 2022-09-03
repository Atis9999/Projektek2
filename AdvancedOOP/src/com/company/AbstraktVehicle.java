package com.company;

public abstract class AbstraktVehicle {

    private long id;
    public String name;

    public AbstraktVehicle() {
    }

    public AbstraktVehicle(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
