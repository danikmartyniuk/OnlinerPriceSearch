package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class MainSteps {

    MainPage mainPage;

    public MainSteps (WebDriver driver) {
        mainPage = new MainPage(driver);
    }

    @Step ("Input item and then click it")
    public MainSteps findAndClickItem () {
        mainPage.openPage();
        mainPage.inputItem();
        mainPage.chooseItem();
        return this;
    }

    @Step ("Control phone prices")
    public MainSteps openPhonePrices() {
        mainPage.openPage();
        mainPage.openPhones();
        return this;
    }

    @Step ("Open Auto")
    public MainSteps openAuto() {
        mainPage.openPage();
        mainPage.openAuto();
        return this;
    }

    @Step ("Open Realty")
    public MainSteps openRealty() {
        mainPage.openPage();
        mainPage.openRealty();
        return this;
    }

    @Step ("Open COVID site")
    public MainSteps controlCovid() {
        mainPage.openCoronaVirus();
        mainPage.getNumberOfCases();
        mainPage.getTopThreeCountries();
        return this;
    }
}
