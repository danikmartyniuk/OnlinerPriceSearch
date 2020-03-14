package tests;

import org.testng.annotations.Test;

public class Main extends BaseTest {

    @Test (retryAnalyzer = RetryFailedTestCases.class, priority = 10, description = "Getting the best shop for your item")
    public void mainApp () {
        mainSteps.findAndClickItem();
        pricesSteps.chooseShop();
        shopSteps.getShopInfo().getRoute();
    }

    @Test (priority = 6, description = "Getting samsung phones average price")
    public void samsungPrice () {
        mainSteps.openPhonePrices();
        phoneSteps.chooseSamsung();
    }

    @Test (priority = 5, retryAnalyzer = RetryFailedTestCases.class, description = "Getting apple phones average price")
    public void applePrice () {
        mainSteps.openPhonePrices();
        phoneSteps.chooseApple();
    }

    @Test (priority = 4, description = "Getting automobiles average price")
    public void autoPrices () {
        mainSteps.openAuto();
        autoSteps.getAutoPrices();
    }

    @Test (priority = 3, description = "Getting realty number of ads")
    public void realtyPrices () {
        mainSteps.openRealty();
        realtySteps.getRealtyPrices();
    }

    @Test (priority = 1, description = "Getting number of COVID cases and top three countries")
    public void covidStats() {
        mainSteps.controlCovid();
    }

    @Test (priority = 2, description = "Getting relevant exchange rates")
    public void currencies() {
        mainSteps.getCurr();
    }

    @Test (priority = 7, description = "Getting Xiaomi (China) phones average price")
    public void xiaomiPrice () {
        mainSteps.openPhonePrices();
        phoneSteps.chooseXiaomi();
    }

    @Test (priority = 8, description = "Getting masks number of ads")
    public void countMasks () {
        mainSteps.countMasks();
    }

    @Test (priority = 9, description = "Most popular category in baraholka")
    public void baraholkaTopCategory () {
        mainSteps.openBaraholka();
        baraholkaSteps.getToBaraholka().getTopCategory();
    }

}
