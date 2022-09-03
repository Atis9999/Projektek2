package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static String morzeAbcEleresiUt = "D:\\Letöltések\\Java\\Soter kozos - Google drive\\infojegyzet_files\\morzeAbc.txt";
    static String morzeTxtEleresiUt = "D:\\Letöltések\\Java\\Soter kozos - Google drive\\infojegyzet_files\\morze.txt";
    static String morzeMegoldasokEleresiUt = "D:\\Letöltések\\Java\\Soter kozos - Google drive\\infojegyzet_txt_megoldasok\\morze_megoldasok.txt";

    static String header;

////////////////////////////////////////////////////////////////////////////////////////

    public static Map<Character, String> morzeAbcBeolvasas() {
        Map<Character, String> morzeAbc = new HashMap<>();

        try(Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(morzeAbcEleresiUt), StandardCharsets.ISO_8859_1)))) {

            header = sc.nextLine();

            sc.useDelimiter("\\s|\\t|\\r\\n");

            while(sc.hasNext()) {
                morzeAbc.put(sc.next().charAt(0), sc.nextLine().replaceAll("\\t", ""));
            }

            //ez csak kiíratás
            /*for(Map.Entry<Character, String> entry : morzeAbc.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }*/

        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        }

        return morzeAbc;
    }

////////////////////////////////////////////////////////////////////////////////////////

    public static Map<String, String> morzeSzovegBeolvasas() {
        Map<String, String> morzeSzoveg = new HashMap<>();

        try(FileReader fr = new FileReader(morzeTxtEleresiUt);
            BufferedReader br = new BufferedReader(fr);
            Scanner sc = new Scanner(br)) {

            sc.useDelimiter(";|\\r\\n");

            String[] line;

            while(sc.hasNext()) {
                line = sc.nextLine().split(";");
                morzeSzoveg.put(line[0], line[1]);
            }

            //ez csak kiíratás
            /*for(Map.Entry<String, String> entry : morzeSzoveg.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }*/

        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return morzeSzoveg;
    }

////////////////////////////////////////////////////////////////////////////////////////

    public static void fajlbaIras(String input) {
        try(FileWriter fw = new FileWriter(morzeMegoldasokEleresiUt);
            BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(input);
            bw.newLine();

        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        Map<Character, String> morzeAbc = morzeAbcBeolvasas();
        Map<String, String> morzeSzoveg = morzeSzovegBeolvasas();
        Map<String, String> morzeSzovegDekodolva = morze2Szoveg(morzeSzoveg, morzeAbc);

        for (Map.Entry<String, String> entry : morzeSzovegDekodolva.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        harmadikFeladat(morzeAbc);
        negyedikFeladat(morzeAbc);
        hetedikFeladat(morzeSzovegDekodolva);
        nyolcadikFeladat(morzeSzovegDekodolva);
        kilencedikFeladat(morzeSzovegDekodolva);
    }

////////////////////////////////////////////////////////////////////////////////////////

    public static void harmadikFeladat(Map<Character, String> morzeAbc) {
        String megoldas = "3. feladat: A morze abc " + morzeAbc.size() + " db karakter kódját tartalmazza.";
        System.out.println(megoldas);
        //fajlbaIras(megoldas);
    }

////////////////////////////////////////////////////////////////////////////////////////

    public static void negyedikFeladat(Map<Character, String> morzeAbc) {
        String megoldas;
        Scanner scanner = new Scanner(System.in);
        System.out.print(betuKeresUzenet());
        char input = scanner.next().charAt(0);
        megoldas = "4. feladat: " + betuKeresUzenet() + " " + input;
        if(morzeAbc.containsKey(input)) {
            megoldas = megoldas + "\n	A " + input + " karakter morze kódja: " +
                    betuMorzeKodja(morzeAbc, input);
            System.out.println(megoldas);
            //fajlbaIras(megoldas);
            return;
        }
        megoldas = megoldas + "\n	Nem található a kódtárban ilyen karakter!";
        System.out.println(megoldas);
        //fajlbaIras(megoldas);
    }

    public static String betuMorzeKodja(Map<Character, String> morzeAbc, char c) {
        for(Map.Entry<Character, String> entry : morzeAbc.entrySet()) {
            if(entry.getKey().equals(c)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public static String betuKeresUzenet() {
        return "Kérek egy karaktert: ";
    }

////////////////////////////////////////////////////////////////////////////////////////

    public static Map<String, String> morze2Szoveg(Map<String, String> morzeSzoveg, Map<Character, String> morzeAbc) {
        Map<String, String> morzeSzovegDekodolva = new HashMap<>();

        for(Map.Entry<String, String> entry : morzeSzoveg.entrySet()) {
            morzeSzovegDekodolva.put(morzeSorKonvertalasaSzovegge(morzeAbc, entry.getKey()), morzeSorKonvertalasaSzovegge(morzeAbc, entry.getValue()));
        }

        for(Map.Entry<String, String> entry : morzeSzovegDekodolva.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        return morzeSzovegDekodolva;
    }

    public static String morzeSorKonvertalasaSzovegge(Map<Character, String> morzeAbc, String morze) {
        String[] morzeSorFeldarabolvaSzavakra = morze.split(" {7}");
        StringBuffer morzeSzoveggeKodolva = new StringBuffer();

        for (int i = 0; i < morzeSorFeldarabolvaSzavakra.length; i++) {

            morzeSzoveggeKodolva.append(morzeSzoKonvertalasaSzovegge(morzeAbc, morzeSorFeldarabolvaSzavakra[i]));

        }


        return morzeSzoveggeKodolva.toString();
    }

    public static String morzeSzoKonvertalasaSzovegge(Map<Character, String> morzeAbc, String morzeSzo) {
        String[] morzeSzoFeldarabolvaBetukre = morzeSzo.split(" {3}");
        StringBuffer morzeSzoSzovegkent = new StringBuffer();

        for (String s : morzeSzoFeldarabolvaBetukre) {

            for (Map.Entry<Character, String> entry : morzeAbc.entrySet()) {
                if (entry.getValue().equals(s)) {
                    morzeSzoSzovegkent.append(entry.getKey());
                }
            }
        }
        return morzeSzoSzovegkent + " ";
    }

////////////////////////////////////////////////////////////////////////////////////////

    public static void hetedikFeladat(Map<String, String> morzeSzovegDekodolva) {
        String megoldas = "7. feladat: Az első idézet szerzője: " + morzeSzovegDekodolva.keySet().iterator().next();
        System.out.println(megoldas);
        //fajlbaIras(megoldas);
    }

////////////////////////////////////////////////////////////////////////////////////////

    public static void nyolcadikFeladat(Map<String, String> morzeSzovegDekodolva) {
        String szerzo = "";
        String idezet = "";
        String megoldas;
        for (Map.Entry<String, String> entry : morzeSzovegDekodolva.entrySet()) {
            if(entry.getValue().length() > idezet.length()) {
                szerzo = entry.getKey();
                idezet = entry.getValue();
            }
        }

        megoldas = "8. feladat: A leghosszabb idézet szerzője és az idézet: " + szerzo + ": " + idezet;
        System.out.println(megoldas);
        //fajlbaIras(megoldas);
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    public static void kilencedikFeladat(Map<String, String> morzeSzovegDekodolva) {
        String megoldas = "9. feladat: Arisztotelész idézetei: ";
        String szerzo = "ARISZTOTELÉSZ";

        System.out.println(megoldas);

        for (Map.Entry<String, String> entry : morzeSzovegDekodolva.entrySet()) {
            if(entry.getKey().equals(szerzo)) {
                System.out.println(" - " + entry.getValue());
                //fajlbaIras(" - " + entry.getValue());
            }
        }
    }
}

////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////