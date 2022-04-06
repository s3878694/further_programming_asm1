package helper;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class ReadCSV {
    /***
     * Read a csv and return all data in form of arraylist
     * @param fileName String a file name
     * @return ArrayList of Strings
     */
    public static ArrayList<String> readCSVFile(String fileName)  {
        ArrayList<String> rows = new ArrayList<>();

        try {
            FileReader fReader = new FileReader(fileName);
            BufferedReader bReader = new BufferedReader(fReader);
            String line = bReader.readLine();
            while (line != null) {
                rows.add(line);
                line = bReader.readLine();
            }
            System.out.println();
            fReader.close();
            bReader.close();
        } catch (IOException e) {
            System.out.println("An error occur");
        }
        return rows;
    }
}
