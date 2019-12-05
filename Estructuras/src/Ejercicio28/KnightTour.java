/* KnightTour.java
   protocolo acostumbrado
*/

package Ejercicio28;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class KnightTour {
    String input;
    Tablero t;
    Caballo c;
    int contador;

    public static void main(String[] args) {
        KnightTour test = new KnightTour();

        if(args.length != 1) {
            String msg = "Especifica un archivo para leer los datos";

            System.out.println(msg);
            System.exit(0);
        }
        test.input = args[0];
        test.meta();
        test.datos();
        test.calculos();
        test.resultados();
    }

    public void meta() {
        String meta = "Mostrar la ruta seguida por un caballo";

        meta       += " de ajedrez para recorrer un tablero en su totalidad";
        System.out.println(meta);
    }

    public void datos() {
        Scanner in = null;

        try {  in = new Scanner(new File(input));  }
        catch(FileNotFoundException ex) {
            ex.getStackTrace();
            System.exit(0);
        }
        t = new Tablero(readComponents(in));
        c = new Caballo(readComponents(in));
    }

    private Pair readComponents(Scanner in) {
        try {  return new Pair(in.nextInt(), in.nextInt());  }
        catch(Exception e) {
            String msg = "Ocurrió un error al leer los datos";

            System.out.println(msg);
            System.exit(0);
        }
        return null;
    }

    public void calculos() { path(c.getCoordinates()); }

    private boolean path(Pair point) {
        if(!isValid(point)) return false;
        t.setCasilla(point.getX(), point.getY(), contador++);
        if(contador == Math.pow(t.getSize(), 2)) return true;
        for(Pair newPair : c.nextMoves()){
            c.setCoordinates(newPair);
            if(path(newPair)) return true;
        }
        contador--;
        t.setCasilla(point.getX(), point.getY(), -1);
        return false;
    }

    private boolean isValid(Pair p) {
        if(p.getX() < 0 || p.getX() >= t.getSize()) return false;
        if(p.getY() < 0 || p.getY() >= t.getSize()) return false;
        if(t.getCasilla(p.getX(), p.getY()) >= 0)return false;
        return true;
    }

    public void resultados() {  System.out.println(t);  }
}

class Pair {
    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }

    public int getX() { return x; }

    public int getY() { return y; }
}

class Tablero {
    int size;
    int[][] tablero;

    public Tablero(int size) {
        this.size = size;
        inicializar();
    }

    public Tablero(Pair length) { this(length.getX()); }

    private void inicializar() {
        tablero = new int[size][size];

        for(int[] r : tablero)
            for(int i = 0; i < r.length; ++i)
                r[i] = -1;
    }

    public void setCasilla(int x, int y, int val) { tablero[x][y] = val; }

    public int getCasilla(int x, int y) { return tablero[x][y]; }

    public int getSize() { return size; }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for(int[] r : tablero)
            s.append(Arrays.toString(r)).append("\n");
        return s.toString();
    }
}

class Caballo {
    int posx, posy;
    int[] dx = {2, 1, -1, -2, -2, -1, 1, 2},
          dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public Caballo(int x, int y) {
        posx = x;
        posy = y;
    }

    public Caballo(Pair p) { this(p.getX(), p.getY()); }

    public Pair[] nextMoves() {
        Pair[] moves = new Pair[dx.length];

        for(int i = 0; i < dx.length; ++i)
            moves[i] = new Pair(posx + dx[i], posy + dy[i]);
        return moves;
    }

    public void setCoordinates(Pair point) {
        posx = point.getX();
        posy = point.getY();
    }

    public Pair getCoordinates() { return new Pair(posx, posy); }
}

