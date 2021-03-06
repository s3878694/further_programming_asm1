package model;

public class Enrollment {
    private final Student student;
    private final Course course;
    private final String semester;

    // Constructor
    public Enrollment(Student student, Course course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
    }

    // Getter
    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getSemester() {
        return semester;
    }

    @Override
    public String toString() {
        return "Names: " + student.getStudentName() + "\n" + "Course: " + course.getCourseName() + "\n" + "Semester: " + semester + "\n";
    }

    /***
     * Function to get information from student to change it into a String to write to csv
     * @return a string under format of csv
     */
    public String toCsv() {
        return student.getStudentName() + "," + course.getCourseName() + "," + semester + "\n";
    }
}
