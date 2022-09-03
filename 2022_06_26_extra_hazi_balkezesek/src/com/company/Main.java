package com.company;

import java.io.*;
import java.util.*;

public class Main {

    static String header = "";

    public static void main(String[] args) {

        List<Player> balkezesek = fajlOlvasas("D:/Letöltések/Java/Soter kozos - Google drive/files/balkezesek.csv");

        fajlbaIras("D:/Letöltések/Java/Soter kozos - Google drive/files/balkezesek_megoldasok.txt", balkezesek);
    }

    public static List<Player> fajlOlvasas(String path) {

        List<Player> balkezesek = new ArrayList<>();

        try (FileReader fr = new FileReader(path);
             BufferedReader br = new BufferedReader(fr);
             Scanner sc = new Scanner(br)) {

            header = sc.nextLine();
            System.out.println(header);

            sc.useDelimiter(";|\\r\\n");

            while (sc.hasNext()) {
                balkezesek.add(new Player(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextInt()));
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        return balkezesek;
    }

    public static void fajlbaIras(String path, List<Player> balkezesek) {
        try (FileWriter fw = new FileWriter(path, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write("3. feladat: ");
            bw.write(hanyAdatsorVanAFajlban(balkezesek));
            bw.newLine();

            bw.write("4. feladat: ");
            jatekosok99OktoberiUtolsoMeccsel(balkezesek, bw);
            bw.newLine();

            bw.write("5. feladat: ");
            int helyesBekertEv = evszamBekeres(bw);
            bw.newLine();

            bw.write("6. feladat: ");
            bw.write(jatekosokAtlagTestsulyaABekertEvben(balkezesek, helyesBekertEv));

        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public static String hanyAdatsorVanAFajlban(List<Player> balkezesek) {
        return "3. feladat: " + balkezesek.size();
    }

    public static void jatekosok99OktoberiUtolsoMeccsel(List<Player> balkezesek, BufferedWriter bw) throws IOException {
        bw.newLine();
        for (Player player : balkezesek) {
            if (1900 + player.lastPlay.getYear() == 1999 && player.lastPlay.getMonth() == Calendar.OCTOBER) {
                bw.write(player.name + ", " + Math.round(inchToCm(player.heightInInch) * 10.0) / 10.0 + " cm");
                bw.newLine();
            }
        }
    }

    public static int evszamBekeres(BufferedWriter bw) throws IOException {
        Scanner scanner = new Scanner(System.in);

        bw.write(evszamBekeresUzenet());
        System.out.print(evszamBekeresUzenet());

        int input = 0;

        do {
            input = scanner.nextInt();
            bw.write(String.valueOf(input));
            bw.newLine();
            if (!bekertEvszamIntervallumonBelulVan(input)) {
                bw.write(evszamBekeresHibaUzenet());
                System.out.println(evszamBekeresHibaUzenet());
            }

        } while (!bekertEvszamIntervallumonBelulVan(input));
        return input;
    }

    public static String jatekosokAtlagTestsulyaABekertEvben(List<Player> balkezesek, int input) {
        int testsulyokOsszege = 0;
        int szamlalo = 0;

        for (Player player : balkezesek) {
            if (1900 + player.firstPlay.getYear() <= input && 1900 + player.lastPlay.getYear() >= input) {
                testsulyokOsszege += player.weightInPound;
                ++szamlalo;
            }
        }

        double atlagTestSuly = (double) testsulyokOsszege / szamlalo;
        double eredmeny = Math.round(atlagTestSuly * 100.0) / 100.0;
        return eredmeny + " font";
    }

    public static boolean bekertEvszamIntervallumonBelulVan(int input) {
        return input > 1990 && input < 1999;
    }

    public static double inchToCm(int inch) {
        return inch * 2.54;
    }

    public static String evszamBekeresUzenet() {
        return "Kérek egy 1990 és 1999 közötti évszámot!: ";
    }

    public static String evszamBekeresHibaUzenet() {
        return "Hibás adat! Kérek egy 1990 és 1999 közötti évszámot!: ";
    }
}
