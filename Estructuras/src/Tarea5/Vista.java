package Tarea5;

import java.util.Scanner;

public class Vista {
    public void mostrar(String msg) {
        System.out.print(msg);
    }

    public void mostrarln(String msg) {
        mostrar(msg);
        System.out.println();
    }

    public int getInt() {
        Vista v = new Vista();
        Scanner in = new Scanner(System.in);

        while(!in.hasNextInt())
            v.mostrarln(in.nextLine() + " no es válido");
        return in.nextInt();
    }
}
