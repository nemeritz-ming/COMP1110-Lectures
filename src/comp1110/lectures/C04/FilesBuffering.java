package comp1110.lectures.C04;

import java.io.*;

public class FilesBuffering {
    public static void main(String[] args) {
        for (int j = 0; j < 20; j++) {
            InputStream in = null;
            OutputStream out = null;
            long start = 0;
            try {
                if (false) {
                    in = new FileInputStream("resources/words/hamlet.txt");
                    out = new FileOutputStream("output.txt");
                } else {
                    in = new BufferedInputStream(new FileInputStream("resources/words/hamlet.txt"), 1<<j);
                    out = new BufferedOutputStream(new FileOutputStream("output.txt"), 1<<j);
                }
                start = System.nanoTime();
                int i = 0;
                while ((i = in.read()) != -1) {
                    byte b = (byte) i;
                    out.write(b);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                    out.close();
                    System.out.println("That took "+((System.nanoTime()-start)/1000000)+"ms");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
