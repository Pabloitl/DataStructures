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
        int temp = f.datos();
        f.calculos(temp);
        f.resultados();
        t.calculos();
        t.resultados();
    }

    public void meta() {
        System.out.print("Desplegar la sucesión ");
        System.out.println("Fibonacci");
    }

    public int datos() {
        return getInt("Ingrese el límite >> ", 0, Integer.MAX_VALUE);
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
    
    private int getInt(String msg, int min, int max) {
        Scanner in = new Scanner(System.in);
        int result;

        do {
            System.out.print(msg);
            while(!in.hasNextInt()) {
                String temp = "";
                try { temp = in.next(); }
                catch (Exception e) {
                    System.out.println("Error");
                    in = new Scanner(System.in);
                }
                System.out.println(temp + " no es valido");
            }
            result = in.nextInt();
        } while(result < min || result > max);
        return result;
    }
}
