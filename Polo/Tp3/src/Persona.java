
class Persona{

    private String name;

    private int age;
    public Persona()
    {

    }
    public Persona(String name, int age)
    {
        this.name=name;

        this.age=age;
    }

    public String getName()

    {

        return this.name;

    }

    public void setName(String name) {

        this.name=name;

    }



    public int getAge()
    {

        return this.age;

    }

    public void setAge(int age) {

        this.age = age;

    }

    public void actualizar(String name)
    {
        setName(name);
    }
    public void actualizar(int age)
    {
        setAge(age);
    }
    public void actualizar(String name, int age)
    {
        setName(name);
        setAge(age);
    }

    public void mostrar(){
        System.out.println("Nombre: "+getName()+"\nEdad: "+getAge());
    }
}