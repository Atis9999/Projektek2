package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<Egyenlet> egyenletek = new ArrayList<>();

        try (FileReader fr = new FileReader(
                "D:/Letöltések/Java/Soter kozos - Google drive/files/kifejezesek.txt");
             BufferedReader br = new BufferedReader(fr);
             Scanner sc = new Scanner(br)) {

            while(sc.hasNext()) {
                egyenletek.add(new Egyenlet(sc.nextInt(), sc.next(), sc.nextInt()));
            }

            for (Egyenlet egyenlet : egyenletek) {
                System.out.println(egyenlet);
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////

// 2., az állomány hány kifejezést tartalmaz?

        try (FileWriter fr = new FileWriter(
                "D:/Letöltések/Java/Soter kozos - Google drive/files/kifejezesek_megoldasok.txt");
             BufferedWriter bw = new BufferedWriter(fr)) {

            bw.write("2. feladat: Kifejezések száma:" + egyenletek.size());
            bw.newLine();

        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////

// 3., Maradékos osztások száma

        try (FileWriter fr = new FileWriter(
                "D:/Letöltések/Java/Soter kozos - Google drive/files/kifejezesek_megoldasok.txt", true);
             BufferedWriter bw = new BufferedWriter(fr)) {

            int count = 0;

            for(Egyenlet egyenlet : egyenletek) {
                if(Objects.equals(egyenlet.operator, "mod")) {
                    ++count;
                }
            }

            bw.write("3. feladat: Kifejezések maradékos osztással: " + count);
            bw.newLine();

        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////

// 4., Van-e olyan egyenlet, amelyben mindkét operandus maradék nélkül osztható tízzel!

        try (FileWriter fr = new FileWriter(
                "D:/Letöltések/Java/Soter kozos - Google drive/files/kifejezesek_megoldasok.txt", true);
             BufferedWriter bw = new BufferedWriter(fr)) {

            for(int i = 0; i < egyenletek.size(); ++i) {
                if(egyenletek.get(i).elsoSzam % 10 == 0 && egyenletek.get(i).masodikSzam % 10 == 0) {
                    bw.write("4. feladat: Van ilyen kifejezés!");
                    bw.newLine();
                    break;
                } else if (i == egyenletek.size() - 1) {
                    bw.write("4. feladat: Nincs ilyen kifejezés!");
                    bw.newLine();
                }
            }

        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////

// 5., Statisztika operátorokról, melyikből hány darab.

        try (FileWriter fr = new FileWriter(
                "D:/Letöltések/Java/Soter kozos - Google drive/files/kifejezesek_megoldasok.txt", true);
             BufferedWriter bw = new BufferedWriter(fr)) {

            int modSzamlalo = 0, osztasSzamlalo = 0, divSzamlalo = 0,
                    kivonasSzamlalo = 0, szorzasSzamlalo = 0, osszeadasSzamlalo = 0;

            for (Egyenlet egyenlet : egyenletek) {
                switch (egyenlet.operator) {
                    case "mod" -> ++modSzamlalo;
                    case "/" -> ++osztasSzamlalo;
                    case "div" -> ++divSzamlalo;
                    case "-" -> ++kivonasSzamlalo;
                    case "*" -> ++szorzasSzamlalo;
                    case "+" -> ++osszeadasSzamlalo;
                }
            }

            bw.write("5. feladat: Statisztika" +
                    "\n	mod -> " + modSzamlalo + "db" +
                    "\n	   /-> " + osztasSzamlalo + "db" +
                    "\n	 div-> " + divSzamlalo + "db" +
                    "\n	  - -> " + kivonasSzamlalo + "db" +
                    "\n	  * -> " + szorzasSzamlalo + "db" +
                    "\n	  + -> " + osszeadasSzamlalo + "db");
            bw.newLine();

        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////

        //7., 6. feladat függvényével egy végtelen ciklus, input alapján számolások, "vége" szóra
        // ciklus vége

        try (FileWriter fr = new FileWriter(
                "D:/Letöltések/Java/Soter kozos - Google drive/files/kifejezesek_megoldasok.txt", true);
             BufferedWriter bw = new BufferedWriter(fr)) {

        Scanner scanner = new Scanner(System.in);

        String[] kifejezes;
        String eredmeny;

        while (true) {
            System.out.print(kerekKifejezestUzenet());
            bw.write(kerekKifejezestUzenet() + " ");

            kifejezes = scanner.nextLine().split(" ");

            if (kifejezes[0].equals("vége")) {
                break;
            }
            eredmeny = egyenletMegoldoFuggveny(
                    Integer.parseInt(kifejezes[0]), kifejezes[1], Integer.parseInt(kifejezes[2]));

            bw.write(kifejezes[0] + " " + kifejezes[1] + " " + kifejezes[2] + " = " + eredmeny);
            bw.newLine();
        }

        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////

// 8., kiírni az eredményeket egy másik fájlba.

        try (FileWriter fr0 = new FileWriter(
                "D:/Letöltések/Java/Soter kozos - Google drive/files/kifejezesek_megoldasok.txt", true);
             BufferedWriter bw0 = new BufferedWriter(fr0)) {

        try (FileWriter fr = new FileWriter(
                "D:/Letöltések/Java/Soter kozos - Google drive/files/kifejezesek_eredmenyek.txt");
             BufferedWriter bw = new BufferedWriter(fr)) {

            for (Egyenlet egyenlet : egyenletek) {
                switch (egyenlet.operator) {
                    case "mod" -> {
                        bw.write(egyenlet + " = " +
                                modSzamolas(egyenlet.elsoSzam, egyenlet.masodikSzam)); bw.newLine();
                    } case "/" -> {
                        bw.write(egyenlet + " = " +
                                osztasSzamolas(egyenlet.elsoSzam, egyenlet.masodikSzam)); bw.newLine();
                    } case "div" -> {
                        bw.write(egyenlet + " = " +
                                egeszOsztasSzamolas(egyenlet.elsoSzam, egyenlet.masodikSzam)); bw.newLine();
                    } case "-" -> {
                        bw.write(egyenlet + " = " +
                                kivonasSzamolas(egyenlet.elsoSzam, egyenlet.masodikSzam)); bw.newLine();
                    } case "*" -> {
                        bw.write(egyenlet + " = " +
                                szorzasSzamolas(egyenlet.elsoSzam, egyenlet.masodikSzam)); bw.newLine();
                    } case "+" -> {
                        bw.write(egyenlet + " = " +
                                osszeadasSzamolas(egyenlet.elsoSzam, egyenlet.masodikSzam)); bw.newLine();
                    } default -> {
                        bw.write(egyenlet + "Hibás operátor!");
                        bw.newLine();
                    }
                }
            }

        } catch (IOException ioe) {
            System.out.println(ioe);
        }

            bw0.write("8. feladat: kifejezesek_eredmenyek.txt");

        } catch (IOException ioe) {
            System.out.println(ioe);
        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////

    //6., Stringgel visszatérő függvény, ami el tudja végezni az összes egyenletet, ismeretlen
    // operátor esetén "Hibás operátor!", egyéb esetben "Egyéb hiba!"

    public static String egyenletMegoldoFuggveny(int elsoSzam, String operator, int masodikSzam) {

        String eredmeny = "";

        switch (operator) {
            case "mod" -> eredmeny = modSzamolas(elsoSzam, masodikSzam);
            case "/" -> eredmeny = osztasSzamolas(elsoSzam, masodikSzam);
            case "div" -> eredmeny = egeszOsztasSzamolas(elsoSzam, masodikSzam);
            case "-" -> eredmeny = String.valueOf(kivonasSzamolas(elsoSzam, masodikSzam));
            case "*" -> eredmeny = String.valueOf(szorzasSzamolas(elsoSzam, masodikSzam));
            case "+" -> eredmeny = String.valueOf(osszeadasSzamolas(elsoSzam, masodikSzam));
            default -> eredmeny = " = Hibás operátor!";
        }
        return eredmeny;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////

    public static String modSzamolas(int elsoSzam, int masodikSzam) {
        return elsoSzam == 0 || masodikSzam == 0 ?
                nullavalValoOsztasUzenet() : String.valueOf(elsoSzam % masodikSzam);
    }

    public static String osztasSzamolas(int elsoSzam, int masodikSzam) {
        return elsoSzam == 0 || masodikSzam == 0 ?
                nullavalValoOsztasUzenet() : String.valueOf(elsoSzam / masodikSzam);
    }

    public static String egeszOsztasSzamolas(int elsoSzam, int masodikSzam) {
        return elsoSzam == 0 || masodikSzam == 0 ?
                nullavalValoOsztasUzenet() : String.valueOf((int) (elsoSzam / masodikSzam));
    }

    public static int kivonasSzamolas(int elsoSzam, int masodikSzam) {
        return elsoSzam - masodikSzam;
    }

    public static int szorzasSzamolas(int elsoSzam, int masodikSzam) {
        return elsoSzam * masodikSzam;
    }

    public static int osszeadasSzamolas(int elsoSzam, int masodikSzam) {
        return elsoSzam + masodikSzam;
    }

    public static String nullavalValoOsztasUzenet() {
        return "Egyéb hiba!";
    }

    public static String kerekKifejezestUzenet() {
        return "Kérek egy kifejezést (pl.: 1 + 1): ";
    }
}
