package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AutoPage extends BasePage {

    private static final By PARAMETERS_BLOCK = By.xpath("//div[@class='vehicle-form__description vehicle-form__description_base vehicle-form__description_primary vehicle-form__description_compass-alter']");
    private static final By PRICES = By.xpath("//div[@class='vehicle-form__description vehicle-form__description_tiny vehicle-form__description_other']");
    private static final By NUMBER_OF_CARS = By.xpath("//div[@class='vehicle-form__description vehicle-form__description_other vehicle-form__description_base vehicle-form__description_condensed']");

    public AutoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage openPage() {
        isPageOpened();
        return this;
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PARAMETERS_BLOCK));
    }

    public int getNumberOfCars() {
        String info = driver.findElement(NUMBER_OF_CARS).getText();
        return Integer.parseInt(info.substring(0, info.indexOf('о') - 1).replace(" ", ""));
    }

    public int getAveragePrice() {
        String[] pr = new String[driver.findElements(PRICES).size()];
        for (int i = 0; i < driver.findElements(PRICES).size(); i++) {
            pr[i] = driver.findElements(PRICES).get(i).getText();
        }
        int[] dollarPrices = new int[pr.length];
        int sum = 0;
        for (int i = 0; i < dollarPrices.length; i++) {
            dollarPrices[i] = Integer.parseInt(pr[i].substring(0, pr[i].indexOf('$') - 1).replace(" ", ""));
            sum += dollarPrices[i];
        }
        return sum / dollarPrices.length;
    }
}
