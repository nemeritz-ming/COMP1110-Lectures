package comp1110.lectures.J07;

public class Methods {

    public static void main(String[] args) {
        int x = 10;
        System.out.println("x is "+x);
        boo();
        System.out.println("x is "+x);
        add(x, 5);
    }

    private static void boo() {
        int x = 12;
        System.out.println("x is "+x);
        System.out.println("Boo!");
    }

    private static void add(int x, int y) {
        int z = x + y;
        System.out.println(x+" + "+y+" = "+z);
    }

}
