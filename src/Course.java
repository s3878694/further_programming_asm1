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
        return "Course{" +
                "courseID='" + courseID + '\'' +
                ", courseName='" + courseName + '\'' +
                ", numOfCredit=" + numOfCredit +
                '}';
    }
}
