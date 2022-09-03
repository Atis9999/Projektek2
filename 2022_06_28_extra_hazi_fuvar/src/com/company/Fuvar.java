package com.company;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Fuvar {

    int taxiAzonosito;
    LocalDateTime indulasIdopontja;
    int utazasIdotartama;
    double megtettTavolsag;
    double viteldij;
    double borravalo;
    String fizetesModja;

    public Fuvar(int taxiAzonosito, String indulasIdopontja, int utazasIdotartama,
                 double megtettTavolsag, double viteldij, double borravalo, String fizetesModja) throws ParseException {
        this.taxiAzonosito = taxiAzonosito;
        this.indulasIdopontja = convertStringToLocalDateTime(indulasIdopontja);
        this.utazasIdotartama = utazasIdotartama;
        this.megtettTavolsag = megtettTavolsag;
        this.viteldij = viteldij;
        this.borravalo = borravalo;
        this.fizetesModja = fizetesModja;
    }

    public LocalDateTime getIndulasIdopontja() {
        return indulasIdopontja;
    }

    public LocalDateTime convertStringToLocalDateTime(String indulasIdopontja) {
        String[] indulasIdopontjaFelbontva = indulasIdopontja.split(" ");
        LocalDate ld = LocalDate.parse(indulasIdopontjaFelbontva[0]);
        LocalTime lt = LocalTime.parse(indulasIdopontjaFelbontva[1]);
        return LocalDateTime.of(ld, lt);
    }

    public String convertLocalDateTimeToFormattedString(LocalDateTime date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return date.format(dateTimeFormatter);
    }

    @Override
    public String toString() {
        return "Fuvar{" +
                ", taxiAzonosito=" + taxiAzonosito +
                ", indulasIdopontja=" + convertLocalDateTimeToFormattedString(indulasIdopontja) +
                ", utazasIdotartama=" + utazasIdotartama +
                ", megtettTavolsag=" + megtettTavolsag +
                ", viteldij=" + viteldij +
                ", borravalo=" + borravalo +
                ", fizetesModja='" + fizetesModja + '\'' +
                '}';
    }
}
