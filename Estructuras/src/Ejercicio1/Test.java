package Ejercicio1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        FueraRango ejercicio = new FueraRango();
        Scanner in = new Scanner(System.in);
        
        FueraRango.meta();
        do {
            ejercicio.calculos(FueraRango.datos());
            ejercicio.resultados();
            System.out.print("¿Quiere cambiar la cantidad escogida? ");
        }while(in.next().equals("Si"));
    }
}
