package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.PricesPage;

public class PricesSteps {

    PricesPage pricesPage;

    public PricesSteps (WebDriver driver) {
        pricesPage = new PricesPage(driver);
    }

    @Step
    public PricesSteps chooseShop() {
        pricesPage.openPage();
        pricesPage.getTheLowestPrice();
        return this;
    }
}
