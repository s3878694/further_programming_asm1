package EnrollmentManagement;
import FileHandler.*;
import Helper.*;
import model.*;

import java.util.ArrayList;

public class StudentEnrollment implements StudentEnrollmentManager {
    private ArrayList<Enrollment> enrollments = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();

    public StudentEnrollment() {}

    /***
     * Populate Data from csv
     * @param fileName
     */
    public void populateData(String fileName) {
        for (String info : ReadCSV.readCSVFile(fileName)) {
            String[] data = info.split(",");
            Student s = new Student(data[0], data[1], data[2]);
            Course c = new Course(data[3], data[4], Integer.parseInt(data[5]));
            Enrollment e = new Enrollment(s,c,data[6]);
            if ( students.isEmpty() || (!isExist(s))) {
                students.add(s);
            }
            if ( courses.isEmpty() || (!isExist(c))) {
                courses.add(c);
            }
            if (enrollments.isEmpty() || !isExist(e)) {
                enrollments.add(e);
            }
        }
    }

    /***
     * Check if exist Student
     * @param s Student
     * @return boolean
     */
    public boolean isExist(Student s) {
        for (Student student: students) {
            if (student.getStudentID().equals(s.getStudentID())) {
                return true;
            }
        }
        return false;
    }

    /***
     * Check if exist Enrollment
     * @param e Enrollment
     * @return boolen
     */
    public boolean isExist(Enrollment e) {
        for (Enrollment enrollment: enrollments) {
            if(enrollment.getStudent().getStudentID().equals(e.getStudent().getStudentID()) && enrollment.getCourse().getCourseID().equals(e.getCourse().getCourseID()) && enrollment.getSemester().equals(e.getSemester())) {
                return true;
            }
        }
        return false;
    }

    /***
     * Check if exist Course
     * @param c Course
     * @return boolean
     */
    public boolean isExist(Course c) {
        for (Course course: courses) {
            if (course.getCourseID().equals(c.getCourseID())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(Enrollment e) {
        if (!isExist(e)) {
            enrollments.add(e);
            return true;
        } else {
            return false;

        }
    }

    @Override
    public boolean delete(Enrollment e) {
      for (int i = 0; i < enrollments.size(); i++) {
          if (enrollments.get(i).getStudent().getStudentID().equals(e.getStudent().getStudentID()) && enrollments.get(i).getCourse().getCourseID().equals(e.getCourse().getCourseID()) && enrollments.get(i).getSemester().equals(e.getSemester())) {
              enrollments.remove(i);
              return true;
          }
      }
      return false;
    }

    @Override
    public Enrollment getOne(String studentID, String courseID, String semester) {
        for (Enrollment e : enrollments) {
            if (e.getStudent().getStudentID().equals(studentID) && e.getCourse().getCourseID().equals(courseID) && e.getSemester().equals(semester)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Enrollment> getAll() {
        return enrollments;
    }

    public Student getStudent(String studentID) {
      for (Student s : students) {
          if (s.getStudentID().equals(studentID)) {
              return s;
          }
      }
      return null;
    }

    public Course getCourse(String courseID) {
        for (Course c : courses) {
            if (c.getCourseID().equals(courseID)) {
                return c.clone();
            }
        }
        return null;
    }
}


