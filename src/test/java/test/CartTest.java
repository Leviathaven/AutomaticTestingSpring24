package test;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import pages.CartPage;

public class CartTest extends BaseTest {

    @Test
    public void testCartArtwork() {
        WebDriver driver = this.driver;
        try {
            Allure.feature("Running test 2.5");
            Allure.story("Checking if item is added to the cart");

            CartPage cartPage = new CartPage(driver);

            Allure.step("Opening the main page of artnow.ru");
            cartPage.open();

            Allure.step("Opening category \"Jewelry art\"");
            cartPage.showMoreButton().click();
            cartPage.categoryItemButton().click();

            Allure.step("Adding the first item to cart, saving its' price and name");
            String artworkName = cartPage.firstArtworkName().getText().trim();
            String artworkPrice = cartPage.firstArtworkPrice().getText();
            cartPage.addToCartButton().click();

            Allure.step("Opening the cart page");
            cartPage.goToCartButton().click();
            String cartArtworkName = cartPage.cartArtworkName().getText().trim();
            String cartArtworkPrice = cartPage.cartArtworkPrice().getText();

            Assert.assertTrue(artworkName.contains(cartArtworkName));
            Assert.assertEquals(artworkPrice, cartArtworkPrice);
        } catch (AssertionError e) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Screenshot", "image/png", String.valueOf(screenshot));
            throw e;
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
