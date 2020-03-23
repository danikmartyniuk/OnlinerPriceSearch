package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PhonesPage extends BasePage {

    private static final By PHONE_BLOCK = By.className("schema-product__group");
    private static final By APPLE_CHECKBOX = By.xpath("//input[@value='apple']");
    private static final By SAMSUNG_CHECKBOX = By.xpath("//input[@value='samsung']");
    private static final By XIAOMI_CHECKBOX = By.xpath("//input[@value='xiaomi']");
    private static final By PRICES = By.xpath("//span[contains(@data-bind,'root.format.minPrice($data.prices')]");

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

    public PhonesPage chooseCompany(String company) {
        if (company.equals("apple")) {
            WebElement checkbox = driver.findElements(APPLE_CHECKBOX).get(0);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", checkbox);
        } else if (company.equals("samsung")) {
            WebElement checkbox = driver.findElements(SAMSUNG_CHECKBOX).get(0);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", checkbox);
        } else if (company.equals("xiaomi")) {
            WebElement checkbox = driver.findElements(XIAOMI_CHECKBOX).get(0);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", checkbox);
        }
        return this;
    }

    public int getPrices() {
        int sum = 0;
        try {
            int len = driver.findElements(PRICES).size();
            int[] pr = new int[len];
            for (int i = 0; i < pr.length; i++) {
                pr[i] = Integer.parseInt(driver.findElements(PRICES).get(i).getText().substring(0, driver.findElements(PRICES).get(i).getText().indexOf(',')));
                sum += pr[i];
            }
            return sum / driver.findElements(PRICES).size();
        } catch (StaleElementReferenceException | IndexOutOfBoundsException ex) {
            int len = driver.findElements(PRICES).size();
            int[] pr = new int[len];
            for (int i = 0; i < pr.length; i++) {
                pr[i] = Integer.parseInt(driver.findElements(PRICES).get(i).getText().substring(0, driver.findElements(PRICES).get(i).getText().indexOf(',')));
                sum += pr[i];
            }
            return sum / driver.findElements(PRICES).size();
        }

    }

}
