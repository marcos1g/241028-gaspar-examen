import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.Collections;

public class Main {


    public static void main(String[] args) {


        Busqueda busqueda = new Busqueda();

        busqueda.setMaxAleatorio(7000);
        busqueda.setTamanoArray(1024);
        busqueda.llenarArray();
        busqueda.ordenarArray();
        busqueda.generarNumeroBusqueda();
        busqueda.ejecutarBusqueda();
        busqueda.mostrarResultados();

        }
    }
