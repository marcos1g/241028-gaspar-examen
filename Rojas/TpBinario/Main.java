package Rojas.TpBinario;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BusquedaBinaria busqueda = new BusquedaBinaria();

        busqueda.setMaxAleatorio(7000);
        busqueda.setTamanoArray(1024);

        busqueda.llenarArray();
        busqueda.ordenarArray();
        busqueda.generarNumeroBusqueda();
        busqueda.ejecutarBusqueda();

        System.out.println(busqueda.mostrarResultados());
    }
}