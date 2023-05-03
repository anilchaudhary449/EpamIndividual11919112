package org.example;

import org.testng.annotations.Test;

public class ComboTest {

    @Test(priority = 0)
    public void paste()throws Exception{
        PasteBinTest pasteBinTest=new PasteBinTest();
        Thread.sleep(10000);
        pasteBinTest.verifyBin();
    }
    @Test(dependsOnMethods = "paste")
    public void googlePricing()throws InterruptedException{
        GooglePricingCalculatorTest googlePricingCalculatorTest=new GooglePricingCalculatorTest();
        googlePricingCalculatorTest.checkInformationInVmClass();
        googlePricingCalculatorTest.checkRegion();
        googlePricingCalculatorTest.checkCommitment();
        googlePricingCalculatorTest.checkLocalSsdSpace();
        googlePricingCalculatorTest.checkInformationInInstanceType();
    }
}
