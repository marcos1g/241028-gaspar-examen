class Persona {
    private String nombre;
    private int edad;
    public Persona() {}
    public Persona(String nombre, int edad) {
    this.nombre=nombre;
    this.edad=edad;
    }
    Persona(String nombre) {
        this.nombre=nombre;
    }
    Persona(int edad) {
        this.edad=edad;
    }
    void Actualizar(int edad)
    {
        this.edad = edad;
    }
    void Actualizar(String nombre)
    {
        this.nombre = nombre;
    }
    void Actualizar(String nombre,int edad)
    {
        this.edad = edad;
        this.nombre = nombre;
    }
    void Actualizar(int edad, String nombre)
    {
        this.nombre = nombre;
        this.edad = edad;

    }

    public void verInfo() {
        System.out.println(nombre + ", " + edad);

    }
    public static void main(String[] args) {
        Persona persona1 = new Persona("Oshiro",17);
        Persona persona2 = new Persona("Matayoshi",16);

        System.out.println("Info sin actualizar");
        persona1.verInfo();
        persona2.verInfo();
        System.out.println();

        persona1.Actualizar("Luca");
        persona1.Actualizar("Santiago");

        System.out.println("Nombre Actualizado");
        persona1.verInfo();
        persona2.verInfo();
        System.out.println();

        persona1.Actualizar(18);
        persona1.Actualizar(18);

        System.out.println("Edad Actualizada");
        persona1.verInfo();
        persona2.verInfo();
        System.out.println();

        persona1.Actualizar("Aaron",17);
        persona1.Actualizar("Sebastian",17);

        System.out.println("Nombre y Edad Actualizados");
        persona1.verInfo();
        persona2.verInfo();
        System.out.println();
    }

 
}