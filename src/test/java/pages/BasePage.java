package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public BasePage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        actions = new Actions(driver);
    }

    public abstract BasePage openPage();
    public abstract void isPageOpened();
}
