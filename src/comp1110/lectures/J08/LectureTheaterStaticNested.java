package comp1110.lectures.J08;

public class LectureTheaterStaticNested {
    String name;
    ProjectorStaticNested projector;

    static public class ProjectorStaticNested {
        private String model;
        private boolean hd;
        private LectureTheaterStaticNested room;

        ProjectorStaticNested(String model, boolean hd, LectureTheaterStaticNested room) {
            this.model = model;
            this.hd = hd;
            this.room = room;
        }

        @Override
        public String toString() {
            return "Model: "+model+", is "+(hd ? "" : "not ")+"HD, in room "+room.name;
        }
    }

    public LectureTheaterStaticNested(String name, String model, boolean hd) {
        this.name = name;
        this.projector = new ProjectorStaticNested(model, hd, this);
    }

    @Override
    public String toString() {
        return "Room "+name+" has a projector "+projector;
    }
}
