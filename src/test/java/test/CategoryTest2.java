package test;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import pages.CategoryPage;

public class CategoryTest2 extends BaseTest {

    @Test
    public void testCheckArtworkWithCategory() {
        WebDriver driver = this.driver;
        try {
            Allure.feature("Running test 2.2");
            Allure.story("Checking the style of the artwork 'Tramway Path'");

            CategoryPage categoryPage = new CategoryPage(driver);

            Allure.step("Opening the main page of artnow.ru");
            categoryPage.open();

            Allure.step("Expanding the navigation menu and navigating to the 'Embroidered Paintings' category");
            categoryPage.showMoreButton().click();
            categoryPage.categoryItemButton().click();

            Allure.step("Searching by genre 'Cityscape'");
            categoryPage.filterButton().click();
            categoryPage.submitFilterButton().click();

            Allure.step("Opening the artwork's page");
            categoryPage.findArtworkName().click();

            Assert.assertEquals(categoryPage.checkArtworkStyle().getText(), "ахрышчь");
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
