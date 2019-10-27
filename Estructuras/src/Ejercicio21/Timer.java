package Ejercicio21;

public class Timer {
    int inicio = datos(),
        horas, minutos, segundos;

    public static void main(String[] args) {
        Timer t = new Timer();
        t.meta();
        t.calculos();
        t.resultados();
    }

    public void meta() {
        System.out.println("Brindar el tiempo de ejecución de un programa");
        System.out.println("en horas:minutos:segundos");
    }

    public int datos() {  return (int) System.currentTimeMillis();  }

    public void calculos() {
        int tiempo = (datos() - inicio) / 1000;

        segundos = tiempo % 60;
        minutos  = (tiempo / 60) % 60;
        horas    = tiempo / 3600;
    }

    public void resultados() {
        System.out.printf("\nEl tiempo transcurrido es: %d:%d:%d\n",
                horas,
                minutos,
                segundos);
    }
}

