package Rojas.TpBinario;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        Integer[] n = new Integer[1000];

        for (int i = 0; i < n.length; i++) {
            n[i]=r.nextInt(7001);
        }

        Arrays.sort(n);

        for (int i = 0; i < n.length; i++) {
            System.out.println(n[i]);
        }
        //bu
    }
}