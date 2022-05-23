package util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadConsoleInput {

    public String getInput(){
        Scanner read = new Scanner(System.in);

        return read.next();
    }

    public char[] readInput(){

        String input = getInput();
        char [] characters = new char[countCharacters(input)];
        char character = ' ';


        for(int i = 0; i < input.length(); i++){
            character = input.charAt(i);
            characters[i] = character;
        }

        for(int i=0;i<characters.length;i++)
        {
            System.out.println(characters[i]);
        }
        return characters;
    }

    public int countCharacters(String read){
        return read.length();
    }


}
