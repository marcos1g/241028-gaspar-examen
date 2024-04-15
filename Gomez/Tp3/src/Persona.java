public class Persona {
    private String nombre = "";
    private int edad;

    public Persona(){
    }

    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public void Actualizar (String nombre){
        setNombre(nombre);
        setEdad(edad);
    }

    public void Actualizar (String nombre, int edad){
        setNombre(nombre);
        setEdad(edad);
    }

    public void Actualizar (int edad){
        setEdad(edad);
    }

}

