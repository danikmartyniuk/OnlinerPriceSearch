package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class MainSteps {

    MainPage mainPage;

    public MainSteps (WebDriver driver) {
        mainPage = new MainPage(driver);
    }

    @Step ("Input item and then click it")
    public MainSteps findAndClickItem () {
        mainPage.openPage();
        mainPage.inputItem();
        mainPage.chooseItem();
        return this;
    }
}
