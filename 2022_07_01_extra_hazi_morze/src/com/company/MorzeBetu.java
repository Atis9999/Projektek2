package com.company;

public class MorzeBetu {

    char betu;
    String betuMorzeJele;

    public MorzeBetu(char betu, String betuMorzeJele) {
        this.betu = betu;
        this.betuMorzeJele = betuMorzeJele;
    }

    @Override
    public String toString() {
        return "MorzeBetu{ betu = " + betu + ", betuMorzeJele = " + betuMorzeJele + "}";
    }
}
