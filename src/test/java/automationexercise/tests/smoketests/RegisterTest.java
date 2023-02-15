package automationexercise.tests.smoketests;

import automationexercise.pages.*;
import automationexercise.utilities.ConfigReader;
import automationexercise.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterTest {

    //1. Tarayıcıyı başlatın
    //2. 'http://automationexercise.com' URL'sine gidin
    //3. Ana sayfanın başarıyla göründüğünü doğrulayın
    //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
    //5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
    //6. Adı ve e-posta adresini girin
    //7. 'Kaydol' düğmesini tıklayın
    //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın
    //9. Ayrıntıları doldurun: Unvan, Ad, E-posta, Parola, Doğum tarihi
    //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
    //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
    //12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
    //13. 'Hesap Oluştur düğmesini' tıklayın
    //14. 'HESAP OLUŞTURULDU!' görünür
    //15. 'Devam Et' düğmesini tıklayın
    //16. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
    //17. 'Hesabı Sil' düğmesini tıklayın
    //18. 'HESAP SİLİNDİ!' görünür ve 'Devam Et' düğmesini tıklayın
    LoginPage loginPage;
    HomePage homePage;
    SignupPage signupPage;
    AccountCreatedPage accountCreatedPage;

    DeleteAccountPage deleteAccountPage;

    @Test
    public void testRegister() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("automation_url"));

        loginPage = new LoginPage();
        homePage = new HomePage();
        signupPage = new SignupPage();
        accountCreatedPage = new AccountCreatedPage();
        deleteAccountPage = new DeleteAccountPage();

        Assert.assertTrue(homePage.homePageVisible.isDisplayed());
        homePage.signupLoginButton.click();

        Assert.assertTrue(loginPage.newUserSignupText.isDisplayed());
        loginPage.newUserName.sendKeys(ConfigReader.getProperty("user_name"));
        loginPage.newUserEmail.sendKeys(ConfigReader.getProperty("user_email"));
        loginPage.newUserButton.click();

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//b[.='Enter Account Information']")).isDisplayed());
        signupPage.gender.click();
        signupPage.password.sendKeys(ConfigReader.getProperty("password"));
        signupPage.day.sendKeys(ConfigReader.getProperty("day"));
        signupPage.month.sendKeys(ConfigReader.getProperty("month"));
        signupPage.year.sendKeys(ConfigReader.getProperty("year"));
        signupPage.newsletter.click();
        signupPage.optin.click();
        signupPage.firstName.sendKeys(ConfigReader.getProperty("first_name"));
        signupPage.lastName.sendKeys(ConfigReader.getProperty("last_name"));
        signupPage.adres1.sendKeys(ConfigReader.getProperty("adres"));
        signupPage.state.sendKeys(ConfigReader.getProperty("state"));
        signupPage.city.sendKeys(ConfigReader.getProperty("city"));
        signupPage.zipcode.sendKeys(ConfigReader.getProperty("zipcode"));
        signupPage.mobileNumber.sendKeys(ConfigReader.getProperty("mobile_number"));
        signupPage.createAccount.click();

        Actions actions = new Actions(Driver.getDriver());
        actions.moveByOffset(0,0).click().perform();

        Assert.assertTrue(accountCreatedPage.accountCreatedText.isDisplayed());
        accountCreatedPage.continueButton.click();

        actions.moveByOffset(0,0).click().perform();
        Assert.assertTrue(homePage.loggedInAsButton.isDisplayed());

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(homePage.deleteAccountButton));

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();",homePage.deleteAccountButton);

        Assert.assertTrue(deleteAccountPage.accountDeletedText.isDisplayed());
        deleteAccountPage.deleteContinue.click();

        Driver.closeDriver();









    }
}
