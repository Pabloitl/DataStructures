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
        Scanner in = new Scanner(System.in);
        System.out.print("Ingrese un número >> ");
        return in.nextInt();
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
}
