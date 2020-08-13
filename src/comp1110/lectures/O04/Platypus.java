package comp1110.lectures.O04;

public class Platypus extends Monotrene implements Venomous {
    void quack() {
        System.out.println("Quack!");
    }
    public Platypus(String name, int age) {
        super(name, age);
    }

    @Override
    public boolean isLethalToAdultHumans() {
        return false;
    }
}
