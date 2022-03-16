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

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
