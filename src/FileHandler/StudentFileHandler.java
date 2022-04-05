package FileHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Student;

public class StudentFileHandler {
    private ArrayList<Student> students;

    public StudentFileHandler() {}

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    /***
     * Write data to CSV file
     */
    public void dumpToFile() {
        try {
            File newFile = new File("Student.csv");
            FileWriter fileWriter = new FileWriter(newFile);
            if (students.isEmpty()) {
                System.out.println("No student to write");
                fileWriter.close();
            } else {
                for (Student s : students) {
                    fileWriter.append(s.toCsv());
                }
                fileWriter.close();
                System.out.println("Added to file");
            }
        } catch (IOException e) {
            System.out.println("Cannot save to File");
        }
    }
}
