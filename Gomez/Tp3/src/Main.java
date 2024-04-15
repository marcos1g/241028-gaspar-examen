import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona();

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresar el nombre de la persona: ");
        String nombre = sc.next();
        System.out.print("Ingresar la edad de la persona: ");
        String linea = sc.next();
        int edad = Integer.parseInt(linea);

        persona.Actualizar(nombre, edad);

        System.out.print("");
        System.out.print("----------Actualizar----------");
        System.out.println("");
        System.out.print(persona.getNombre() + " tiene " + persona.getEdad() + " años de edad.");

    }
}

