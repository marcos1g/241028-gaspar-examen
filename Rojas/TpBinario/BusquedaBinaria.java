package Rojas.TpBinario;
import java.util.Arrays;
import java.util.Random;

public class BusquedaBinaria {
    private Random r = new Random();
    private int maxAleatorio;
    private int tamanoArray;
    private int[] n;
    private int numeroBusqueda;
    private int pos;
    private int cantIt;
    private boolean busquedaResultado;

    public BusquedaBinaria(){

    }

    public void setMaxAleatorio(int maxAleatorio){
        this.maxAleatorio = maxAleatorio;
    }

    public void setTamanoArray(int tamanoArray){
        this.tamanoArray = tamanoArray;
        n = new int[tamanoArray];
    }

   //public int getNumeroBusqueda(){
   //    return this.numeroBusqueda;
   //}

    public void llenarArray(){
        for (int i = 0; i < n.length; i++){
            n[i]=r.nextInt(maxAleatorio);
        }
    }

    public void ordenarArray(){
        Arrays.sort(n);
    }

    public void generarNumeroBusqueda(){
        this.numeroBusqueda = r.nextInt(maxAleatorio);
    }

    public void ejecutarBusqueda(){
        int inicio = 0;
        int fin = n.length - 1;
        int iteraciones = 0;
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            iteraciones++;

            if (n[medio] == numeroBusqueda) {
                pos = medio;
                cantIt = iteraciones;
                busquedaResultado = true;
                break;
            } else if (n[medio] < numeroBusqueda) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
    }

    public String mostrarResultados(){
        if(busquedaResultado){
            return "Se encontro el numero " + numeroBusqueda + " en la posicion " + pos + " con " + cantIt + " iteraciones";
        }else {
            return "El numero " + numeroBusqueda + " no esta presente en el array";
        }
    }

    public int[] array(){
        return n;
    }
}
