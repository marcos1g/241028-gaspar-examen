import java.util.Scanner;
public class Persona
{
    /*Crear un programa que tenga una clase que se llame Persona
    Crear 2 atributos: Nombre y edad
    Crear un método constructor que reciba ambos parámetros
    Crear los respectivos getters y setters de los atributos
    Tener en cuenta la visibilidad de cada método y atributo como debe ser
    Crear un método actualizar que este sobrecargado, puede recibir solo nombre, nombre y edad o solo edad
    Dependiendo que reciba llamara a los setters correspondientes
    En la clase Main instanciar un objeto de la clase Persona y ejecutar los correspondientes métodos*/
    protected String name;
    protected int age;
    public Persona(String name,int age)
    {
        this.name=name;
        this.age=age;
    }
    public String getName()
    {
        return this.name;
    }
    public int getAge()
    {
        return this.age;
    }
    public void setName(String name)
    {
        this.name= name;
    }
    public void setAge(int age)
    {
        this.age=age;
    }
    public void actualizar(String newName,int newAge)
    {
        setName(newName);
        setAge(newAge);
    }
    public void actualizar(String newName)
    {
        setName(newName);
    }
    public void actualizar(int newAge)
    {
        setAge(newAge);
    }
    public void mostrar()
    {
        System.out.println(getName()+" "+getAge());
    }
}
