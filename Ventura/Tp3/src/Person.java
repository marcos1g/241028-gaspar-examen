package Ventura.Tp3.src;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return this.age;
    }

    public boolean setAge(int age){
        if(age > 0 && age < 101) {
            this.age = age;
            return true;
        }
        return false;
    }

    public void update (String name){
        setName(name);
    }

    public boolean update (String name, int age){
        setName(name);
        return setAge(age);
    }

    public boolean update (int age){
        return setAge(age);
    }

}
