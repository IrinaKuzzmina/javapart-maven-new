package homework16;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertyReader {
    public static String readProperty(String key) {
        Properties prop = new Properties();
        InputStream is = PropertyReader.class.getClassLoader().getResourceAsStream("java-part.properties");
        try(InputStreamReader isr = new InputStreamReader(is, "UTF-8")) {
            prop.load(isr);
            return prop.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
