//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int studentID;
    private String studentName;
    private int studentAge;

    // Constructor
    public Student(int studentID, String studentName, int studentAge) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAge = studentAge;
    }

    // Getters
    public int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }
}

class StudentManagement {
    private ArrayList<Student> students;

    public StudentManagement() {
        students = new ArrayList<>();
    }

    // 1. SaveStudent
    public void saveStudent(int studentID, String studentName, int studentAge) {
        Student student = new Student(studentID, studentName, studentAge);
        students.add(student);
        System.out.println("Student details have been successfully saved.");
    }

    // 2. SearchStudent
    public void searchStudent(int studentID) {
        for (Student student : students) {
            if (student.getStudentID() == studentID) {
                System.out.println("Student found: ID: " + student.getStudentID() +
                        ", Name: " + student.getStudentName() +
                        ", Age: " + student.getStudentAge());
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // 3. DeleteStudent
    public void deleteStudent(int studentID) {
        for (Student student : students) {
            if (student.getStudentID() == studentID) {
                System.out.println("Are you sure you want to delete student with ID: " + studentID + "? (yes/no)");
                Scanner scanner = new Scanner(System.in);
                String confirmation = scanner.nextLine();
                if (confirmation.equalsIgnoreCase("yes")) {
                    students.remove(student);
                    System.out.println("Student deleted.");
                } else {
                    System.out.println("Deletion cancelled.");
                }
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // 4. StudentReport
    public void studentReport() {
        System.out.println("---- Student Report ----");
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println("ID: " + student.getStudentID() +
                        ", Name: " + student.getStudentName() +
                        ", Age: " + student.getStudentAge());
            }
        }
    }

    // 5. ExitStudentApplication
    public void exitApplication() {
        System.out.println("Exiting the application. Goodbye!");
        System.exit(0);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement management = new StudentManagement();
        int studentID, studentAge;
        String studentName;

        while (true) {
            // Display menu
            System.out.println("\n1. Capture New Student");
            System.out.println("2. Search Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View Student Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Capture New Student
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextInt();
                    scanner.nextLine(); // Clear the buffer
                    System.out.print("Enter Student Name: ");
                    studentName = scanner.nextLine();
                    while (true) {
                        System.out.print("Enter Student Age: ");
                        if (scanner.hasNextInt()) {
                            studentAge = scanner.nextInt();
                            if (studentAge >= 16) {
                                break;
                            } else {
                                System.out.println("Invalid age. Age must be greater than or equal to 16.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a valid age.");
                            scanner.next(); // Clear invalid input
                        }
                    }
                    management.saveStudent(studentID, studentName, studentAge);
                    break;

                case 2:
                    // Search Student
                    System.out.print("Enter Student ID to search: ");
                    studentID = scanner.nextInt();
                    management.searchStudent(studentID);
                    break;

                case 3:
                    // Delete Student
                    System.out.print("Enter Student ID to delete: ");
                    studentID = scanner.nextInt();
                    management.deleteStudent(studentID);
                    break;

                case 4:
                    // View Student Report
                    management.studentReport();
                    break;

                case 5:
                    // Exit
                    management.exitApplication();
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }
    }
}