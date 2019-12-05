package Ejercicio31;

import Ejercicio30.Lista;

public class Negocio {
    public void meta() {
        String msg = "";
        
        msg += "Para ilustrar la inserción de nodos al principio de una lista ";
        msg += "simplemente ligada usando como Nodo un IMC, pueden leerse los ";
        msg += "datos de archivo o capturarlos por centinela. La salida puede ";
        msg += "ser elegible a pantalla o archivo";
        Vista.mostrar(msg);
    }
    
    public void captura() {
        int cuenta = 1;
        Lista lsl = new Lista();
        String centinela = "FIN";
        
        String nombre = Vista.askString("Deme el nombre de la persona" + cuenta
                + " o FIN para terminar");
        while(nombre != centinela) {
            double peso = Vista.askDouble("Cuanto pesa la persona " + cuenta);
            double talla= Vista.askDouble("La talla de la persona " + cuenta);
            
            cuenta++;
            IMC imcp = new IMC(nombre, peso, talla);
            lsl.append(imcp);
            nombre = Vista.askString("Deme el nombre de la persona" + cuenta
                + " o FIN para terminar");
        }
    }
}

class IMC {
    private String nombre;
    private double peso, talla;
    
    public IMC(String nombre, double peso, double talla) {
        setNombre(nombre);
        setPeso(peso);
        setTalla(talla);
    }
    
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPeso(double peso) { this.peso = peso; }
    public void setTalla(double talla) { this.talla = talla; }
    public String getNombre() { return nombre; }
    public double getPeso() { return peso; }
    public double getTalla() { return talla; }
}