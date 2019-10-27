package Ejemplo5;

public class Node {
    private Object info;
    private Node next;

    public Node() {
        info = null;
        next = null;
    }

    public Node(Object valor) { this(valor, null); }

    public Node(Object o, Node n) {
        setInfo(o);
        setNext(n);
    }

    public void setInfo(Object info) { this.info = info; }
    public void setNext(Node next) {this.next = next; }
    public Object getInfo() { return info; }
    public Node getNext() { return next; }
}
