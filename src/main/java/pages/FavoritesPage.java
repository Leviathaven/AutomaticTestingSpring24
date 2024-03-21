package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FavoritesPage extends BasePage {
    private By showMoreButtonSelector = By.xpath("//*[@id=\"left_container\"]/div/ul[2]/li[15]/div/i");
    private By categoryItemButtonSelector = By.xpath("//*[@id=\"left_container\"]/div/ul[2]/li[3]/a");
    private By firstArtworkNameSelector = By.cssSelector("#sa_container > div:nth-child(3) > a:nth-child(1) > div");
    private By favoriteButtonSelector = By.cssSelector("#sa_container > div:nth-child(3) > div.heart");
    private By favoritePageButtonSelector = By.cssSelector("body > div.topheader > span.fvtico");
    private By firstArtworkNameInFavoriteSelector = By.cssSelector("#sa_container > div.post > a:nth-child(1) > div");

    public FavoritesPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://artnow.ru");
    }

    public WebElement showMoreButton() {
        return this.find(showMoreButtonSelector);
    }

    public WebElement categoryItemButton() {
        return this.find(categoryItemButtonSelector);
    }

    public WebElement firstArtworkName() {
        return this.find(firstArtworkNameSelector);
    }

    public WebElement favoriteButton() {
        return this.find(favoriteButtonSelector);
    }

    public WebElement favoritePageButton() {
        return this.find(favoritePageButtonSelector);
    }

    public WebElement firstArtworkNameInFavorite() {
        return this.find(firstArtworkNameInFavoriteSelector);
    }
}
