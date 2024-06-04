import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    private int TamanoArray;
    private int MaxNumArray;

    public int getTamanoArray() {
        return TamanoArray;
    }

    public void setTamanoArray(int tamanoArray) {
        TamanoArray = tamanoArray;
    }

    // Getter y Setter para MaxNumArray
    public int getMaxNumArray() {
        return MaxNumArray;
    }

    public void setMaxNumArray(int maxNumArray) {
        MaxNumArray = maxNumArray;
    }

    public int[] CreateArray() {

        int[] numeros = new int[getTamanoArray()];
        int i;
        for (i = 0; i < getTamanoArray(); i++) {
            numeros[i] = (int) (Math.random() * getMaxNumArray() + 1);
        }
        Arrays.sort(numeros);
        return numeros;
    }


    public static int BinarySearchRecursive(int arr[], int a, int b, int num, int[] iteraciones){
        //Base Case to Exit the Recursive Function
        if (b < a) {
            return -1;
        }
        int n = a + (b - a) / 2;

        // Incrementar el contador de iteraciones
        iteraciones[0]++;

        //If number is found at mean index of start and end
        if(arr[n]==num)
            return n;

            //If number to search for is less than the arr value at index 'n'
        else if(arr[n]>num)
            return BinarySearchRecursive(arr,a,n-1,num, iteraciones);

            //If number to search for is greater than the arr value at index 'n'
        else
            return BinarySearchRecursive(arr,n+1,b,num, iteraciones);
    }
}
