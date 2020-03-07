package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import steps.MainSteps;
import steps.PricesSteps;

public class BaseTest {

    WebDriver driver;
    MainSteps mainSteps;
    PricesSteps pricesSteps;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainSteps = new MainSteps(driver);
        pricesSteps = new PricesSteps(driver);
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }

}
