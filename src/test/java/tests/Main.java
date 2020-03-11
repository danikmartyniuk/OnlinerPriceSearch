package tests;

import org.testng.annotations.Test;

public class Main extends BaseTest {

    @Test (retryAnalyzer = RetryFailedTestCases.class)
    public void mainApp () {
        mainSteps.findAndClickItem();
        pricesSteps.chooseShop();
        shopSteps.getShopInfo();
    }

    @Test
    public void phonePrices () {
        mainSteps.openPhonePrices();
        phoneSteps.chooseApple();
    }

    @Test
    public void autoPrices () {
        mainSteps.openAuto();
        autoSteps.getAutoPrices();
    }

    @Test
    public void realtyPrices () {
        mainSteps.openRealty();
        realtySteps.getRealtyPrices();
    }

    @Test
    public void covidStats() {
        mainSteps.controlCovid();
    }

}
