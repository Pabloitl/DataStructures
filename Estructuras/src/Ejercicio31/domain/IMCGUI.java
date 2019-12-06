/*PruebaIMCGUI.java
Instituto Tecnologico de Leon
Ingenieria en sistemas computacionales
Programacion orientada a objetos
Martes y Jueves 8:45- 10:25
Viernes 8:45-9:35
Alumno:________________
Numero de tarea:_______
Fecha de entrega:______
Fecha real:_____
*/

package domain;

import cstio.*;

public class IMCGUI {
  Pizarra p = new Pizarra();     // para lanzar los resultados a la pantalla
  Dialog di = new Dialog();     // para captar los datos por teclado
  public MySimpleLinkedList listIMC = new MySimpleLinkedList();      
  double BMI[] = new double[20];// arreglo paralelo conteniendo los resutados
  int cuenta;
  static final String CENTINELA = "FIN";

  public void inicio() {
    p.out("Para desplegar una lista de IMC\n");
    p.setVisible(true);
  }  

  public boolean isNum(String n) {   // determina si una cadena es numerica
    if (n == null) return false;
    try {
       Double.parseDouble(n);
       return true;
    } catch (NumberFormatException e) {
        return false;
      }
  }

  public int datos() {     // captura de datos por centinela
    String aux="";
    cuenta = 0;
    IMC imc;

    do aux = di.readString("Deme el nombre o \"FIN\" para terminar:");
    while (aux.length() == 0);   // lazo valida el nombre
    while (!aux.toUpperCase().equals(CENTINELA) && cuenta < BMI.length) { 
       imc = new IMC();      // construir un nuevo objeto IMC
       imc.setNombre(aux);
       do do aux = di.readString("Deme el peso de la persona:");
          while (!isNum(aux));
       while (!imc.setPeso(Double.parseDouble(aux)));
       do do aux = di.readString("Deme la estatura de la persona:");
          while (!isNum(aux));
       while (!imc.setEstatura(Double.parseDouble(aux)));
       listIMC.insert(imc);
       cuenta++;
       do aux = di.readString("Deme el nombre o \"FIN\" para terminar:");
       while (aux.length() == 0);      
    }
    return cuenta;
  }

  public void calculos() {
    Node temp = listIMC.first;
    IMC imct;
    double peso = 0, estatura = 0; 
    int i = 0;

    while (temp != null && i < BMI.length) 
      if (temp.getInfo() instanceof IMC) {
        imct = (IMC) temp.getInfo();
        peso = imct.getPeso();
        estatura = imct.getEstatura();
        if (estatura != 0)
          BMI[i] =  peso/ Math.pow(estatura,2);
        temp = temp.getNext();
        i++;  
      }
  }

  public String diagnostico(int i) {
    double index = BMI[i];
    String resultado = "";
     
    if (index < 16) resultado = " Delgadez Severa";
    if (index >= 16 && index <17) resultado = " Delgadez Moderada";
    if (index >= 17 && index < 25) resultado = " Complexion Normal";
    if (index >= 25 && index < 30) resultado = " Pre Obeso";
    if (index >= 30) resultado = " Obesidad";
    return resultado;
  } 

  public void resultados() {
    Node temp = listIMC.first;
    double peso = 0, e = 0;
    String n = "";
    int i = 0;
    IMC imct;

    p.out(" #    nombre     Estatura     peso    IMC    Diagnostico\n");
    p.out("________________________________________________________\n");
    while (temp != null) 
      if (temp.getInfo() instanceof IMC) {
        imct = (IMC) temp.getInfo();
        n = imct.getNombre();
        peso = imct.getPeso();
        e = imct.getEstatura();
        p.out((i+1)+".- "+n +" "+e + " "+peso + " "+BMI[i++] +diagnostico(i));
        p.out("\n");
        temp = temp.getNext();
      }
  } 
}

