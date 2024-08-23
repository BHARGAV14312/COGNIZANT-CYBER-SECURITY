public class StudentGradesTest {
    public static void main(String[] args) {
        // Create StudentGrades instance
        StudentGrades grades = new StudentGrades();

        grades.addStudent(new Student(1, "Alice", 'A'));
        grades.addStudent(new Student(2, "Bob", 'B'));
        grades.addStudent(new Student(3, "Charlie", 'C'));


        System.out.println("All students:");
        grades.displayStudents();

        grades.updateStudentGrade(2, 'A');

        System.out.println("\nStudents after grade update:");
        grades.displayStudents();

        grades.removeStudent(1);

        System.out.println("\nStudents after removal:");
        grades.displayStudents();
    }
}
