import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    private static final ArrayList<Person> people = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Add Teacher");
            System.out.println("2. Add Student");
            System.out.println("3. Show All People");
            System.out.println("4. Show All Teachers");
            System.out.println("5. Show All Students");
            System.out.println("6. Show Teacher by ID");
            System.out.println("7. Show Student by ID");
            System.out.println("8. Show Students by Score Range");
            System.out.println("9. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addTeacher(scanner);
                case 2 -> addStudent(scanner);
                case 3 -> showAllPeople();
                case 4 -> showAllTeachers();
                case 5 -> showAllStudents();
                case 6 -> showTeacherById(scanner);
                case 7 -> showStudentById(scanner);
                case 8 -> showStudentsByScoreRange();
                case 9 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addTeacher(Scanner scanner) {
        Teacher teacher = new Teacher();
        teacher.input(scanner);
        people.add(teacher);
        System.out.println("Teacher added.");
    }

    private static void addStudent(Scanner scanner) {
        Student student = new Student();
        student.input(scanner);
        people.add(student);
        System.out.println("Student added.");
    }

    private static void showAllPeople() {
        System.out.println("All people:");
        for (Person person : people) {
            System.out.println(person.toString());
        }
    }

    private static void showAllTeachers() {
        System.out.println("All teachers:");
        for (Person person : people) {
            if (person instanceof Teacher) {
                System.out.println(person);
            }
        }
    }

    private static void showAllStudents() {
        System.out.println("All students:");
        for (Person person : people) {
            if (person instanceof Student) {
                System.out.println(person);
            }
        }
    }

    private static void showTeacherById(Scanner scanner) {
        System.out.println("Enter the teacher's ID:");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Person person : people) {
            if (person.getId() == id) {
                if (person instanceof Teacher) {
                    System.out.println(person);
                } else {
                    System.out.println("Not a teacher.");
                }
                return;
            }
        }

        System.out.println("Doesn't exist.");
    }


        public static void showStudentById (Scanner scanner) {
            System.out.print("Enter student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Person person = null;
            for (Person p : people) {
                if (p.getId() == id) {
                    person = p;
                    break;
                }
            }

            if (person == null) {
                System.out.println("Doesn't exist");
            } else if (person instanceof Teacher) {
                System.out.println("Not a student");
            } else {
                Student student = (Student) person;
                System.out.println(student);

                boolean subMenuLoop = true;
                while (subMenuLoop) {
                    System.out.println("\nSelect an option:");
                    System.out.println("a. Show All Scores");
                    System.out.println("b. Insert a New Score");
                    System.out.println("c. Show Average Score");
                    System.out.println("d. Return to the Main Menu");

                    String choice = scanner.nextLine();
                    switch (choice) {
                        case "a" -> {
                            System.out.println("Scores:");
                            List<Score> scores = student.getScores();
                            for (int i = 0; i < scores.size(); i++) {
                                System.out.println(i + 1 + ". " + scores.get(i).toString());
                                //scores.get(i).toString()
                            }
                        }
                        case "b" -> {
                            System.out.print("Enter course name: ");
                            String course = scanner.nextLine();
                            System.out.print("Enter score value: ");
                            double value = scanner.nextDouble();
                            scanner.nextLine();
                            Score newScore = new Score(course, (int) value);
                            student.getScores().add(newScore);
                            System.out.println("Score added successfully.");
                        }
                        case "c" -> System.out.printf("Average score: %.2f\n", student.getAverageScore());
                        case "d" -> subMenuLoop = false;
                        default -> System.out.println("Invalid choice. Please try again.");
                    }
                }
            }
        }


    public static void showStudentsByScoreRange() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minimum score: ");
        double minScore = scanner.nextDouble();
        System.out.print("Enter maximum score: ");
        double maxScore = scanner.nextDouble();

        boolean found = false;
        for (Person person : people) {
            if (person instanceof Student student) {
                double avgScore = student.getAverageScore();
                if (avgScore >= minScore && avgScore <= maxScore) {
                    System.out.println(student + ", Average Score: " + avgScore);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No students found in that score range.");
        }
    }
}

