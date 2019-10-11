package Ejemplo4;

import java.util.*;
import java.text.*;

public class TimeElapsed {
    long inicio = System.currentTimeMillis();
    Scanner sc = new Scanner(System.in);
    long fin, te;
    Date dia;

    void inicial() {
        System.out.println("Calcula tiempo de ejecución del programa\n");
    }

    void entrada() {
        DateFormat formateadorFecha = DateFormat.getDateInstance();

        dia = new Date();
        System.out.println("hola: hoy es: " + formateadorFecha.format(dia));
        System.out.println("\nDeme <enter> para continuar: ");
        sc.nextLine();
    }

    void resulta() {
        DateFormat formateadorHora =
                DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.FRANCE);

        System.out.print("\nEl tiepmo transucrrido durante la ejecución es: ");
        System.out.println(formateadorHora.format(dia));
    }

    void calcula() {
        fin = System.currentTimeMillis();
        te = fin - inicio;
        dia = new Date(te + 3600l * 6000l);
    }

    public static void main(String args[]) {
        TimeElapsed timeElap = new TimeElapsed();

        timeElap.inicial();
        timeElap.entrada();
        timeElap.calcula();
        timeElap.resulta();
    }
}
