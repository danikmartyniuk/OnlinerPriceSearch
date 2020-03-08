package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopPage extends BasePage {

    private static final By SHOP_NAME = By.className("sells-title");
    private static final By CONTACTS = By.className("button-style button-style_auxiliary button-style_middle sells-contacts-description__link js-popup__trigger js-contacts-trigger");
    //phone numbers
    private static final By ADDRESS = By.className("sells-contacts-list-itm _address");

    public ShopPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage openPage() {
        return null;
    }

    @Override
    public void isPageOpened() {

    }
}
