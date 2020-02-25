package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import sun.net.www.http.KeepAliveCache;

import java.util.Scanner;

public class MainPage extends BasePage {

    private static final By SEARCH_INPUT = By.name("query");
    private static final By SEARCH_ITEM = By.className("result__wrapper");
    private static final By CATEGORY_PHOTO = By.className("tiles__preview tiles__preview_position_bottom-center");

    public MainPage (WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        driver.get("https://catalog.onliner.by/");
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CATEGORY_PHOTO));
    }

    public void inputItem () {
        System.out.print("Введите ваш товар: ");
        Scanner s = new Scanner(System.in);
        String item = s.nextLine();
        driver.findElement(SEARCH_INPUT).sendKeys(item);
    }

    public void chooseItem () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_ITEM));
        driver.findElement(SEARCH_INPUT).sendKeys(Keys.ENTER);
    }
}
