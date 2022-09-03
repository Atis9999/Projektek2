package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Eredmeny {

    String hazai;
    String idegen;
    int hazaiPont;
    int idegenPont;
    String helyszin;
    Date idopont;

    SimpleDateFormat sdf;

    public Eredmeny(String hazai, String idegen, int hazaiPont,
                    int idegenPont, String helyszin, String idopont) {

        this.hazai = hazai;
        this.idegen = idegen;
        this.hazaiPont = hazaiPont;
        this.idegenPont = idegenPont;
        this.helyszin = helyszin;
        this.idopont = inputStringToDate(idopont);

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
        return "Eredmeny{" +
                "hazai='" + hazai + '\'' +
                ", idegen='" + idegen + '\'' +
                ", hazaiPont=" + hazaiPont +
                ", idegenPont=" + idegenPont +
                ", helyszin='" + helyszin + '\'' +
                ", idopont=" + datumFormazas(idopont) +
                '}';
    }
}