package comp1110.lectures.O02;

public class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) {
        Person mary = new Person(19, "Sue");
        Person fred = new Person(21, "Fred");
        System.out.println("I created a person: "+mary);
        System.out.println("I created a person: "+fred);
    }

    @Override
    public String toString() {
        return name + " is aged " + age;
    }
}
