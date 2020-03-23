package tests;

import org.testng.annotations.Test;

public class CovidTest extends BaseTest {

    @Test(description = "Getting number of COVID cases")
    public void covidStats() {
        csv.setCovid(mainSteps.controlCovid());
    }

}
