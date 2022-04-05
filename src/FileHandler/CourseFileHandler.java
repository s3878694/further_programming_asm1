package FileHandler;

import model.Course;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CourseFileHandler {
    private ArrayList<Course> courses;

    public CourseFileHandler() {}

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    /***
     * Write data to CSV file
     */
    public void dumpToFile() {
        try {
            File newFile = new File("Course.csv");
            FileWriter fileWriter = new FileWriter(newFile);
            if (courses.isEmpty()) {
                System.out.println("No course to write");
                fileWriter.close();
            } else {
                for (Course c : courses) {
                    fileWriter.append(c.toCsv());
                }
                fileWriter.close();
                System.out.println("Added to file");
            }
        } catch (IOException e) {
            System.out.println("Cannot save to File");
        }
    }
}
