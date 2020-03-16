package tests;

import org.testng.annotations.Test;

public class CovidTest extends BaseTest {

    @Test(description = "Getting number of COVID cases and top three countries")
    public void covidStats() {
        mainSteps.controlCovid();
    }

}
