package Ejercicio4;

public class Rational implements Rationalizable {
    private int x, y;

    public Rational() {
        x = 0;
        y = 1;
        simplify();
    }

    public Rational(Rational r2) throws Exception {
        x = r2.getNumerator();
        y = r2.getDenominator();
        simplify();
    }

    public Rational(int x, int y) throws Exception {
        this.x = x;
        setDenominator(y);
    }

    public void setNumerator(int x) {
        this.x = x;
        simplify();
    }

    public void setDenominator(int y) throws Exception {
        if(y == 0) throw new Exception("Denominator can't be 0");
        this.y = y;
        simplify();
    }

    public void set(int x, int y) throws Exception {
        this.x = x;
        setDenominator(y);
    }

    public int getNumerator() {
        return x;
    }

    public int getDenominator() {
        return y;
    }

    public float get() {
        return x / (float) y;
    }

    @Override
    public Rationalizable sum(Rationalizable r) throws Exception {
        Rational r2 = (Rational) r;
        int numerator = x * r2.getDenominator() + r2.getNumerator() * y;
        int denominator = y * r2.getDenominator();
        return new Rational(numerator, denominator);
    }
    
    @Override
    public Rationalizable sub(Rationalizable r) throws Exception {
        Rational r2 = (Rational) r;
        int numerator = x * r2.getDenominator() - r2.getNumerator() * y;
        int denominator = y * r2.getDenominator();
        return new Rational(numerator, denominator);
    }

    @Override
    public Rationalizable mul(Rationalizable r) throws Exception {
        Rational r2 = (Rational) r;
        int numerator = x * r2.getNumerator();
        int denominator = y * r2.getDenominator();
        return new Rational(numerator, denominator);
    }

    @Override
    public Rationalizable div(Rationalizable r) throws Exception {
        Rational r2 = (Rational) r;
        int numerator = x * r2.getDenominator();
        int denominator = y * r2.getNumerator();
        return new Rational(numerator, denominator);
    }

    @Override
    public Rationalizable pow(int c) throws Exception {
        int numerator = (int) Math.pow(x, c);
        int denominator = (int) Math.pow(y, c);
        return new Rational(numerator, denominator);
    }

    @Override
    public Rationalizable negate() throws Exception {
        return new Rational(-x, y);
    }

    @Override
    public boolean equals(Rationalizable r) {
        Rational r2 = (Rational) r;
        return get() == r2.get();
    }

    @Override
    public boolean gt(Rationalizable r) {
        Rational r2 = (Rational) r;
        return get() > r2.get();
    }

    @Override
    public boolean lt(Rationalizable r) {
        Rational r2 = (Rational) r;
        return get() < r2.get();
    }

    @Override
    public boolean ge(Rationalizable r) {
        Rational r2 = (Rational) r;
        return get() >= r2.get();
    }

    @Override
    public boolean le(Rationalizable r) {
        Rational r2 = (Rational) r;
        return get() <= r2.get();
    }

    @Override
    public boolean ne(Rationalizable r) {
        Rational r2 = (Rational) r;
        return get() != r2.get();
    }

    @Override
    public String toString() {
        return x + "/" + y;
    }

    @Override
    public void simplify() {
        reduce();
        solveSignum();
    }

    @Override
    public void reduce() {
        int div = gcd(x, y);
        x /= div;
        y /= div;
    }
    
    @Override
    public void solveSignum() {
        if(y < 0){
            x *= -1;
            y *= -1;
        }
    }

    @Override
    public int gcd(int x, int y) {
        if(y == 0) return x;
        return gcd(y, x % y);
    }
}
