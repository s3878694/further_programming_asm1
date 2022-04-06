package EnrollmentManagement;

import model.Enrollment;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class StudentEnrollmentTest {

    private StudentEnrollment studentEnrollment = new StudentEnrollment();

    @BeforeEach
    void setUp() {
        studentEnrollment.populateData("default.csv");
    }

    @org.junit.jupiter.api.Test
    void add() {
        Enrollment e = new Enrollment(studentEnrollment.getStudent("S101312"), studentEnrollment.getCourse("COSC4030"), "2021A");
        assertTrue(studentEnrollment.add(e));
        Enrollment e2 = new Enrollment(studentEnrollment.getStudent("S101312"), studentEnrollment.getCourse("COSC4030"), "2020C");
        assertFalse(studentEnrollment.add(e2));
    }

    @org.junit.jupiter.api.Test
    void delete() {
        Enrollment e = new Enrollment(studentEnrollment.getStudent("S101312"), studentEnrollment.getCourse("COSC4030"), "2021A");
        assertFalse(studentEnrollment.delete(e));
        Enrollment e2 = new Enrollment(studentEnrollment.getStudent("S101312"), studentEnrollment.getCourse("COSC4030"), "2020C");
        assertTrue(studentEnrollment.delete(e2));
    }

    @org.junit.jupiter.api.Test
    void getOne() {
        assertNotNull(studentEnrollment.getOne("S101312", "COSC4030", "2020C"));
        assertNull(studentEnrollment.getOne("S101312", "COSC4030", "2022R"));
    }

    @org.junit.jupiter.api.Test
    void getAll() {
        assertEquals(studentEnrollment.getAll().size(), 15);
    }
}