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
    public int getAutoPrices() {
        autoPage.openPage();
        autoPage.getNumberOfCars();
        return autoPage.getAveragePrice();
    }
}
