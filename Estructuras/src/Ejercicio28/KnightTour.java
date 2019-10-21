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

    private Point readComponents(String msg, Scanner in) {
        return new Point(in.nextInt(), in.nextInt());
    }

    public void calculos() { path(c.getCoordinates()); }

    private boolean path(Point point) {
        if(!isValid(point)) return false;
        t.setCasilla(point.getX(), point.getY(), contador++);
        if(contador == Math.pow(t.getX(), 2)) return true;
        for(Point newPoint : c.nextMoves()){
            c.setCoordinates(newPoint);
            if(path(newPoint)) return true;
        }
        contador--;
        t.setCasilla(point.getX(), point.getY(), -1);
        return false;
    }

    private boolean isValid(Point p) {
        if(p.getX() < 0 || p.getX() >= t.getX()) return false;
        if(p.getY() < 0 || p.getY() >= t.getX()) return false;
        if(t.getCasilla(p.getX(), p.getY()) >= 0)return false;
        return true;
    }

    public void resultados() {
        System.out.println(t);
    }
}

class Point {
    private int x, y;

    public Point(int x, int y) {
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

class Tablero extends Point {
    int[][] tablero;

    public Tablero(int x, int y) {
        super(x, y);
        inicializar();
    }

    public Tablero(Point p) {
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

class Caballo extends Point {
    int[] dx = {2, 1, -1, -2, -2, -1, 1, 2},
          dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public Caballo(int x, int y) {
        super(x, y);
    }

    public Caballo(Point p) {
        this(p.getX(), p.getY());
    }

    public Point[] nextMoves() {
        Point[] moves = new Point[dx.length];
        for(int i = 0; i < dx.length; ++i) {
            moves[i] = new Point(getX() + dx[i], getY() + dy[i]);
        }
        return moves;
    }

    public void setCoordinates(Point point) {
        setX(point.getX());
        setY(point.getY());
    }

    public Point getCoordinates() {
        return new Point(getX(), getY());
    }
}
