package automationexercise.pages;

import automationexercise.tests.exceltests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//section[@id='slider']")
    public WebElement homePageVisible;

    @FindBy(xpath = "//i[@class='fa fa-lock']")
    public WebElement signupLoginButton;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[last()]")
    public WebElement loggedInAsButton;

    @FindBy(partialLinkText = "Delete Account")
    public WebElement deleteAccountButton;

    @FindBy(xpath = "//i[@class='fa fa-lock']")
    public WebElement logoutButton;

}
