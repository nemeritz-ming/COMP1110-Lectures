package comp1110.lectures.J08;

public class LectureTheater {
    String name;
    Projector projector;

    public LectureTheater(String name, String model, boolean hd) {
        this.name = name;
        this.projector = new Projector(model, hd, this);
    }

    @Override
    public String toString() {
        return "Room "+name+" has a projector "+projector;
    }
}
