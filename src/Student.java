import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person {
    private ArrayList<Score> scores;

    public Student() {
        scores = new ArrayList<>();
    }


    public ArrayList<Score> getScores() {
        return scores;
    }

    public void addScore(String course, int value) {
        Score score = new Score(course, value);
        scores.add(score);
    }

    public double getAverageScore() {
        if (scores.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Score score : scores) {
            sum += score.getValue();
        }
        return sum / scores.size();
    }

    @Override
    public String toString() {
        return super.toString() + " " + getAverageScore();
    }
}