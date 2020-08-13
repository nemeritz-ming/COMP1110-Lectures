package comp1110.lectures.O03;

public class Interfaces {
    public static void main(String[] args) {
        Toxic nasty = new Cyanide();
        Dog fido = new Dog();
        Toxic charlotte = new RedBackSpider();

        Object[] things = { nasty, fido, charlotte };

        for (Object t : things) {
            if (t instanceof Toxic)
                System.out.println(t+" is toxic"+(((Toxic) t).isLethalToAdultHumans() ? " and deadly" : ""));
            else
                System.out.println(t+" is nice");
        }
    }
}
