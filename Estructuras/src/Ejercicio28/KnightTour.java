package Ejercicio28;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class KnightTour {
    Tablero t;
    Caballo c;
    int contador;

    public static void main(String[] args) {
        KnightTour test = new KnightTour();
        test.meta();
        test.datos();
        test.calculos();
        test.resultados();
    }

    public void meta() {
        System.out.println("Mostrar la ruta seguida por un caballo"
        + "de ajedrez para recorrer un tablero en su totalidad");
    }

    public void datos() {
        Scanner in = null;
        try {
            in = new Scanner(new File("src/Ejercicio28/Coordenadas.txt"));
        } catch(FileNotFoundException ex) { ex.getStackTrace(); }
        t = new Tablero(readComponents("Tablero", in));
        c = new Caballo(readComponents("Punto inicial del caballo", in));
    }

    private Pair readComponents(String msg, Scanner in) {
        return new Pair(in.nextInt(), in.nextInt());
    }

    public void calculos() { path(c.getCoordinates()); }

    private boolean path(Pair point) {
        if(!isValid(point)) return false;
        t.setCasilla(point.getX(), point.getY(), contador++);
        if(contador == Math.pow(t.getX(), 2)) return true;
        for(Pair newPair : c.nextMoves()){
            c.setCoordinates(newPair);
            if(path(newPair)) return true;
        }
        contador--;
        t.setCasilla(point.getX(), point.getY(), -1);
        return false;
    }

    private boolean isValid(Pair p) {
        if(p.getX() < 0 || p.getX() >= t.getX()) return false;
        if(p.getY() < 0 || p.getY() >= t.getX()) return false;
        if(t.getCasilla(p.getX(), p.getY()) >= 0)return false;
        return true;
    }

    public void resultados() {
        System.out.println(t);
    }
}

class Pair {
    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Tablero extends Pair {
    int[][] tablero;

    public Tablero(int x, int y) {
        super(x, y);
        inicializar();
    }

    public Tablero(Pair p) {
        this(p.getX(), p.getY());
    }

    private void inicializar() {
        tablero = new int[getX()][getY()];

        for(int[] r : tablero)
            for(int i = 0; i < r.length; ++i)
                r[i] = -1;
    }

    public void setCasilla(int x, int y, int val) {
        tablero[x][y] = val;
    }

    public int getCasilla(int x, int y) {
        return tablero[x][y];
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(int[] r : tablero) {
            s.append(Arrays.toString(r)).append("\n");
        }
        return s.toString();
    }
}

class Caballo extends Pair {
    int[] dx = {2, 1, -1, -2, -2, -1, 1, 2},
          dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public Caballo(int x, int y) {
        super(x, y);
    }

    public Caballo(Pair p) {
        this(p.getX(), p.getY());
    }

    public Pair[] nextMoves() {
        Pair[] moves = new Pair[dx.length];
        for(int i = 0; i < dx.length; ++i) {
            moves[i] = new Pair(getX() + dx[i], getY() + dy[i]);
        }
        return moves;
    }

    public void setCoordinates(Pair point) {
        setX(point.getX());
        setY(point.getY());
    }

    public Pair getCoordinates() {
        return new Pair(getX(), getY());
    }
}
