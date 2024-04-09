// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Persona per = new Persona("Gabo", 17);

        per.getName();
        per.getAge();
        per.Actualizar("Juan",18);
        per.Actualizar("Juan");
        per.Actualizar(18);
        per.getName();
        per.getAge();
    }
}

class Persona{

    private String name;

    private int age;

    public Persona(String name, int age) {

        this.name=name;

        this.age=age;

    }

    public String getName()

    {

        return name;

    }

    public void setName(String name) {

        this.name=name;

    }



    public int getAge()

    {

        return age;

    }

    public void setAge(int age) {

        this.age=age;

    }

    public void Actualizar(String name){
        setName(name);
    }
    public void Actualizar(String name, int age){
        setAge(age);
        setName(name);
    }
    public void Actualizar(int age){
        setAge(age);
    }
}