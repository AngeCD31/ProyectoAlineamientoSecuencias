package domain;

public class Node {

    private Object element;
    Node next;

    public Node(Object e) {
        this.element = e;
        this.next = null;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object e) {
        this.element = e;
    }

}
