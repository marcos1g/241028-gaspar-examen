package com.binarysearch;

public class Main {
    public static void main(String[] args) throws Exception {
        BusquedaBinaria busqueda = new BusquedaBinaria();

        busqueda.setMaxAleatorio(1023);
        busqueda.setTamanoArray(1024);

        busqueda.llenarArray();
        busqueda.ordenarArray();
        busqueda.generarNumeroBusqueda();
        busqueda.ejecutarBusqueda();
        busqueda.mostrarResultados();
        
    }
}
