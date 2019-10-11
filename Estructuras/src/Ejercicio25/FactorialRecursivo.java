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
        Scanner in = new Scanner(System.in);
        System.out.print("Ingrese un número >> ");
        return in.nextInt();
    }

    public BigInteger calculos(int n) {
        if(n <= 1) return BigInteger.valueOf(1);
        return calculos(n - 1).multiply(BigInteger.valueOf(n));
    }

    public void resultados() {
        System.out.printf("Resultado: %d\n",
                calculos(datos()));
    }
}
