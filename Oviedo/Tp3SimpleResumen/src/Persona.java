public class Persona {
    private String nombre;
    private int edad;

    //Encapsulamiento
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

    //sobrecarga de metodos
    public void actualizar(String Nombre){
        setNombre(Nombre);
    }
    public void actualizar(String Nombre , int Edad){
        setNombre(Nombre);
        setEdad(Edad);

    }
    public void actualizar(int Edad){
        setEdad(Edad);
    }

    //Metodo
    public void mostrarInformacion() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad());
    }

    //Constructor
    public Persona(String Nombre , int Edad){
        this.nombre = Nombre;
        this.edad =  Edad;
    }
}
