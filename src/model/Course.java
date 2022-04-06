package model;

public class Course {
    private final String courseID;
    private final String courseName;
    private final int numOfCredit;

    // Constructor
    public Course(String courseID, String courseName, int numOfCredit) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.numOfCredit = numOfCredit;
    }

    //Getter
    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getNumOfCredit() {
        return numOfCredit;
    }

    @Override
    public String toString() {
        return "ID: " + courseID + "\n" + "Course: " + courseName + "\n" + "Credit: " + numOfCredit + "\n";
    }

    /***
     * Function to get information from course to change it into a String to write to csv
     * @return a string under format of csv
     */
    public String toCsv() {
        return courseID + "," + courseName + "," + numOfCredit + "\n";
    }
}
