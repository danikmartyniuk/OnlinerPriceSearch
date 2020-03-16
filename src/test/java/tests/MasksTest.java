package tests;

import org.testng.annotations.Test;

public class MasksTest extends BaseTest {

    @Test(priority = 8, description = "Getting masks number of ads")
    public void countMasks() {
        mainSteps.countMasks();
    }

}
