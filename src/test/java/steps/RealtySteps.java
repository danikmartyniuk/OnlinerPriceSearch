package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.RealtyPage;

public class RealtySteps {

    RealtyPage realtyPage;

    public RealtySteps (WebDriver driver) {
        realtyPage = new RealtyPage(driver);
    }

    @Step ("Getting realty prices")
    public int getRealtyAds() {
        realtyPage.openPage();
        return realtyPage.getNumOfAds();
    }

}
