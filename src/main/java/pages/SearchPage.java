package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class SearchPage extends BasePage {

    private By searchInputSelector = By.cssSelector("#MainSearchForm > div > div:nth-child(1) > input.inp.scLarge");
    private By searchButtonSelector = By.cssSelector("#MainSearchForm > div > div:nth-child(2) > button");
    private By firstArtworkNameSelector = By.cssSelector("#sa_container > div:nth-child(3) > a:nth-child(1) > div");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://artnow.ru");
    }

    public WebElement searchInput() {
        return this.find(searchInputSelector);
    }

    public WebElement searchButton() {
        return this.find(searchButtonSelector);
    }

    public WebElement firstArtworkName() {
        return this.find(firstArtworkNameSelector);
    }
}