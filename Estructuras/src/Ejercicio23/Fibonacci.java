package Ejercicio23;

import Ejercicio21.Timer;
import java.util.HashMap;
import java.util.Scanner;

public class Fibonacci {
    HashMap<Integer, Integer> buff = new HashMap();

    public static void main(String[] args) {
        Timer t = new Timer();
        Fibonacci f = new Fibonacci();
        f.meta();
        f.calculos(f.datos());
        f.resultados();
        t.calculos();
        t.resultados();
    }

    public void meta() {
        System.out.print("Desplegar la sucesión ");
        System.out.println("Fibonacci");
    }

    public int datos() {
        Scanner in = new Scanner(System.in);
        System.out.print("Ingrese el límite >> ");
        return in.nextInt();
    }

    public int calculos(int n) {
        if(n >= 0) buff.put(0, 0);
        if(n >= 1) buff.put(1, 1);
        if(!buff.containsKey(n)) buff.put(n, calculos(n - 1) + calculos(n - 2));
        return buff.get(n);
    }

    public void resultados() {
        for(int valor : buff.values())
            System.out.printf("%d ", valor);
        System.out.println();
    }
}
