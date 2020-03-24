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
import java.util.concurrent.TimeUnit;

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

    @BeforeClass
    public void setUp() {
        csv = new OnlinerStats();
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime now = LocalDateTime.now();
        csv.setDate(dtf.format(now));
        CSVUtils.writeStatsToCSV("data.csv", csv);
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
