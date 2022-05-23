package domain;

public class MatrixData {

    public String type;
    public char data;
    public String[] directions;

    public MatrixData(String type, char data) {
        this.type = type;
        this.data = data;
        this.directions = new String[3];
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public String[] getDirections() {
        return directions;
    }

    public void setDirections(String[] directions) {
        this.directions = directions;
    }

}
