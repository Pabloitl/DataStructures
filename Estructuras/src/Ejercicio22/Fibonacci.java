package Ejercicio22;

// import Ejercicio21.Timer;
import java.util.Scanner;

public class Fibonacci {
    int l; // Límite
    int[] serie = {0, 1};

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        f.meta();
        f.datos();
        // Timer t = new Timer();
        f.calculos();
        // t.calculos();
        // t.resultados();
    }

    public void meta() { System.out.println("Mostrar la sucesión Fibonacci"); }

    public void datos() {
        Scanner in = new Scanner(System.in);
        String msg = "Ingrese el límite: ";

        l = getInt(msg, 0, Integer.MAX_VALUE);
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

