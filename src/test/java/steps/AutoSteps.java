package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.AutoPage;

public class AutoSteps {

    AutoPage autoPage;

    public AutoSteps (WebDriver driver) {
        autoPage = new AutoPage(driver);
    }

    @Step ("Getting auto prices")
    public AutoSteps getAutoPrices() {
        autoPage.openPage();
        autoPage.getNumberOfCars();
        autoPage.getAveragePrice();
        return this;
    }
}
