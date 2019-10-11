package Ejercicio4;

public interface Rationalizable {
    void simplify();
    void reduce();
    void solveSignum();
    int gcd(int x, int y);

    //Operators
    Rationalizable sum(Rationalizable r2) throws Exception;
    Rationalizable sub(Rationalizable r2) throws Exception;
    Rationalizable mul(Rationalizable r2) throws Exception;
    Rationalizable div(Rationalizable r2) throws Exception;
    Rationalizable pow(int c) throws Exception;
    Rationalizable negate() throws Exception;
    boolean equals(Rationalizable r2);
    boolean gt(Rationalizable r2);
    boolean lt(Rationalizable r2);
    boolean ge(Rationalizable r2);
    boolean le(Rationalizable r2);
    boolean ne(Rationalizable r2);
}
