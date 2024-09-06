//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
class Student {
    int id;
    String name;
    int age;
    String email;
    String course;

    public Student(int id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public boolean isValidAge() {
        return age >= 16;
    }
}

class StudentManagement {
    Student[] students = new Student[100];
    int count = 0;

    public void saveStudent(Student student) {
        students[count++] = student;
        System.out.println("Student saved.");
    }

    public Student searchStudent(int id) {
        for (Student s : students) {
            if (s != null && s.id == id) {
                return s;
            }
        }
        return null;
    }

    public boolean deleteStudent(int id) {
        for (int i = 0; i < count; i++) {
            if (students[i].id == id) {
                students[i] = null;
                System.out.println("Student deleted.");
                return true;
            }
        }
        System.out.println("Student not found.");
        return false;
    }
}

public class StudentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement sm = new StudentManagement();

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Enter ID:");
                int id = scanner.nextInt();
                System.out.println("Enter Name:");
                String name = scanner.next();
                System.out.println("Enter Age:");
                int age = scanner.nextInt();
                System.out.println("Enter Email:");
                String email = scanner.next();
                System.out.println("Enter Course:");
                String course = scanner.next();

                Student student = new Student(id, name, age, email, course);
                sm.saveStudent(student);
            } else if (choice == 2) {
                System.out.println("Enter Student ID to Search:");
                int id = scanner.nextInt();
                Student foundStudent = sm.searchStudent(id);
                if (foundStudent != null) {
                    System.out.println("Student found: " + foundStudent.getName());
                } else {
                    System.out.println("Student not found.");
                }
            } else if (choice == 3) {
                System.out.println("Enter Student ID to Delete:");
                int id = scanner.nextInt();
                sm.deleteStudent(id);
            } else if (choice == 4) {
                break;
            }
        }

        scanner.close();
    }
}