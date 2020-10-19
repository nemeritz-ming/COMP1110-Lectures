package comp1110.lectures.C04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FilesInputStream {
    public static void main(String[] args) {
        FileInputStream in = null;

        try {
            in = new FileInputStream("resources/words/hamlet.txt");
            for (int j = 0; j < 100; j++) {
                int i = 0;
                i = in.read();
                byte b = (byte) i;
                System.out.write(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
