package Rojas.Tp3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        Persona persona = new Persona(nombre, edad);

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n¿Qué desea actualizar?");
            System.out.println("1. Nombre");
            System.out.println("2. Edad");
            System.out.println("3. Ambos");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre: ");
                    nombre = scanner.nextLine();
                    persona.actualizar(nombre);
                    break;
                case 2:
                    System.out.print("Ingrese la nueva edad: ");
                    edad = scanner.nextInt();
                    scanner.nextLine();
                    persona.actualizar(edad);
                    break;
                case 3:
                    System.out.print("Ingrese el nuevo nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese la nueva edad: ");
                    edad = scanner.nextInt();
                    persona.actualizar(nombre, edad);
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
            }
            System.out.println("\nDatos actualizados:");
            System.out.println("Nombre: " + persona.getNombre());
            System.out.println("Edad: " + persona.getEdad());
        }

        scanner.close();
    }
}
