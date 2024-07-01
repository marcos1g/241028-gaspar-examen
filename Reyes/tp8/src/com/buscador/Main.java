package com.buscador;

import com.buscador.binario.BuscadorBinario;

public class Main{
    public static void main(String[] args) throws Exception {
        BuscadorBinario buscador = new BuscadorBinario();

        buscador.cantidadPosiciones(1000);
        buscador.randomNumbers(7000);
        buscador.orderArray();
        int index = buscador.BinarySearch(254);

        if (index >= 0) {
            System.out.println("El número se encuentra en la posición: " + index + " e hizo " + buscador.getContador() + " de iteraciones");
        } else {
            System.out.println("El número no se encuentra en el array.");
        }
    }
}
