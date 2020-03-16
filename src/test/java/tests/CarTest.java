package tests;

import org.testng.annotations.Test;

public class CarTest extends BaseTest {

    @Test(description = "Getting automobiles average price")
    public void autoPrices() {
        mainSteps.openAuto();
        autoSteps.getAutoPrices();
    }

}
