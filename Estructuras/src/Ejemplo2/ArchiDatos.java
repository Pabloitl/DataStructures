package Ejemplo2;

//2.- Datos: Usa arss[0] como el arhvio de entrada
//    Usa un arreglo A[] como buffer
//    in = abrir(args[0])
//    i= 0
//    mientras ( in != EOF) emperzar
//        s = in.lee()
//        A[i] = atof(s)
//    terminar
//3.- Calculos:
//    desde i = 0; i < A.length; incrementa i para
//        A[i] = A[i] + 10.5
//4.- Resultados: Usa args[1] como el archivo de salida
//    out = abrir(args[1])
//
//    desde i = ; i < A.length; incrementa i para
//        escribe(out, A[i])
//5.- Navegabilidad: Sin navegavbilidad

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ArchiDatos {
    double A[] = new double[50];

    public void inicio() {
        System.out.print("Programa para ilustrar la lectura y escritura de"
                + "archivos para manipular sus datos en un arreglo");
    }

    public void datosIn(String file) {
        String s;
        int i = 0;
        Scanner in = null;

        try {
            in = new Scanner(new File(file));

            while (in.hasNextLine()) {
                s = in.nextLine();
                A[i++] = Double.parseDouble(s);
            }
            System.out.print("Se leyeron los datos");
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
            e.printStackTrace();
        } finally { in.close(); }
    }

    public void datosOut(String file) {
        PrintStream out = null;

        try {
            out = new PrintStream(new FileOutputStream(file));

            for (int i = 0; i < A.length & A[i] != 0.0; i++)
                out.println(A[i]);
            System.out.println("Se escribieron los datos en : ");
        } catch (FileNotFoundException e) {
            System.out.println("Error al dar salida en archivo");
            e.printStackTrace();
        } finally { out.close(); }
    }

    public static void main(String args[]) {
        ArchiDatos rwf = new ArchiDatos();

        rwf.inicio();
        rwf.datosIn(args[0]);
        rwf.datosOut(args[1]);
        System.out.println("Proceso terminado");
    }
}
