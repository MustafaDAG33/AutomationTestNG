package automationexercise.tests.smoketests;

import automationexercise.pages.HomePage;
import automationexercise.utilities.ConfigReader;
import automationexercise.utilities.Driver;
import automationexercise.utilities.ReusableMethods;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTestCasesPage {


    @Test
    public void test01() throws InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        HomePage homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("automation_url"));

        //3. Verify that home page is visible successfully
        Assert.assertTrue(homePage.homePageVisible.isDisplayed());

        //4. Click on 'Test Cases' button
        homePage.testCasesButton.click();

        Actions actions = new Actions(Driver.getDriver());
        actions.moveByOffset(0,0).click().perform();
        ReusableMethods.waitFor(2);

        //5. Verify user is navigated to test cases page successfully
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("test_cases"));
    }
}
