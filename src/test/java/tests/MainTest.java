package tests;

import org.testng.annotations.Test;
import utils.RetryFailedTestCases;

public class MainTest extends BaseTest {

    @Test(retryAnalyzer = RetryFailedTestCases.class, description = "Getting the best shop for your item")
    public void mainApp() {
        mainSteps.findAndClickItem("iPhone 8", 0);
        pricesSteps.chooseShop();
        shopSteps.getShopInfo().getRoute();
    }

}