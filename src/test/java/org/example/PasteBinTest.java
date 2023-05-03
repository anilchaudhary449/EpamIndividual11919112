package org.example;

import com.browser.BrowserParameters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class PasteBinTest {
    WebDriver driver;
    PasteBin pasteBin;

@Test
    public void verifyBin() throws Exception {
        driver=BrowserParameters.setupBrowser("chrome","https://pastebin.com");
        //noinspection deprecation
        driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);

        pasteBin = new PasteBin(driver);
        pasteBin.WriteText();
        pasteBin.setExpirationDuration();
        pasteBin.setTitle();
        pasteBin.ConfirmBin();

        driver.quit();
    }
}
