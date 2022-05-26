package domain;

public class MatrixData {

    public String type;
    public String data;

    public String before;

    public MatrixData(String type, String data) {
        this.type = type;
        this.data = data;
        this.before = "";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }
}
