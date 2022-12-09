import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager implements Serializable {

    private static final String REGEX_STRING = "[ny]" ;
    public static Scanner scanner = new Scanner(System.in);

    private List<Student> studentList;

    private final StudentDao studentDao;

    public StudentManager() {
        studentList = new ArrayList<>();
        studentDao = new StudentDao();
        studentList = studentDao.read();
        resetStaticINDEX();
    }

    void addStudent(){
        String name = inputName();
        int age = inputAge();
        String sex = inputSex();
        String address = inputAddress();
        float gpa = inputGpa();
        studentList.add(new Student(name, age, sex, address, gpa));
        StudentDao.write(studentList);
    }

    public void editStudent(int id) {
        boolean isExisted = false;
        for (Student student : studentList) {
            if (student.getId() == id) {
                isExisted = true;
                student.setName(inputName());
                student.setAge(inputAge());
                student.setSex(inputSex());
                student.setAddress(inputAddress());
                student.setGpa(inputGpa());
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("id = %d not existed.\n", id);
        } else {
            studentDao.write(studentList);
        }
    }

    public void deleteStudent(int id) {
        Student student = null;
        for (Student value : studentList) {
            if (value.getId() == id) {
                student = value;
                break;
            }
        }
        if (student != null) {
            studentList.remove(student);
            studentDao.write(studentList);
        } else {
            System.out.printf("id = %d not existed.\n", id);
        }
    }

    public void displayListStudent() {
        System.out.printf("%10s | ","ID");
        System.out.printf("%20s | ","Name");
        System.out.printf("%5s | ", "Age");
        System.out.printf("%20s | ", "Sex");
        System.out.printf("%20s | ", "Address");
        System.out.printf("%10s%n", "Gpa");

        for (Student student : studentList) {
            System.out.format("%10d | ", student.getId());
            System.out.format("%20s | ", student.getName());
            System.out.format("%5d | ", student.getAge());
            System.out.format("%20s | ", student.getSex());
            System.out.format("%20s | ", student.getAddress());
            System.out.format("%15f%n", student.getGpa());

        }
    }


        public void sortStudentByGPA(int choice) {
            if (choice == 1) {
                studentList.sort(new SortStudentGetSmallerByGPA());
                displayListStudent();
            }
            if (choice == 2){
                studentList.sort(new SortStudentGetBiggerByGPA());
                displayListStudent();
            }
        }


    public int inputId() {
        System.out.print("Input student id: ");
        while (true) {
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input student id again: ");
            }
        }
    }
    public void ReadFromFile() {
        System.out.println("Reading from File will lose current data, do you want to continue? (yes:y or no:n): ");
        String choice = validateString(REGEX_STRING);
        if (choice.equals("y")) {
            studentList = StudentDao.read();
            System.out.println("Read the file successfully, select the list view function to check.");
        }
    }

    //Ghi từ file
    public void WriteToFile() {
        System.out.println("Writing to File will lose saved data, do you want to continue? (yes:y or no:n): ");
        String choice = validateString(REGEX_STRING);
        if (choice.equals("y")) {
            StudentDao.write(studentList);
            System.out.println("Write the file successfully, run the program again and select the file reading function to check.");
        }
    }

    public String validateString(String regex) {
        while (true) {
            String name = scanner.nextLine();
            if (name.matches(regex)) {
                return name;
            }
            System.err.println("Incorrect format, please re-enter.");
        }
    }



    private String inputName() {
        System.out.println("Input student name: ");
        return scanner.nextLine();
    }

    private int inputAge() {
        System.out.println("Input student Age: ");
        while (true) {
            try {
                int age = Integer.parseInt((scanner.nextLine()));
                if (age < 0 || age > 100) {
                    throw new NumberFormatException();
                }
                return age;
            } catch (NumberFormatException ex) {
                System.out.print("Invalid! Input student age again: ");
            }

        }
    }
    private String inputSex() {
        System.out.println("Input student Sex(Male / Female): ");
        String sex = scanner.nextLine();
        return sex;
    }

    private String inputAddress() {
        System.out.println("Input student address: ");
        String add = scanner.nextLine();
        return add;
    }

    private float inputGpa() {
        System.out.print("Input student gpa: ");
        while (true) {
            try {
                float gpa = Float.parseFloat((scanner.nextLine()));
                if (gpa < 0.0 || gpa > 10.0) {
                    throw new NumberFormatException();
                }
                return gpa;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input student gpa again: ");
            }
        }
    }

    private void resetStaticINDEX(){
        if(!studentList.isEmpty()){
            Student.INDEX = Long.valueOf(studentList.get(studentList.size()-1).getId());
        }
    }

}
