package Helper;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class ReadCSV {
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
