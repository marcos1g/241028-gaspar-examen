import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        int opcion2 = 0;

        ArrayList<Persona> personas = new ArrayList<>();

        while (opcion != 1 && opcion != 2) {
            try {
                System.out.println("Por favor, ingrese la opción que desea ver:");
                System.out.println("Opción 1: Mostrar un 'Hola Mundo'");
                System.out.println("Opción 2: Operaciones con personas");

                opcion = scanner.nextInt();

                if (opcion == 1) {
                    System.out.println("¡AMERICA YAAA HELLOOOO!");
                }
                else if (opcion == 2)
                {
                    while (opcion2 != 5) {
                        try {
                            System.out.println("---------------------CRUD DE PERSONAS EPICAS---------------------");
                            System.out.println("Por favor, ingrese la opción que desea ver:");
                            System.out.println("Opción 1: Registrar una persona");
                            System.out.println("Opción 2: Listado de personas");
                            System.out.println("Opción 3: Actualizar una persona");
                            System.out.println("Opción 4: Eliminar una persona");
                            System.out.println("Opción 5: Finalizar");
                            System.out.println("-----------------------------------------------------------------");
                            opcion2 = scanner.nextInt();

                            switch (opcion2) {
                                
                                case 1:
                                    System.out.println(" ");
                                    System.out.println("Opción 1 seleccionada: Registrar una persona");
                                    //Do while para que mientras la opcion2 sea 1 se mantenga dentro del bucle de agregar personas
                                    do {
                                        //Ingresamos el nombre y la edad de la persona
                                        System.out.println("Ingrese el nombre de una persona:");
                                        String nombre = scanner.next();
                                        
                                        System.out.println("Ingrese la edad de una persona:");
                                        int edad = 1; // Valor predeterminado
                                        try {
                                            edad = scanner.nextInt();
                                        } catch (java.util.InputMismatchException e) {
                                            System.out.println("La entrada no es un número entero. La edad se establecerá en 1 por defecto.");
                                            scanner.next();
                                        }
                                        
                                        Persona persona = new Persona(nombre, edad);
                                        personas.add(persona);
                                        
                                        System.out.println("Se agrego a la persona con los siguientes datos:");
                                        persona.mostrarInformacion();

                                        //pregunta si deseamos agregar otra persona , si usamos 1 se mantiene en el bucle si presionamos otra cosa nos manda directamente a menu CRUD
                                        System.out.println("¿Desea agregar otra persona? (1 = Y , cualquier tecla = N)");
                                        int opcion3 = scanner.nextInt();
                                        if (opcion3 == 2) {
                                            opcion2 = 0;
                                        }
                                    } while (opcion2 == 1);
                                    break;
                                    
                                    
                                case 2:
                                    System.out.println(" ");
                                    System.out.println("Opción 2 seleccionada: Listado de personas");
                                    System.out.println("Listado de personas:");
                                    if (!personas.isEmpty()){
                                        //Hacemos un for para mostrar solamente el nombre de las personas
                                        // personas.get(i) obtenemos la persona con tal indice y ejecutamos su metodo
                                        for (int i = 0; i < personas.size(); i++) {
                                            System.out.println((i + 1) + "- " + personas.get(i).getNombre());
                                        }

                                        System.out.println("Ingrese el índice de la persona que desea seleccionar:");
                                        int index = scanner.nextInt();

                                        //Al seleccionar a la persona instaciamos un nuevo objeto que representara a la persona elegida y ejecutamos las acciones
                                        if (index >= 1 && index <= personas.size()) {
                                            Persona personaSeleccionada = personas.get(index - 1);
                                            personaSeleccionada.mostrarInformacion();
                                        } else {
                                            System.out.println("El índice ingresado no es válido.");
                                        }
                                    }
                                    else {
                                        System.out.println(" ");
                                        System.out.println("No existe ninguna persona registrada aun");
                                    }
                                    break;


                                case 3:
                                    System.out.println(" ");
                                    System.out.println("Opción 3 seleccionada: Actualizar una persona");

                                    // Mostrar la lista de personas
                                    System.out.println("Lista de personas:");
                                    for (int i = 0; i < personas.size(); i++) {
                                        System.out.println((i + 1) + ". " + personas.get(i).getNombre());
                                    }

                                    //seleccionamos la persona para actualizar
                                    System.out.println("Ingrese el número de la persona que desea actualizar:");
                                    int indexA = scanner.nextInt();
                                    if (indexA < 1 || indexA > personas.size()) {
                                        System.out.println("¡Número de persona inválido!");
                                        break;
                                    }

                                    //Mostrar persona seleccionada
                                    Persona personaSeleccionada = personas.get(indexA - 1);
                                    System.out.println("Persona seleccionada:");
                                    personaSeleccionada.mostrarInformacion();

                                    System.out.println("¿Qué atributo desea actualizar? (1 = Nombre, 2 = Edad, 3 = Ambos)");
                                    int opcionAtributo = scanner.nextInt();
                                    if (opcionAtributo < 1 || opcionAtributo > 3) {
                                        System.out.println("¡Opción inválida!");
                                        break;
                                    }

                                    // Actualizar los atributos seleccionados
                                    if (opcionAtributo == 1 || opcionAtributo == 3) {
                                        System.out.println("Ingrese el nuevo nombre:");
                                        String nuevoNombre = scanner.next();
                                        personaSeleccionada.actualizar(nuevoNombre);
                                    }
                                    if (opcionAtributo == 2 || opcionAtributo == 3) {
                                        System.out.println("Ingrese la nueva edad:");
                                        int nuevaEdad = scanner.nextInt();
                                        personaSeleccionada.actualizar(nuevaEdad);
                                    }

                                    // Mostrar el resultado final
                                    System.out.println("Resultado final:");
                                    personaSeleccionada.mostrarInformacion();
                                    break;



                                case 4:
                                    System.out.println(" ");
                                    System.out.println("Opción 4 seleccionada: Eliminar una persona");
                                    System.out.println("Listado de personas:");

                                    for (int i = 0; i < personas.size(); i++) {
                                        System.out.println((i + 1) + "- " + personas.get(i).getNombre());
                                    }

                                    System.out.println("Ingrese el índice de la persona que desea eliminar:");
                                    int indexE = scanner.nextInt();
                                    if (indexE >= 1 && indexE <= personas.size()) {
                                        Persona personaEliminada = personas.get(indexE - 1);
                                        personaEliminada.mostrarInformacion();
                                        
                                        System.out.println("Seguro que desea eliminar a esta persona? (1 = Y , cualquier tecla = N)");
                                        
                                        int respuestaE = scanner.nextInt();
                                            if (respuestaE == 1){
                                                personas.remove(indexE - 1);
                                                System.out.println("USUARIO ELIMINADO CORRECTAMENTE");
                                            }
                                            else {
                                                System.out.println("SE CANCELO LA ELIMINACION...");
                                            }
                                    } else {
                                        System.out.println("El índice ingresado no es válido.");
                                    }
                                    break;
                                    
                                    
                                case 5:
                                    System.out.println(" ");
                                    System.out.println("Opción 5 seleccionada: Finalizar");
                                    System.out.println("---------------------FIN--------------------- ");
                                    break;
                                    
                                    
                                default:
                                    System.out.println(" ");
                                    System.out.println("Por favor, ingrese una opción válida (1-5)");
                                    break;
                            }
                        } catch (java.util.InputMismatchException e) {
                            System.out.println(" ");
                            System.out.println("Por favor, ingrese un número entero");
                            scanner.next();
                        }
                    }
                } else {
                    System.out.println(" ");
                    System.out.println("¡Por favor, ingrese una opción válida (1 o 2)!");
                }
                //si un graciosito pone algo que no es un int
            } catch (java.util.InputMismatchException e) {
                System.out.println("¡Por favor, ingrese un número entero!");
                scanner.next();
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
