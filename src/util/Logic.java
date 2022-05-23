package util;

import domain.MatrixData;
import domain.Scoring;
import main.Menu;

public class Logic {

    Scoring scoring;
    MatrixData matrixData;
    MatrixData[][] matrix;
    Menu menu = new Menu();
    private char[] X;
    private char[] Y;

    public Logic() {
        this.menu.showMenu();
        this.scoring = this.menu.getScoring();
        this.X = this.menu.returnX();
        this.Y = this.menu.returnY();
        this.matrix = new MatrixData[this.menu.returnM()][this.menu.returnN()];
        fillMatrixBorders();
        //M = X
        //N = Y
    }

    public void fillMatrixBorders(){

        matrix[0][0] = matrixData = new MatrixData("border", '*');

        for (int x=1; x < this.menu.returnM(); x++) {
            matrix[x][0] = this.matrixData = new MatrixData("border", this.X[x-1]);
        }

        for (int x=1; x < this.menu.returnN(); x++) {
            matrix[0][x] = this.matrixData = new MatrixData("border", this.Y[x-1]);
        }

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
