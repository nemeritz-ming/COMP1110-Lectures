package comp1110.lectures.J11;

import java.util.Random;

public class Boggle {
    static String[] dice = {"AJBBOO","AFFPSK","ANEAGE","APSHCO","QNUMHI","ZNHRLN","TDSTYI","TTWOOA","TLRYET","TUMIOC","EDVLRY","EDRLXI","EEGNHW","EIOTSS","ERHTWV","EENUSI"};


    public static void main(String[] args) {
        Random rand = new Random();

        int rowlength = (int) Math.sqrt(dice.length);

        for (int i = 0; i < dice.length; i++) {
            int die = rand.nextInt(dice.length);
            while (dice[die] == null) {
                die = (die + 1)  % dice.length;
            }

            // found
            int face = rand.nextInt(6);
            char value = dice[die].charAt(face);
            dice[die] = null;
            System.out.print(value);
            if (i % rowlength == (rowlength -1))
                System.out.println();
        }
    }
    }
