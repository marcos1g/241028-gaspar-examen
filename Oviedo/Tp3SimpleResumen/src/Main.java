
public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Luishi", 17);

        // Mostrar información inicial
        System.out.println("--------------------------");
        System.out.println("Información inicial:");
        System.out.println("--------------------------");
        persona.mostrarInformacion();

        // Actualizar solo el nombre
        persona.actualizar("Alejandro");
        System.out.println(" ");
        System.out.println("Después de actualizar el nombre:");
        System.out.println("--------------------------");
        persona.mostrarInformacion();

        // Actualizar nombre y edad
        persona.actualizar("Luisiño", 18);
        System.out.println(" ");
        System.out.println("Después de actualizar el nombre y la edad:");
        System.out.println("--------------------------");
        persona.mostrarInformacion();

        // Actualizar solo la edad
        persona.actualizar(100000000);
        System.out.println(" ");
        System.out.println("Después de actualizar solo la edad:");
        System.out.println("--------------------------");
        persona.mostrarInformacion();
    }
}