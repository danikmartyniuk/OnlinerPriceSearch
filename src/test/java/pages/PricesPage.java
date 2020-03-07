package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;

public class PricesPage extends BasePage {

    private static final By PRICES_BLOCK = By.className("b-offers-list-line-table");
    private static final By PRICES = By.xpath("//span[@data-bind='html: position.format.priceObject(position.data.position_price.converted['BYN'])]'");
    private static final By SHOPS = By.xpath("//a[@data-bind='attr: {href: position.shop ? position.shop.html_url : ''}]'");
    private static final By PRICE_SORT = By.xpath("//span[@data-bind='text: $root.items[type].text]");

    public PricesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PricesPage openPage() {
        isPageOpened();
        return this;
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRICES_BLOCK));
    }

    public void getTheLowestPrice() {
        int size = driver.findElements(PRICES).size();
        int[] prices = new int[size];
        for (int i = 0; i < driver.findElements(PRICES).size(); i++) {
            prices[i] = Integer.parseInt(driver.findElements(PRICES).get(i).getText());
        }
        Arrays.sort(prices);
        driver.findElements(SHOPS).get(prices[0]).click();
    }
}
