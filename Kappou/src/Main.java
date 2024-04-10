public class Main {

    public static void main(String[] args) {

        Persona persona = new Persona("Gaspi", 18);

        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Edad: " + persona.getEdad());

        persona.actualizar("Angie");
        System.out.println("Nombre actualizado: " + persona.getNombre());

        persona.actualizar("Luis", 17);
        System.out.println("Nombre actualizado: " + persona.getNombre());
        System.out.println("Edad actualizada: " + persona.getEdad());

        persona.actualizar(18);
        System.out.println("Edad actualizada: " + persona.getEdad());
    }
}