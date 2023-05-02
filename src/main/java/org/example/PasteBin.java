package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PasteBin {
    WebDriver driver;

    public PasteBin(WebDriver driver) {
        this.driver=driver;
    }
    By TxtArea=By.xpath("//textarea[@id='postform-text']");
    By ele=By.id("select2-postform-expiration-container");
    By selectResult=By.xpath("//span[@class= 'select2-results']/ul/li[3]");

    By title=By.xpath("//input[@id='postform-name']");

    By title1=By.id("postform-name");

    By createPaste=By.xpath("//button[text() = 'Create New Paste']");


    public void WriteText() throws InterruptedException {
            driver.findElement(TxtArea).click();
            driver.findElement(TxtArea).sendKeys("Hello from WebDriver");
            Thread.sleep(5000);

            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("window.scrollBy(0,460)", "");
        }
        public void setExpirationDuration() throws InterruptedException{
            driver.findElement(ele).click();
            driver.findElement(selectResult).click();
            Thread.sleep(5000);

            JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
            jsExecutor1.executeScript("window.scrollBy(0,560)", "");
        }

        public void setTitle()throws InterruptedException{
            driver.findElement(title).click();
            driver.findElement(title1).sendKeys("hello");
            Thread.sleep(5000);
        }
        public void ConfirmBin()throws InterruptedException {
            driver.findElement(createPaste).click();
            Thread.sleep(7000);
        }
    }

