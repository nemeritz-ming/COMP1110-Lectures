package comp1110.lectures.J06;

public class ControlFlowWhile {
    public static void main(String[] args) {
        int i = 1;

        while (i < 3) {
            System.out.println("while i is: "+i);
            // i = i + 1;
            i++;
        }

        do {
            System.out.println("do is : "+i);
            i++;
        } while (i < 5);
    }
}
