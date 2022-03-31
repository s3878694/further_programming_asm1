package FileHandler;

import model.Course;
import java.util.ArrayList;
import Helper.ReadCSV;
import model.Student;

public class CourseFileHandler {
    private ArrayList<Course> courses = new ArrayList<>();

    public CourseFileHandler() {}

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void populateCourse(String fileName) {
        for (String info : ReadCSV.readCSVFile(fileName)) {
            String[] data = info.split(",");
            Course c = new Course(data[3], data[4], Integer.valueOf(data[5]));
            if ( courses.isEmpty() || (!isExist(c))) {
                courses.add(c);
            }
        }
    }

    public boolean isExist(Course c) {
        for (Course course: courses) {
            if (course.getCourseID().equals(c.getCourseID())) {
                return true;
            }
        }
        return false;
    }
}
