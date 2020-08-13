package comp1110.lectures.O04;

public class EasternBrownSnake extends Reptile implements Venomous {
    public EasternBrownSnake(String name, int age) {
        super(name, age);
    }

    @Override
    public boolean isLethalToAdultHumans() {
        return true;
    }
}
