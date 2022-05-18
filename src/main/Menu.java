package main;

import util.ReadConsoleInput;
import util.ReadFile;

import java.util.Scanner;

public class Menu {

    ReadFile readFile = new ReadFile();
    ReadConsoleInput readConsoleInput = new ReadConsoleInput();

    public void showMenu(){

        System.out.println("Menú de aplicación para el alineamiento de secuencias:");
        System.out.println("1. Alinear secuencias de un archivo.");
        System.out.println("2. Alinear secuencias de entrada por consola.");
        System.out.println("3. Salir.");

        Scanner read = new Scanner(System.in);

        switch (Integer.parseInt(read.next())){
            case 1:
                System.out.println("Ingrese el nombre del archivo 1:");
                readFile.readTxt();
                System.out.println("Ingrese el nombre del archivo 2:");
                readFile.readTxt();
                break;
            case 2:
                System.out.println("Ingrese el texto 1:");
                readConsoleInput.readInput();
                System.out.println("Ingrese el texto 2:");
                readConsoleInput.readInput();
                break;
            case 3:
                System.exit(0);
                break;
        }

    }

}
