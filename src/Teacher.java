import java.util.Scanner;

public class Teacher extends Person {
    private double wage;

    @Override
    public void input(Scanner scanner) {
        super.input(scanner);

        System.out.print("Enter wage: ");
        wage = scanner.nextDouble();
    }

    @Override
    public String toString() {
        return super.toString() + " " + wage;
    }

    public double getWage() {
        return wage;
    }
}
