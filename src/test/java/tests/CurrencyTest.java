package tests;

import org.testng.annotations.Test;

public class CurrencyTest extends BaseTest {

    @Test(description = "Getting relevant exchange rates")
    public void currencies() {
        mainSteps.getCurr();
    }

}
