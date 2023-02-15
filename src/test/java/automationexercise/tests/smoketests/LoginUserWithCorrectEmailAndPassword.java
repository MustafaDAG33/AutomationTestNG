package automationexercise.tests.smoketests;

import automationexercise.pages.*;
import automationexercise.utilities.ConfigReader;
import automationexercise.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUserWithCorrectEmailAndPassword {

    LoginPage loginPage;
    HomePage homePage;
    SignupPage signupPage;
    AccountCreatedPage accountCreatedPage;
    DeleteAccountPage deleteAccountPage;

    @Test
    public void loginUserWithCorrectEmailAndPasswordTest() {

        loginPage = new LoginPage();
        homePage = new HomePage();
        signupPage = new SignupPage();
        accountCreatedPage = new AccountCreatedPage();
        deleteAccountPage = new DeleteAccountPage();
        //. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' URL'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("automation_url"));

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        Assert.assertTrue(homePage.homePageVisible.isDisplayed());

        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        homePage.signupLoginButton.click();

        //5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
        Assert.assertTrue(loginPage.loginToYourAccountText.isDisplayed());

        //6. Doğru e-posta adresini ve şifreyi girin
        loginPage.loginEmail.sendKeys(ConfigReader.getProperty("user_email"));
        loginPage.loginPassword.sendKeys(ConfigReader.getProperty("password"));

        //7. 'Giriş' düğmesine tıklayın
        loginPage.loginButton.click();

        //8. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(homePage.loggedInAsButton.isDisplayed());

        //9. 'Hesabı Sil' düğmesini tıklayın
        homePage.deleteAccountButton.click();

        //10. 'HESAP SİLİNDİ!' görünür
        Assert.assertTrue(deleteAccountPage.accountDeletedText.isDisplayed());

        Driver.closeDriver();


    }
}
