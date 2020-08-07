package comp1110.lectures.O02;

public enum Grade {
    HD(80), D(70), CR(60), P(50), N(0);
    private final int lowerBound;

    Grade(int lowerBound) {
        this.lowerBound = lowerBound;
    }
    public static Grade fromMark(int mark) {
        for (Grade g : Grade.values()) {
            if (mark >= g.lowerBound)
                return g;
        }
        return N;
    }
}
