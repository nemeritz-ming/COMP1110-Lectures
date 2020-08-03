package comp1110.lectures.J05;

public class ControlFlowSwitch {
    public static void main(String[] args) {
        int c = 7;
        switch (c) {
            case 1:
                System.out.println("c == 1");
                break;
            case 2:
                System.out.println("c == 2");
                break;
            default:
                System.out.println("Something else");
        }
    }
}
