import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        int userInput = 0;
        FileManagement fileManagement = new FileManagement();
        fileManagement.ReadFromFile();
        Scanner scanner = new Scanner(System.in);
        // List<Course> courses = fileManagement.getCourses();

        while (userInput != 6) {
            userInput = menu.DisplayMainMenu();

            // view all students in a class
            if (userInput == 1) {
                System.out.println("Choose a course (CSE 110, WDD 130, or ITM 111): ");
                String selectedCourseCode = scanner.nextLine();
                Course selectedCourse = fileManagement.getCourseByCode(selectedCourseCode);
                System.out.println();
                selectedCourse.displayStudents();
                System.out.println();
            }

            // change a grade
            if (userInput == 2) {
                System.out.println("Choose a course (CSE 110, WDD 130, or ITM 111): ");
                String selectedCourseCode = scanner.nextLine();
                Course selectedCourse = fileManagement.getCourseByCode(selectedCourseCode);
                List<Student> students = selectedCourse.getStudents();
                System.out.println();
                for (int i = 0; i < students.size(); i++) {
                    System.out.println((i + 1) + "-" + students.get(i).getFullName());
                }
                System.out.println("Please choose a student by number: ");
                int studentNumber = scanner.nextInt() - 1;
                Student selectedStudent = students.get(studentNumber);
                System.out.println("Enter the grade percentage for " + selectedStudent.getFullName() + ": ");
                double newPercentage = scanner.nextDouble();
                scanner.nextLine();
                selectedStudent.setPercentage(newPercentage);
                selectedStudent.setLetterGrade(selectedStudent.determineLetterGrade(newPercentage));
                System.out.println();
                System.out.println("Updated " + selectedStudent.getFullName() + "'s grade to " + selectedStudent.getLetterGrade() + " " +  newPercentage + "!");
                System.out.println();
                fileManagement.writeToFile();  
                fileManagement.ReadFromFile();
            }

            //move a student
            if (userInput == 3) {
                System.out.println("Choose the current course of the student (CSE 110, WDD 130, or ITM 111): ");
                String currentCourseCode = scanner.nextLine();
                Course currentCourse = fileManagement.getCourseByCode(currentCourseCode);
                List<Student> students = currentCourse.getStudents();
                for (int i = 0; i < students.size(); i++) {
                    System.out.println((i + 1) + " - " + students.get(i).getFullName());
                }
                System.out.println("Choose a student by number: ");
                int studentNumber = scanner.nextInt() - 1;
                scanner.nextLine();
                Student studentToMove = students.get(studentNumber);
                System.out.println("Enter the new course code: ");
                String newCourseCode = scanner.nextLine();
                Course newCourse = fileManagement.getCourseByCode(newCourseCode);
                currentCourse.removeStudent(studentToMove);
                newCourse.addStudent(studentToMove);
                studentToMove.setCourseCode(newCourseCode);
                studentToMove.setCourseName(newCourse.getCourseName());
                System.out.println();
                System.out.println(studentToMove.getFullName() + " has been moved to " + newCourseCode + "!");
                System.out.println();
                fileManagement.writeToFile();  
            }

            //add a student
            if (userInput == 4) {
                System.out.println("Choose a course to add a student to (CSE 110, WDD 130, or ITM 111): ");
                String courseCode = scanner.nextLine();
                Course course = fileManagement.getCourseByCode(courseCode);
                System.out.println("Enter the student's first name: ");
                String firstName = scanner.nextLine();
                System.out.println("Enter the student's last name: ");
                String lastName = scanner.nextLine();
                System.out.println("Enter the student's grade percentage: ");
                double percentage = scanner.nextDouble();
                scanner.nextLine();  // Clear the newline
                String letterGrade = new Student(firstName, lastName, "", percentage, courseCode, course.getCourseName()).determineLetterGrade(percentage);
                Student newStudent = new Student(firstName, lastName, letterGrade, percentage, courseCode, course.getCourseName());
                course.addStudent(newStudent);
                System.out.println(firstName + " " + lastName + " has been added to " + course.getCourseCode() + "!");
                System.out.println();
                fileManagement.writeToFile(); 
            }

            //remove a student
            if (userInput == 5) {
                System.out.println("Choose the course to remove a student from (CSE 110, WDD 130, or ITM 111): ");
                String courseCode = scanner.nextLine();
                Course course = fileManagement.getCourseByCode(courseCode);
                List<Student> students = course.getStudents();
                for (int i = 0; i < students.size(); i++) {
                    System.out.println((i + 1) + " - " + students.get(i).getFullName());
                }
                System.out.println("Choose a student by number: ");
                int studentNumber = scanner.nextInt() - 1;
                scanner.nextLine(); 
                Student studentToRemove = students.get(studentNumber);
                course.removeStudent(studentToRemove);
                System.out.println();
                System.out.println(studentToRemove.getFullName() + " has been removed from " + course.getCourseCode() + "!");
                System.out.println();
                fileManagement.writeToFile();
            }
        }
        scanner.close();
    }       
}
