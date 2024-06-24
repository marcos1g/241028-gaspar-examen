package com.binarysearch;

import java.util.Arrays;
import java.util.Random;

public class BusquedaBinaria {
    private int[] listaNumeros;
    private int maxAleatorio;
    private int numeroBusqueda;
    private int index;
    private Random rnd = new Random();

    public BusquedaBinaria() {
    }

    //getters
    public int[] getListaNumeros() {
        return this.listaNumeros;
    }
    public int getIndex(){
        return this.index;
    }
    public int getNumeroBusqueda(){
        return this.numeroBusqueda;
    }
    public int maxAleatorio(){
        return this.maxAleatorio;
    }
    public int getTamañoArray(){
        return this.listaNumeros.length;
    }
    //setters
    public void setMaxAleatorio(int maxAleatorio) {
       this.maxAleatorio = maxAleatorio;
    }

    public void setTamanoArray(int posiciones){
        listaNumeros = new int[posiciones];
    }
    public void setIndex(int index){
        this.index = index;
    }
    public void setNumeroBusqueda(int numeroBusqueda){
        this.numeroBusqueda = numeroBusqueda;
    }

    //funciones apartes
    public void llenarArray(){
        for (int i = 0; i < listaNumeros.length; i++) {
            listaNumeros[i] = rnd.nextInt(maxAleatorio) + 1;
        }
    }
     public void ordenarArray(){
        Arrays.sort(listaNumeros);
    }
    public void generarNumeroBusqueda(){
        setNumeroBusqueda(rnd.nextInt(maxAleatorio) + 1);
    }
    public int ejecutarBusqueda(){
        int left = 0;
        int right = listaNumeros.length - 1;
        int mid = 0;
        while (left <= right) {
             mid = left + (right - left) / 2;

            if (listaNumeros[mid] == numeroBusqueda) {
                return mid;
            }

            if (listaNumeros[mid] < numeroBusqueda) {
                left = mid + 1; // Ignorar la mitad izquierda
            } else {
                right = mid - 1; // Ignorar la mitad derecha
            }
        }

        return -1; // El elemento no se encontró
    }
    public void mostrarResultados(){
        setIndex(ejecutarBusqueda());
        if (index >= 0) {
            System.out.println("El número "+ numeroBusqueda +" se encuentra en la posición: " + index);
        } else {
            System.out.println("El número "+ numeroBusqueda +" no se encuentra en el array.");
        }
    }
    public void viewList(){
        for(int nop : listaNumeros){
            System.out.println(nop);
        }
    }
}
