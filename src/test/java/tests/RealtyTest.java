package tests;

import org.testng.annotations.Test;

public class RealtyTest extends BaseTest {

    @Test(description = "Getting realty number of ads")
    public void realtyPrices() {
        mainSteps.openRealty();
        csv.setEstate(realtySteps.getRealtyAds());
    }

}
