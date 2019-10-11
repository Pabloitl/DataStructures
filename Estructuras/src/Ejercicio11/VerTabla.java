/* NO SOBREPASAR LAS 80 COLUMNAS */
package Ejercicio11;

import Ejercicio11.Registro;
import java.util.*;
import java.io.*;

public class VerTabla{ // Capa del usuario y clase de pruaba
    Scanner sc = new Scanner(System.in);
    TablaBaseDatos t;  // = new TablaBaseDatos("DAtos.dir");
    int nR;

    void inicio() {
        System.out.println("Para agregar registros en una tabla de ");
        System.out.println("datos con accew aleatorio.");
    }
    String pideNombreArchivo() {
        System.out.print("Diga el archivo que desea usar: ");
        return sc.nextLine();
    }

    int capInt(String s) {
        int edad = 0;

        System.out.print(s);
        try {
            edad = sc.nextInt();
            sc.nextLine(); // Leer el enter que se quedo en el buffer del teclado
        } catch (Exception e) {
            System.out.println("capInt: Exception: ");
            sc.nextLine();
            edad = 0;
        }
        return edad;
    }

    double capDouble(String s) {
        double peso = 0.0;

        System.out.print(s);
        try {
            peso = sc.nextDouble();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("capDouble Exception"); // es Optativo
            sc.nextLine();
            peso = 0;
        }
        return peso;
    }

    void datos() throws IOException {
        String nombre;
        int edad;
        double peso;

        System.out.print("NOmbre: "); //Entrada por tecado
        nombre = sc.nextLine();
        do edad = capInt("Edad: ");
        while (edad < 0);
        do peso = capDouble("Peso: ");
        while(peso < 0.0);
        nR = t.dameNumeroRegistros();
        nR++;
        t.escribeRegistro(nombre, edad, peso, nR); // Salida al disco
    }

    void reporta() throws IOException {
        for (int i = 1; i <= nR; i++) {
            Registro r = t.leeRegistro(i); // Entrada por archivo
            System.out.println(r.muestraRegistro()); // Salida por pantalla
        }
    }

    public static void main(String argumentos[]) throws Exception {
        VerTabla vt = new VerTabla();
        String archName;

        vt.inicio();
        archName = vt.pideNombreArchivo();
        vt.t = new TablaBaseDatos(archName);
        vt.datos();
        vt.reporta();
        vt.t.cierraTabla();
    }
}
