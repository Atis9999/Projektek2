package com.company;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Ez le fog futni");
            throwsExceptionMethod();
            System.out.println("Ez nem fog megfutni");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Hiba történt");
        }finally {
            System.out.println("Ez mindenkép meg fog futni");
        }
        try {
            System.out.println("Ez le fog futni Runtimeba.");
            //throwsRunTimeexceptionMethod();
            throwsCustumeException();
            System.out.println("Ez nem fog lefutni");
        }catch (RuntimeException r){
            r.printStackTrace();
            System.out.println("Ez fog lefutni a Runtimenál.");

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Ez nem fog lefutni mert az elötte lévő lefut.");
        }
        finally {
            System.out.println("Ez pedig mindig lefut.");
        }


    }
    public static void throwsExceptionMethod()throws Exception{
        throw new Exception("Almafa");
    }
    public static void throwsRunTimeexceptionMethod()throws RuntimeException{
        throw new RuntimeException("Almafa");
    }
    public static void throwsCustumeException()throws CustomeException{
        throw new CustomeException("Egyedi Exception");
    }

}
