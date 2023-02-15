package automationexercise.tests.smoketests;

import automationexercise.pages.HomePage;
import automationexercise.pages.ProductsPage;
import automationexercise.utilities.ConfigReader;
import automationexercise.utilities.Driver;
import automationexercise.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyAllProductsAndProductDetailPage {

    HomePage homePage = new HomePage();
    ProductsPage productsPage = new ProductsPage();

    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automation_url"));

        //3. Verify that home page is visible successfully
        Assert.assertTrue(homePage.homePageVisible.isDisplayed());

        //4. Click on 'Products' button
        homePage.productsButton.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveByOffset(0,0).click().perform();
        ReusableMethods.waitFor(2);
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("products"));

        //6. The products list is visible
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div[@class='features_items']")).isDisplayed());
        //7. Click on 'View Product' of first product
        productsPage.firstProduct.click();
        ReusableMethods.waitFor(2);

        //8. User is landed to product detail page
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("product_details"));

        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        WebElement productDetails = Driver.getDriver().findElement(By.xpath("//div[@class='product-information']"));
        Assert.assertTrue(productDetails.getText().contains("Availability"));


    }
}
