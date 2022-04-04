import EnrollmentManagement.StudentEnrollment;
import EnrollmentManagement.StudentEnrollmentManager;
import FileHandler.CourseFileHandler;
import FileHandler.EnrollmentFileHandler;
import Helper.ReadCSV;
import FileHandler.StudentFileHandler;
import model.*;

public class Main {
    public static void main(String[] args) {
//        for (String s: ReadCSV.readCSVFile("default.s")) {
//            System.out.println(s);
//        }
//
//        StudentFileHandler handler = new StudentFileHandler();
//        handler.populateStudent("default.csv");
//        for (Student student : handler.getStudents()) {
//            System.out.println(student);
//        }
//
//        CourseFileHandler courseFileHandler = new CourseFileHandler();
//        EnrollmentFileHandler enrollmentFileHandler = new EnrollmentFileHandler();
//        courseFileHandler.populateCourse("default.csv");
//        enrollmentFileHandler.populateEnrollment("default.csv");
//
//        for (Course c : courseFileHandler.getCourses()) {
//            System.out.println(c);
//        }
//        System.out.println("\n");
//        for (Enrollment e : enrollmentFileHandler.getEnrolments()) {
//            System.out.println(e);
//        }
        StudentEnrollment studentEnrollmentManager = new StudentEnrollment();
        studentEnrollmentManager.populateData("default.csv");
        System.out.println(studentEnrollmentManager.getAll());
        System.out.println(studentEnrollmentManager.getOne("S101312", "COSC4030", "2020C"));

        Enrollment e = new Enrollment(studentEnrollmentManager.getStudent("S101312"), studentEnrollmentManager.getCourse("COSC4030"), "2021C");
        System.out.println(studentEnrollmentManager.add(e));
        System.out.println(studentEnrollmentManager.delete(e));


    }

}
