package enrollmentmanagement;

import model.Enrollment;

import java.util.ArrayList;

/**
 *
 */
public interface StudentEnrollmentManager {
    Enrollment getOne(String studentID, String courseID, String semester);
    ArrayList<Enrollment> getAll();
    boolean add(Enrollment enrollment);
    boolean delete(Enrollment enrollment);
}
