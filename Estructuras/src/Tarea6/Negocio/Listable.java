package Tarea6.Negocio;

public interface Listable<T> {
    public void    empty();
    public boolean isEmpty();
    public boolean contains(T x);
    public int     size();
    public boolean append(T x);
    public boolean preppend(T x);
    public boolean insert(T x, int i);
    public boolean remove(int i);
    public boolean set(int i, T x);
    public int     indexOf(T x);
    public T       get(int i);
    public void    trim();
}
