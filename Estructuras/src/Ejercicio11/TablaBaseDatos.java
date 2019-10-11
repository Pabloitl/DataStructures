/*
#Numero de registros

Nommbre: 40 bytes
Edad: 4 bytes
Peso: 8 bytes

Nommbre: 40 bytes
Edad: 4 bytes
Peso: 8 bytes

Nommbre: 40 bytes
Edad: 4 bytes
Peso: 8 bytes

TotalL 52 bytes
*/

import Ejercicio11.Registro;
import java.io.*;

public class TablaBaseDatos { // Persistencia del archivo de datos
    private RandomAccessFile miTabla;
    private int numeroRegistros;
    private int longitudR = 52;
    private int desplaza = 4;

    TablaBaseDatos(String tabla) {
        try{
            miTabla = new RandomAccessFile(tabla, "rw");
            if (miTabla.length() == 0) numeroRegistros = 0;
            else numeroRegistros = miTabla.readInt();
        }catch (IOException e) { e.getMessage(); }
    }

    public int dameNumeroRegistros() {
        return numeroRegistros;
    }

    public Registro leeRegistro(int nRegistro) throws IOException {
        String nombre = "";
        int edad;
        double peso;

        miTabla.seek((nRegistro - 1) * longitudR + desplaza);
        for(int i = 0; i < 20; i++) nombre += miTabla.readChar();
        edad = miTabla.readInt();
        peso = miTabla.readDouble();
        return (new Registro(nombre, edad, peso));
    }

    public void escribeRegistro (String nombre, int edad, double peso, int nRegistro) throws IOException {
        int longitud = nombre.length();

        miTabla.seek((nRegistro - 1) * longitudR + desplaza);
        for(int i = 0; i < 20; i++) {
            if (i < longitud)
                miTabla.writeChar(nombre.charAt(i));
            else miTabla.writeChar(' ');
        }
        miTabla.writeInt(edad);
        miTabla.writeDouble(peso);
        numeroRegistros++;
    }

    public void cierraTabla() throws IOException {
        miTabla.seek(0);
        miTabla.writeInt(numeroRegistros);
        miTabla.close();
    }
}
