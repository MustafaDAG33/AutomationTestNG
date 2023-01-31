package automationexercise.tests.exceltests;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

public class ExcelLoginTest01 {

    @Test
    public void excelLoginTest() throws IOException {

        String path = "./src/test/java/resources/AutomationTest.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet =   workbook.getSheet("Sayfa1");
        sheet.getRow(1).getCell(0);
        sheet.getRow(1).getCell(1);
        sheet.getRow(2).getCell(0);
        sheet.getRow(2).getCell(1);
        sheet.getRow(3).getCell(0);
        sheet.getRow(3).getCell(1);






    }



}
