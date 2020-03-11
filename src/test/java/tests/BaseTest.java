package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import steps.*;

public class BaseTest {

    WebDriver driver;
    MainSteps mainSteps;
    PricesSteps pricesSteps;
    ShopSteps shopSteps;
    PhoneSteps phoneSteps;
    AutoSteps autoSteps;
    RealtySteps realtySteps;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainSteps = new MainSteps(driver);
        pricesSteps = new PricesSteps(driver);
        shopSteps = new ShopSteps(driver);
        phoneSteps = new PhoneSteps(driver);
        autoSteps = new AutoSteps(driver);
        realtySteps = new RealtySteps(driver);
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }

}
