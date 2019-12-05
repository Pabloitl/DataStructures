package Tarea6.Negocio;

import java.util.Arrays;

public class ListaCircular<T> implements Listable<T> {
    int size;
    T[] list;

    public ListaCircular(int maxSize) { list = (T[]) new Object[maxSize]; }

    @Override
    public void empty() { size = 0; }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public boolean contains(T x) {
        for(T element : list)
            if(element.equals(x))
                return true;
        return false;
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean append(T x) { return insert(x, size); }

    @Override
    public boolean preppend(T x) { return insert(x, 0); }

    @Override
    public boolean insert(T x, int i) {
        if(size == list.length - 1) return false;
        for(int index = size; index > i; ++index)
            list[index] = list[index - 1];
        list[i] = x;
        size++;
        return true;
    }

    @Override
    public boolean remove(int i) {
        if(size < i) return false;
        size--;
        return true;
    }

    @Override
    public boolean set(int i, T x) {
        if(size < i) return false;
        list[i] = x;
        return true;
    }

    @Override
    public int indexOf(T x) {
        for(int i = 0; i < size; ++i)
            if(list[i].equals(x))
                return i;
        return -1;
    }

    @Override
    public T get(int i) { return list[i % size]; }

    @Override
    public void trim() { list = Arrays.copyOf(list, size); }
}
