package util;

import java.io.*;
import java.util.Scanner;

public class ReadFile {

    public String getFileName(){
        Scanner read = new Scanner(System.in);

        return read.next();
    }

    public FileReader getFileReader(String link) throws FileNotFoundException {

        return new FileReader(link);

    }

    public char[] readTxt(){

        char[] characters = new char[0];

        try {
            String route = "src\\resources\\"+getFileName()+".txt";
            FileReader fileReader = getFileReader(route);

            int read;
            characters = new char[countCharacters(fileReader)];
            char character = ' ';
            int count = 0;
            fileReader = getFileReader(route);
            read = fileReader.read();

            while(read != -1){
                character = (char) read;
                characters[count] = character;

                count++;
                read = fileReader.read();
            }
            fileReader.close();

            for(int i=0;i<characters.length;i++)
            {
                System.out.println(characters[i]);
            }

        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }

        return characters;

    }

    public int countCharacters(FileReader fileReader){
        int count = 0;
        try {
            int read = fileReader.read();
            while(read != -1){
                count++;

                read = fileReader.read();
            }

            fileReader.close();

        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
        return count;
    }

}
