package Examen1;

public class Vector implements Dirigible {
    double i, j;

    public Vector(Vector v) {
        i = v.getI();
        j = v.getJ();
    }

    public Vector(double i, double j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public Dirigible sum(Dirigible d) {
        Vector v = (Vector) d;
        double i2 = v.getI() + i;
        double j2 = v.getJ() + j;

        return new Vector(i2, j2);
    }

    @Override
    public Dirigible sub(Dirigible d) {
        Vector v = (Vector) d;
        double i2 = v.getI() - i;
        double j2 = v.getJ() - j;

        return new Vector(i2, j2);
    }

    @Override
    public double pesc(Dirigible d) {
        Vector v = (Vector) d;
        double i2 = v.getI() * i;
        double j2 = v.getJ() * j;

        return i2 + j2;
    }

    @Override
    public Dirigible pcruz(Dirigible d) {
        Vector v = (Vector) d;
        double i2 = i * v.getJ();
        double j2 = j * v.getI() * -1;

        return new Vector(i2, j2);
    }

    @Override
    public Dirigible mult(int n) {
        double i2 = n * i;
        double j2 = n * j;

        return new Vector(i2, j2);
    }

    public void setI(double d) { i = d; }
    public void setJ(double d) { j = d; }
    public double getMagnitud() { return Math.sqrt(i * i + j * j); }
    public double getDireccion() { return Math.tan(i / j); }
    public double getI() { return i; }
    public double getJ() { return j; }

    @Override
    public String toString() {  return "<" + i + ", " + j + ">"; }
}
