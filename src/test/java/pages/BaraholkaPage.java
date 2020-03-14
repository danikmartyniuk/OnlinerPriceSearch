package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BaraholkaPage extends BasePage {

    private static final By WEATHER = By.xpath("//a[@href='https://pogoda.onliner.by/']");
    private static final By NUMBER_OF_ADS = By.tagName("sup");
    private static final By CATEGORIES = By.xpath("//a[contains(@href,'./viewforum.php')]");

    public BaraholkaPage(WebDriver driver) {
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

    public int countAds() {
        int[] array = new int[driver.findElements(NUMBER_OF_ADS).size()];
        int index = 0;
        int min = array[index];
        for (int i = 1; i < array.length; i++){
            array[i] = Integer.parseInt(driver.findElements(NUMBER_OF_ADS).get(i).getText());
            if (array[i] <= min){
                min = array[i];
                index = i;
            }
        }
        return index;
    }

    public String topCategory(int i) {
        return driver.findElements(CATEGORIES).get(i).getText();
    }
}
