package com.buscador;

import com.buscador.binario.BuscadorBinario;

public class Main{
    public static void main(String[] args) throws Exception {
        BuscadorBinario buscador = new BuscadorBinario();

        buscador.cantidadPosiciones(25);
        buscador.randomNumbers(20);
        buscador.orderArray();
        int index = buscador.BinarySearch(15);

        if (index >= 0) {
            System.out.println("El número se encuentra en la posición: " + index);
        } else {
            System.out.println("El número no se encuentra en el array.");
        }
    }
}
