package FileHandler;

import java.util.ArrayList;
import model.Student;
import Helper.ReadCSV;

public class StudentFileHandler {
    private ArrayList<Student> students = new ArrayList<>();

    public StudentFileHandler() {}

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public void populateStudent(String fileName) {
        for (String info : ReadCSV.readCSVFile(fileName)) {
            String[] data = info.split(",");
            Student s = new Student(data[0], data[1], data[2]);
            if ( students.isEmpty() || (!isExist(s))) {
               students.add(s);
            }
        }
    }

    public boolean isExist(Student s) {
        for (Student student: students) {
            if (student.getStudentID().equals(s.getStudentID())) {
                return true;
            }
        }
        return false;
    }
}
