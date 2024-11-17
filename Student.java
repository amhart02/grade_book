public class Student {

    private String firstName;
    private String lastName;
    private String letterGrade;
    private double percentage;
    private String courseCode;
    private String courseName;

    public Student (String firstName, String lastName, String letterGrade, double percentage, String courseCode, String courseName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.letterGrade = letterGrade;
        this.percentage = percentage;
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    public String determineLetterGrade(double percentage) {
        if (percentage >= 97) {
            return "A+";
        } else if (percentage >= 93) {
            return "A";
        } else if (percentage >= 90) {
            return "A-";
        } else if (percentage >= 87) {
            return "B+";
        } else if (percentage >= 83) {
            return "B";
        } else if (percentage >= 80) {
            return "B-";
        } else if (percentage >= 77) {
            return "C+";
        } else if (percentage >= 73) {
            return "C";
        } else if (percentage >= 70) {
            return "C-";
        } else if (percentage >= 67) {
            return "D+";
        } else if (percentage >= 63) {
            return "D";
        } else if (percentage >= 60) {
            return "D-";
        } else {
            return "F";
        }
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void displayStudent() {
        System.out.println(firstName + " " + lastName + "-");
        System.out.println("Grade: " + letterGrade + " " + percentage);
        System.out.println("Class: " + courseCode + "-" + courseName);
        System.out.println("--------------------------------------");
    }
}

