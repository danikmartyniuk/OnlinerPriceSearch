package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import java.util.Arrays;

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
    public void controlCovid() {
        mainPage.openCoronaVirus();
        System.out.println("Number of cases - " + mainPage.getNumberOfCases() + ", top countries are " + Arrays.toString(mainPage.getTopThreeCountries()));
    }

    @Step ("Getting relevant currencies")
    public void getCurr() {
        System.out.println(Arrays.toString(mainPage.openCurrencies().getCurrencies()));
    }

    @Step ("Count masks")
    public void countMasks() {
        System.out.println(mainPage.openMasksSite().countMasks() + " masks in supply");
    }
}
