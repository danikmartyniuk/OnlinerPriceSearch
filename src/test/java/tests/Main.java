package tests;

import org.testng.annotations.Test;

public class Main extends BaseTest {

    @Test (retryAnalyzer = RetryFailedTestCases.class, priority = 10, enabled = false)
    public void mainApp () {
        mainSteps.findAndClickItem();
        pricesSteps.chooseShop();
        shopSteps.getShopInfo();
    }

    @Test (priority = 6)
    public void samsungPrice () {
        mainSteps.openPhonePrices();
        phoneSteps.chooseSamsung();
    }

    @Test (priority = 5)
    public void applePrice () {
        mainSteps.openPhonePrices();
        phoneSteps.chooseApple();
    }

    @Test (priority = 4)
    public void autoPrices () {
        mainSteps.openAuto();
        autoSteps.getAutoPrices();
    }

    @Test (priority = 3)
    public void realtyPrices () {
        mainSteps.openRealty();
        realtySteps.getRealtyPrices();
    }

    @Test (priority = 1)
    public void covidStats() {
        mainSteps.controlCovid();
    }

    @Test (priority = 2)
    public void currencies() {
        mainSteps.getCurr();
    }

    @Test (priority = 7)
    public void xiaomiPrice () {
        mainSteps.openPhonePrices();
        phoneSteps.chooseXiaomi();
    }

    @Test (priority = 8)
    public void countMasks () {
        mainSteps.countMasks();
    }

    @Test (priority = 9, enabled = false)
    public void test9 () {

    }

}
