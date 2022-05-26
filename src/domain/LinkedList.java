package domain;

public class LinkedList {

    Node first;
    Node last;

    public LinkedList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty(){
        return this.first==null;
    }

    public int size() {
        if(this.isEmpty()){
            return 0;
        }
        Node aux = this.first;
        int count = 0;

        while(aux!=null){
            count++;
            aux = aux.next;
        }
        return count;
    }

    public void addElement(Object e){

        Node newNode = new Node(e);

        if(this.isEmpty()){
            this.last = this.first = newNode;
        }
        else {
            Node aux = this.first;

            while (aux.next != null){
                aux = aux.next;
            }

            aux.next = newNode;
            this.last = newNode;
        }

    }

    public void removeLast(){
        if(this.isEmpty()){
            System.out.println("La lista está vacía");
        }
        else{
            Node aux = this.first;

            if(this.first==this.last){
                this.first = this.last = null;
            }

            else {
                while (aux.next != this.last) {
                    aux = aux.next;
                }

                this.last = aux;
                this.last.next = null;
            }


            }
    }

    public void removeFirst(){
        if(this.isEmpty()){
            System.out.println("La lista está vacía");
        }
        else{

            if(this.first==this.last){
                this.first = this.last = null;
            }

            else {
                this.first = this.first.next;
            }


        }
    }


    public String toString() {
        String result="";

        if(this.isEmpty()){
            result = "La lista está vacía";
        }
        else {
            Node aux = this.first;

            while (aux != null) {
                result += aux.getElement() + "\n";
                aux = aux.next;
            }
        }
        return result;
    }

}
