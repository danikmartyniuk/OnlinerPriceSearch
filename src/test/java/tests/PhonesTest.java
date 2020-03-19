package tests;

import org.testng.annotations.Test;

public class PhonesTest extends BaseTest {

    @Test(priority = 1, description = "Getting samsung phones average price")
    public void samsungPrice() {
        mainSteps.openPhonePrices();
        phoneSteps.chooseSamsung();
    }

    @Test(retryAnalyzer = RetryFailedTestCases.class, priority = 3, description = "Getting apple phones average price")
    public void applePrice() {
        mainSteps.openPhonePrices();
        phoneSteps.chooseApple();
    }

    @Test(priority = 2, description = "Getting Xiaomi (China) phones average price")
    public void xiaomiPrice() {
        mainSteps.openPhonePrices();
        phoneSteps.chooseXiaomi();
    }

}
