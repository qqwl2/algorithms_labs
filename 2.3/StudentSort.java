import java.util.List;

public class StudentSort implements Sorting<Student> {
    @Override
    public void sort(List<Student> students) {
        insertionSortByName(students);
        insertionSortByAge(students);
    }

    private void insertionSortByName(List<Student> students) {
        for (int i = 1; i < students.size(); i++) {
            Student studentik = students.get(i);
            int j = i - 1;
            while (j >= 0 && students.get(j).getName().compareTo(studentik.getName()) > 0) {
                students.set(j + 1, students.get(j));
                j--;
            }
            students.set(j + 1, studentik);
        }
    }

    private void insertionSortByAge(List<Student> students) {
        for (int i = 1; i < students.size(); i++) {
            Student studentik = students.get(i);
            int j = i - 1;
            while (j >= 0 && students.get(j).getAge() > studentik.getAge()) {
                students.set(j + 1, students.get(j));
                j--;
            }
            students.set(j + 1, studentik);
        }
    }
}