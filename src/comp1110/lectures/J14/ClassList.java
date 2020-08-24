package comp1110.lectures.J14;

import comp1110.lectures.O02.COMP1110Student;

import java.util.*;

public class ClassList {

    public static void main(String[] args) {
        COMP1110Student stuarray[] = {
                new COMP1110Student(19,"Mary",  "u1234567", 4, 15, 5, 4, 7, 60),
                new COMP1110Student(20,"Bob",  "u2345678", 3, 16, 5, 4, 6, 70),
                new COMP1110Student(21,"Ting",  "u3456789", 4, 15, 4, 5, 9, 85),
                new COMP1110Student(18,"Vijay",  "u4567890", 5, 13, 3, 4, 6, 75),
        };

        for (COMP1110Student student : stuarray) {
            System.out.println("From array: "+student);
        }

        List<COMP1110Student> students = new ArrayList<>(Arrays.asList(stuarray));

        for (COMP1110Student student : students) {
            System.out.println("From list: "+student);
        }

        Map<String, COMP1110Student> uidmap = new HashMap<>();

        for (COMP1110Student student : stuarray) {
            uidmap.put(student.getUid(), student);
        }

        String key = "u2345678";
        COMP1110Student value = uidmap.get(key);
        System.out.println("Found: "+value);

        for (COMP1110Student student : uidmap.values()) {
            System.out.println("From map: "+student);
        }

        COMP1110Student sue = new COMP1110Student(21,"Sue",  "u4567891", 4, 15, 4, 5, 9, 85);
        uidmap.put(sue.getUid(), sue);

        System.out.println("Added Sue");
        for (COMP1110Student student : uidmap.values()) {
            System.out.println("From map: "+student);
        }
    }


}
