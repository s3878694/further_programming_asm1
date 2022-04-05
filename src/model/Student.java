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

    /***
     * Return a clone of Studnet
     * @return student
     */
    public Student clone() {
        return new Student(this.studentID, this.studentName, this.date);
    }


    @Override
    public String toString() {
        return "ID: " + studentID + "\n" + "Name: " + studentName + "\n" + "Dob: " + date + "\n";
    }

    public String toCsv() {
        return studentID + "," + studentName + "," + date + "\n";
    }
}
