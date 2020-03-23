package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class MainSteps {

    MainPage mainPage;

    public MainSteps (WebDriver driver) {
        mainPage = new MainPage(driver);
    }
    
    @Step ("Input item {item} and then click its price with index {index}")
    public MainSteps findAndClickItem (String item, int index) {
        mainPage
                .openPage()
                .inputItem(item)
                .openItemPrices(index);
        return this;
    }

    @Step ("Open phone prices")
    public MainSteps openPhonePrices() {
        mainPage.openPage().openPhones();
        return this;
    }

    @Step ("Open Auto")
    public MainSteps openAuto() {
        mainPage.openPage().openAuto();
        return this;
    }

    @Step ("Open Realty")
    public MainSteps openRealty() {
        mainPage.openPage().openRealty();
        return this;
    }

    @Step ("Getting COVID information")
    public int controlCovid() {
        return mainPage.openCoronaVirus().getNumberOfCases();
    }

    @Step ("Getting relevant currencies")
    public String[] getCurr() {
        return mainPage.openCurrencies().getCurrencies();
    }

    @Step ("Comparing exchange rates")
    public void compare() {
        mainPage.compareRates(mainPage.openCurrencies().getUSDfromMyFin(), mainPage.openPage().getUSDfromOnliner());
    }

}
