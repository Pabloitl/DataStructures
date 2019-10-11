package Tarea2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Wrapper {
  Integer i, j, opt;

  public static void main(String[] args){
    new Wrapper().run();
  }

  public void meta(){
    System.out.println("Para hacer conciente al programador del uso\n"
    + "de las prestaciones de los tipos de datos envolventes\n"
    + "en su lenguaje de programación favorito. Verifique la\n"
    + "documentación de los paquetes de biblioteca predefinidos\n"
    + "de su lenguaje, elija uno y dentro de el una clase para\n"
    + "modelar un algoritmo y un programa capaz de ilustrar\n"
    + "cada uno de sus métodos");
  }

  public void run(){
    Scanner in = new Scanner(System.in);
    meta();
    try{
      do{
        System.out.print("Escoga el tipo de prestación que quiere ver\n" +
          "1.- byte\n" +
          "2.- boolean\n" +
          "3.- int\n" +
          "4.- short\n" +
          "5.- long\n" +
          "6.- float\n" +
          "7.- double\n" +
          "8.- Integer\n" +
          "9.- String\n" +
          "10.- Constantes\n" +
          "11.- Salir\n>>");
          opt = in.nextInt();
          if(opt == 11){
            System.out.println("Hasta luego!");
            System.exit(0);
          }
          else{
            datos();
            resultados();
          }
      }while(opt >= 1 && opt <= 10);
    }catch(InputMismatchException e){
      System.out.println("Error, introduzca un número entero\n");
      run();
    }
  }

  public void datos(){
    Scanner in = new Scanner(System.in);
    try{
      if(opt <= 10 && opt >= 1){
        System.out.print("Ingrese primer entero: ");
        i = in.nextInt();
        System.out.print("Ingrese segundo entero: ");
        j = in.nextInt();}
    }catch(InputMismatchException e){
      System.out.println("Error, introduzca un número entero\n");
      datos();
    }
  }

  public void resultados(){
    switch(opt){
      case 1: probarByte(); break;
      case 2: probarBoolean(); break;
      case 3: probarInt(); break;
      case 4: probarShort(); break;
      case 5: probarLong(); break;
      case 6: probarFloat(); break;
      case 7: probarDouble(); break;
      case 8: probarInteger(); break;
      case 9: probarString(); break;
      case 10: probarConstantes(); break;
      default: System.out.println("Opción no valida.\n");
               run();
    }
  }

  void probarByte() {
      System.out.println("byteValue regresa el entero como byte\n\t" +
          i.byteValue());
  }

  void probarBoolean() {
      System.out.println("equals regresa true si los objetos son" +
          "iguales y false en caso contrario\n\t" + i.equals(j));
  }

  void probarInt() {
      probarPrimerInt();
      probarSegundoInt();
  }

  void probarPrimerInt() {
          System.out.println("bitCount regresa el número de 1's en "
              + "la representacińo binaria\n\t" + Integer.bitCount(i) + "\n"
              + "divideUnsigned regresa el cociente de realizar la división "
              + "del primer argumento entre el segundo\n\t"
              + Integer.divideUnsigned(i, j) + "\n"
              + "remainderUnsigned regresa el residuo de realizar la división"
              + " del primer argumento entre el segundo\n\t"
              + Integer.remainderUnsigned(i, j) + "\n"
              + "sum regresa el resultado de sumar sus argumentos\n\t"
              + Integer.sum(i, j) + "\n"
              + "compare regresa 0 si ambos valores son iguales, "
              + ">0 si (1)>(2), " + "<0 si (1)<(2)\n\t"
              + Integer.compare(i, j) + "\n"
              + "compareTo compara dos valores enteros, el resultado es el "
              + "mismo que en el anterior\n\t" + i.compareTo(j) + "\n"
              + "hashCode regresa el hash code igual al valor del entero "
              + "primitivo representado por la clase\n\t"
              + Integer.hashCode(i) + "\n"
              +"highesetOneBit regresa el valor del bit más significante\n\t"
              + Integer.highestOneBit(i)
              + "\n" + "intValue regresa el valor del Integer como int\n\t"
              + i.intValue() + "\n"
              + "lowestOneBit regresa el valor del bit menos significante\n\t"
              + Integer.lowestOneBit(i) + "\n"
              + "numberOfLeadingZeros regresa el número de ceros a la izquierda"
              + " en su representación binaria\n\t"
              + Integer.numberOfLeadingZeros(i));
  }

  void probarSegundoInt() {
        System.out.println("numberOfTrailingZeros regresa el número"
              + "de ceros a la derecha"
              + "en su representación binaria\n\t"
              + Integer.numberOfTrailingZeros(i) + "\n"
              + "parseInt regresa el entero representado por un string\n"
              + "Arroja (NumberFormatException)\n\t"
              + Integer.parseInt(i.toString()) + "\n"
              + "parseUnsignedInt regresa el entero representado por un "
              + "string\nArroja (NumberFormatException)\n\t"
              + Integer.parseUnsignedInt(i.toString()) + "\n"
              + "reverse regresa el valor de voltear el orden de los bits\n\t"
              + Integer.reverse(i) + "\n"
              + "reverseBytes regresa el valor de voltear el orden de los "
              + "bytes\n\t" + Integer.reverseBytes(i) + "\n"
              + "rotateLeft regresa el valor despues de rotar los bits a la "
              + "izquierda\n\t" + Integer.rotateLeft(i, 1) + "\n"
              + "rotateRight regresa el valor despues de rotar los bits a la "
              + "derecha\n\t" + Integer.rotateRight(i, 1) + "\n"
              + "signum regresa -1 si el valor es negativo, 0 si el valor es "
              + "cero y 1 si el valor es positivo\n\t"
              + Integer.signum(i) + "\n"
              + "max regresa el entero mas grande de sus parámetros"
              + Integer.max(i, j) + "\n"
              + "min regresa el entero menos de sus parámetros\n\t"
              + Integer.min(i, j));
  }

  void probarShort() {
      System.out.println("shortValue regresa el entero como "
          + "short\n\t" + i.shortValue());
  }

  void probarLong() {
      System.out.println("longValue regresa el entero como "
          + "long\n\t" + i.longValue() + "\n"
          + "toUnsignedLong regresa el entero como un long sin signo\n\t"
          + Integer.toUnsignedLong(i));
  }

  void probarFloat() {
      System.out.println("floatValue regresa el entero como "
          + "float\n\t" + i.floatValue());
  }

  void probarDouble() {
      System.out.println("doubleValue regresa el entero como "
          + "double\n\t" + i.doubleValue());
  }

  void probarInteger() {
      System.out.println("decode regresa un Integer con el valor "
          + "decodificado de un String\nArroja (Number Format "
          + "Exception)\n\t" + Integer.decode(i.toString()) + "\n"
          + "getInteger regresa el valor de una propiedad del sistema "
          + "en este case de la arquitectura\n\t"
          + Integer.getInteger("sun.arch.data.model") + "\n"
          + "valueOf regresa el Integer representado por su argumento\n"
          + "Arroja (Number Format Exception)\n\t"
          +Integer.valueOf(i.toString()));
  }

  void probarString() {
      System.out.println("toBinaryString regresa el entero en "
          + "binario\n\t" + Integer.toBinaryString(i) + "\n"
          + "toHexString regresa el entero en hexadecimal\n\t"
          + Integer.toHexString(i) + "\n"
          + "toOctalString regresa el entero en octal\n\t"
          + Integer.toOctalString(i) + "\n"
          + "toString regresa su argumento como String\n\t"
          + Integer.toString(i) + "\n"
          + "toString regresa el entero como String\n\t"
          + i.toString() + "\n"
          + "toUnsignedString regresa el entero sin sin signo como "
          + "String\n\t" + Integer.toUnsignedString(i));
  }

  void probarConstantes() {
      System.out.println("Valor máximo del entero: "
          + Integer.MAX_VALUE + "\n"
          + "Valor mínimo del entero: " + Integer.MIN_VALUE + "\n"
          + "Número de bits que contiene el entero: " + Integer.SIZE + "\n"
          + "Instancia de clase que representa al tipo primitivo int: "
          + Integer.TYPE);
  }
}

