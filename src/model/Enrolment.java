package model;

public class Enrolment {
    private final String studentName;
    private final String courseName;
    private final String semester;

    // Constructor
    public Enrolment(String studentName, String courseName, String semester) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.semester = semester;
    }

    // Getter
    public String getStudent() {
        return studentName;
    }

    public String getCourse() {
        return courseName;
    }

    public String getSemester() {
        return semester;
    }

    @Override
    public String toString() {
        return "Enrolment{" +
                "student=" + studentName +
                ", course=" + courseName +
                ", semester='" + semester + '\'' +
                '}';
    }
}
