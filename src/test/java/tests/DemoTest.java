package tests;

import org.testng.annotations.Test;
import utils.RetryFailedTestCases;

public class DemoTest extends BaseTest {

    @Test (description = "Choosing the best shop for item", retryAnalyzer = RetryFailedTestCases.class)
    public void getShop () {
        mainSteps.findAndClickItem("iPhone XS", 0);
        pricesSteps.chooseShop();
        shopSteps.getShopInfo().getRoute();
    }
}
