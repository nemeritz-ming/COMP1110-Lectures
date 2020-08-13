package comp1110.lectures.J08;

public class LectureTheaterInner {
    String name;
    ProjectorInner projector;

    public class ProjectorInner {
        private String model;
        private boolean hd;

        ProjectorInner(String model, boolean hd) {
            this.model = model;
            this.hd = hd;
        }

        @Override
        public String toString() {
            return "Model: "+model+", is "+(hd ? "" : "not ")+"HD, in room "+name;
        }
    }

    public LectureTheaterInner(String name, String model, boolean hd) {
        this.name = name;
        this.projector = new ProjectorInner(model, hd);
    }

    @Override
    public String toString() {
        return "Room "+name+" has a projector "+projector;
    }
}
