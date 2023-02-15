package automationexercise.tests.smoketests;

import automationexercise.pages.*;
import automationexercise.utilities.ConfigReader;
import automationexercise.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ContactUsForm {


    HomePage homePage;




    @Test
    public void contactUsForm() throws InterruptedException {

        homePage = new HomePage();

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automation_url"));

        //3. Verify that home page is visible successfully
        Assert.assertTrue(homePage.homePageVisible.isDisplayed());

        //4. Click on 'Contact Us' button
        homePage.contactUsButton.click();

        //5. Verify 'GET IN TOUCH' is visible
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//h2[.='Get In Touch']")).isDisplayed());

        String path = "C:\\Users\\LENOVA\\OneDrive\\Masaüstü\\Blue and White Abstract Technology LinkedIn Banner.png";
        //6. Enter name, email, subject and message
        Driver.getDriver().findElement(By.xpath("//input[@name='name']")).sendKeys("Orhan", Keys.TAB,"orhan@gmail.com",
                Keys.TAB,"Sikayet",Keys.TAB,"Thanks");
        Driver.getDriver().findElement(By.xpath("//*[@name='upload_file']")).sendKeys(path);
        //7. Upload file
        //8. Click 'Submit' button
        //9. Click OK button
        Driver.getDriver().findElement(By.xpath("//input[@name='submit']")).click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Driver.getDriver().switchTo().alert().accept();//sayfa maximaze iken aler hatasi cikiyor!!


        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div[@class='status alert alert-success']")).isDisplayed());

        //11. Click 'Home' button and verify that landed to home page successfully
        Driver.getDriver().findElement(By.partialLinkText("Home")).click();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveByOffset(0,0).click().perform();
        Assert.assertTrue(homePage.homePageVisible.isDisplayed());

    }



}
