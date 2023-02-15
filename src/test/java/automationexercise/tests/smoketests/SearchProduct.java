package automationexercise.tests.smoketests;

import automationexercise.pages.HomePage;
import automationexercise.pages.ProductsPage;
import automationexercise.utilities.ConfigReader;
import automationexercise.utilities.Driver;
import automationexercise.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProduct {

    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automation_url"));
        HomePage homePage = new HomePage();
        ProductsPage productsPage = new ProductsPage();
        //3. Verify that home page is visible successfully
        Assert.assertTrue(homePage.homePageVisible.isDisplayed());
        //4. Click on 'Products' button
        homePage.productsButton.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveByOffset(0,0).click().perform();
        ReusableMethods.waitFor(2);
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("products"));
        //6. Enter product name in search input and click search button
        productsPage.searchProduct.sendKeys("Tshirt");
        productsPage.submitSearch.click();

        //7. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed());

        //8. Verify all the products related to search are visible

    }
}
