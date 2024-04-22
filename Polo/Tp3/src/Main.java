import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Persona persona = new Persona();

        System.out.print("Ingrese tu nombre: ");

        persona.setName(scanner.nextLine());

            System.out.print("Ingresa tu edad: ");
            persona.setAge(scanner.nextInt());

       persona.mostrar();

        System.out.print("¿Quieres actualizar algun dato: Y/N? :");
        if (scanner.next().equals("Y")) {
            System.out.println("¿Que dato queires actualizar?:");
            System.out.println("1. Nombre");
            System.out.println("2. Edad");
            System.out.print("Ingresa el número de opción: ");

            switch(scanner.nextInt()){

            case 1:
                System.out.print("Ingrese el nuevo nombre: ");
                persona.actualizar(scanner.next());
                persona.mostrar();
                break;
            case 2:
                System.out.print("Ingrese la nueva edad: ");
                persona.actualizar(scanner.nextInt());
                persona.mostrar();
                break;

            default:
                System.out.println("Opción no válida");
            }

        }
        else { scanner.close(); }
    }


}