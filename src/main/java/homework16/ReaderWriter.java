package homework16;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReaderWriter {

    public String[] readToArray(String filename) {
        String[] arrayOfNames = new String[500];
        try {
            Scanner scanner = new Scanner(new FileReader((filename)));
            int i = 0;
            while (scanner.hasNext()) {
                //scanner.nextLine() = arrayOfNames[i];
                i++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return arrayOfNames;
    }
}
