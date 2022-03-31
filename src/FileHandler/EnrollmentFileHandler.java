package FileHandler;

import Helper.ReadCSV;
import model.Enrollment;

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
            Enrollment e = new Enrollment(data[1], data[4], data[6]);
            if (enrollments.isEmpty() || !isExist(e)) {
                enrollments.add(e);
            }
        }

    }

    public boolean isExist(Enrollment e) {
        for (Enrollment enrollment: enrollments) {
            if (enrollment.getStudent().equals(e.getStudent()) && enrollment.getCourse().equals(e.getCourse()) && enrollment.getSemester().equals(e.getSemester())) {
                return true;
            }
        }
        return false;
    }
}
