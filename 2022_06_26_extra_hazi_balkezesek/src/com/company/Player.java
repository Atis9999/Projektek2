package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Player {

    String name;
    Date firstPlay;
    Date lastPlay;
    int weightInPound;
    int heightInInch;

    SimpleDateFormat sdf;

    public Player(String name, String firstPlay, String lastPlay, int weightInPound, int heightInInch) {
        this.name = name;
        this.firstPlay = inputStringToDate(firstPlay);
        this.lastPlay = inputStringToDate(lastPlay);
        this.weightInPound = weightInPound;
        this.heightInInch = heightInInch;
    }

    public Date inputStringToDate(String inputDateAsString) {
        Date date = null;
        try {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(inputDateAsString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public String datumFormazas(Date datum) {
        sdf = new SimpleDateFormat("yyyy.MM.dd");
        return sdf.format(datum);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", firstPlay=" + datumFormazas(firstPlay) +
                ", lastPlay=" + datumFormazas(lastPlay) +
                ", weightInPound=" + weightInPound +
                ", heightInInch=" + heightInInch +
                '}';
    }
}
