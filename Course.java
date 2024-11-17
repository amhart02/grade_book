import java.util.List;
import java.util.ArrayList; 

public class Course {

    private String courseName;
    private String courseCode;
    private List<Student> students;

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.students = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void displayStudents() {
        System.out.println("Students in " + courseCode + ": " + courseName + "-");
        for (Student student : students) {
            student.displayStudent();
        }
    }  

    public void removeStudent(Student student) {
        students.remove(student);
    }
}
