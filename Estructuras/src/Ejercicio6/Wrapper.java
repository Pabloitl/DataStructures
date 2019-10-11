package Ejercicio6;

import Ejercicio4.Rational;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Wrapper {
    public static void main(String[] args) {
        Wrapper test = new Wrapper();
        test.showGoal();
        while(true) {
            test.showResult(test.showMenu());
        }
    }

    private void showGoal() {
        System.out.println("Test (ADT) Rational class");
    }

    private int showMenu() {
        System.out.print(
                "Menú:\n" +
                "1.- Setters\n" +
                "2.- Getters\n" +
                "3.- Algebraic operations\n" +
                "4.- Relational operations\n" +
                "5.- Simplification\n" +
                "Any other number - Exit\n" +
                ">>> ");
        return getInt();
    }

    private Rational[] getRational(int n) {
        Rational arr[] = new Rational[n];
        int numerator, denominator;

        for(int i = 0; i < n; i++) {
            System.out.printf("Rational N°%d\n", i);
            System.out.print("Input a numerator >>> ");
            numerator = getInt();
            System.out.print("Input a denominator >>> ");
            denominator = getInt();

            try {
                arr[i] = new Rational(numerator, denominator);
            }catch(Exception ex) {
                System.out.println(ex.getMessage());
                i--;
            }
        }
        return arr;
    }

    private void showResult(int option) {
        switch(option) {
            case 1:
                testSetters();
                break;
            case 2:
                testGetters();
                break;
            case 3:
                testAlgebraic();
                break;
            case 4:
                testRelational();
                break;
            case 5:
                testSimplification();
                break;
            default:
                System.exit(0);
        }
    }

    private void testSetters() {
        try {
            Rational arr[] = getRational(1);
            System.out.printf("From %s\n", arr[0]);

            System.out.println("setNumerator");
            System.out.print("Change numerator to: ");
            arr[0].setNumerator(getInt());
            System.out.println(arr[0]);

            System.out.println("setDenominator");
            System.out.print("Change denominator to: ");
            arr[0].setDenominator(getInt());
            System.out.println(arr[0]);

            System.out.println("set");
            System.out.print("Change numerator to: ");
            int numerator = getInt();
            System.out.print("Change denominator to: ");
            int denominator = getInt();
            arr[0].set(numerator, denominator);
            System.out.println(arr[0]);
        } catch (Exception ex) {
            System.out.println("Can't set denominator to 0");
        }
    }

    private void testGetters() {
        Rational arr[] = getRational(1);
        System.out.printf("getNumerator   -> %d\n", arr[0].getNumerator());
        System.out.printf("getDenominator -> %d\n", arr[0].getDenominator());
        System.out.printf("get -> %f\n", arr[0].get());
    }

    private void testAlgebraic() {
        Rational arr[] = getRational(2);
        try {

            System.out.printf("r1 + r2 -> %s\n", arr[0].sum(arr[1]));
            System.out.printf("r1 - r2 -> %s\n", arr[0].sub(arr[1]));
            System.out.printf("r1 * r2 -> %s\n", arr[0].mul(arr[1]));
            System.out.printf("r1 / r2 -> %s\n", arr[0].div(arr[1]));
            System.out.printf("r1 ^ 2  -> %s\n", arr[0].pow(2));
            System.out.printf("-r1     -> %s\n", arr[0].negate());
        } catch (Exception ex) {
            System.out.println("An operation returned a 0 in the denominator");
        }
    }

    private void testRelational() {
        Rational arr[] = getRational(2);
        System.out.printf("r1 == r2 -> %s\n", arr[0].equals(arr[1]));
        System.out.printf("r1 > r2  -> %s\n", arr[0].gt(arr[1]));
        System.out.printf("r1 < r2  -> %s\n", arr[0].lt(arr[1]));
        System.out.printf("r1 >= r2 -> %s\n", arr[0].ge(arr[1]));
        System.out.printf("r1 <= r2 -> %s\n", arr[0].le(arr[1]));
        System.out.printf("r1 != r2 -> %s\n", arr[0].ne(arr[1]));
    }

    private void testSimplification() {
        Rational arr[] = getRational(1);

        System.out.printf("After simplifying %s\n", arr[0]);
    }

    private int getInt() {
        Scanner in = new Scanner(System.in);
        while(!in.hasNextInt()) {
            System.out.print(in.nextLine() + " is not valid\n>>> ");
        }
        return in.nextInt();
    }
}
