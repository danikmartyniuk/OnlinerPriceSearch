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

    @Step ("Open phone prices")
    public MainSteps openPhonePrices() {
        mainPage.openPage().openPhones();
        return this;
    }

    @Step ("Open baraholka")
    public MainSteps openBaraholka() {
        mainPage.openPage().openBaraholka();
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
    public MainSteps controlCovid() {
        mainPage.openCoronaVirus();
        mainPage.getNumberOfCases();
        mainPage.getTopThreeCountries();
        return this;
    }

    @Step ("Getting relevant currencies")
    public MainSteps getCurr() {
        mainPage.openCurrencies().getCurrencies();
        return this;
    }

    @Step ("Count masks")
    public MainSteps countMasks() {
        mainPage.openMasksSite().countMasks();
        return this;
    }
}
