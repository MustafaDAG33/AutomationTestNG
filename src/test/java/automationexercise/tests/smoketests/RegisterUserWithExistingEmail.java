package automationexercise.tests.smoketests;

import automationexercise.pages.*;
import automationexercise.utilities.ConfigReader;
import automationexercise.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterUserWithExistingEmail {

    LoginPage loginPage;
    HomePage homePage;
    SignupPage signupPage;
    AccountCreatedPage accountCreatedPage;
    DeleteAccountPage deleteAccountPage;

    @Test
    public void RegisterUserWithExistingEmailTest() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        signupPage = new SignupPage();
        accountCreatedPage = new AccountCreatedPage();
        deleteAccountPage = new DeleteAccountPage();

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automation_url"));

        //3. Verify that home page is visible successfully
        Assert.assertTrue(homePage.homePageVisible.isDisplayed());
        //4. Click on 'Signup / Login' button
        homePage.signupLoginButton.click();
        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(loginPage.newUserSignupText.isDisplayed());
        //6. Enter name and already registered email address
        loginPage.newUserName.sendKeys("Hilal");
        loginPage.newUserEmail.sendKeys(ConfigReader.getProperty("user_email"));
        //7. Click 'Signup' button
        loginPage.newUserButton.click();

        //8. Verify error 'Email Address already exist!' is visible
        Assert.assertTrue(loginPage.emailAddressAlreadyExistText.isDisplayed());


    }
}
