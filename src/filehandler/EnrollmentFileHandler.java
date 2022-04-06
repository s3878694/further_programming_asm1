package filehandler;

import model.Enrollment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class EnrollmentFileHandler {
    private ArrayList<Enrollment> enrollments;

    public EnrollmentFileHandler() {}

    public ArrayList<Enrollment> getEnrolments() {
        return enrollments;
    }

    public void setEnrollments(ArrayList<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    /***
     * Write data to CSV file
     */
    public void dumpToFile() {
        try {
            File newFile = new File("Enrollment.csv");
            FileWriter fileWriter = new FileWriter(newFile);
            if (enrollments.isEmpty()) {
                System.err.println("No enrollment to write");
                fileWriter.close();
            } else {
                for (Enrollment e : enrollments) {
                    fileWriter.append(e.toCsv());
                }
                fileWriter.close();
                System.out.println("Added to file");
            }
        } catch (IOException e) {
            System.err.println("Cannot save to File");
        }
    }
}
