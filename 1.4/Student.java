public class Student {
    private final String name;
    private final int grade;
    private final int group;

    public Student(String name, int grade, int group) {
        this.name = name;
        this.grade = grade;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public int getGroup() {
        return group;
    }
}