package Ejercicio30;

public interface Listable {
    public  boolean  esVacia();
    private void     insertar(Object x, Nodo p);
    public  void     inserPrimero(Object x);
    private Nodo     localizar(Object x);
    public  void     suprimir(Object x);
    public  void     anula();
}
