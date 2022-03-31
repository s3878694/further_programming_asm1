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

    /***
     *
     * @param courseString a String from csv file
     * @return new course base on String data
     */
    public static Course parseCsvString(String courseString) {
        String[] data = courseString.split(",");

        return new Course(data[0], data[1], Integer.valueOf(data[2]));
    }

    /***
     *
     * @return new course base on data of the first course
     */
    public Course clone() {
        return new Course(this.courseID, this.courseName, this.numOfCredit);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID='" + courseID + '\'' +
                ", courseName='" + courseName + '\'' +
                ", numOfCredit=" + numOfCredit +
                '}';
    }
}
