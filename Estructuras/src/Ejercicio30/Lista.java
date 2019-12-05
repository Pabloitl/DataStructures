package Ejercicio30;

public class Lista implements Listable {
    private Node list;
    private int size = 0;

    @Override
    public void empty() {
        list = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public boolean contains(Object x) {
        Node current = list;

        while(current != null) {
            if(current.getX().equals(x)) return true;
            current = current.getNext();
        }
        return false;
    }

    @Override
    public int size() { return size; }

    @Override
    public void append(Object x) { insert(x, size); }

    @Override
    public void preppend(Object x) { insert(x, 0); }

    @Override
    public boolean insert(Object x, int i) {
        Node current = list;

        if(i > size || i < 0) return false;
        if(list == null) list = new Node(x);
        else if(i == 0) {
            list = new Node(x, list);
        }
        else {
            for(int index = 0; index < i - 1; ++index)
                current = current.getNext();
            current.setNext(new Node(x, current.getNext()));
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(int i) {
        Node current = list;
        int index = 0;

        if(size < i) return false;
        while(index++ < i)
            current = current.getNext();
        current.setNext(current.getNext().getNext());
        size--;
        return true;
    }

    @Override
    public boolean set(int i, Object x) {
        Node current = list;
        int index = 0;

        if(size < i) return false;
        while(index++ < i)
            current = current.getNext();
        current.setX(x);
        return true;
    }

    @Override
    public int indexOf(Object x) {
        Node current = list;
        int index = 0;

        while(current != null) {
            if(x.equals(current.getX())) return index;
            current = current.getNext();
            index++;
        }
        return -1;
    }

    @Override
    public Object get(int i) {
        Node current = list;
        int index = 0;

        while(current != null) {
            if(index++ == i) return current.getX();
            current = current.getNext();
        }
        return null;
    }
}

class Node {
    private Object x;
    private Node   next;

    public Node(Object x) { this.x = x; }

    public Node(Object x, Node next) {
        this(x);
        this.next = next;
    }

    public void setX(Object x) { this.x = x; }

    public void setNext(Node next) { this.next = next; }

    public Object getX() { return x; }

    public Node getNext() { return next; }

    @Override
    public String toString() {
        return x.toString();
    }
}