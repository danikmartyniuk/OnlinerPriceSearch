package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.PhonesPage;

public class PhoneSteps {


    PhonesPage phonesPage;

    public PhoneSteps (WebDriver driver) {
        phonesPage = new PhonesPage(driver);
    }

    @Step ("Get iPhones average price")
    public PhoneSteps chooseApple() {
        phonesPage.openPage();
        phonesPage.chooseCompany("apple").getPrices();
        return this;
    }

    @Step ("Get Samsung average price")
    public PhoneSteps chooseSamsung() {
        phonesPage.openPage();
        phonesPage.chooseCompany("samsung").getPrices();
        return this;
    }

    @Step ("Get Samsung average price")
    public PhoneSteps chooseXiaomi() {
        phonesPage.openPage();
        phonesPage.chooseCompany("xiaomi").getPrices();
        return this;
    }
}
