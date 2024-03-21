package test;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import pages.FavoritesPage;

public class FavoriteTest extends BaseTest {

    @Test
    public void testCheckFavoriteArtwork() {
        WebDriver driver = this.driver;
        try {
            Allure.feature("Running test 2.3");
            Allure.story("Checking the saving of the artwork to favorites");

            FavoritesPage favoritePage = new FavoritesPage(driver);

            Allure.step("Opening the main page of artnow.ru");
            favoritePage.open();

            Allure.step("Expanding the navigation menu and navigating to the 'Batik' category");
            favoritePage.showMoreButton().click();
            favoritePage.categoryItemButton().click();

            Allure.step("Adding the first artwork to favorites and remembering its name");
            String artworkName = favoritePage.firstArtworkName().getText().trim();
            favoritePage.favoriteButton().click();

            Allure.step("Navigating to the favorites page");
            favoritePage.favoritePageButton().click();

            String favoriteArtworkName = favoritePage.firstArtworkNameInFavorite().getText().trim().replaceAll("\\n", " ");

            Assert.assertEquals(artworkName, favoriteArtworkName);
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
