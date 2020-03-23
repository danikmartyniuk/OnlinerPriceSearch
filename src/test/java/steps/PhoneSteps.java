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
    public int chooseApple() {
        phonesPage.openPage();
        return phonesPage.chooseCompany("apple").getPrices();
    }

    @Step ("Get Samsung average price")
    public int chooseSamsung() {
        phonesPage.openPage();
        return phonesPage.chooseCompany("samsung").getPrices();
    }

    @Step ("Get Samsung average price")
    public int chooseXiaomi() {
        phonesPage.openPage();
        return phonesPage.chooseCompany("xiaomi").getPrices();
    }
}
