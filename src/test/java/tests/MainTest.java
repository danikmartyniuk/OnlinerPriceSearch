package tests;

import org.testng.annotations.Test;

public class MainTest extends BaseTest {

    @Test (description = "Searching for item")
    public void searchItem () {
        mainSteps.findAndClickItem();
    }
}
