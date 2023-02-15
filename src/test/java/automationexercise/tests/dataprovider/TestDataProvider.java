package automationexercise.tests.dataprovider;

import automationexercise.pages.HomePage;
import automationexercise.pages.LoginPage;
import automationexercise.utilities.ConfigReader;
import automationexercise.utilities.Driver;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class TestDataProvider {

    @DataProvider
    public Object[][] test01() throws IOException {

        String path = "./src/test/java/resources/AutomationTest.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet =   workbook.getSheet("Sayfa1");

        String[][] str = {
                {sheet.getRow(1).getCell(0).toString(), sheet.getRow(1).getCell(1).toString()},
                {sheet.getRow(2).getCell(0).toString(), sheet.getRow(2).getCell(1).toString()},
                {sheet.getRow(3).getCell(0).toString(), sheet.getRow(3).getCell(1).toString()}

        };
        return str;
    }

    @Test(dataProvider = "test01")
    public void testSearch(String name,String password) {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("automation_url"));
        homePage.signupLoginButton.click();
        loginPage.newUserName.sendKeys(name);
        loginPage.newUserEmail.sendKeys(password);
        loginPage.newUserButton.click();

    }
}
