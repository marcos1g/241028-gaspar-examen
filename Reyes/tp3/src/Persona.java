public class Persona {
    // Se crean atributos y que permanezcan privados
    private String nombre;
    private int edad;

    // se crea constructor que reciba dos parametros
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    // creo get y set de nombre
    public void setNombre(String inNombre) {
        this.nombre = inNombre;
    }

    public String getNombre() {
        return nombre;
    }

    // creo get y set de edad
    public void setEdad(int inEdad) {
        this.edad = inEdad;
    }

    public int getEdad() {
        return edad;
    }

    // Metodo Actualizar
    public void actualizar(String newName, int newEdad) {
        this.nombre = newName;
        this.edad = newEdad;
    }

    public void actualizar(String newName) {
        this.nombre = newName;
    }

    public void actualizar(int newEdad) {
        this.edad = newEdad;
    }

    
}
