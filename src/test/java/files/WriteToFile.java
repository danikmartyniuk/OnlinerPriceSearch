package files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WriteToFile {
    public static void main(String[] args) {

        File myFile = new File("text.txt");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(myFile, true));
            writer.write(formatter.format(today) + "\n");
            writer.write("lol");
            writer.close();
        } catch (IOException | NullPointerException ex) {
            ex.printStackTrace();
        }

    }
}
