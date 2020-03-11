package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class PhonesPage extends BasePage {

    private static final By PHONE_BLOCK = By.className("schema-product__group");
    private static final By PHONE_CHECKBOX = By.xpath("//input[@value='apple']");

    public PhonesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage openPage() {
        isPageOpened();
        return this;
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PHONE_BLOCK));
    }

    public void chooseCompany(String company) {
        driver.findElements(PHONE_CHECKBOX).get(0).click();
    }

}
