package Tarea5;

import Examen1.Vector;
import java.util.Scanner;

public class TestVector {
    String msg, in, out;
    int option;

    public static void main(String[] args) {
        TestVector t = new TestVector();

        if(args.length != 2) {
            t.meta();
            System.exit(1);
        }
        t.in  = args[0];
        t.out = args[1];
        do {
            t.mostrarMenu();
        } while(t.option <= 0 || t.option >= 3);
        t.direccionar();
        t.resultados();
    }

    public void meta() {
        Vista v = new Vista();
        String msg = "Probar la clase Vector derivada de";
        msg += " Dirigible ADT";

        v.mostrar(msg);
    }

    public Vector[] datos(int n) {
        Vector vectors[] = new Vector[n];
        Persistencia p = new Persistencia(in, "r");

        for(int i = 0; i < n; ++i) {
            double x = p.leerDouble();
            double y = p.leerDouble();
            vectors[i] = new Vector(x, y);
        }
        p.cerrar();
        return vectors;
    }

    public void testSetters() {
        Vector vectors[] = datos(1);
        int comp[] = {0, 1};

        msg  = "v(original) = " + vectors[0] + "\n";
        vectors[0].setI(comp[0]);
        vectors[0].setJ(comp[1]);
        msg += "v(despues)  = " + vectors[0] + "\n";
    }

    public void testGetters() {
        Vector vectors[] = datos(1);

        msg  = "I   -> " + vectors[0].getI() + "\n";
        msg += "J   -> " + vectors[0].getJ() + "\n";
        msg += "|v| -> " + vectors[0].getMagnitud() + "\n";
        msg += "<   -> " + vectors[0].getDireccion() + "\n";
    }

    public void testOperations() {
        Vector vectors[] = datos(2);
        int escalar = 2;

        msg  = "v1 + v2 = " + vectors[0].sum(vectors[1]) + "\n";
        msg += "v1 - v2 = " + vectors[0].sub(vectors[1]) + "\n";
        msg += "v1 . v2 = " + vectors[0].pesc(vectors[1]) + "\n";
        msg += "v2 x v2 = " + vectors[0].pcruz(vectors[1]) + "\n";
        msg += "2(v1)   = " + vectors[0].mult(escalar) + "\n";
    }

    public void resultados() {
        escribir();
        mostrar();
    }

    public void escribir() {
        Persistencia p = new Persistencia(out, "w");

        p.escribir(msg);
        p.cerrar();
    }

    public void mostrar() {
        Vista v = new Vista();

        v.mostrar(msg);
    }

    private void mostrarMenu() {
        Vista v = new Vista();

        v.mostrarln("Menu: ");
        v.mostrarln("1.- Setters");
        v.mostrarln("2.- Getters");
        v.mostrarln("3.- Operaciones");
        v.mostrar("opción: ");
        option = v.getInt();
    }

    private void direccionar() {
        switch(option) {
            case 1: testSetters();    break;
            case 2: testGetters();    break;
            case 3: testOperations(); break;
            case 4: System.exit(0);
        }
    }
}

