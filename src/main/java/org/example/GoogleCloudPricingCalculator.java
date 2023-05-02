package org.example;

import org.openqa.selenium.*;

public class GoogleCloudPricingCalculator {
    WebDriver driver;
    public GoogleCloudPricingCalculator(WebDriver driver){
        this.driver=driver;
    }


    private final By search=By.xpath("//input[@class='devsite-search-field devsite-search-query']");
    //input[@placeholder='Search']
    private final By searchResult=By.xpath("//div[@class='gs-title']//b[contains(text(),'Google Cloud Pricing Calculator')]");
    private final By newFirstFrame = By.xpath("//iframe[contains(@name,'goog_')]");
    private final By instancesField = By.xpath("//md-input-container/child::input[@ng-model='listingCtrl.computeServer.quantity']");
    private final By seriesOfMachine = By.xpath("//md-select[@name='series']/parent::md-input-container");
    private final By seriesOfMachineModel = By.xpath("//md-option[@value='n1']");
    private final By machineType = By.xpath("//label[text()='Machine type']/parent::md-input-container");
    private final By computeEngine = By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']");
    private final By gpusCheckBox = By.xpath("//md-checkbox[@aria-label='Add GPUs']");
    private final By gpuType = By.xpath("//md-select[@placeholder='GPU type']");
    private final By gpuTypeModel =By.xpath("//md-option[@value='NVIDIA_TESLA_V100']");
    private final By numberOfGpus = By.xpath("//md-select[@placeholder='Number of GPUs']");
    private final By numberOfGpusModel = By.cssSelector("md-option[value='1'][class='ng-scope md-ink-ripple'][ng-disabled]");
    private final By localSsd = By.xpath("//md-select[@placeholder='Local SSD']");
    private final By localSsdModel = By.xpath("//md-option[@ng-repeat='item in listingCtrl.dynamicSsd.computeServer'][@value='2']/div[@class='md-text ng-binding']");
    private final By dataCenterLocation = By.xpath("//md-select[@placeholder='Datacenter location']");
    private final By dataCenterLocationInFrankfurt = By.xpath("//md-option[@value='europe-west3' and contains(@ng-repeat,'computeServer')]");
    private final By committedUsage = By.xpath("//md-select[@placeholder='Committed usage']");
    private final By oneYearUsage = By.cssSelector("div[class='md-select-menu-container md-active md-clickable']" + " md-option[value='1'][class='md-ink-ripple']");
    private final By addToEstimateButton = By.xpath("//form[@name='ComputeEngineForm']//button[contains(text(),'Add to Estimate')]");
    private final By informationInVmClassIsRegular = By.xpath("//div[normalize-space()='Provisioning model: Regular']");
    private final By InformationInInstanceTypeIncludeN1Standard8 = By.xpath("//div[contains (text(),'Instance type: n1-standard-8')]");
    private final By regionIsFrankfurt = By.xpath("//div[contains (text(),'Region: Frankfurt')]");
    private final By localSsdSpace2x375Gib = By.xpath("//div[contains (text(),'Local SSD: 2x375 GiB')]");
    private final By commitmentTermOneYear = By.xpath("//div[contains (text(),'Commitment term: 1 Year')]");

    public void homePage() throws InterruptedException {
        Thread.sleep(5000);
        //driver.findElement(searchLogo).click();
        WebElement r = driver.findElement(search);
        r.sendKeys("Google Cloud Platform Pricing Calculator");
        // press ENTER
        r.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.findElement(searchResult).click();
        Thread.sleep(3000);
    }
    public void sendKeyInToNumberOfInstancesField(String keyForNumberOfInstances) throws InterruptedException {
        WebElement element = driver.findElement(newFirstFrame);
        driver.switchTo().frame(element);
        driver.switchTo().frame("myFrame");
        Thread.sleep(2000);
        WebElement numberOfInstancesField = driver.findElement(instancesField);
        numberOfInstancesField.sendKeys(keyForNumberOfInstances);
        Thread.sleep(3000);
    }
    public void selectSeriesOfMachine() throws InterruptedException {
        driver.findElement(seriesOfMachine).click();
        Thread.sleep(2000);
        driver.findElement(seriesOfMachineModel).click();
        Thread.sleep(3000);
    }
    public void selectMachineType() throws InterruptedException {
        driver.findElement(machineType).click();
        Thread.sleep(2000);
        driver.findElement(computeEngine).click();
        Thread.sleep(3000);
    }
    public void clickAddGpusCheckBox() throws InterruptedException {
        driver.findElement(gpusCheckBox).click();
        Thread.sleep(3000);
    }
    public void selectGpuType() throws InterruptedException {
        driver.findElement(gpuType).click();
        Thread.sleep(2000);
        driver.findElement(gpuTypeModel).click();
        Thread.sleep(3000);
    }
    public void selectNumberOfGpus() throws InterruptedException {
        driver.findElement(numberOfGpus).click();
        Thread.sleep(2000);
        driver.findElement(numberOfGpusModel).click();
        Thread.sleep(3000);
    }
    public void selectLocalSsd() throws InterruptedException {
        driver.findElement(localSsd).click();
        Thread.sleep(2000);
        driver.findElement(localSsdModel).click();
        Thread.sleep(3000);
    }
    public void selectDataCenterLocation() throws InterruptedException {
        driver.findElement(dataCenterLocation).click();
        Thread.sleep(2000);
        driver.findElement(dataCenterLocationInFrankfurt).click();
        Thread.sleep(3000);
    }
    public void selectCommittedUsage() throws InterruptedException {
        driver.findElement(committedUsage).click();
        Thread.sleep(3000);
        driver.findElement(oneYearUsage).click();
        Thread.sleep(3000);
    }
    public void pushAddToEstimate() throws InterruptedException {
        driver.findElement(addToEstimateButton).click();
        Thread.sleep(3000);
    }
    public WebElement checkInformationInVmClassIsRegular() {
        return driver.findElement(informationInVmClassIsRegular);
    }
    public WebElement checkInformationInInstanceTypeIncludeN1Standard8() {
        return driver.findElement(InformationInInstanceTypeIncludeN1Standard8);
    }
    public WebElement checkRegionIsFrankfurt() {
        return driver.findElement(regionIsFrankfurt);
    }
    public WebElement checkLocalSsdSpace2x375Gib() {
        return driver.findElement(localSsdSpace2x375Gib);
    }
    public WebElement checkCommitmentTermOneYear() {
        return driver.findElement(commitmentTermOneYear);
    }
}

