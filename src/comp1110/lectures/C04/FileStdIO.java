package comp1110.lectures.C04;

import java.io.IOException;

public class FileStdIO {
    public static void main(String[] args) {
        try {
            int i = System.in.read();
            byte b = (byte) i; // cast our int into a byte
            // System.out.println(b);
            System.out.write(b);
            System.out.flush(); // without this flush, the program will end before the print happens
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
