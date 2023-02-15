package automationexercise.pages;

import automationexercise.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    public ProductsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[.='View Product'])[1]")
    public WebElement firstProduct;

    @FindBy(id = "search_product")
    public WebElement searchProduct;

    @FindBy(id = "submit_search")
    public WebElement submitSearch;
}
