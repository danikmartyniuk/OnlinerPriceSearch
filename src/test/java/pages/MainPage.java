package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage {

    private static final By SEARCH_INPUT = By.name("query");
    private static final By CATEGORY_PHOTO = By.id("widget-18");
    private static final By IFRAME = By.className("modal-iframe");
    private static final By PRODUCT_PRICE = By.xpath("//a[@class='product__price-value product__price-value_primary']");

    public MainPage (WebDriver driver) {
        super(driver);
    }

    @Override
    public MainPage openPage() {
        driver.get("https://catalog.onliner.by/");
        isPageOpened();
        return this;
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CATEGORY_PHOTO));
    }

    public void inputItem () {
        String item = "Iphone 5s";
        driver.findElement(SEARCH_INPUT).sendKeys(item);
    }

    public void chooseItem () {
        driver.switchTo().frame(driver.findElement(IFRAME));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElements(PRODUCT_PRICE).get(0).click();
    }

}
