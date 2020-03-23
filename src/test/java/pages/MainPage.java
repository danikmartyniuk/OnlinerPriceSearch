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
    private static final By ELECTRONICS = By.xpath("//span[contains(text(),'Электроника')]");
    private static final By MOBILE_PHONES = By.className("catalog-navigation-list__aside-title");
    private static final By PHONES = By.className("catalog-navigation-list__dropdown-title");
    private static final By AUTO = By.className("b-main-navigation__text");
    private static final String COVID_URL = "https://www.worldometers.info/coronavirus/";
    private static final String CURRENCY_URL = "https://myfin.by/currency/minsk";
    private static final String MASKS_URL = "https://medcatalog.by/category/maski?page=2";

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

    public MainPage inputItem (String item) {
        driver.findElement(SEARCH_INPUT).sendKeys(item);
        return this;
    }

    public MainPage openItemPrices (int index) {
        driver.switchTo().frame(driver.findElement(IFRAME));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElements(PRODUCT_PRICE).get(index).click();
        return this;
    }

    public void openPhones() {
        driver.findElement(ELECTRONICS).click();
        driver.findElements(MOBILE_PHONES).get(0).click();
        driver.findElements(PHONES).get(0).click();
    }

    public void openAuto() {
        driver.findElements(AUTO).get(2).click();
    }

    public void openRealty() {
        driver.findElements(AUTO).get(3).click();
    }

    public MainPage openCoronaVirus() {
        driver.navigate().to(COVID_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tabbable-panel-cases']")));
        return this;
    }

    public int getNumberOfCases() {
        return Integer.parseInt(driver.findElement(By.xpath("//span[@style='color:#aaa']")).getText().replace(",", ""));
    }

    public String[] getTopThreeCountries() {
        String[] countries = new String[3];
        for (int i = 0; i < countries.length; i++) {
            countries[i] = driver.findElements(By.xpath("//a[@class='mt_a']")).get(i).getText();
        }
        return countries;
    }

    public MainPage openCurrencies() {
        driver.navigate().to(CURRENCY_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='g-sidebar_i credit-request lizing-request']")));
        return this;
    }

    public String[] getCurrencies() {
        String[] curr = new String[]{driver.findElement(By.xpath("//*[@id=\"workarea\"]/div[1]/div[2]/div/div/div/div/table/tbody/tr[1]/td[2]")).getText(),
                driver.findElement(By.xpath("//*[@id=\"workarea\"]/div[1]/div[2]/div/div/div/div/table/tbody/tr[2]/td[2]")).getText()};
        return curr;
    }

    public double getUSDfromMyFin() {
        return Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"workarea\"]/div[1]/div[2]/div/div/div/div/table/tbody/tr[1]/td[2]")).getText());
    }

    public double getUSDfromOnliner() {
        return Double.parseDouble(driver.findElement(By.cssSelector("._u")).getText().replace("$ ","").replace(",", "."));
    }

    public void compareRates(double myFin, double onliner) {
        if (onliner != myFin) {
            System.out.println("The difference is " + Math.abs(onliner - myFin));
        } else {
            System.out.println("The rates are identical");
        }
    }

}
