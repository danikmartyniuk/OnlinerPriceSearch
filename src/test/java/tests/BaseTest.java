package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import steps.*;
import utils.CapabilitiesGenerator;
import utils.TestListener;

@Listeners ({TestListener.class})
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
        CapabilitiesGenerator.getChromeOptions();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainSteps = new MainSteps(driver);
        pricesSteps = new PricesSteps(driver);
        shopSteps = new ShopSteps(driver);
        phoneSteps = new PhoneSteps(driver);
        autoSteps = new AutoSteps(driver);
        realtySteps = new RealtySteps(driver);
    }

    @AfterClass (alwaysRun = true)
    public void close() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
