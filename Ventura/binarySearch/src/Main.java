import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BinarySearch binarySearch = new BinarySearch();
        binarySearch.setMaxRandom(7000);
        binarySearch.setSizeArray(1000);
        binarySearch.fillArray();
        binarySearch.sortArray();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número que está buscando: ");
        do{
            try{
                int targetNumber = scanner.nextInt();

                binarySearch.numberToSearch(targetNumber);

                int position = binarySearch.binarySearch();

                if (position != -1) {
                    System.out.printf("El número %d está en la posición: %d. Número de iteraciones realizadas : %d", targetNumber, position, binarySearch.getIterations());
                    break;
                } else {
                    System.out.println("El número " + targetNumber + " no se encuentra en el array. Vuelva a intentar:");
                }
            } catch (Exception e){
                System.out.println("Solo se aceptan números, vuelva a intentarlo:");
                scanner.next();
            }
        }while (true);
    }
}