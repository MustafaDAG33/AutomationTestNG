package automationexercise.tests.smoketests;

import automationexercise.pages.HomePage;
import automationexercise.utilities.ConfigReader;
import automationexercise.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductsinCart {


    @Test
    public void addProductsInCart() {
        HomePage homePage = new HomePage();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automation_url"));
        //3. Verify that home page is visible successfully
        Assert.assertTrue(homePage.homePageVisible.isDisplayed());
        //4. Click 'Products' button
        homePage.productsButton.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveByOffset(0,0).click().perform();

        //5. Hover over first product and click 'Add to cart'
        Driver.getDriver().findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click();
        //6. Click 'Continue Shopping' button
        //7. Hover over second product and click 'Add to cart'
        //8. Click 'View Cart' button
        //9. Verify both products are added to Cart
        //10. Verify their prices, quantity and total price

    }




}
