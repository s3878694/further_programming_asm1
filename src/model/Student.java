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

    @Override
    public String toString() {
        return "ID: " + studentID + "\n" + "Name: " + studentName + "\n" + "Dob: " + date + "\n";
    }

    /***
     * Return a String to write data to csv files
     * @return String
     */
    public String toCsv() {
        return studentID + "," + studentName + "," + date + "\n";
    }
}
