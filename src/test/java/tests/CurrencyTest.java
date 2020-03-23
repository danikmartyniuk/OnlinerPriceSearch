package tests;

import org.testng.annotations.Test;

public class CurrencyTest extends BaseTest {

    @Test(description = "Getting relevant exchange rates")
    public void currencies() {
        String[] currencies = mainSteps.getCurr();
        csv.setUsd(currencies[0]);
        csv.setEur(currencies[1]);
    }

    @Test(description = "Check if there is the right exchange rate on onliner")
    public void compareRates() {
        mainSteps.compare();
    }

}
