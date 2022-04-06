package helper;

import model.*;
import enrollmentmanagement.*;

import java.util.Scanner;

public class Menu {
    private StudentEnrollment studentEnrollment = new StudentEnrollment();
    private static Scanner sc = new Scanner(System.in);

    public Menu() {}

    /***
     * display User Interface for user
     */
    public void displayMainMenu() {
        boolean isRunning = true;

        studentEnrollment.populateData("default.csv");
        System.out.println("Welcome to our App");
        do {
            System.out.println("********************");
            displayOption();
            String opt = sc.nextLine();
            switch (opt) {
                case "0" -> {
                    System.out.println("********************");
                    System.out.println("Quitting program");
                    isRunning = false;
                }
                case "1" -> {
                    System.out.println("********************");
                    addEnrollment();
                    pressToContinue();
                }
                case "2" -> {
                    System.out.println("********************");
                    deleteEnrollment();
                    pressToContinue();
                }
                case "3" -> {
                    System.out.println("********************");
                    getOneEnrollment();
                    pressToContinue();
                }
                case "4" -> {
                    System.out.println("********************");
                    for (Enrollment e : studentEnrollment.getAll()) {
                        System.out.println(e);
                    }
                    pressToContinue();
                }
                case "5" -> {
                    System.out.println("********************");
                    printCoursesPerStudentPerSemester();
                    pressToContinue();
                }
                case "6" -> {
                    System.out.println("********************");
                    printStudentsPerCoursePerSemester();
                    pressToContinue();
                }
                case "7" -> {
                    System.out.println("********************");
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
        } else {
            System.err.println("Enrollment not added");
        }

    }

    /***
     * UI for delete enrollment
     */
    private void deleteEnrollment() {
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
            System.err.println("No enrollment exist or not deleted");
        }
    }

    /***
     * Get one enrollment UI
     */
    private void getOneEnrollment() {
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
                isRunning = false;
            } else if (opt.equals("n")) {
                System.out.println("Proceeding");
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
                isRunning = false;
            } else if (opt.equals("n")) {
                System.out.println("Proceeding");
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
                isRunning = false;
            } else if (opt.equals("n")) {
                System.out.println("Proceeding");
                isRunning = false;
            } else {
                System.out.println("********************");
                System.out.println("Invalid option");
                System.out.println("********************");
            }
        } while (isRunning);
    }

    private void pressToContinue() {
        System.out.println("********************");
        System.out.println("Press anything to continue: ");
        String temp = sc.nextLine();
    }

}
