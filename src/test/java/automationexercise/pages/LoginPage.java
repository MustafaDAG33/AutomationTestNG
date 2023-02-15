package automationexercise.pages;

import automationexercise.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }




    @FindBy(xpath = "//h2[.='New User Signup!']")
    public WebElement newUserSignupText;

    @FindBy(xpath = "//h2[.='Login to your account']")
    public WebElement loginToYourAccountText;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement newUserName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement newUserEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement newUserButton;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement loginEmail;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElement loginPassword;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[.='Your email or password is incorrect!']")
    public WebElement yourEmailOrPasswordIsIncorrectText;

    @FindBy(xpath = "//*[.='Email Address already exist!']")
    public WebElement emailAddressAlreadyExistText;





}
