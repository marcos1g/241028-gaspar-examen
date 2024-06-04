import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main
{

    public static void main(String[] args)
    {
        ArrayList<Persona> personas= new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        while (true)
        {
            System.out.println("Menu");
            System.out.println("1. Ingresar persona");
            System.out.println("2. modificar persona");
            System.out.println("3. Ver persanas");
            System.out.println("4. Salir");
            int eleciom = scan.nextInt();
            scan.nextLine();
            switch (eleciom)
            {
                case 1:
                    System.out.println("Ingrese su nombre: ");
                    String nombre= scan.next();
                    System.out.println("Ingrese su edaad: ");
                    int edad= scan.nextInt();
                    personas.add(new Persona(nombre, edad));
                    break;
                case 2:
                    System.out.println("Ingrese el numero de la persona: ");
                    int elecion1 = scan.nextInt();
                    scan.nextLine();
                    if (elecion1<0)
                    {
                        System.out.println("Valor invalido");
                    }
                    else
                    {
                        System.out.println("1. Cambiar solo el nombre");
                        System.out.println("2. Cambiar solo la edad");
                        System.out.println("3. Cambiar los dos");
                        int elecion2 = scan.nextInt();
                        scan.nextLine();
                        switch (elecion2)
                        {
                            case 1:
                                System.out.println("ingrese el nuevo nombre: ");
                                String newnombre=scan.next();
                                personas.get(elecion1).actualizar(newnombre);
                                break;
                            case 2:
                                System.out.println("ingrese el nueva edad: ");
                                int newedad=scan.nextInt();
                                personas.get(elecion1).actualizar(newedad);
                            break;
                            case 3:
                                System.out.println("ingrese el nueva edad: ");
                                int newedad1=scan.nextInt();
                                System.out.println("ingrese el nuevo nombre: ");
                                String newnombre1=scan.next();
                                personas.get(elecion1).actualizar(newnombre1,newedad1);
                                break;
                            default:
                                System.out.println("Opcion no valida");
                        }
                    }
                case 3:
                    if (personas.isEmpty())
                    {
                        System.out.println("No hay personas.");
                    } else {
                        for (Persona gente : personas) {
                            gente.mostrar();
                        }
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("opcion no valida");
            }

        }
    }
}