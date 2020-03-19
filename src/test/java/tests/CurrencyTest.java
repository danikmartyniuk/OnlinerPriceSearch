package tests;

import org.testng.annotations.Test;

public class CurrencyTest extends BaseTest {

    @Test(description = "Getting relevant exchange rates")
    public void currencies() {
        mainSteps.getCurr();
    }

    @Test(description = "Check if there is the right exchange rate on onliner")
    public void compareRates() {
        mainSteps.compare();
    }

}
