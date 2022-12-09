import java.util.Scanner;

public class StudentMenu {
    public static Scanner scanner = new Scanner(System.in);
    StudentManager studentManager = new StudentManager();
    public void menu() {
        String choose = null;
        boolean exit = false;

        int studentId;
        do {
            System.out.println("-----------MENU------------");
            System.out.println("1. Add student.");
            System.out.println("2. Edit student by id.");
            System.out.println("3. Delete student by id.");
            System.out.println("4. Sort student by gpa.");
            System.out.println("5. Display student.");
            System.out.println("6. Read files.");
            System.out.println("7. Write file.");
            System.out.println("0. Exit.");
            System.out.println("---------------------------");
            System.out.print("Please choose: ");


            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    studentManager.addStudent();
                    break;
                case "2":
                    studentId = studentManager.inputId();
                    studentManager.editStudent(studentId);
                    break;
                case "3":
                    studentId = studentManager.inputId();
                    studentManager.deleteStudent(studentId);
                    break;
                case "4":
                    menuGPA();
                    break;
                case "5":
                    studentManager.displayListStudent();
                    break;
                case "6":
                    studentManager.ReadFromFile();
                    break;
                case "7":
                    studentManager.WriteToFile();
                    break;
                case "0":
                    System.out.println("Exited!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid! Please choose action in below menu:");
            }
            if (exit) {
                break;
            }

        } while (choose != null);
    }

    public void menuGPA() {
        do {
            System.out.println("1. Grade point average is decreasing");
            System.out.println("2. Grade point average increasing");
            System.out.println("0. Exit");
            System.out.println("Please choose: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 0) {
                break;
            }
            studentManager.sortStudentByGPA(choice);
        }
        while (true) ;
    }
}
