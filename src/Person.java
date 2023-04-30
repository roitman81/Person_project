import java.util.ArrayList;
import java.util.Scanner;

public class Person {
    static ArrayList<Integer> idList = new ArrayList<Integer>();
    private int id;
    private String firstName;
    private String lastName;
    private MaritalStatus status;
    int attempts=5;

    public void input(Scanner scanner) {


        while(true){
            System.out.print("Enter id: ");
            attempts--;
            if (scanner.hasNextInt()){
                id = scanner.nextInt();
                if(!idList.contains(id)){
                    idList.add(id);
                    break;
                }
                else {
                    System.out.println("ID already exists, attempts " + attempts + " left");
                }
            }
            else {
                System.out.println("ID should be an integer, attempts " + attempts + " left");
                if (attempts == 0) break;
                scanner.next();

            }
        }

        System.out.print("Enter first name: ");
        firstName = scanner.next();
        while (firstName.isEmpty() || !firstName.matches("^[a-zA-Z]*$")) {
            attempts -= 1;
            System.out.println("The first name must be string, attempts " + attempts + " left");
            if (attempts == 0) break;
            System.out.print("Enter first name: ");
            firstName = scanner.next();
        }

        System.out.print("Enter last name: ");
        lastName = scanner.next();
        while (lastName.isEmpty() || !lastName.matches("^[a-zA-Z]*$")) {
            attempts-=1;
            System.out.println("The last name must be string, attempts "+attempts+ " left");
            if (attempts==0)break;
            System.out.print("Enter last name: ");
            lastName = scanner.next();

        }

        while (status==null){
        try {
        System.out.print("Enter marital status (SINGLE/MARRIED/DIVORCED): ");
        String statusString = scanner.next();
        status = MaritalStatus.valueOf(statusString.toUpperCase());}
        catch (Exception e){
            System.out.println("The marital status must be (SINGLE/MARRIED/DIVORCED)");

        }
    }}

    public String toString() {
        return id + " " + firstName + " " + lastName + " " + status.toString();
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public MaritalStatus getStatus() {
        return status;
    }

    public void setStatus(MaritalStatus status) {
        this.status = status;
    }
}
