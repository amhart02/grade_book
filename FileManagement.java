import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class FileManagement {

    private List<Course> courses = new ArrayList<>();

    public void ReadFromFile() {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader("students.csv"))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            String firstName = data[0];
            String lastName = data[1];
            String letterGrade = data[2];
            double percentage = Double.parseDouble(data[3]);
            String courseCode = data[4];
            String courseName = data[5];

            Course course = findOrCreateCourse(courseCode, courseName);

            Student student = new Student(firstName, lastName, letterGrade, percentage, courseCode, courseName);
            course.addStudent(student);
            }

        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }
    }

    public void writeToFile() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.csv"))) {
        writer.write("First Name,Last Name,Grade,Percentage,Course Code,Course Name");
        writer.newLine();

        for (Course course : courses) {
            for (Student student : course.getStudents()) {
                writer.write(student.getFirstName() + "," 
                        + student.getLastName() + ","
                        + student.getLetterGrade() + ","
                        + student.getPercentage() + ","
                        + student.getCourseCode() + ","
                        + student.getCourseName());
                writer.newLine();
            }
        }

    } catch (IOException e) {
        System.out.println("Error writing to the file.");
    }
}


    private Course findOrCreateCourse(String courseCode, String courseName) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        
        Course newCourse = new Course(courseName, courseCode);
        courses.add(newCourse);
        return newCourse;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Course getCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        System.out.println("Course not found");
        return null;
    }
}
