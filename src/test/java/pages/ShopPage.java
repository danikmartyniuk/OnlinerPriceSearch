package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class ShopPage extends BasePage {

    private static final By SHOP_NAME = By.className("sells-title");
    private static final By CONTACTS = By.xpath("//div[contains(@class,'button-style button-style_auxiliary button-style_middle sells-contacts-description')]");
    private static final By NUMBERS = By.cssSelector(".sells-contacts-itm-link");
    private static final By ADDRESS = By.xpath("//*[@id=\"contacts-minsk\"]/div[2]/ul/li");
    private static final By WORK_TIME = By.xpath("//p[@class='sells-time-work-week-text js-worktime-pseudolink']");
    private static final By DAY = By.cssSelector("._day");
    private static final By WEATHER = By.className("b-top-navigation-informers__link");
    private static final String MAPS_URL = "https://yandex.by/maps/?ll=26.080757%2C53.116197&mode=routes&rtext=&rtt=auto&z=7";
    private static final By FROM_WHERE = By.xpath("//input[@placeholder='Откуда']");
    private static final By TO_WHERE = By.xpath("//input[@placeholder='Куда']");
    private static final By MAPS_MENU = By.cssSelector(".user-menu-control");

    public ShopPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ShopPage openPage() {
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

    public ShopPage openMaps(String userAddress) {
        try {
            String shopAddress = driver.findElement(ADDRESS).getText();
            driver.navigate().to(MAPS_URL);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".route-travel-modes-view")));
            driver.findElement(FROM_WHERE).sendKeys(userAddress, Keys.ENTER);
            WebElement toWhere = driver.findElement(TO_WHERE);
            toWhere.sendKeys(shopAddress);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            toWhere.sendKeys(Keys.ENTER);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("path")));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            String shopAddress = driver.findElement(ADDRESS).getText();
            driver.navigate().to(MAPS_URL);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".route-travel-modes-view")));
            driver.findElement(FROM_WHERE).sendKeys(userAddress, Keys.ENTER);
            WebElement toWhere = driver.findElement(TO_WHERE);
            toWhere.sendKeys(shopAddress);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            toWhere.sendKeys(Keys.ENTER);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("path")));
        }
        return this;
    }

    public void copyRoute() {
        driver.findElements(MAPS_MENU).get(0).click();
        driver.findElements(MAPS_MENU).get(0).click();
        driver.findElements(MAPS_MENU).get(0).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='user-menu-view__menu']")));
        driver.findElement(By.xpath("//a[@data-type='share']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("map-share-view__content")));
        System.out.println(driver.findElements(By.xpath("//input[@class='input__control']")).get(3).getAttribute("value"));
    }

    public String[] getWorkTime() {
        WebElement workTime = driver.findElement(WORK_TIME);
        actions.moveToElement(workTime).perform();
        workTime.click();
        String[] days = new String[7];
        for (int i = 0; i < days.length; i++) {
            days[i] = driver.findElements(DAY).get(i).getText();
            if (days[i] == null) {
                days[i] = "Магазин в этот день не работает";
            }
        }
        return days;
    }

    public String[] getContacts() {
        driver.findElement(CONTACTS).click();
        String[] numbers = new String[driver.findElements(NUMBERS).size()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = driver.findElements(NUMBERS).get(i).getText();
        }
        return numbers;
    }
}
