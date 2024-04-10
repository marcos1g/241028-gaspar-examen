public class App {
    public static void main(String[] args) throws Exception {
        //Se muestra Hola Mundo por pantalla
        System.out.println("Hola Mundo");

        //instanciamos la clase Persona
        Persona persona = new Persona("Luis", 24);

        System.out.println("Datos al iniciar: ");
        System.out.println("el nombre es: " + persona.getNombre());
        System.out.println("la edad es: " + persona.getEdad());
        System.out.println("--------------------------");

        //actualizamos datos
        persona.actualizar(18);
        persona.actualizar("Joaquin");

        //volvemos a mostrar los datos
        System.out.println("Datos al iniciar: ");
        System.out.println("el nombre es: " + persona.getNombre());
        System.out.println("la edad es: " + persona.getEdad());
    }
}
