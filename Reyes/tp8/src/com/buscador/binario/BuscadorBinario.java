package com.buscador.binario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BuscadorBinario {
    private int[] listNumbers;
    private Random rnd = new Random();
    private int contador;
    public BuscadorBinario(){}
    
    public int[] getListNumbers(){
        return listNumbers;
    }
    public int getContador(){
        return this.contador;
    }
    public void setContador(int contador){
        this.contador = contador;
    }
    public int BinarySearch(int target){
        int left = 0;
        int right = listNumbers.length - 1;
        while (left <= right) {
            contador= contador + 1;
            int mid = left + (right - left) / 2;

            if (listNumbers[mid] == target) {
                return mid; // El elemento se encontró
            }

            if (listNumbers[mid] < target) {
                left = mid + 1; // Ignorar la mitad izquierda
            } else {
                right = mid - 1; // Ignorar la mitad derecha
            }
        }

        return -1; // El elemento no se encontró
        }
    
    public void cantidadPosiciones(int posiciones){
        listNumbers = new int[posiciones];
    }
    public void randomNumbers(int principalNumber){
        for(int i = 0 ; i < listNumbers.length; i++){
            listNumbers[i] = rnd.nextInt(principalNumber) + 1;
        }
    }
    public void orderArray(){
        Arrays.sort(listNumbers);
    }
}
