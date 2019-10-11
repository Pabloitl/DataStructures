package Ejemplo3;

// Objetivo de cohesión para cualquier manipulación de archivos

import java.io.*;
import cstio.*;

/* Program TestFIOStram

   A test program to save data to a file using FileOutputStream
   and recover information with FileInputStream
*/

class TestFIOStream { // Prueba flujos d entrada/salida por el archivo
    //data to output
    Pizarra p = new Pizarra();
    Dialog dei = new Dialog();
    byte byteArray[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}; // Se puede mejorar

    void inicio() {
        p.out("crea un archivo binario con datos");
        p.out("lo guarda en disco con el nombre que elija el usuario");
        p.out("lee el archivo recien creado abriendolo del disco");
        p.out("y lo deslpiega en una pizarra de información");
        p.setVisible(true);
    }

    String capArchName() {
        String aux;

        do aux = dei.readString("Deme nombre del archivo de datos: ");
        while (aux.length() <= 0);
        return aux;
    }

    public FileOutputStream openOut(String name) { // Salida por archivos
        FileOutputStream outStream = null;
        File outFile;

        // Setup file and stream
        outFile = new File(name);
        try{ outStream = new FileOutputStream( outFile );  }
        catch( FileNotFoundException fnfe ) {
            dei.display("No se creó el archivo " + name);
        }
        return outStream;
    }

    public FileInputStream openIn(String name) throws IOException {
        // entrada por achivo
        FileInputStream inStream = null;
        File inFile;

        //Setup file and stream
        inFile = new File(name);
        try{ inStream = new FileInputStream(inFile); }
        catch (FileNotFoundException fnfe) {
            dei.display("No existe el archivo " + name);
        }
        return inStream;
    }

    public void out (String arch) throws IOException {
        FileOutputStream outStream;

        outStream = openOut(arch);
        // Write data to the stream
        outStream.write(byteArray);
        // >Output done, so close the steam
        outStream.close();
    }

    public void in (String arch) throws IOException {
        // Set up an array to read data in
        int fileSize; // Deuprar
        byte bytebuff[];
        FileInputStream inStream;

        inStream = openIn(arch);
        fileSize = inStream.available();
        bytebuff = new byte[fileSize];
        p.out("\nLa longitud del archivo es: " + fileSize);
        // Read data in and display them
        inStream.read(bytebuff);
        p.out("\ndatos en el archivo " + arch + "\n");
        for(int i = 0; i < bytebuff.length; i++) // Quiza en otro método
            p.out(bytebuff[i] + " ");
        inStream.close();
    }

    public static void main(String args[]) {
        TestFIOStream tfios = new TestFIOStream();
        String archivo;

        tfios.inicio();
        archivo = tfios.capArchName();
        try {
            tfios.out(archivo);
            tfios.in(archivo);
        } catch (IOException ioe) {
            tfios.dei.display("Error de entrada/salida>");
        }
    }
}
