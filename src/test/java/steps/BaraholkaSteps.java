package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.BaraholkaPage;

public class BaraholkaSteps {

    BaraholkaPage baraholkaPage;

    public BaraholkaSteps (WebDriver driver) {
        baraholkaPage = new BaraholkaPage(driver);
    }

    @Step
    public BaraholkaSteps getToBaraholka() {
        baraholkaPage.openPage();
        return this;
    }

    @Step
    public BaraholkaSteps getTopCategory() {
        baraholkaPage.topCategory(baraholkaPage.countAds());
        return this;
    }
}
