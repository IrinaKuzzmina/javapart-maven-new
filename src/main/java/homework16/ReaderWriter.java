package homework16;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sun.rmi.runtime.Log;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ReaderWriter {

    public static String[] readToArray(String filename) {
        String[] data = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            data = lines.toArray(new String[]{});
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return data;
    }


    public static void writeToExcel(Subscriber[] array) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Subscibers");
        for (int i = 0; i < array.length; i++) {
            Row row = sheet.createRow(i);
            Cell cellId = row.createCell(0);
            Cell cellFirstName = row.createCell(1);
            Cell cellLastName = row.createCell(2);
            Cell cellAge = row.createCell(3);
            Cell cellPhoneNumber = row.createCell(4);
            Cell cellGender = row.createCell(5);

            cellId.setCellValue((Long) array[i].getId());
            cellFirstName.setCellValue(array[i].getFirstName());
            cellLastName.setCellValue(array[i].getLastName());
            cellAge.setCellValue((int) array[i].getAge());
            cellPhoneNumber.setCellValue(array[i].getPhoneNumber());
            cellGender.setCellValue(array[i].getGender());
        }

        try (FileOutputStream out = new FileOutputStream(new File("d:/Practice/javapart-maven/subscribers.xlsx"))) {
            workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<Long, Subscriber> readFromExcelToMap() {
        Map<Long, Subscriber> mapOfSubscribers = new HashMap<>();
        File file = new File("d:/Practice/javapart-maven/subscribers.xlsx");

        try (XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file))) {
            XSSFSheet sheet = workbook.getSheet("Subscibers");
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                XSSFRow row = sheet.getRow(i);
                Long id = ((Double) (row.getCell(0).getNumericCellValue())).longValue();
                String firstName = row.getCell(1).getStringCellValue();
                String lastName = row.getCell(2).getStringCellValue();
                int age = (int) row.getCell(3).getNumericCellValue();
                String phoneNumber = row.getCell(4).getStringCellValue();
                String gender = row.getCell(5).getStringCellValue();
                Subscriber newSubscriber = new Subscriber(id, firstName, lastName, age, phoneNumber, gender);
                mapOfSubscribers.put(id, newSubscriber);
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return mapOfSubscribers;

    }

    public static void writeToTxt(Map<Long, Subscriber> map) {
        try {
            FileWriter fw = new FileWriter("subscribers.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 1; i < map.size(); i++) {
                Long index = Long.valueOf(i);
                Subscriber subscriber = map.get(index );
                pw.println(subscriber.getId() + " " + subscriber.getFirstName() + " " + subscriber.getLastName() + " "
                        + subscriber.getAge() + " " + subscriber.getPhoneNumber() + " " + subscriber.getGender());
            }
            pw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
