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
    public void chooseApple() {
        phonesPage.openPage();
        System.out.println("iPhones average price is " + phonesPage.chooseCompany("apple").getPrices());
    }

    @Step ("Get Samsung average price")
    public void chooseSamsung() {
        phonesPage.openPage();
        System.out.println("Samsung average price is " + phonesPage.chooseCompany("samsung").getPrices());
    }

    @Step ("Get Samsung average price")
    public void chooseXiaomi() {
        phonesPage.openPage();
        System.out.println("Xiaomi average price is " + phonesPage.chooseCompany("xiaomi").getPrices());
    }
}
