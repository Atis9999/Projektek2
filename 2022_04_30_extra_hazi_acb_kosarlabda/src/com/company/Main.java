package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Eredmeny> eredmenyek = new ArrayList<>();

        String header = "";

        try (FileReader fr = new FileReader(
                "D:/Letöltések/Java/Soter kozos - Google drive/files/eredmenyek.csv");
             BufferedReader br = new BufferedReader(fr);
             Scanner sc = new Scanner(br)) {

            header = sc.nextLine();
            System.out.println(header);

            sc.useDelimiter(";|\\r\\n");

            while(sc.hasNext()) {
                eredmenyek.add(new Eredmeny(sc.next(), sc.next(), sc.nextInt(),
                        sc.nextInt(), sc.next(), sc.next()));
            }

            for(Eredmeny eredmeny : eredmenyek) {
                System.out.println(eredmeny);
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////

//3., Real Madrid - hány hazai, ill. idegen meccs volt.

        try (FileWriter fw = new FileWriter(
                "D:/Letöltések/Java/Soter kozos - Google drive/files/acb_kosarlabda_megoldasok.txt");
             BufferedWriter bw = new BufferedWriter(fw)) {

            int realHazaiMeccs = 0;
            int realIdegenMeccs = 0;

            for(Eredmeny eredmeny : eredmenyek) {
                if(eredmeny.hazai.equals("Real Madrid")) {
                    ++realHazaiMeccs;
                } else if(eredmeny.idegen.equals("Real Madrid")) {
                    ++realIdegenMeccs;
                }
            }

            bw.write("3. feladat: Real Madrid: Hazai: " + realHazaiMeccs + ", Idegen: " + realIdegenMeccs);
            bw.newLine();

        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////

//4., Volt-e döntetlen mérkőzés

        try (FileWriter fw = new FileWriter(
                "D:/Letöltések/Java/Soter kozos - Google drive/files/acb_kosarlabda_megoldasok.txt", true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            boolean dontetlen = false;

            for(Eredmeny eredmeny : eredmenyek) {
                if (Objects.equals(eredmeny.hazai, eredmeny.idegen)) {
                    dontetlen = true;
                    break;
                }
            }

            bw.write("4. feladat: Volt döntetlen? " + (dontetlen ? "igen" : "nem"));
            bw.newLine();

        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////

//5., Barcelona csapat teljes neve

        try (FileWriter fw = new FileWriter(
                "D:/Letöltések/Java/Soter kozos - Google drive/files/acb_kosarlabda_megoldasok.txt", true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            String barcelonaCsapatNev = "";

            for(Eredmeny eredmeny : eredmenyek) {
                if (eredmeny.hazai.contains("Barcelona")) {
                    barcelonaCsapatNev = eredmeny.hazai;
                    break;
                } else if (eredmeny.idegen.contains("Barcelona")) {
                    barcelonaCsapatNev = eredmeny.idegen;
                    break;
                }
            }

            bw.write("5. feladat: barcelonai csapat neve: " + barcelonaCsapatNev);
            bw.newLine();

        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////

//6., 2004.11.21-ei mérkőzések

        try (FileWriter fw = new FileWriter(
                "D:/Letöltések/Java/Soter kozos - Google drive/files/acb_kosarlabda_megoldasok.txt", true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write("6. feladat: ");
            bw.newLine();

            for(Eredmeny eredmeny : eredmenyek) {
                if (eredmeny.datumFormazas(eredmeny.idopont).equals("2004.11.21")) {
                    bw.write("	" + eredmeny.hazai + "-" + eredmeny.idegen +
                            " (" + eredmeny.hazaiPont + ":" + eredmeny.idegenPont + ")");
                    bw.newLine();
                }
            }

        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////

//7., Stadionok, melyekben 20-nál több mérkőzés zajlott - ez HashMap lesz

        HashMap<String, Integer> huszMerkozesFelettiStadionok = new HashMap<>();

        try (FileWriter fw = new FileWriter(
                "D:/Letöltések/Java/Soter kozos - Google drive/files/acb_kosarlabda_megoldasok.txt", true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            for(Eredmeny eredmeny : eredmenyek) {
                huszMerkozesFelettiStadionok.merge(eredmeny.helyszin, 1, Integer::sum);
            }

            bw.write("7. feladat: ");
            bw.newLine();

            for (Map.Entry<String, Integer> set : huszMerkozesFelettiStadionok.entrySet()) {
                if(set.getValue() > 20) {
                    bw.write("  " + set.getKey() + ": " + set.getValue());
                    bw.newLine();
                }
            }

        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}