package tests;

import org.testng.annotations.Test;
import utils.RetryFailedTestCases;

public class GetStatsTest extends BaseTest{

    @Test (description = "Get all stats related to financial impact of COVID-19")
    public void getStats() {
        mainSteps.openAuto();
        csv.setAuto(autoSteps.getAutoPrices());
        csv.setCovid(mainSteps.controlCovid());
        String[] currencies = mainSteps.getCurr();
        csv.setUsd(currencies[0]);
        csv.setEur(currencies[1]);
        mainSteps.openPhonePrices();
        csv.setSamsung(phoneSteps.chooseSamsung());
        mainSteps.openPhonePrices();
        csv.setIphone(phoneSteps.chooseApple());
        mainSteps.openPhonePrices();
        csv.setXiaomi(phoneSteps.chooseXiaomi());
        mainSteps.openRealty();
        csv.setEstate(realtySteps.getRealtyAds());
    }
}
