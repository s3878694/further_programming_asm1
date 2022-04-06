package Helper;

import model.*;
import EnrollmentManagement.*;

import java.util.Scanner;

public class Menu {
    private StudentEnrollment studentEnrollment = new StudentEnrollment();

    public Menu() {}

    /***
     * display User Interface for user
     */
    public void displayMainMenu() {
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;

        studentEnrollment.populateData("default.csv");
        System.out.println("Welcome to our App");
        do {
            System.out.println("********************");
            displayOption();
            String opt = sc.nextLine();
            switch (opt) {
                case "0" -> {
                    System.out.println("Quitting program");
                    isRunning = false;
                }
                case "1" -> {
                    addEnrollment();
                    pressToContinue();
                }
                case "2" -> {
                    deleteEnrollment();
                    pressToContinue();
                }
                case "3" -> {
                    getOneEnrollment();
                    pressToContinue();
                }
                case "4" -> {
                    for (Enrollment e : studentEnrollment.getAll()) {
                        System.out.println(e);
                    }
                    pressToContinue();
                }
                case "5" -> {
                    printCoursesPerStudentPerSemester();
                    pressToContinue();
                }
                case "6" -> {
                    printStudentsPerCoursePerSemester();
                    pressToContinue();
                }
                case "7" -> {
                    printCoursesPerSemester();
                    pressToContinue();
                }
                default -> System.out.println("Invalid input!");
            }

        } while (isRunning);
    }

    /***
     * display option for user
     */
    private void displayOption() {
        System.out.println("0.Quit program\n1.Add an enrollment\n2.Delete an enrollment\n3.Get one enrollment\n4.Get all enrollments\n5.Print all courses for 1 student in 1 semester\n6.Print all students of 1 course in 1 semester\n7.Prints all courses offered in 1 semester\n");
        System.out.println("Choose your option: ");
    }

    /***
     * UI for add enrollment
     */
    private void addEnrollment() {
        Scanner sc = new Scanner(System.in);
        String studentID;
        String courseID;
        while (true) {
            System.out.println("Enter the student id: ");
            studentID = sc.nextLine();
            if (studentEnrollment.studentExist(studentID)) {
                break;
            } else {
                System.out.println("********************");
                System.out.println("Invalid id");
                System.out.println("********************");
            }
        }
        while (true) {
            System.out.println("Enter the course id: ");
            courseID = sc.nextLine();
            if (studentEnrollment.courseExist(courseID)) {
                break;
            } else {
                System.out.println("********************");
                System.out.println("Invalid id");
                System.out.println("********************");
            }
        }
        System.out.println("Enter semester: ");
        String semester = sc.nextLine();
        Enrollment e = new Enrollment(studentEnrollment.getStudent(studentID), studentEnrollment.getCourse(courseID), semester);
        if (studentEnrollment.add(e)) {
            System.out.println("Successfully added");
            System.out.println("********************");
        } else {
            System.out.println("Enrollment not added");
            System.out.println("********************");
        }

    }

    /***
     * UI for delete enrollment
     */
    private void deleteEnrollment() {
        Scanner sc = new Scanner(System.in);
        String studentID;
        String courseID ;
        while (true) {
            System.out.println("Enter the student id: ");
            studentID = sc.nextLine();
            if (studentEnrollment.studentExist(studentID)) {
                break;
            } else {
                System.out.println("********************");
                System.out.println("Invalid id");
                System.out.println("********************");
            }
        }
        while (true) {
            System.out.println("Enter the course id: ");
            courseID = sc.nextLine();
            if (studentEnrollment.courseExist(courseID)) {
                break;
            } else {
                System.out.println("********************");
                System.out.println("Invalid id");
                System.out.println("********************");
            }
        }
        System.out.println("Enter semester: ");
        String semester = sc.nextLine();
        Enrollment e = new Enrollment(studentEnrollment.getStudent(studentID), studentEnrollment.getCourse(courseID), semester);
        if (studentEnrollment.delete(e)) {
            System.out.println("Successfully deleted");
        } else {
            System.out.println("No enrollment exist or not deleted");
        }
    }

    /***
     * Get one enrollment UI
     */
    private void getOneEnrollment() {
        Scanner sc = new Scanner(System.in);
        String studentID;
        String courseID;
        while (true) {
            System.out.println("Enter the student id: ");
            studentID = sc.nextLine();
            if (studentEnrollment.studentExist(studentID)) {
                break;
            } else {
                System.out.println("********************");
                System.out.println("Invalid id");
                System.out.println("********************");
            }
        }
        while (true) {
            System.out.println("Enter the course id: ");
            courseID = sc.nextLine();
            if (studentEnrollment.courseExist(courseID)) {
                break;
            } else {
                System.out.println("********************");
                System.out.println("Invalid id\n");
                System.out.println("********************");
            }
        }
        System.out.println("Enter semester: ");
        String semester = sc.nextLine();
        System.out.println(studentEnrollment.getOne(studentID, courseID, semester));
    }

    /***
     * Print course UI per student per semester
     */
    private void printCoursesPerStudentPerSemester() {
        Scanner sc = new Scanner(System.in);
        String studentID;
        while (true) {
            System.out.println("Enter the student id: ");
            studentID = sc.nextLine();
            if (studentEnrollment.studentExist(studentID)) {
                break;
            } else {
                System.out.println("Invalid id");
            }
        }
        System.out.println("Enter semester: ");
        String semester = sc.nextLine();
        studentEnrollment.printCoursesPerStudentPerSemester(studentID, semester);

        String opt;
        boolean isRunning = true;
        do {
            System.out.println("Do you want to save this to csv? (y/n)");
            opt = sc.nextLine();
            if (opt.equals("y")) {
                studentEnrollment.getCourseFileHandler().dumpToFile();
                System.out.println("********************");
                isRunning = false;
            } else if (opt.equals("n")) {
                System.out.println("Proceeding");
                System.out.println("********************");
                isRunning = false;
            } else {
                System.out.println("********************");
                System.out.println("Invalid option");
                System.out.println("********************");
            }
        } while (isRunning);
    }

    /***
     * Print student UI per course per semester
     */
    private void printStudentsPerCoursePerSemester() {
        Scanner sc = new Scanner(System.in);
        String courseID;
        while (true) {
            System.out.println("Enter the course id: ");
            courseID = sc.nextLine();
            if (studentEnrollment.courseExist(courseID)) {
                break;
            } else {
                System.out.println("********************");
                System.out.println("Invalid id");
                System.out.println("********************");
            }
        }
        System.out.println("Enter semester: ");
        String semester = sc.nextLine();
        studentEnrollment.printStudentsPerCoursePerSemester(courseID, semester);

        String opt;
        boolean isRunning = true;
        do {
            System.out.println("Do you want to save this to csv? (y/n)");
            opt = sc.nextLine();
            if (opt.equals("y")) {
                studentEnrollment.getStudentFileHandler().dumpToFile();
                System.out.println("********************");
                isRunning = false;
            } else if (opt.equals("n")) {
                System.out.println("Proceeding");
                System.out.println("********************");
                isRunning = false;
            } else {
                System.out.println("********************");
                System.out.println("Invalid option");
                System.out.println("********************");
            }
        } while (isRunning);
    }

    /***
     * Print course UI per semester
     */
    private void printCoursesPerSemester() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter semester: ");
        String semester = sc.nextLine();
        studentEnrollment.printCoursesPerSemester(semester);

        String opt;
        boolean isRunning = true;
        do {
            System.out.println("Do you want to save this to csv? (y/n)");
            opt = sc.nextLine();
            if (opt.equals("y")) {
                studentEnrollment.getCourseFileHandler().dumpToFile();
                System.out.println("********************");
                isRunning = false;
            } else if (opt.equals("n")) {
                System.out.println("Proceeding");
                System.out.println("********************");
                isRunning = false;
            } else {
                System.out.println("********************");
                System.out.println("Invalid option");
                System.out.println("********************");
            }
        } while (isRunning);
    }

    private void pressToContinue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("********************");
        System.out.println("Press anything to continue: ");
        String temp = sc.nextLine();
    }

}
