package Ejercicio30;

public class Lista implements Listable {
    Nodo p;

    @Override
    public boolean esVacia() { return p == null; }

    @Override
    private void insertar(Object x, Nodo p) {
        Nodo nuevo = new Nodo(x, p.next);
        p.next = nuevo;
    }

    @Override
    public void inserPrimero(Object x) { insertar(x, p); }

    @Override
    private Object localizar(Object x) {
        if(esVacia()) return null;
        Nodo current = p;
        while(!x.equals(current.getX()) && p.getNext() != null)
            current = p.getNext();
        return current;
    }

    @Override
    public void suprimir(Object x) {
        Nodo temp = localizar(x);
        temp.setX() = temp.getNext().getX();
        temp.setNext() = temp.getNext().getNext();
        temp.getNext().setNext(null);
    }

    @Override
    public void anula() {
        p = null;
    }

    @Override
    public String toString() {
        if(esVacia()) return "";
        StringBuilder lista = new StringBuilder();
        Nodo current = p;
        while(!x.equals(current.getX()) && p.getNext() != null) {
            lista.append(current.getX().toSTring());
            current = p.getNext();
        }
        return lista.toString();
    }
}

public class Nodo {
    Object x;
    Nodo   next;

    public Nodo(Object x) { this.x = x; }

    public Nodo(Object x, Nodo next) {
        this(x);
        this.next = next;
    }

    public void setX(Object x) { this.x = x; }
    public void setNext(Nodo next) { this.next = next; }
    public Object getX() { return x; }
    public Nodo getNext() { return next; }

    @Override
    public String toString() {
        return x.toString();
    }
}
