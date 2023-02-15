package automationexercise.tests.smoketests;

import automationexercise.pages.HomePage;
import automationexercise.utilities.ConfigReader;
import automationexercise.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifySubscriptionInHomePage {


    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automation_url"));
        HomePage homePage = new HomePage();
        //3. Verify that home page is visible successfully
        Assert.assertTrue(homePage.homePageVisible.isDisplayed());

        //4. Scroll down to footer
        WebElement subscription = Driver.getDriver().findElement(By.xpath("//h2[.='Subscription']"));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",subscription);
        //5. Verify text 'SUBSCRIPTION'
        Assert.assertTrue(subscription.isDisplayed());
        //6. Enter email address in input and click arrow button
        Driver.getDriver().findElement(By.id("susbscribe_email")).sendKeys("fatmabetul@gmail.com", Keys.ENTER);
        //7. Verify success message 'You have been successfully subscribed!' is visible
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[.='You have been successfully subscribed!']")).isDisplayed());

    }
}
