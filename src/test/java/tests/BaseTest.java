package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import steps.MainSteps;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    MainSteps mainSteps;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mainSteps = new MainSteps(driver);
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }

}
