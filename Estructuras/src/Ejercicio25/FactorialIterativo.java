package Ejercicio25;

import Ejercicio21.Timer;
import java.math.BigInteger;
import java.util.Scanner;

public class FactorialIterativo {
    public static void main(String[] args) {
        FactorialIterativo f = new FactorialIterativo();
        Timer t = new Timer();

        f.meta();
        f.resultados();
        t.calculos();
        t.resultados();
    }

    public void meta() {
        System.out.println("Calcular la factorial ");
        System.out.println("de manera iterativa");
    }

    public int datos() {
        return getInt("Ingrese un número >> ", 0, Integer.MAX_VALUE);
    }

    public BigInteger calculos(int n) {
        BigInteger r;

        for(r = BigInteger.valueOf(1);n > 1; --n)
            r = r.multiply(BigInteger.valueOf(n));
        return r;
    }

    public void resultados() {
        System.out.print("Resultado: " +
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
