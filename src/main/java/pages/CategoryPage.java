package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryPage extends BasePage {
    public static final By showMoreButtonSelector = By.xpath("//*[@id='left_container']/div/ul[2]/li[15]/div/i");
    public static final By categoryItemButtonSelector = By.xpath("//*[@id='left_container']/div/ul[2]/li[8]/a");
    public static final By filterButtonSelector = By.xpath("//*[@id='genre257']");
    public static final By submitFilterButtonSelector = By.xpath("//*[@id='applymsg']");
    public static final By artworkNameSelector = By.xpath("//*[text()='Трамвайный путь']");
    public static final By artworkStyleSelector = By.xpath("//*[@id='main_container']/div[3]/div[2]/div[5]/a");

    public CategoryPage(WebDriver driver) {
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

    public WebElement filterButton() {
        return this.find(filterButtonSelector);
    }

    public WebElement submitFilterButton() {
        return this.find(submitFilterButtonSelector);
    }

    public WebElement findArtworkName() {
        return this.find(artworkNameSelector);
    }

    public WebElement checkArtworkStyle() {
        return this.find(artworkStyleSelector);
    }
}
