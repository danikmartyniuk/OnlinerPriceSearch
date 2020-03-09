package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PricesPage extends BasePage {

    private static final By PRICES_BLOCK = By.className("b-offers-list-line-table");
    private static final By SHOP_SORT = By.xpath("//span[@data-bind='text: $root.items[type].text']");
    private static final By SHOPS = By.xpath("//a[contains(@data-bind,'attr: {href: position.shop ? position.shop.html_url')]");
    private static final By PRICES = By.xpath("//span[contains(@data-bind,'html: position.format.priceObject(position.data.position_price.converted')]");

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

    public int getTheLowestPrice() {

        try {
            driver.findElements(SHOP_SORT).get(1).click();
            String[] price = new String[driver.findElements(PRICES).size()];
            for (int i = 0; i < price.length; i++) {
                price[i] = driver.findElements(PRICES).get(i).getText();
            }
            int[] prices = new int[price.length];
            for (int i = 0; i < prices.length; i++) {
                prices[i] = Integer.parseInt(price[i].substring(0, price[i].indexOf(',')));
            }
            int min = prices[0];
            int index = 0;
            for(int i = 0; i < prices.length; i++) {
                if(min > prices[i]) {
                    min = prices[i];
                    index = i;
                }
            }
            return index;
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            driver.findElements(SHOP_SORT).get(1).click();
            String[] price = new String[driver.findElements(PRICES).size()];
            for (int i = 0; i < price.length; i++) {
                price[i] = driver.findElements(PRICES).get(i).getText();
            }
            int[] prices = new int[price.length];
            for (int i = 0; i < prices.length; i++) {
                prices[i] = Integer.parseInt(price[i].substring(0, price[i].indexOf(',')));
            }
            int min = prices[0];
            int index = 0;
            for(int i = 0; i < prices.length; i++) {
                if(min > prices[i]) {
                    min = prices[i];
                    index = i;
                }
            }
            return index;
        }
    }

    public void openTheShop(int index) {
        driver.findElements(SHOPS).get(index).click();
    }
}
