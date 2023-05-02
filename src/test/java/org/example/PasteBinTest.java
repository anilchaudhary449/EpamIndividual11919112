package org.example;

import com.browser.BrowserParameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PasteBinTest {
    WebDriver driver;
    PasteBin pasteBin;

    @Test
    public void verifyBin() throws InterruptedException {
        WebDriver driver = BrowserParameters.setupBrowser("chrome", "https://pastebin.com/");
        pasteBin = new PasteBin(driver);
        pasteBin.WriteText();
        pasteBin.setExpirationDuration();
        pasteBin.setTitle();
        pasteBin.ConfirmBin();

        driver.quit();
    }
}
