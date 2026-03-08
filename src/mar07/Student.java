package mar07;

public class Student {

    String name;
    int age;
    static int count;
    String StudentId;
    String course;
    String grade;

    static {
    }

    {
        count++;
        StudentId = "stu-" + count;
    }

    public Student(String name, int age, String course, String grade) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.grade = grade;
    }

    public String getProfile() {
        StringBuilder sBu = new StringBuilder("name:" + name);
        sBu.append(" |age:" + age);
        sBu.append(" |course:" + course);
        sBu.append(" |grade:" + grade);
        sBu.append(" |StudentId:" + StudentId);

        return sBu.toString();
    }
}
