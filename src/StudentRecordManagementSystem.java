import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentRecordManagementSystem {

    // list to store students
    static List<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {


        System.out.println("Welcome to Student Record Management System");

        // Main menu loop
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Student.");
            System.out.println("2. view Students.");
            System.out.println("3. Update Student.");
            System.out.println("4. Delete Student.");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();


            // Handle user choice
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }


    }

    // Method to add a new student
    private static void addStudent() {

        System.out.println("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter student name: ");
        String name = sc.nextLine();
        System.out.println("Enter student marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }


    // Method to view all students
    private static void viewStudent() {
        if (students.isEmpty()) {
            System.out.println("No student records found");
        } else {
            System.out.println("---- Students List -----");

            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Method to update student information
    private static void updateStudent() {
        System.out.println("Enter Student Id to Update.");

        int id = sc.nextInt();

        for (Student student : students) {
            if (student.getId() == id) {
                sc.nextLine();
                System.out.println("Enter new name");
                String updatedName = sc.nextLine();
                student.setName(updatedName);
                System.out.println("Enter new marks");
                double updatedMarks = sc.nextDouble();
                student.setMarks(updatedMarks);

                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Method to delete a student
    private static void deleteStudent() {

        System.out.println("Enter student ID to delete:");
        int id = sc.nextInt();

        boolean removed = students.removeIf(student -> student.getId() == id);

        if (removed) {
            System.out.println("Student record deleted successfully.");
        } else {
            System.out.println("No student found with that ID : " + id);
        }
    }
}


// Student class
class Student {

    private int id;
    private String name;
    private double marks;


    // Constructor for student class
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;


    }

    //Getters and setters for student class
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}