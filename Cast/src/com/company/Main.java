package com.company;

public class Main {

    public static void main(String[] args) {

        AbstraktEntity note = new Note();
        note.setId(14L);
        ((Note)note).setContent("Almafa");
        System.out.println(((Note)note).getContent());
        System.out.println(((Exerise)note).getDuedate());







    }
}
