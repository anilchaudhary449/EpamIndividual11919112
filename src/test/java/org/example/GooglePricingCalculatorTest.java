package org.example;

import com.browser.BrowserParameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GooglePricingCalculatorTest  {

    GoogleCloudPricingCalculator calculatorPage;
    PasteBinTest pasteBinTest=new PasteBinTest();
@Test(priority = 0)
    public void setPasteBinTest()throws Exception {
        pasteBinTest.verifyBin();
    }
@Test(dependsOnMethods = "setPasteBinTest")
    public void checkInformationInVmClass() throws InterruptedException {
        WebDriver driver= BrowserParameters.setupBrowser("chrome","https://cloud.google.com/");
        Thread.sleep(15000);
        calculatorPage = new GoogleCloudPricingCalculator(driver);
        calculatorPage.homePage();
        calculatorPage.sendKeyInToNumberOfInstancesField("4");
        calculatorPage.selectSeriesOfMachine();
        calculatorPage.selectMachineType();
        calculatorPage.clickAddGpusCheckBox();
        calculatorPage.selectGpuType();
        calculatorPage.selectNumberOfGpus();
        calculatorPage.selectLocalSsd();
        calculatorPage.selectDataCenterLocation();
        calculatorPage.selectCommittedUsage();
        calculatorPage.pushAddToEstimate();

        String vm = calculatorPage.checkInformationInVmClassIsRegular().getText();
        System.out.println(vm);
        Assert.assertEquals(vm, "Provisioning model: Regular");

        driver.quit();
    }

    @Test(dependsOnMethods = "setPasteBinTest")
    public void checkInformationInInstanceType() throws InterruptedException {
        WebDriver driver= BrowserParameters.setupBrowser("chrome","https://cloud.google.com/");

        calculatorPage=new GoogleCloudPricingCalculator(driver);
        calculatorPage.homePage();
        calculatorPage.sendKeyInToNumberOfInstancesField("4");
        calculatorPage.selectSeriesOfMachine();
        calculatorPage.selectMachineType();
        calculatorPage.clickAddGpusCheckBox();
        calculatorPage.selectGpuType();
        calculatorPage.selectNumberOfGpus();
        calculatorPage.selectLocalSsd();
        calculatorPage.selectDataCenterLocation();
        calculatorPage.selectCommittedUsage();
        calculatorPage.pushAddToEstimate();

        String instanceType=calculatorPage.checkInformationInInstanceTypeIncludeN1Standard8().getText();
        System.out.println(instanceType);
        Assert.assertEquals(instanceType,"Instance type: n1-standard-8\n" + "Committed Use Discount applied");
        driver.quit();
    }
    @Test(dependsOnMethods = "setPasteBinTest")
    public void checkRegion() throws InterruptedException {
        WebDriver driver= BrowserParameters.setupBrowser("chrome","https://cloud.google.com/");

        calculatorPage=new GoogleCloudPricingCalculator(driver);
        calculatorPage.homePage();
        calculatorPage.sendKeyInToNumberOfInstancesField("4");
        calculatorPage.selectSeriesOfMachine();
        calculatorPage.selectMachineType();
        calculatorPage.clickAddGpusCheckBox();
        calculatorPage.selectGpuType();
        calculatorPage.selectNumberOfGpus();
        calculatorPage.selectLocalSsd();
        calculatorPage.selectDataCenterLocation();
        calculatorPage.selectCommittedUsage();
        calculatorPage.pushAddToEstimate();

        String region=calculatorPage.checkRegionIsFrankfurt().getText();
        System.out.println(region);
        Assert.assertEquals(region,"Region: Frankfurt");
        driver.quit();
    }
    @Test(dependsOnMethods = "setPasteBinTest")
    public void checkLocalSsdSpace() throws InterruptedException {
        WebDriver driver= BrowserParameters.setupBrowser("chrome","https://cloud.google.com/");

        calculatorPage=new GoogleCloudPricingCalculator(driver);
        calculatorPage.homePage();
        calculatorPage.sendKeyInToNumberOfInstancesField("4");
        calculatorPage.selectSeriesOfMachine();
        calculatorPage.selectMachineType();
        calculatorPage.clickAddGpusCheckBox();
        calculatorPage.selectGpuType();
        calculatorPage.selectNumberOfGpus();
        calculatorPage.selectLocalSsd();
        calculatorPage.selectDataCenterLocation();
        calculatorPage.selectCommittedUsage();
        calculatorPage.pushAddToEstimate();

        String ssd=calculatorPage.checkLocalSsdSpace2x375Gib().getText();
        System.out.println(ssd);
        Assert.assertEquals(ssd,"Local SSD: 2x375 GiB\n" + "Committed Use Discount applied");
        driver.quit();
    }
    @Test(dependsOnMethods = "setPasteBinTest")
    public void checkCommitment() throws InterruptedException {
        WebDriver driver= BrowserParameters.setupBrowser("chrome","https://cloud.google.com/");

        calculatorPage=new GoogleCloudPricingCalculator(driver);
        calculatorPage.homePage();
        calculatorPage.sendKeyInToNumberOfInstancesField("4");
        calculatorPage.selectSeriesOfMachine();
        calculatorPage.selectMachineType();
        calculatorPage.clickAddGpusCheckBox();
        calculatorPage.selectGpuType();
        calculatorPage.selectNumberOfGpus();
        calculatorPage.selectLocalSsd();
        calculatorPage.selectDataCenterLocation();
        calculatorPage.selectCommittedUsage();
        calculatorPage.pushAddToEstimate();

        String term=calculatorPage.checkCommitmentTermOneYear().getText();
        System.out.println(term);
        Assert.assertEquals(term,"Commitment term: 1 Year");
        driver.quit();
    }
}
