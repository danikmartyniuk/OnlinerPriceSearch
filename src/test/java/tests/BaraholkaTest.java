package tests;

import org.testng.annotations.Test;

public class BaraholkaTest extends BaseTest {

    @Test(description = "Most popular category in baraholka")
    public void baraholkaTopCategory() {
        mainSteps.openBaraholka();
        baraholkaSteps
                .getToBaraholka()
                .getTopCategory();
    }

}
