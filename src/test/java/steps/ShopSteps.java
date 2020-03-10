package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ShopPage;

public class ShopSteps {

    ShopPage shopPage;

    public ShopSteps (WebDriver driver) {
        shopPage = new ShopPage(driver);
    }

    @Step ("Getting information about the shop")
    public ShopSteps getShopInfo() {
        shopPage.openPage();
        shopPage.getShopName();
        shopPage.getWorkTime();
        shopPage.getContacts();
        shopPage.openMaps();
        shopPage.copyRoute();
        return this;
    }
}
