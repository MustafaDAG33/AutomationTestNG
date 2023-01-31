package automationexercise.tests.smoketests;

import automationexercise.pages.*;
import automationexercise.tests.exceltests.utilities.ConfigReader;
import automationexercise.tests.exceltests.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutUser {

    LoginPage loginPage;
    HomePage homePage;
    SignupPage signupPage;
    AccountCreatedPage accountCreatedPage;
    DeleteAccountPage deleteAccountPage;

    @Test
    public void logoutUserTest() {

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

        //6. Enter correct email address and password
        loginPage.loginEmail.sendKeys(ConfigReader.getProperty("user_email"));
        loginPage.loginPassword.sendKeys(ConfigReader.getProperty("password"));

        //7. Click 'login' button
        loginPage.loginButton.click();

        //8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(homePage.loggedInAsButton.isDisplayed());

        //9. Click 'Logout' button
        homePage.logoutButton.click();

        //10. Verify that user is navigated to login page
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));

    }


}
