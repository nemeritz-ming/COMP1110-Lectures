package comp1110.lectures.J08;

public class Nesting {
    public static void main(String[] args) {
        LectureTheater a = new LectureTheater("MCH", "Panasonic", true);
        System.out.println("Two classes: "+a);
        LectureTheaterStaticNested b = new LectureTheaterStaticNested("MCH", "Panasonic", true);
        System.out.println("Classes static nested: "+b);
        LectureTheaterInner c = new LectureTheaterInner("MCH", "Panasonic", true);
        System.out.println("Classes inner class: "+c);
    }
}
