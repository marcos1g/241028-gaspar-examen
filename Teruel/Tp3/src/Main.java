import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Nombre: ");
        String fname = input.next();

        System.out.print("Apellido: ");
        String lname = input.next();

        System.out.println();
        System.out.println("Hola \n" + fname + " " + lname);
    }
}
