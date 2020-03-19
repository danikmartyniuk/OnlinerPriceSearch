package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import steps.*;
import utils.CapabilitiesGenerator;

@Listeners ({TestListener.class})
public class BaseTest {

    WebDriver driver;
    MainSteps mainSteps;
    PricesSteps pricesSteps;
    ShopSteps shopSteps;
    PhoneSteps phoneSteps;
    AutoSteps autoSteps;
    RealtySteps realtySteps;
    BaraholkaSteps baraholkaSteps;

    @BeforeClass
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        CapabilitiesGenerator.getChromeOptions();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainSteps = new MainSteps(driver);
        pricesSteps = new PricesSteps(driver);
        shopSteps = new ShopSteps(driver);
        phoneSteps = new PhoneSteps(driver);
        autoSteps = new AutoSteps(driver);
        realtySteps = new RealtySteps(driver);
        baraholkaSteps = new BaraholkaSteps(driver);
    }

    @AfterClass (alwaysRun = true)
    public void close() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
