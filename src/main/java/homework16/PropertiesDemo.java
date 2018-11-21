package homework16;


import java.io.*;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) {

        //1)  Создать файл 'java-part.properties'
        File file = new File( "java-part.properties");
        try {
             file.createNewFile();
        } catch(IOException ex) {
            ex.printStackTrace();
        }

         //Добавить в файл свойства:
        Properties properties = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream("java-part.properties");

        // set the properties value
        properties.setProperty("subscriber.exc", "d:/myprojects/java-part/data/subscriber.xlsx");
        properties.setProperty("subscriber.txt", "d:/myprojects/java-part/data/subscriber.txt");
        properties.setProperty("subscriber.sort.txt", "d:/myprojects/java-part/data/subscriber-sort.txt");
        properties.setProperty("subscriber.arc", "d:/myprojects/java-part/data/subscriber.zip");
        properties.setProperty("male.firstnames", "d:/myprojects/java-part/data/мужские имена.txt");
        properties.setProperty("female.firstnames", "d:/myprojects/java-part/data/женские имена.txt");
        properties.setProperty("female.lastnames", "d:/myprojects/java-part/data/женские фамилии.txt");
        properties.setProperty("age.from", "5");
        properties.setProperty("age.to", "90");
        properties.setProperty("age.gaussian", "true");

        // save properties to project root folder
        properties.store(output, null);

        }catch (FileNotFoundException e){
            System.out.println("File was not found");
        } catch (IOException io) {
            System.out.println("General exception has occurred");
            io.printStackTrace();
        }finally {
            if (output != null){
                try {
                    output.close();
                }catch (IOException e){
                    System.out.println("General exception has occurred");
                    e.printStackTrace();
                }
            }
        }
    }
}
