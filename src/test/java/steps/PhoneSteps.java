package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.PhonesPage;

public class PhoneSteps {

    PhonesPage phonesPage;

    public PhoneSteps (WebDriver driver) {
        phonesPage = new PhonesPage(driver);
    }

    @Step ("Choose Apple phones")
    public PhoneSteps chooseApple() {
        phonesPage.openPage();
        phonesPage.chooseCompany("apple");
        return this;
    }

    @Step ("Choose Samsung phones")
    public PhoneSteps chooseSamsung() {
        phonesPage.openPage();
        phonesPage.chooseCompany("samsung");
        return this;
    }
}
