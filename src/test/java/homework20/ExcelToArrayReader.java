package homework20;

import homework16.PropertyReader;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelToArrayReader {
    public String[][] readToArray(int start, int end) {
        String[][] data = new String[end][3];
        int count=0;
        File file = new File(PropertyReader.readProperty("login.data"));
        try (XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file))) {
            XSSFSheet sheet = workbook.getSheet("DataForLogin");
            for (int i = start; i <= end; i++) {
                XSSFRow row = sheet.getRow(i);
                String login = row.getCell(1).getStringCellValue();
                String password = row.getCell(2).getStringCellValue();
                String message = row.getCell(3).getStringCellValue();
                data[count][0] = login;
                data[count][1] = password;
                data[count][2] = message;
                count ++;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return data;
    }


}
