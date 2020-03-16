package tests;

import org.testng.annotations.Test;

public class MainTest extends BaseTest {

    @Test(retryAnalyzer = RetryFailedTestCases.class, description = "Getting the best shop for your item")
    public void mainApp() {
        mainSteps.findAndClickItem();
        pricesSteps.chooseShop();
        shopSteps.getShopInfo().getRoute();
    }

}