package automationexercise.pages;

import automationexercise.tests.exceltests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

    public SignupPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//input[@id='id_gender2']")
    public WebElement gender;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "days")
    public WebElement day;

    @FindBy(id = "months")
    public WebElement month;

    @FindBy(id = "years")
    public WebElement year;

    @FindBy(id = "newsletter")
    public WebElement newsletter;

    @FindBy(id = "optin")
    public WebElement optin;

    @FindBy(id = "first_name")
    public WebElement firstName;

    @FindBy(id = "last_name")
    public WebElement lastName;

    @FindBy(id = "address1")
    public WebElement adres1;

    @FindBy(id = "country")
    public WebElement country;

    @FindBy(xpath = "//input[@id='state']")
    public WebElement state;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement city;

    @FindBy(id = "zipcode")
    public WebElement zipcode;

    @FindBy(id = "mobile_number")
    public WebElement mobileNumber;

    @FindBy(xpath = "//button[.='Create Account']")
    public WebElement createAccount;





}
