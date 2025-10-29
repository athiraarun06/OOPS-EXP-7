import java.util.*;

class InvalidEmpidException extends Exception {
    public InvalidEmpidException(String message) {
        super(message);
    }
}

class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }
}

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class Employee {
    int empid;
    String name;
    int age;

    public Employee(int empid, String name, int age) {
        this.empid = empid;
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("Employee ID  : " + empid);
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Age : " + age);
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Employee ID: ");
            int empid = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Employee Age: ");
            int age = sc.nextInt();

            
            if (empid < 1000) {
                throw new InvalidEmpidException("Invalid Employee ID! Must be a 4-digit number.");
            }

            
            if (name.matches("\\d+")) {
                throw new InvalidNameException("Invalid Name! Name cannot be a number.");
            }

            
            if (age > 50) {
                throw new InvalidAgeException("Invalid Age! Age must not exceed 50.");
            }

            
            Employee e = new Employee(empid, name, age);
            System.out.println("\nEmployee object created successfully!");
            e.display();

        } catch (InvalidEmpidException | InvalidNameException | InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid input types!");
        } finally {
            sc.close();
        }
    }
}
