import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    static File file = new File("D:\\bai tap\\module 2\\Case Module 2\\Module_APwithJava2.0\\src\\Student.csv");

    public static void write(List<Student> studentList) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Student student : studentList) {
                bufferedWriter.write(student.in());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> read() {
        List<Student> studentList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while (str != null) {
                String[] arr = str.split(", ");
//                String code = arr[0];
                String name = arr[0];
                int age = Integer.parseInt(arr[1]);
                String gender = arr[2];
                String address = arr[3];
                float gpa = Float.parseFloat((arr[4]));


                Student student = new Student(name, age, gender, address, gpa);
                studentList.add(student);
                str = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
