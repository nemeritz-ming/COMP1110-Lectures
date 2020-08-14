package comp1110.lectures.O05;

public abstract class Animal {
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " is a "+getClass().getSimpleName()+", aged "+age;
    }
}
