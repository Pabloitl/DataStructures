package Ejercicio30;

public interface Listable {
    public void    empty();
    public boolean isEmpty();
    public boolean contains(Object x);
    public int     size();
    public void    append(Object x);
    public void    preppend(Object x);
    public boolean insert(Object x, int i);
    public boolean remove(int i);
    public boolean set(int i, Object x);
    public int     indexOf(Object x);
    public Object  get(int i);
}
