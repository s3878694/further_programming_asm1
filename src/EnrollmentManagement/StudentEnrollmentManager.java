package EnrollmentManagement;

import model.*;

import java.util.ArrayList;

public interface StudentEnrollmentManager {
    public Enrollment getOne(String studentID, String courseID, String semester);
    public ArrayList<Enrollment> getAll();
    public boolean add(Enrollment enrollment);
    public boolean delete(Enrollment enrollment);
}
