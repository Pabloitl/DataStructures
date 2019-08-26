package Ejercicio1;

import java.util.Scanner;

public class FueraRango {
    byte   b;
    short  s;
    int    i;
    long   l;
    float  f;
    double d;
    char   c;
    
    public static void meta() {
        System.out.println("Comprombar por medio de un programa\n"
                + "lo que ocurre cuando intentamos usar valores\n"
                + "fuera del rango permitido en un tipo de datos\n"
                + "primitivo\n");
    }
    
    public static int datos() {
        Scanner in = new Scanner(System.in);

        System.out.print("¿Por cuantas unidades quiere sobrepasar el valor"
                + "máximo? ");
        return in.nextInt();
    }

    public void calculos(int offset) {
        b = (byte)  (Byte.MAX_VALUE      + offset);
        s = (short) (Short.MAX_VALUE     + offset);
        i =          Integer.MAX_VALUE   + offset;
        l =          Long.MAX_VALUE      + offset;
        f =          Float.MAX_VALUE     + offset;
        d =          Double.MAX_VALUE    + offset;
        c = (char)  (Character.MAX_VALUE + offset);
    }
    
    public void resultados() {
        System.out.printf("Byte:\t %d\nShort:\t%d\nInteger:%d\n"
                + "Long:\t%d\nFloat:\t%f\nDouble:\t%f\nCharacter:%c\n",
                b, s, i, l, f, d, c );
    }
}
