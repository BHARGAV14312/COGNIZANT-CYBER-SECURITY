import java.util.LinkedHashMap;
import java.util.Map;

public class StudentGrades {
    private LinkedHashMap<Integer, Student> studentMap;

    public StudentGrades() {
        studentMap = new LinkedHashMap<>();
    }

    public void addStudent(Student student) {
        studentMap.put(student.getId(), student);
    }

    public void removeStudent(int studentId) {
        studentMap.remove(studentId);
    }

    public void updateStudentGrade(int studentId, char newGrade) {
        Student student = studentMap.get(studentId);
        if (student != null) {
            student.setGrade(newGrade);
        }
    }

 
    public void displayStudents() {
        for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
