import java.util.Arrays;
import java.util.Comparator;

public class StudentSorter {
    public static void sortStudents(Student[] students) {
        Arrays.sort(students, new Comparator<Student>() {
            public int compare(Student a, Student b) {
                if (a.getGroup() != b.getGroup()) return Integer.compare(a.getGroup(), b.getGroup());
                if (a.getGrade() != b.getGrade()) return Integer.compare(b.getGrade(), a.getGrade());
                return a.getName().compareTo(b.getName());
            }
        });
    }
}