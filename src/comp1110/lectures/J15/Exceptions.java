package comp1110.lectures.J15;

import java.util.Date;

public class Exceptions {
    static void exceptionalMethod() {
        System.out.println("Start of method");
       // int j = 7 / 0;
        try {
            Date d = null; // new Date();
            System.out.println(d.toString());
            int i = 7 / 0;
        } catch (NullPointerException e) {
            System.out.println("Null pointer "+e);
        } catch (Exception e) {
            System.out.println("Generic exception "+e);
        } finally {
            System.out.println("Finally");
        }
        System.out.println("End of method");
    }

    public static void main(String[] args) {
        System.out.println("Start of main()");
        exceptionalMethod();
        System.out.println("End of main()");
    }
}
