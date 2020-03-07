package tests;

import org.testng.annotations.Test;

public class Main extends BaseTest {

    @Test (description = "Searching for item")
    public void searchItem () {
        mainSteps.findAndClickItem();
        pricesSteps.chooseShop();
    }

    @Test (description = "Finding the most suitable shop")
    public void openShop () {

    }
}
