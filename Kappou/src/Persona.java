/*
Crear los respectivos getters y setters de los atributos
Tener en cuenta la visibilidad de cada método y atributo como debe ser
Crear un método actualizar que este sobrecargado, puede recibir solo nombre, nombre y edad o solo edad
Dependiendo que reciba llamara a los setters correspondientes
En la clase Main instanciar un objeto de la clase Persona y ejecutar los correspondientes métodos
*/
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