package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import steps.*;
import utils.CSVUtils;
import utils.CapabilitiesGenerator;
import utils.OnlinerStats;
import utils.TestListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Listeners ({TestListener.class})
public class BaseTest {

    WebDriver driver;
    MainSteps mainSteps;
    PricesSteps pricesSteps;
    ShopSteps shopSteps;
    PhoneSteps phoneSteps;
    AutoSteps autoSteps;
    RealtySteps realtySteps;

    OnlinerStats csv;

    @BeforeTest
    public void createCSV () {
        csv = new OnlinerStats();
    }

    @AfterTest
    public void writeToCSV () {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime now = LocalDateTime.now();
        csv.setDate(dtf.format(now) + ";");
        CSVUtils.writeStatsToCSV("src/test/resources/data.csv", csv);
    }

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
