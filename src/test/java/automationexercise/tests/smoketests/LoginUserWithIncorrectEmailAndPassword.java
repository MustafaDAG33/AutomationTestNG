package automationexercise.tests.smoketests;

import automationexercise.pages.*;
import automationexercise.utilities.ConfigReader;
import automationexercise.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUserWithIncorrectEmailAndPassword {

    LoginPage loginPage;
    HomePage homePage;
    SignupPage signupPage;
    AccountCreatedPage accountCreatedPage;
    DeleteAccountPage deleteAccountPage;

    @Test
    public void loginUserWithIncorrectEmailAndPasswordTest() {

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

        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(loginPage.loginToYourAccountText.isDisplayed());

        //6. Enter incorrect email address and password
        loginPage.loginEmail.sendKeys("betus@gmail.com");
        loginPage.loginPassword.sendKeys("129687");

        //7. Click 'login' button
        loginPage.loginButton.click();

        //8. Verify error 'Your email or password is incorrect!' is visible
        Assert.assertTrue(loginPage.yourEmailOrPasswordIsIncorrectText.isDisplayed());

        Driver.closeDriver();
    }

}
