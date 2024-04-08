public class Persona {
    private String nombre;
    private int edad;

    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }


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
