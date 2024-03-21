package test;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;

public class SearchTest extends BaseTest {

    @Test
    public void testSearchArtwork() {
        WebDriver driver = this.driver;
        try {
            Allure.feature("Running test 2.4");
            Allure.story("Searching for artworks containing the word \"Giraffe\" in the title");

            SearchPage searchPage = new SearchPage(driver);

            Allure.step("Opening the main page of artnow.ru");
            searchPage.open();

            Allure.step("Entering the word \"Giraffe\" into the search input");
            searchPage.searchInput().clear();
            searchPage.searchInput().sendKeys("Giraffe");

            Allure.step("Clicking the search button and navigating to the new page");
            searchPage.searchButton().click();

            String artworkName = searchPage.firstArtworkName().getText().toLowerCase();
            Assert.assertTrue(artworkName.contains("жираф"));
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
