package comp1110.lectures.J14;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Boggle {
    static String[] dice = {"AJBBOO","AFFPSK","ANEAGE","APSHCO","QNUMHI","ZNHRLN","TDSTYI","TTWOOA","TLRYET","TUMIOC","EDVLRY","EDRLXI","EEGNHW","EIOTSS","ERHTWV","EENUSI"};

    static List<Set<Integer>> neighbours = new ArrayList<>(dice.length);

    static {
        int [] distance = { -5, -4, -3, -1, 1, 3, 4, 5};
        for (int i = 0; i < 16; i++) {
            Set<Integer> die = new HashSet<>();

            for (int d : distance) {
                int n = i + d;
                int ncol = n % 4;
                int icol = i % 4;
                if (n >= 0 && n <= 15 && Math.abs(ncol - icol) <= 1)
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
        assertTrue("Did not include 6 in neighbours", neighbours.get(1).contains(6));
    }

    static char[] shake() {
        char[] result = new char[16];
        Random rand = new Random(2);

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

    static boolean bogglable(String word, char[] boggle) {
        if (word.length() < 3 || word.length() > 16) return false;

        List<Character> usable = new ArrayList<>();
        for (int i = 0; i < boggle.length; i++)
            usable.add(boggle[i]);

        for (int i = 0; i < word.length(); i++) {
            char l = word.charAt(i);
            if (usable.contains(l))
                usable.remove(usable.indexOf(l));
            else
                return false;
        }
        return true;
    }

    static void readWords(String filename, Set<String> words, Set<String> prefixes, char[] boggle) {
        int wordcount = 0;
        try {
            Scanner s = new Scanner(new File(filename));
            while (s.hasNext()) {
                String word = s.next().toUpperCase();
                wordcount++;
                if (bogglable(word, boggle)) {
                    words.add(word);
                    for (int i = 0; i < word.length(); i++) {
                        prefixes.add(word.substring(0, i));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Read in "+wordcount+" words, making a word set of size "+words.size()+" and "+prefixes.size()+" prefixes");
    }

    static void findWords(Set<String> bogglewords, Set<String> words, Set<String> prefixes, boolean[] used, char[] boggle, int start, String prefix) {
        used[start] = true;

        String candidate = prefix+boggle[start];
        if (candidate.length() >= 3 && words.contains(candidate)) // yay, found a valid word
            bogglewords.add(candidate);
        if (prefixes.contains(candidate)) {
            for (int n : neighbours.get(start)) {
                if (!used[n])
                    findWords(bogglewords, words, prefixes, used, boggle, n, candidate);
            }
        }

        used[start] = false;
    }

    static List<String> solveBoggle(char[] boggle) {
        Set<String> words = new HashSet<>();
        Set<String> prefixes = new HashSet<>();

        boolean[] used = new boolean[dice.length];
        Set<String> boggleWords = new HashSet<>();

        readWords("resources/words/dictionary.txt", words, prefixes, boggle);

        for (int i = 0; i < dice.length; i++)
            findWords(boggleWords, words, prefixes, used, boggle, i, "");
        return new ArrayList<>(boggleWords);
    }

    @Test
    public void testBoggle() {
        char [] dice = { 'R', 'H', 'R', 'E', 'Y', 'P', 'C','S', 'W', 'N', 'S', 'N', 'T', 'E', 'G', 'O'};

        List<String> result = solveBoggle(dice);
        assertTrue("Did not contain PRESS", result.contains("PRESS"));
        assertTrue("Did not contain GENT", result.contains("GENT"));
        assertTrue("Did not contain PRY", result.contains("PRY"));
        assertFalse("Did  contain IRE", result.contains("IRE"));
        assertFalse("Did  contain CENTRE", result.contains("CENTRE"));
        assertFalse("Did  contain RESPECT", result.contains("RESPECT"));
        assertFalse("Did  contain PRESENT", result.contains("PRESENT"));
        assertFalse("Did  contain RHETORIC", result.contains("RHETORIC"));
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
        System.out.println("N "+neighbours.size());

        long start = System.currentTimeMillis();
       List<String> solution = solveBoggle(boggle);
       long duration = System.currentTimeMillis() - start;

        System.out.println("Found "+solution.size()+" words in "+duration+" msec!");

        Collections.sort(solution, (String s1, String s2) -> {
            if (s1.length() == s2.length())
                return s1.compareTo(s2);
            else
                return s2.length() - s1.length();
        });

        for (String w : solution)
            System.out.println(w);
    }
}
