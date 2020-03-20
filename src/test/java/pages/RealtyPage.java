package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RealtyPage extends BasePage {

    private static final By ITEM = By.xpath("//a[@class='classified__handle']");
    private static final By NUM_OF_ADS = By.xpath("//div[@class='classifieds-bar__item']");

    public RealtyPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage openPage() {
        isPageOpened();
        return this;
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ITEM));
    }

    public int getNumOfAds () {
        return Integer.parseInt(driver.findElement(NUM_OF_ADS).getText().substring(0, driver.findElement(NUM_OF_ADS).getText().indexOf('о') - 1));
    }
}
