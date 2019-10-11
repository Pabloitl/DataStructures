package Ejercicio11;

public class Registro { // Faltan getters y setters
    private String nombre;
    private int edad;
    private double peso;

    // Ojo faltan validaciones en el constructos
    // Para aceptar solo nombres != "" y edades y pesos > 0
    public Registro(String nom, int nEdad, double nPeso) {
        nombre = nom;
        edad = nEdad;
        peso = nPeso;
    }

    public String muestraRegistro() {
        return nombre + " " + edad + " " + peso;
    }

    public String dameNombre() {
        return nombre;
    }
}
