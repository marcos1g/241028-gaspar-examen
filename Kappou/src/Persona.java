public class Persona {

    private String nombre;
    private int edad;

    // Constructor con dos parámetros
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Get y set
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

    // Métodos
    public void actualizar(String nombre) {
        setNombre(nombre);
    }

    public void actualizar(String nombre, int edad) {
        setNombre(nombre);
        setEdad(edad);
    }

    public void actualizar(int edad) {
        setEdad(edad);
    }

}