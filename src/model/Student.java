package model;

public class Student {
    private final String studentID;
    private final String studentName;
    private final String date;

    public Student(String studentID, String studentName, String date) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.date = date;
    }


    // Getter
    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getDate() {
        return date;
    }

    public static Student parseCsv(String studentString) {
        String[] data = studentString.split(",");

        return new Student(data[0], data[1], data[2]);
    }

    public Student clone() {
        return new Student(this.studentID, this.studentName, this.date);
    }


    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public boolean equals(Student other) {
        return (this.studentID.equals(other.getStudentID()) || this.studentName.equals(other.getStudentName()));
    }
}
