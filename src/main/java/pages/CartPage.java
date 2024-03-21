package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class CartPage extends BasePage {
    private By showMoreButtonSelector = By.xpath("//*[@id=\"left_container\"]/div/ul[2]/li[15]/div/i");
    private By categoryItemButtonSelector = By.xpath("//*[@id=\"left_container\"]/div/ul[2]/li[5]/a");
    private By firstArtworkNameSelector = By.cssSelector("#sa_container > div:nth-child(3) > a:nth-child(1) > div");
    private By firstArtworkPriceSelector = By.cssSelector("#sa_container > div:nth-child(3) > div.price");
    private By addToCartButtonSelector = By.cssSelector("#sa_container > div:nth-child(3) > a:nth-last-of-type(1) > div");
    private By goToCartButtonSelector = By.xpath("//*[@id=\"cmodal\"]/div/p/button[1]");
    private By cartArtworkNameSelector = By.cssSelector("div.c_cell > div:nth-child(1) > a");
    private By cartArtworkPriceSelector = By.cssSelector("div.c_cell > div.shop > div.price");

    public CartPage(WebDriver driver) {
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

    public WebElement firstArtworkPrice() {
        return this.find(firstArtworkPriceSelector);
    }

    public WebElement addToCartButton() {
        return this.find(addToCartButtonSelector);
    }

    public WebElement goToCartButton() {
        return this.find(goToCartButtonSelector);
    }

    public WebElement cartArtworkName() {
        return this.find(cartArtworkNameSelector);
    }

    public WebElement cartArtworkPrice() {
        return this.find(cartArtworkPriceSelector);
    }
}
