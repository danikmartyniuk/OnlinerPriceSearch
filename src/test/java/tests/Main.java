package tests;

import org.testng.annotations.Test;

public class Main extends BaseTest {

    @Test (retryAnalyzer = RetryFailedTestCases.class)
    public void mainApp () {
        mainSteps.findAndClickItem();
        pricesSteps.chooseShop();
        shopSteps.getShopInfo();
    }

}
