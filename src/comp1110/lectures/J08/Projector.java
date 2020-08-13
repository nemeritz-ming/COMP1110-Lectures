package comp1110.lectures.J08;

public class Projector {
    private String model;
    private boolean hd;
    private LectureTheater room;

    Projector(String model, boolean hd, LectureTheater room) {
        this.model = model;
        this.hd = hd;
        this.room = room;
    }

    @Override
    public String toString() {
        return "Model: "+model+", is "+(hd ? "" : "not ")+"HD, in room "+room.name;
    }
}
