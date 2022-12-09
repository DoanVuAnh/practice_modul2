import java.io.Serializable;

public class Student implements Serializable {
    public static Long INDEX = Long.valueOf(0);
    private int id;

    private String name;

    private int age;

    private String sex;

    private String address;

    private float gpa;

    public Student() {
    }

    public Student(String name, int age, String sex, String address, float gpa) {
        this.id = Integer.parseInt(String.valueOf(++INDEX));
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.gpa = gpa;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", gpa=" + gpa +
                '}';
    }

    public int in() {
        return 0;
    }
}
