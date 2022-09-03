package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    static String header;

    static String eleresiUt = "D:/Letöltések/Java/Soter kozos - Google drive/infojegyzet_files/felfedezesek.csv";
    static String megoldasokEleresiUt = "D:/Letöltések/Java/Soter kozos - Google drive/infojegyzet_txt_megoldasok/felfedezesek_megoldasok.txt";

////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static List<Felfedezes> fajlBeolvasas() {

        List<Felfedezes> felfedezesek = new ArrayList<>();

        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(eleresiUt),"ISO-8859-1")))) {

            header = sc.nextLine();
            sc.useDelimiter(";|\\r\\n");

            while(sc.hasNext()) {
                felfedezesek.add(new Felfedezes(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.next()));
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        return felfedezesek;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void fajlbaIras(String input) {

        try (FileWriter fw = new FileWriter(megoldasokEleresiUt, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(input);
            bw.newLine();

        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {

        List<Felfedezes> felfedezesek = fajlBeolvasas();

        harmadikFeladat(felfedezesek);
        negyedikFeladat(felfedezesek, "Ókor");
        String bekertVegyjel = otodikFeladat(felfedezesek);
        hatodikFeladat(felfedezesek, bekertVegyjel);
        hetedikFeladat(felfedezesek);
        nyolcadikFeladat(felfedezesek);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void harmadikFeladat(List<Felfedezes> felfedezesek) {
        String megoldas = "3. feladat: Elemek Száma: " + felfedezesek.size();
        fajlbaIras(megoldas);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void negyedikFeladat(List<Felfedezes> felfedezesek, String ev) {

        int szamlalo = 0;

        for(Felfedezes felfedezes : felfedezesek) {
            if(felfedezes.ev.equalsIgnoreCase(ev)) {
                ++szamlalo;
            }
        }

        String megoldas = "4. feladat: Felfedezések száma az ókorban: " + szamlalo;
        fajlbaIras(megoldas);
    }


////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static String otodikFeladat(List<Felfedezes> felfedezesek) {
        Scanner scanner = new Scanner(System.in);
        String input = "0";
        boolean megfeleloBevitel = false;

        while(!megfeleloBevitel) {

            System.out.print("Kérek egy vegyjelet: ");

            input = scanner.next();

            System.out.println();

            fajlbaIras("5. feladat: Kérek egy vegyjelet: " + input);

            megfeleloBevitel = nemMegfeleloBevitelEllenorzes(input);
        }

        return input;
    }

    public static boolean nemMegfeleloBevitelEllenorzes(String input) {
        return input.matches("[a-zA-Z]+") && input.length() == 2;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void hatodikFeladat(List<Felfedezes> felfedezesek, String bekertVegyjel) {

        for(Felfedezes felfedezes : felfedezesek) {

            if(felfedezes.vegyjelEquals(bekertVegyjel)) {

                fajlbaIras(hatodikFeladatValasz(felfedezes));
                System.out.println(hatodikFeladatValasz(felfedezes));
                return;

            }

        }

        System.out.println("6. feladat: Keresés\n	Nincs ilyen elem az adatforrásban!");
        fajlbaIras("6. feladat: Keresés\n	Nincs ilyen elem az adatforrásban!");
    }

    public static String hatodikFeladatValasz(Felfedezes felfedezes) {
        return "6. feladat: Keresés " +
                "\n	Az elem vegyjele: " + felfedezes.vegyjel +
                "\n	Az elem neve: " + felfedezes.nev +
                "\n	Rendszáma: " + felfedezes.rendszam +
                "\n	Felfedezés éve: " + felfedezes.ev +
                "\n	Felfedező: " + felfedezes.felfedezoNeve;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void hetedikFeladat(List<Felfedezes> felfedezesek) {
        int szamlalo = 0;
        int ketEvKozottiKulonbseg;

        for(int i = 0; i + 1 < felfedezesek.size(); ++i) {
            if(!felfedezesek.get(i).ev.equals("Ókor")) {
                ketEvKozottiKulonbseg = Math.abs(Integer.parseInt(felfedezesek.get(i).ev) - Integer.parseInt(felfedezesek.get(i + 1).ev));
                if(ketEvKozottiKulonbseg > szamlalo) {
                    szamlalo = ketEvKozottiKulonbseg;
                }
            }
        }
        fajlbaIras("7. feladat: " + szamlalo + " év volt a leghosszabb időszak két elem felfedezése között.");
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void nyolcadikFeladat(List<Felfedezes>  felfedezesek) {
        Map<Integer, Integer> evekEsFelfedezesekSzama = new HashMap<>();

        for (Felfedezes felfedezes : felfedezesek) {
            if (!felfedezes.ev.equals("Ókor")) {
                evekEsFelfedezesekSzama.merge(Integer.parseInt(felfedezes.ev), 1, Integer::sum);
            }
        }

        fajlbaIras("8. feladat: Statisztika");

        for (Map.Entry<Integer, Integer> entry : evekEsFelfedezesekSzama.entrySet()) {
            if(entry.getValue() > 3) {
                fajlbaIras("	" + entry.getKey() + ": " + entry.getValue() + " db");

            }
        }
    }
}