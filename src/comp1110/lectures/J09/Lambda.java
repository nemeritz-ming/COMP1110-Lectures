package comp1110.lectures.J09;

import java.util.function.IntPredicate;

public class Lambda {

    static void printBig(int value, IntPredicate bigTest) {
        if (bigTest.test(value)) {
            System.out.println("Yup "+value+" is big!");
        } else {
            System.out.println("No "+value+" is not big.");
        }
    }

    public static void main(String[] args) {
        printBig(200, x -> x > 1000);
        IntPredicate bt = x -> x > 100;
        printBig(10, bt);
        printBig(200, bt);
    }
}
