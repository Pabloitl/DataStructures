package Ejercicio25;

import Ejercicio21.Timer;
import java.math.BigInteger;
import java.util.Scanner;

public class FactorialRecursivo {
    public static void main(String[] args) {
        FactorialRecursivo f = new FactorialRecursivo();
        Timer t = new Timer();

        f.meta();
        f.resultados();
        t.calculos();
        t.resultados();
    }

    public void meta() {
        System.out.print("Calcular el factorial");
        System.out.println("de manera recursiva");
    }

    public int datos() {
        return getInt("Ingrese un número >> ", 0, Integer.MAX_VALUE);
    }

    public BigInteger calculos(int n) {
        if(n <= 1) return BigInteger.valueOf(1);
        return calculos(n - 1).multiply(BigInteger.valueOf(n));
    }

    public void resultados() {
        System.out.printf("Resultado: %d\n",
                calculos(datos()));
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
