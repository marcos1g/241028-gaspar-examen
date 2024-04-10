import java.util.Scanner;
class PersonaC {
    //atributos
    private String nombre;
    private int edad;
    //----------------------------//
    //constructor
    public PersonaC(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    //----------------------------//
    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    //metodos
    public void actualizar(String nuevoNombre) {
        setNombre(nuevoNombre);
    }

    public void actualizar(String nuevoNombre, int nuevaEdad) {
        setNombre(nuevoNombre);
        setEdad(nuevaEdad);
    }

    public void actualizar(int nuevaEdad) {
        setEdad(nuevaEdad);
    }
}

public class MainC {
    public static void main(String[] args) {
        Scanner lectura = new Scanner (System.in);

        System.out.println("Ingrese su nombre: ");

        String nombre = lectura.next();

        System.out.println("Ingrese su edad: ");

        int edad = lectura.nextInt();

        System.out.println("Su nombre es: " + nombre + " y su edad es: " + edad);

        PersonaC persona = new PersonaC(nombre, edad);

        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Edad: " + persona.getEdad());

        System.out.println("Si desea actualizar alguno de sus datos, escriba si");
        String respuesta = lectura.next();
        if (respuesta.equalsIgnoreCase("si")) {
            System.out.println("¿Desea actualizar el nombre? (si/no)");
            String actualizarNombre = lectura.next();

            if (actualizarNombre.equalsIgnoreCase("si")) {
                System.out.println("Ingrese el nuevo nombre:");
                String nuevoNombre = lectura.next();
                persona.actualizar(nuevoNombre);
            }

            System.out.println("¿Desea actualizar la edad? (si/no)");
            String actualizarEdad = lectura.next();

            if (actualizarEdad.equalsIgnoreCase("si")) {
                System.out.println("Ingrese la nueva edad:");
                int nuevaEdad = lectura.nextInt();
                persona.actualizar(nuevaEdad);
            }

            System.out.println("Datos actualizados:");
            System.out.println("Nombre: " + persona.getNombre());
            System.out.println("Edad: " + persona.getEdad());
        }
    }
}