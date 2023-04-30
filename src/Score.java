public class Score {
    private String course;
    private int value;

    public Score(String course, int value) {
        this.course = course;
        this.value = value;
    }

    public String getCourse() {
        return course;
    }

    public int getValue() {
        return value;
    }
    @Override
    public String toString() {
        return getCourse() + ": " + value;
    }
}
