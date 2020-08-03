package comp1110.lectures.J05;

public class ControlFlowIfThenElse {
    public static void main(String[] args) {
        boolean a = false;
        boolean b = false;

        if (a && b)  // then (implied)
            System.out.println("Both are true");
        else
            System.out.println("At least one is false");

        if (a) {  // a is true
            if (b)
                System.out.println("Both are true");
            else
                System.out.println("A is true, b is false");
        } else {  // a is false
            if (b)
                System.out.println("A is false and b is true");
            else
                System.out.println("Both are false");
        }
    }
}
