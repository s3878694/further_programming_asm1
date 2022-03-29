import Helper.ReadCSV;
import FileHandler.StudentFileHandler;
import model.*;

public class Main {
    public static void main(String[] args) {
        for (String s: ReadCSV.readCSVFile("default.s")) {
            System.out.println(s);
        }

        StudentFileHandler handler = new StudentFileHandler();
        handler.populateStudent("default.csv");
        for (Student student : handler.getStudents()) {
            System.out.println(student);
        }
    }
}
