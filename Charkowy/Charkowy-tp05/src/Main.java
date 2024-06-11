
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int tArray;
        int maxArray;

        Scanner input = new Scanner (System.in);
        System.out.println("Ingrese tamaño del array: ");
        tArray = input.nextInt();
        System.out.println("Ingrese el numero máximo que contendra el array: ");
        maxArray = input.nextInt();

        BinarySearch Binary = new BinarySearch();
        Binary.setTamanoArray(tArray);
        Binary.setMaxNumArray(maxArray);

        int[] numeros = Binary.CreateArray();



        do {
            try {
                System.out.println("Ingrese el número que está buscando: ");
                int num = input.nextInt();
                int[] iteraciones = {0}; // Inicializar el contador de iteraciones

                int index = Binary.BinarySearchRecursive(numeros, 0, numeros.length - 1, num, iteraciones);
                if (index != -1) {
                    System.out.println("El número " + num + " está en la posición: " + index);
                    System.out.println("Número de iteraciones realizadas: " + iteraciones[0]);
                    break; // Salir del bucle si se encuentra el número
                } else {
                    System.out.println("Valor no encontrado. Inténtelo de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Por favor, ingrese un número válido.");
                input.next(); // Limpiar el buffer de entrada
            }
        } while (true); // Continuar preguntando hasta que se encuentre un número válido
        input.close(); // Cerrar el scanner al finalizar
    }
    }


