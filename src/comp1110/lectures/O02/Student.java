package comp1110.lectures.O02;

public class Student extends Person {
    private String uid;

    public Student(int age, String name, String uid) {
        super(age, name);
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    @Override
    public String toString() {
        return super.toString() + ", has uid "+uid;
    }
}
