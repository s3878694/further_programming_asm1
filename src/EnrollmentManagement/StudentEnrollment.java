package EnrollmentManagement;
import FileHandler.*;
import Helper.*;
import model.*;

import java.util.ArrayList;

public class StudentEnrollment implements StudentEnrollmentManager {
    private ArrayList<Enrollment> enrollments = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();

    private EnrollmentFileHandler enrollmentFileHandler = new EnrollmentFileHandler();
    private StudentFileHandler studentFileHandler = new StudentFileHandler();
    private CourseFileHandler courseFileHandler = new CourseFileHandler();

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
        studentFileHandler.setStudents(students);
        courseFileHandler.setCourses(courses);
        enrollmentFileHandler.setEnrollments(enrollments);
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
     * @return boolean
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

    /***
     * Get Enrollment File Handler
     * @return Enrollment File Handler
     */
    public EnrollmentFileHandler getEnrollmentFileHandler() {
        return enrollmentFileHandler;
    }

    /***
     * Get Course File Handler
     * @return Course File Handler
     */
    public CourseFileHandler getCourseFileHandler() {
        return courseFileHandler;
    }

    /***
     * Get Student File Hander
     * @return Student File Handler
     */
    public StudentFileHandler getStudentFileHandler() {
        return studentFileHandler;
    }

    /***
     * Add an Enrollment
     * @param e enrollment
     * @return boolean
     */
    @Override
    public boolean add(Enrollment e) {
        if (!isExist(e)) {
            enrollments.add(e);
            enrollmentFileHandler.setEnrollments(enrollments);
            return true;
        } else {
            return false;
        }
    }

    /***
     * Delete an erollment
     * @param e
     * @return boolean
     */
    @Override
    public boolean delete(Enrollment e) {
      for (int i = 0; i < enrollments.size(); i++) {
          if (enrollments.get(i).getStudent().getStudentID().equals(e.getStudent().getStudentID()) && enrollments.get(i).getCourse().getCourseID().equals(e.getCourse().getCourseID()) && enrollments.get(i).getSemester().equals(e.getSemester())) {
              enrollments.remove(i);
              enrollmentFileHandler.setEnrollments(enrollments);
              return true;
          }
      }
      return false;
    }

    /***
     * Get one enrollment
     * @param studentID
     * @param courseID
     * @param semester
     * @return one enrollment
     */
    @Override
    public Enrollment getOne(String studentID, String courseID, String semester) {
        for (Enrollment e : enrollments) {
            if (e.getStudent().getStudentID().equals(studentID) && e.getCourse().getCourseID().equals(courseID) && e.getSemester().equals(semester)) {
                return e;
            }
        }
        return null;
    }

    /***
     * Get all enrollments
     * @return ArrayList of Enrollments
     */
    @Override
    public ArrayList<Enrollment> getAll() {
        return enrollments;
    }

    /***
     * Get Student who studied in Course and Semester
     * @param courseID
     * @param semester
     * @return Array of Student
     */
    public ArrayList<Student> getStudentsPerCoursePerSemester(String courseID, String semester) {
        ArrayList<Student> temp = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getCourse().getCourseID().equals(courseID) && e.getSemester().equals(semester)) {
                temp.add(e.getStudent());
            }
        }
        return temp;
    }

    /***
     * Print all student in a Course and Semester
     * @param courseID
     * @param semester
     */
    public void printStudentsPerCoursePerSemester(String courseID, String semester) {
        ArrayList<Student> temp = getStudentsPerCoursePerSemester(courseID, semester);
        studentFileHandler.setStudents(temp);
        if (temp.isEmpty()) {
            System.out.println("There are no Students");
        } else {
            for (Student s : temp) {
                System.out.println(s);
            }
        }
    }

    /***
     * Get Courses Per Student per Semester
     * @param studentID
     * @param semester
     * @return
     */
    public ArrayList<Course> getCoursesPerStudentPerSemester(String studentID, String semester) {
        ArrayList<Course> temp = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getStudent().getStudentID().equals(studentID) && e.getSemester().equals(semester)) {
                temp.add(e.getCourse());
            }
        }
        return temp;
    }

    /***
     * Print Course Per Student Per Semester
     * @param studentID
     * @param semester
     */
    public void printCoursesPerStudentPerSemester(String studentID, String semester) {
        ArrayList<Course> temp = getCoursesPerStudentPerSemester(studentID, semester);
        courseFileHandler.setCourses(temp);
        if (temp.isEmpty()) {
            System.out.println("There are no Courses");
        } else {
            for (Course c : temp) {
                System.out.println(c);
            }
        }
    }

    /***
     * Get Courses in specific semester
     * @param semester
     * @return array of Course
     */
    public ArrayList<Course> getCoursesPerSemester(String semester) {
        ArrayList<Course> temp = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getSemester().equals(semester)) {
                if (temp.isEmpty() || !isExistCourse(temp,e.getCourse())) {
                    temp.add(e.getCourse());
                }
            }
        }
        return temp;
    }

    /***
     * Print all Courses in 1 Semester
     * @param semester
     */
    public void printCoursesPerSemester(String semester) {
        ArrayList<Course> temp = getCoursesPerSemester(semester);
        courseFileHandler.setCourses(temp);
        if (temp.isEmpty()) {
            System.out.println("There are no Course in this semester");
        } else {
            for (Course c : temp) {
                System.out.println(c);
            }
        }
    }

    /***
     * Check if exist a course in array
     * @param courses
     * @param course
     * @return boolean
     */
    public boolean isExistCourse(ArrayList<Course> courses, Course course) {
        for (Course c : courses) {
            if (c.getCourseID().equals(course.getCourseID())) {
                return true;
            }
        }
        return false;
    }


    /***
     * Get one Student from Students
     * @param studentID
     * @return Student
     */
    public Student getStudent(String studentID) {
      for (Student s : students) {
          if (s.getStudentID().equals(studentID)) {
              return s.clone();
          }
      }
      return null;
    }

    /***
     * Get one Courses from Courses
     * @param courseID
     * @return Course
     */
    public Course getCourse(String courseID) {
        for (Course c : courses) {
            if (c.getCourseID().equals(courseID)) {
                return c.clone();
            }
        }
        return null;
    }

    /***
     * Check if Course exist in database
     * @param courseID
     * @return boolean
     */
    public boolean courseExist(String courseID) {
        for (Course c : courses) {
            if (c.getCourseID().equals(courseID)) {
                return true;
            }
        }
        return false;
    }

    /***
     * check if student exist in database
     * @param studentID
     * @return boolean
     */
    public boolean studentExist(String studentID) {
        for (Student s : students) {
            if (s.getStudentID().equals(studentID)) {
                return true;
            }
        }
        return false;
    }
}


