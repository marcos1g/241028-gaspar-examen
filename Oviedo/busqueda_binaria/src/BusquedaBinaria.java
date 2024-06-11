import java.util.Arrays;
import java.util.Random;

public class BusquedaBinaria
{
    private int maxAleatorio;
    private int longitudArray;
    private int[] array;
    private int[] arrayOriginal;
    private int numBusqueda;
    private int posicion;
    private int iteraciones;

    public void setMaxAleatorio(int maxAleatorio) {
        this.maxAleatorio = maxAleatorio;
    }

    public void setlongitudArray(int tamanoArray) {
        this.longitudArray = tamanoArray;
    }

    public void llenarArray() {
        array = new int[longitudArray];
        arrayOriginal = new int[longitudArray];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(maxAleatorio) + 1;
            arrayOriginal[i] = array[i];
        }
    }

    public void ordenarArray() {
        Arrays.sort(array);
    }

    public void mostrarArrayNoOrdenado() {
        System.out.println("Array no ordenado: " + Arrays.toString(arrayOriginal));
    }

    public void mostrarArrayOrdenado() {
        System.out.println("Array ordenado: " + Arrays.toString(array));
    }

    public void ejecutarBusqueda() {
        int[] resultado = busquedaBinaria(array, numBusqueda);
        posicion = resultado[0];
        iteraciones = resultado[1];
    }

    private int[] busquedaBinaria(int[] array, int numBusqueda) {
        int indiceMin = 0;
        int indiceMax = array.length - 1;
        int iteraciones = 0;

        while (indiceMin <= indiceMax) {
            iteraciones++;
            int indiceMedio = indiceMin + (indiceMax - indiceMin) / 2;
            System.out.println("Iteración " + iteraciones + ": Es el numero " + array[indiceMedio]);

            if (array[indiceMedio] == numBusqueda) {
                return new int[]{indiceMedio, iteraciones};
            }

            if (array[indiceMedio] < numBusqueda) {
                indiceMin = indiceMedio + 1;
            } else {
                indiceMax = indiceMedio - 1;
            }
        }
        return new int[]{-1, iteraciones};
    }

    public void generarNumeroBusqueda() {
        Random rand = new Random();
        numBusqueda = array[rand.nextInt(array.length)];
        System.out.println("Numero a buscar: " + numBusqueda);
    }

    public void mostrarResultados() {
        if (posicion != -1) {
            System.out.println("El número se encuentra en la posición: " + posicion );
        } else {
            System.out.println("El número no se encuentra en el array.");
        }
        System.out.println("Cantidad de iteraciones: " + iteraciones);
    }
}

