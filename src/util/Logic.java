package util;

import domain.LinkedList;
import domain.MatrixData;
import domain.Scoring;
import main.Menu;

import java.util.Objects;

public class Logic {

    Scoring scoring;
    MatrixData matrixData;
    MatrixData[][] matrix;
    Menu menu = new Menu();
    private char[] X;
    private char[] Y;

    private LinkedList numbersPath = new LinkedList();
    private LinkedList directionsPath = new LinkedList();

    public Logic() {
        this.menu.showMenu();
        this.scoring = this.menu.getScoring();
        this.X = this.menu.returnX();
        this.Y = this.menu.returnY();
        this.matrix = new MatrixData[this.menu.returnM()][this.menu.returnN()];
        fillMatrixBorders();
        fillMatrix();
        printGlobalSequenceAlignment();
        //M = X
        //N = Y
    }

    public void printGlobalSequenceAlignment(){

        String output = "";
        int i = this.menu.returnM()-1;
        int j = this.menu.returnN()-1;

        this.matrixData = this.matrix[i][j];

        while(!Objects.equals(this.matrixData.getBefore(), "")) {

            this.matrixData = this.matrix[i][j];

                switch (this.matrixData.getBefore()){
                    case "diagonal":
                        this.numbersPath.addElement(this.matrixData.data);
                        this.directionsPath.addElement(this.matrixData.getBefore());
                        this.matrixData = this.matrix[i-1][j-1];
                        i--;
                        j--;
                    break;

                    case "up":
                        this.numbersPath.addElement(this.matrixData.data);
                        this.directionsPath.addElement(this.matrixData.getBefore());
                        this.matrixData = this.matrix[i-1][j];
                        i--;
                    break;

                    case "left":
                        this.numbersPath.addElement(this.matrixData.data);
                        this.directionsPath.addElement(this.matrixData.getBefore());
                        this.matrixData = this.matrix[i][j-1];
                        j--;
                    break;

                    case "diagonal-left":
                        this.numbersPath.addElement(this.matrixData.data);
                        this.directionsPath.addElement(this.matrixData.getBefore());
                        this.matrixData = this.matrix[i-1][j-1];
                        i--;
                        j--;
                    break;

                    case "up-left":
                        this.numbersPath.addElement(this.matrixData.data);
                        this.directionsPath.addElement(this.matrixData.getBefore());
                        this.matrixData = this.matrix[i-1][j];
                        i--;
                    break;

                    case "diagonal-up":
                        this.numbersPath.addElement(this.matrixData.data);
                        this.directionsPath.addElement(this.matrixData.getBefore());
                        this.matrixData = this.matrix[i-1][j-1];
                        i--;
                        j--;
                    break;
                    
                }
        }

        System.out.println(this.numbersPath.toString());
        System.out.println(this.directionsPath.toString());

    }

    public void fillMatrixBorders(){

        matrix[0][0] = matrixData = new MatrixData("border", "*");
        matrix[0][1] = matrixData = new MatrixData("border", "Ω");
        matrix[1][0] = matrixData = new MatrixData("border", "Ω");

        for (int x=2; x < this.menu.returnM(); x++) {
            matrix[x][0] = this.matrixData = new MatrixData("border", String.valueOf(this.X[x-2]));
        }

        for (int x=2; x < this.menu.returnN(); x++) {
            matrix[0][x] = this.matrixData = new MatrixData("border", String.valueOf(this.Y[x-2]));
        }

    }

    public void fillMatrix(){

        int points = 0;
        MatrixData aux;

        matrix[1][1] = matrixData = new MatrixData("border", "0");

        for (int x=2; x < this.menu.returnM(); x++) {
            points = points + this.scoring.gapsPenalty;
            this.matrixData = new MatrixData("border", Integer.toString(points));
            this.matrixData.setBefore("up");
            matrix[x][1] = this.matrixData;
        }

        points = 0;

        for (int x=2; x < this.menu.returnN(); x++) {
            points = points + this.scoring.gapsPenalty;
            this.matrixData = new MatrixData("border", Integer.toString(points));
            this.matrixData.setBefore("left");
            matrix[1][x] = this.matrixData;
        }

        for (int x=2; x < this.matrix.length; x++) {
            for (int y=2; y < this.matrix[x].length; y++) {

                aux = setNewData(this.matrix[x-1][y-1].data,
                        this.matrix[x-1][y].data, this.matrix[x][y-1].data,
                        compareTwoCharacter(this.matrix[0][y].data, this.matrix[x][0].data));

                this.matrix[x][y] = aux;
            }

        }


    }

    public MatrixData setNewData(String diagonal, String up, String left, int i){

        int resultDiagonal = 0;
        int resultUp = 0;
        int resultLeft = 0;
        MatrixData aux;
        int resultGeneral;

        resultDiagonal = Integer.parseInt(diagonal)+i;
        resultUp = Integer.parseInt(up)+this.scoring.gapsPenalty;
        resultLeft = Integer.parseInt(left)+this.scoring.gapsPenalty;

        resultGeneral = returnUpperNumber(resultDiagonal, resultUp, resultLeft);
        aux = new MatrixData("center", String.valueOf(resultGeneral));

        if(resultDiagonal==resultGeneral){
            aux.setBefore("diagonal");
        }
        else {
            if(resultUp==resultGeneral){
                aux.setBefore("up");
            }
            else{
                if(resultLeft==resultGeneral){
                    aux.setBefore("left");
                }
            }
        }

        if(resultDiagonal==resultGeneral && resultDiagonal==resultLeft){
            aux.setBefore("diagonal-left");
        }
        else {
            if(resultUp==resultGeneral && resultUp==resultLeft){
                aux.setBefore("up-left");
            }
            else{
                if(resultDiagonal==resultGeneral && resultDiagonal==resultUp){
                    aux.setBefore("diagonal-up");
                }
            }
        }

        return aux;
    }

    public int compareTwoCharacter(String a, String b){
        int result = 0;

        if(a.equals(b)){
            result = this.scoring.match;
        }
        else {
            result = this.scoring.missMatch;
        }

        return result;
    }

    public int returnUpperNumber(int x, int y, int z){

        int numbers[] = {x,y,z};
        int upper = numbers[0];//Suponemos que el upper es el primero

        for (int i = 1; i < numbers.length; i++) {
            int actualNumber = numbers[i];
            if (actualNumber > upper) {
                upper = actualNumber;
            }
        }

        return upper;
    }

    public String showMatrix(){
        String output = "";

        for (int x=0; x < this.matrix.length; x++) {
            output += "|";
            for (int y=0; y < this.matrix[x].length; y++) {
                this.matrixData = this.matrix[x][y];
                if(this.matrixData!=null) {
                    output += this.matrixData.data;
                }
                else{
                    output += this.matrix[x][y];
                }
                if (y!=this.matrix[x].length-1) {
                    output += "\t";
                }
            }
            output += "|\n";
        }

        return output;
    }

}
