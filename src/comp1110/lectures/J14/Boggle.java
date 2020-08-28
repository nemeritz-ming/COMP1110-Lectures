package comp1110.lectures.J14;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Boggle {
    static String[] dice = {"AJBBOO","AFFPSK","ANEAGE","APSHCO","QNUMHI","ZNHRLN","TDSTYI","TTWOOA","TLRYET","TUMIOC","EDVLRY","EDRLXI","EEGNHW","EIOTSS","ERHTWV","EENUSI"};

    static List<Set<Integer>> neighbours = new ArrayList<>(dice.length);
    {
        int [] distance = { -5, -4, -3, -1, 1, 3, 4, 5};
        for (int i = 0; i < 16; i++) {
            Set<Integer> die = new HashSet<>();

            for (int d : distance) {
                int n = i + d;
                int ncol = n % 4;
                int icol = i % 4;
                if (n >= 0 && n < 15 && Math.abs(ncol - icol) <= 1)
                    die.add(n);
            }
            neighbours.add(die);
        }
    }

    @Test
    public void testNeighbours() {
        for (int i = 0; i < 16; i++) {
            assertFalse("included self in neighbours ", neighbours.get(i).contains(i));
            assertFalse("included -1 in neighbours ", neighbours.get(i).contains(-1));
            assertFalse("included 16 in neighbours ", neighbours.get(i).contains(16));
        }
        assertTrue("Did not include 0 in neighbours", neighbours.get(1).contains(0));
        assertTrue("Did not include 2 in neighbours", neighbours.get(1).contains(2));
        assertTrue("Did not include 4 in neighbours", neighbours.get(1).contains(4));
        assertTrue("Did not include 5 in neighbours", neighbours.get(1).contains(5));
        assertTrue("Did not include 6 in neighbours", neighbours.get(1).contains(6));ß
    }

    static char[] shake() {
        char[] result = new char[16];
        Random rand = new Random();

        for (int i = 0; i < dice.length; i++) {
            int die = rand.nextInt(dice.length);
            while (dice[die] == null) {
                die = (die + 1) % dice.length;
            }
            // found
            int face = rand.nextInt(6);
            char value = dice[die].charAt(face);
            dice[die] = null;
            result[i] = value;
        }
        return result;
    }

    List<String> solveBoggle(char[] boggle) {
        return new ArrayList<>();
    }

    @Test
    public void testBoggle() {
        char [] dice = { 'R', 'H', 'R', 'E', 'Y', 'P', 'C','S', 'W', 'N', 'S', 'N', 'T', 'E', 'G', 'O'};

        List<String> result = solveBoggle(dice);
        assertTrue("Did not contain PRESS", result.contains("PRESS"));
        assertTrue("Did not contain GENT", result.contains("GENT"));
        assertTrue("Did not contain PRY", result.contains("PRY"));
        assertTrue("Did not contain IRE", result.contains("IRE"));
        assertFalse("Did not contain CENTRE", result.contains("CENTRE"));
        assertFalse("Did not contain RESPECT", result.contains("RESPECT"));
        assertFalse("Did not contain PRESENT", result.contains("PRESENT"));
        assertFalse("Did not contain RHETORIC", result.contains("RHETORIC"));
    }

    static void printBoggle(char[] boggle) {
        int rowlength = (int) Math.sqrt(dice.length);

        for (int i = 0; i < dice.length; i++) {
            System.out.print(boggle[i]);
            if (i % rowlength == (rowlength - 1))
                System.out.println();
        }
    }

    public static void main(String[] args) {
       char[] boggle = shake();
       printBoggle(boggle);
    }
}
