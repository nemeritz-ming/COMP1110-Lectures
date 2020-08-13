package comp1110.lectures.O04;

public class Inheritance {
    public static void main(String[] args) {
        Albatross alex = new Albatross("Alex", 39);
        Dog spot = new Dog("Spot", 7);
        FruitBat fred = new FruitBat("Fred", 10);
        EasternBrownSnake steph = new EasternBrownSnake("Steph", 12);
        GreatWhiteShark bruce = new GreatWhiteShark("Bruce", 40);
        RedBackSpider charlotte = new RedBackSpider("Charlotte", 1);
        Platypus perry = new Platypus("Perry", 5);
        Human bob = new Human("Bob", 19);

        Animal[] animals = { alex, spot, fred, steph, bruce, charlotte, perry, bob };

        for (Animal a : animals) {
            System.out.println(a);
            if (a instanceof Platypus)
                ((Platypus) a).quack();
        }

        System.out.println();
        System.out.println("The following animals are venomous:");
        for (Animal a : animals) {
           if (a instanceof Venomous) {
               boolean deadly = ((Venomous) a).isLethalToAdultHumans();
               System.out.println(a +(deadly ? ", and it's lethal!": ", and fortunately non-lethal."));
           }
        }
    }
}
