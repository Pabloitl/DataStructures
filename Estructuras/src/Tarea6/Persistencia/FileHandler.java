package Tarea6.Persistencia;

import Tarea6.Negocio.ListaCircular;
import java.io.File;

public class FileHandler {
    /** Returns an ArrayList with all the files in directory dir */
    public static String[] listFiles(String dir) {
        return new File(dir).list();
    }

    /** Return the files that match the regex */
    public static ListaCircular<String> filterFiles(String[] files, String pattern) {
        ListaCircular<String> images = new ListaCircular<String>(files.length);

        for(String file : files)
            if(file.matches(pattern))
                    images.append(file);
        return images;
    }
}
