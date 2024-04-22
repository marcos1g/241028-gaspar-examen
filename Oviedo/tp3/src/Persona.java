public class Persona {

    private  String nombre;
    private int edad;

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEdad(int edad) {
        try {
            if (edad <= 0 || edad > 100) {
                throw new IllegalArgumentException("La edad debe estar en el rango de 1 a 100 años.");
            }
            this.edad = edad;
        } catch (IllegalArgumentException e) {
            System.out.println("Error al establecer la edad: " + e.getMessage());
            //la edad anterior se mantiene
        }
    }

    public void setNombre(String nombre) {

        this.nombre = nombre.substring(0,1).toUpperCase() + nombre.substring(1);
    }

    public void actualizar(String nuevoNombre) {
        setNombre(nuevoNombre);
    }

    public void actualizar(int nuevaEdad) {
        setEdad(nuevaEdad);
    }

    //esto seria un procedimiento
    public void mostrarInformacion() {
        System.out.println(" ");
        System.out.println("------------------------------");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad());
        System.out.println("------------------------------");
        System.out.println(" ");
    }

    public Persona(String Nombre , int Edad){
        //El primer caracter lo transformamos en mayusculas
        this.nombre = Nombre.substring(0,1).toUpperCase()+ Nombre.substring(1);

        //verificamos que la edad debe estar en cierto rango para que sea valida
        try {
            if (Edad <= 0 || Edad > 100) {
                throw new IllegalArgumentException("La edad debe estar en el rango de 1 a 100 años.");
            }
            this.edad = Edad;
        }
        catch (IllegalArgumentException e) {
        System.out.println("La edad ingresada no es válida. Se establecerá la edad por defecto en 1.");
        this.edad = 1; // Edad por defecto
        }
    }
}
