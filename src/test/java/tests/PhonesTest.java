package tests;

import org.testng.annotations.Test;
import utils.RetryFailedTestCases;

public class PhonesTest extends BaseTest {

    @Test(retryAnalyzer = RetryFailedTestCases.class, priority = 1, description = "Getting samsung phones average price")
    public void samsungPrice() {
        mainSteps.openPhonePrices();
        phoneSteps.chooseSamsung();
    }

    @Test(retryAnalyzer = RetryFailedTestCases.class, priority = 3, description = "Getting apple phones average price")
    public void applePrice() {
        mainSteps.openPhonePrices();
        phoneSteps.chooseApple();
    }

    @Test(retryAnalyzer = RetryFailedTestCases.class, priority = 2, description = "Getting Xiaomi (China) phones average price")
    public void xiaomiPrice() {
        mainSteps.openPhonePrices();
        phoneSteps.chooseXiaomi();
    }

}
