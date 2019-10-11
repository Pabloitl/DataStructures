package Ejercicio22;

import Ejercicio21.Timer;
import java.util.Scanner;

public class Fibonacci {
    int l; // Límite
    int[] serie = {0, 1};

    public static void main(String[] args) {
        Timer t = new Timer();
        Fibonacci f = new Fibonacci();
        f.meta();
        f.datos();
        f.calculos();
        t.calculos();
        t.resultados();
    }

    public void meta() { System.out.println("Mostrar la sucesión Fibonacci"); }

    public void datos() {
        Scanner in = new Scanner(System.in);
        System.out.print("Ingrese el límite: ");
        l = in.nextInt();
    }

    public void calculos() {
        if(l >= 0) resultados(serie[0]);
        if(l >= 1) resultados(serie[1]);
        for(int i = 2; i < l; ++i) {
            serie[i % 2] = serie[0] + serie[1];
            resultados(serie[i % 2]);
        }
    }

    public void resultados(int n) {  System.out.print(n + " ");  }
}
