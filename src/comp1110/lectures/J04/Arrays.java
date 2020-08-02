package comp1110.lectures.J04;

public class Arrays {
    public static void main(String[] args) {
        double d[];
        d = new double[5];
        d[0] = 1.0;
        d[4] = 3.2;
        System.out.println(d[0]);
        System.out.println(d[1]);
        System.out.println(d[2]);
        System.out.println(d[3]);
        System.out.println(d[4]);
        d[4] = 3.3;
        System.out.println(d[4]);
        System.out.println("Length of d is: "+d.length);

        int x = 7;
        // int[] i = new int[5];
        int[] i = { 2, 3, 4, 5, x};
        System.out.println(i[0]);
        System.out.println(i[4]);
        x = 42;
        System.out.println(i[4]);
    }
}