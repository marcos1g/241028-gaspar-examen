package Ventura.Tp3.src;

import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese sus datos");
        System.out.println("Nombre:");
        String name = scanner.nextLine();

        int age = 0;

        Person person = new Person(name, age);
        System.out.println("Edad:");

        do {
            try {
                age = scanner.nextInt();
                scanner.nextLine();
                if(!person.setAge(age)) System.out.println("Entrada no válida. Debe ingresar un número entero entre 1 y 100 para la edad:");
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Debe ingresar un número entero entre 1 y 100 para la edad");
                scanner.nextLine();
                age = -1;
            }
        } while (!person.setAge(age));

        System.out.print("\033[H\033[2J");
        System.out.flush();

        do{
            showMenu(person);
            int option;
            try{
                option = scanner.nextInt();

                switch (option){
                    case 1:
                        System.out.println("Ingrese el nuevo nombre: ");
                        name = scanner.next();
                        person.update(name);
                        break;
                    case 2:
                        System.out.println("Ingrese la nueva edad: ");
                        age = scanner.nextInt();
                        if(!person.update(age)) System.out.println("Entrada no válida. Debe ingresar un número entero entre 1 y 100 para la edad.");
                        break;
                    case 3:
                        System.out.println("Ingrese el nuevo nombre: ");
                        name = scanner.next();
                        System.out.println("Ingrese la nueva edad: ");
                        age = scanner.nextInt();
                        if(!person.update(name, age)) System.out.println("Entrada no válida. Debe ingresar un número entero entre 1 y 100 para la edad.");
                        break;
                    case 0:
                        exit(person);
                        break;
                    default:
                        System.out.println("\nOpción no valida");
                }
            } catch (InputMismatchException e){
                System.out.println("\nEntrada no válida. Debe ingresar un número entero para la opción.");
                scanner.nextLine();
            }

        } while (true);
    }

    public static void showMenu(Person person){
        System.out.print("\033[H\033[2J");
        System.out.println("\n\nNombre usuario: " + person.getName());
        System.out.println("Edad usuario: " + person.getAge());
        System.out.println("\nMenú de actualización:");
        System.out.println("Actualizar nombre (1)");
        System.out.println("Actualizar edad (2)");
        System.out.println("Actualizar nombre y edad (3)");
        System.out.println("Salir (0)");
        System.out.print("Seleccione una opción: ");
    }

    public static void exit(Person person){
        System.out.println(String.format("\nHasta la proxima, %s de %d %s de edad.", person.getName(), person.getAge(), person.getAge() == 1 ? "año" : "años" ));
        System.exit(0);
    }

}