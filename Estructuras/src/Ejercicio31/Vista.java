package Ejercicio31;

import javax.swing.JOptionPane;

public class Vista {
    public static void mostrar(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public static String askString(String msg) {
        return JOptionPane.showInputDialog(null, msg);
    }
    
    public static int askInt(String msg) {
        String respuesta;
        while(!isInt(respuesta = JOptionPane.showInputDialog(null, msg)));
        return Integer.parseInt(respuesta);
    }
    
    private static boolean isInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        }
        catch (Exception e) { return false; }
    }
    
    public static double askDouble(String msg) {
        String respuesta;
        while(!isDouble(respuesta = JOptionPane.showInputDialog(null, msg)));
        return Integer.parseInt(respuesta);
    }
    
    private static boolean isDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        }
        catch (Exception e) { return false; }
    }
}
