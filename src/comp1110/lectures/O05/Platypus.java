package comp1110.lectures.O05;

public final class Platypus extends Monotrene implements Venomous {
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
