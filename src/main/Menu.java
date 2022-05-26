package main;

import domain.Scoring;
import util.ReadConsoleInput;
import util.ReadFile;

import java.util.Scanner;

public class Menu {

    Scanner read;
    ReadFile readFile = new ReadFile();
    ReadConsoleInput readConsoleInput = new ReadConsoleInput();
    Scoring scoring;

    private char[] X;
    private char[] Y;

    public void showMenu(){

        System.out.println("Menú de aplicación para el alineamiento de secuencias:");
        System.out.println("1. Alinear secuencias de un archivo.");
        System.out.println("2. Alinear secuencias de entrada por consola.");
        System.out.println("3. Salir.");

        read = new Scanner(System.in);

        switch (Integer.parseInt(read.next())){
            case 1:
                System.out.println("Ingrese el nombre del archivo 1:");
                X = readFile.readTxt();
                System.out.println("Ingrese el nombre del archivo 2:");
                Y = readFile.readTxt();
                break;
            case 2:
                System.out.println("Ingrese el texto 1:");
                X = readConsoleInput.readInput();
                System.out.println("Ingrese el texto 2:");
                Y = readConsoleInput.readInput();
                break;
            case 3:
                System.exit(0);
                break;
        }

    }

    public char[] returnX(){
       return X;
    }

    public char[] returnY(){
        return Y;
    }

    public int returnM(){
        return X.length + 2;
    }

    public int returnN(){
        return Y.length + 2;
    }

    public Scoring getScoring(){

        read = new Scanner(System.in);
        scoring = new Scoring(0,0,0);

        System.out.println("Ingrese el score para el match:");
        scoring.setMatch(Integer.parseInt(read.next()));
        System.out.println("Ingrese el score para el miss match:");
        scoring.setMissMatch(Integer.parseInt(read.next()));
        System.out.println("Ingrese el score para el gap:");
        scoring.setGapsPenalty(Integer.parseInt(read.next()));

        return scoring;
    }



}
