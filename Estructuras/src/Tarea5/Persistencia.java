package Tarea5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Persistencia {
    String permission[] = {"r", "w"};
    Scanner in;
    FileWriter out;
    File f;

    public Persistencia(String f, String mode) {
        this.f = new File(f);
        init(mode);
    }

    private void init(String mode) {
        try {
            if(mode.equals(permission[0])) {
                in = new Scanner(f);
            } else if(mode.equals(permission[1])) {
                out = new FileWriter(f);
            }
        } catch(Exception e) {
            System.exit(0);
        }
    }

    public double leerDouble() {
        double d;

        if(in == null) return -1;
        try {
            d = Double.parseDouble(in.nextLine());
        } catch(Exception e) {
            return 0;
        }
        return d;
    }

    public void escribir(String msg) {
        if(out == null) return;
        try {
            out.write(msg);
        } catch(IOException ex) {
            System.exit(0);
        }
    }

    public void cerrar() {
        try {
            if(out != null) out.close();
            else if(in != null) in.close();
        } catch(Exception e) {
            System.exit(0);
        }
    }
}
