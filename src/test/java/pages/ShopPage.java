package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class ShopPage extends BasePage {

    private static final By SHOP_NAME = By.className("sells-title");
    private static final By CONTACTS = By.className("button-style button-style_auxiliary button-style_middle sells-contacts-description__link js-popup__trigger js-contacts-trigger");
    //phone numbers
    private static final By ADDRESS = By.xpath("//*contains(text(),'Минск ,')");
    private static final By WEATHER = By.className("b-top-navigation-informers__link");
    private static final String MAPS_URL = "https://yandex.by/maps/?ll=26.080757%2C53.116197&mode=routes&rtext=&rtt=auto&z=7";
    private static final By WHERE = By.className("input_waypoint__control");

    public ShopPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage openPage() {
        isPageOpened();
        return this;
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(WEATHER));
    }

    public String getShopName() {
        return driver.findElement(SHOP_NAME).getText();
    }

    public void getRouteLink() {
        String userAddress = "Шафарнянская 4";
        String shopAddress = "проспект независимости 3";
        driver.navigate().to(MAPS_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("route-travel-modes-view")));
        driver.findElements(WHERE).get(0).sendKeys(userAddress);
        driver.findElements(WHERE).get(0).sendKeys(Keys.ENTER);
        WebElement where = driver.findElements(WHERE).get(1);
        where.sendKeys(shopAddress);
        where.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("path")));
        System.out.println(driver.getCurrentUrl());
    }
}
