package Tarea6.Negocio;

import Tarea6.Persistencia.FileHandler;
import Tarea6.Vista.Graphics;

public class Presentador {
    String dir;
    ListaCircular images;

    /** Test the program */
    public static void main(String[] args) {
        Presentador test =  new Presentador();

        test.meta();
        test.datos();
        test.calculos();
        test.resultados();
    }

    /** Muestra el propósito del programa */
    public void meta() {
        String msg =  "Mostrar en forma de presentación una serie";
        msg       += " de imágenes ubicadas en un directorio escogido";
        msg       += " por el usuario";

        Graphics.alert(msg);
    }

    /** Recoge el nombre del directorio escogido */
    public void datos() { dir = Graphics.chooseDir("Escoge un directorio"); }

    /** Filtra los archivos del directorio */
    public void calculos() {
        String formats = ".*jpg$|.*png$|.*jpeg$"; // Regex
        String[] files = FileHandler.listFiles(dir);

        images = FileHandler.filterFiles(files, formats);
        images.trim();
        if(images.size() == 0) {
            Graphics.alert("No hay imagenes a mostrar");
            System.exit(0);
        }

    }

    /** Muestra la presentación de imágenes */
    public void resultados() {
        Graphics window = new Graphics();
        int i = 0, sleepTime = 2;

        while(true) {
            window.changeImage(dir + "/" +  images.get(i).toString());
            try { Thread.sleep(sleepTime * 1000); }
            catch (InterruptedException ex) {
                Graphics.alert("No se pudo esperar");
            }
            i++;
        }
    }
}
