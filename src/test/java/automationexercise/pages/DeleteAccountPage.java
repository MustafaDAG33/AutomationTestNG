package automationexercise.pages;

import automationexercise.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccountPage {

    public DeleteAccountPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement accountDeletedText;

    @FindBy(xpath = "//div[@class='pull-right']")
    public WebElement deleteContinue;
}
