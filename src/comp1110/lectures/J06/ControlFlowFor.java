package comp1110.lectures.J06;

public class ControlFlowFor {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            System.out.println("for i: "+i);
        }


        int a[] = { 2, 3, 5, 7, 19, -3 };

        for (int idx = 0; idx < a.length; idx++) {
            System.out.println("a["+idx+"] is "+a[idx]);
        }

        for (int value : a) {
            System.out.println("next value is "+value);
        }
    }
}
