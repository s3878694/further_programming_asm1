package FileHandler;

import Helper.ReadCSV;
import model.Course;
import model.Enrollment;
import model.Student;

import java.util.ArrayList;


public class EnrollmentFileHandler {
    private ArrayList<Enrollment> enrollments = new ArrayList<>();

    public EnrollmentFileHandler() {}

    public ArrayList<Enrollment> getEnrolments() {
        return enrollments;
    }

    public void populateEnrollment(String fileName) {
        for (String info : ReadCSV.readCSVFile(fileName)) {
            String[] data = info.split(",");
            Student s = new Student(data[0], data[1], data[2]);
            Course c = new Course(data[3], data[4], Integer.valueOf(data[5]));
            Enrollment e = new Enrollment(s,c,data[6]);
            if (enrollments.isEmpty() || !isExist(e)) {
                enrollments.add(e);
            }
        }

    }

    public boolean isExist(Enrollment e) {
        for (Enrollment enrollment: enrollments) {
            if(enrollment.getStudent().getStudentID().equals(e.getStudent().getStudentID()) && enrollment.getCourse().getCourseID().equals(e.getCourse().getCourseID()) && enrollment.getSemester().equals(e.getSemester())) {
                return true;
            }
        }
        return false;
    }
}
