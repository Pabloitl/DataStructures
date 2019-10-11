package Tarea3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class Ordenar {
    private byte buff[];

    public static void main(String[] args) throws Exception {
        Ordenar test = new Ordenar();

        if(args.length != 2) {
            test.meta();
            System.out.println("Mal uso de argumentos");
            System.out.println("java Ordenar FUENTE DESTINO");
            System.exit(0);
        }

        test.datos(args[0]);
        test.calculos();
        test.resultados(args[1]);
    }

    public static void meta() {
        System.out.println("Modelar acciones de manipulación de\n" +
            "flujos en forma de canal usando Buffered(i/o)Stream\n" +
            "para ordenar cada dato");
    }

    public void datos(String archivo) throws Exception {
        FileInputStream stream = new FileInputStream(archivo);
        BufferedInputStream in = new BufferedInputStream(stream);
        buff = new byte[in.available()];

        int num, i = -1;
        while((num = in.read()) != -1) {
            buff[++i] = (byte) num;
        }

        in.close();
        stream.close();
    }

    public void calculos() { Arrays.sort(buff); }

    public void resultados(String archivo) throws Exception {
        FileOutputStream stream = new FileOutputStream(archivo);
        BufferedOutputStream out = new BufferedOutputStream(stream);

        out.write(buff);

        out.flush();
        out.close();
        stream.close();
    }
}
