package com.company;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Main {

    static String header;

    public static List<Fuvar> fajlBeolvasas(String eleresiUt) {
        List<Fuvar> fuvarok = new ArrayList<>();
        try (FileReader fr = new FileReader(eleresiUt);
             BufferedReader br = new BufferedReader(fr);
             Scanner sc = new Scanner(br)){

            header = sc.nextLine();

            sc.useDelimiter(";|\\r\\n");

            while (sc.hasNext()) {
                fuvarok.add(new Fuvar(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.next()));
            }

        } catch (IOException fnfe) {
            System.out.println(fnfe);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fuvarok;
    }

    public static void fajlbaIras(String eleresiUt, String input) {
        try (FileWriter fw = new FileWriter(eleresiUt, true);
             BufferedWriter bw = new BufferedWriter(fw)){

            bw.write(input);
            bw.newLine();

        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public static void main(String[] args) {

        String fajlEleresiUt = "D:/Letöltések/Java/Soter kozos - Google drive/files/fuvar.csv";
        String megoldasokEleresiUt = "D:/Letöltések/Java/Soter kozos - Google drive/files/fuvar_megoldasok.txt";
        String hibakEleresiUt = "D:/Letöltések/Java/Soter kozos - Google drive/files/fuvar_hibak.txt";

        List<Fuvar> fuvarok = fajlBeolvasas(fajlEleresiUt);

        harmadikFeladat(megoldasokEleresiUt, fuvarok);
        negyedikFeladat(megoldasokEleresiUt, fuvarok, 6185);
        otodikFeladat(megoldasokEleresiUt, fuvarok);
        hatodikFeladat(megoldasokEleresiUt, fuvarok);
        hetedikFeladat(megoldasokEleresiUt, fuvarok);
        nyolcadikFeladat(hibakEleresiUt, megoldasokEleresiUt, fuvarok);
    }

    public static void harmadikFeladat(String megoldasokEleresiUt, List<Fuvar> fuvarok) {
        fajlbaIras(megoldasokEleresiUt, "3. feladat: " + fuvarok.size() + " fuvar");
    }

    public static void negyedikFeladat(String megoldasokEleresiUt, List<Fuvar> fuvarok, int azonosito) {
        int fuvarSzamlalo = 0;
        double bevetel = 0;

        for (Fuvar fuvar : fuvarok) {
            if(fuvar.taxiAzonosito == azonosito) {
                ++fuvarSzamlalo;
                bevetel += fuvar.viteldij + fuvar.borravalo;
            }
        }
        fajlbaIras(megoldasokEleresiUt, "4. feladat: " + fuvarSzamlalo + " fuvar alatt: " + bevetel + "$");
    }

    public static void otodikFeladat(String megoldasokEleresiUt, List<Fuvar> fuvarok) {
        Map<String, Integer> fizetesiModokEsHanyszor = new HashMap<>();
        for (Fuvar fuvar : fuvarok) {
                fizetesiModokEsHanyszor.merge(fuvar.fizetesModja, 1, Integer::sum);
        }

            fajlbaIras(megoldasokEleresiUt, "5. feladat: ");
        for (Map.Entry<String, Integer> fizetesiMod : fizetesiModokEsHanyszor.entrySet()){
            fajlbaIras(megoldasokEleresiUt, "    " + fizetesiMod.getKey() + ": " + fizetesiMod.getValue() + " fuvar");
        }
    }

    public static void hatodikFeladat(String megoldasokEleresiUt, List<Fuvar> fuvarok) {
        double osszFuvarokMegtettTavolsagaMerfoldben = 0;

        for (Fuvar fuvar : fuvarok) {
            osszFuvarokMegtettTavolsagaMerfoldben += fuvar.megtettTavolsag;
        }

        fajlbaIras(megoldasokEleresiUt, "6. feladat: " + doubleErtekKetTizedesjeggyel(merfoldAtvaltasKilometerbe(osszFuvarokMegtettTavolsagaMerfoldben)) + "km");
    }

    public static void hetedikFeladat(String megoldasokEleresiUt, List<Fuvar> fuvarok) {
        int fuvarHossz = fuvarok.get(0).utazasIdotartama;
        int taxiAzonosito = fuvarok.get(0).taxiAzonosito;
        double megtettTavolsag = fuvarok.get(0).megtettTavolsag;
        double viteldij = fuvarok.get(0).viteldij;

        for (int i = 1; i < fuvarok.size(); i++) {
            if (fuvarok.get(i).utazasIdotartama > fuvarHossz) {
                fuvarHossz = fuvarok.get(i).utazasIdotartama;
                taxiAzonosito = fuvarok.get(i).taxiAzonosito;
                megtettTavolsag = fuvarok.get(i).megtettTavolsag;
                viteldij = fuvarok.get(i).viteldij;
            }
        }

        fajlbaIras(megoldasokEleresiUt, "7. feladat: Leghosszabb fuvar: " +
                "\n     Fuvar hossza: " + fuvarHossz + " másodperc" +
                "\n     Taxi azonosító: " + taxiAzonosito +
                "\n     Megtett távolság: " + doubleErtekKetTizedesjeggyel(megtettTavolsag) + " km" +
                "\n     Viteldíj: " + doubleErtekKetTizedesjeggyel(viteldij) + "$");
    }

    public static void nyolcadikFeladat(String hibakEleresiUt, String megoldasokEleresiUt, List<Fuvar> fuvarok) {
        fuvarok.sort(Comparator.comparing(Fuvar::getIndulasIdopontja));

        fajlbaIras(megoldasokEleresiUt, "8. feladat: fuvar_hibak.txt");
        fajlbaIras(hibakEleresiUt, header);

        for (Fuvar fuvar : fuvarok) {
            if (fuvar.utazasIdotartama > 0 && fuvar.viteldij > 0 && fuvar.megtettTavolsag == 0) {
                fajlbaIras(hibakEleresiUt, formazottFuvarRekord(fuvar));
            }
        }
    }

    public static String formazottFuvarRekord(Fuvar fuvar) {
        return fuvar.taxiAzonosito + ";" + fuvar.convertLocalDateTimeToFormattedString(fuvar.indulasIdopontja) + ";" +
                fuvar.utazasIdotartama + ";" + fuvar.megtettTavolsag + ";" + fuvar.viteldij + ";" + fuvar.borravalo + ";" +
                fuvar.fizetesModja;
    }

    public static double merfoldAtvaltasKilometerbe(double merfold) {
        return merfold *1.6;
    }

    public static String doubleErtekKetTizedesjeggyel(double ertek) {
        return String.format("%.2f", ertek);
    }
}
