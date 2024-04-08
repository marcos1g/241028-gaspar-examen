public class Main {
    public static void main(String[] args) {
        // Instanciar un objeto de la clase Persona
        Persona persona1 = new Persona("Juan", 30);

        // Ejecutar métodos correspondientes
        System.out.println("Nombre: " + persona1.getNombre());
        System.out.println("Edad: " + persona1.getEdad());

        // Llamar al método actualizar sobrecargado con diferentes combinaciones de parámetros
        persona1.actualizar("jorgelio");
        System.out.println("Nombre después de actualizar: " + persona1.getNombre());

        persona1.actualizar(35);
        System.out.println("Edad después de actualizar: " + persona1.getEdad());
    }
}
