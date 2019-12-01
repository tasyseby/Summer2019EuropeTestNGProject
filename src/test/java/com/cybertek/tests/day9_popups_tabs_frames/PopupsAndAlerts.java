package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void SetUpMethod() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        driver.findElement(By.xpath("//*[text()='Destroy the World']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='No']"));
    }

    @Test
    public void Alerts() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        //just click for JS Alert
        driver.findElement(By.xpath("//button[1]")).click();

        //we have special class from selenium which is Alert !! for JS pop ups
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        //alert. has 4 different methods to deal with alert popups
        //accept.dismis.sendkeys,getText;

        alert.accept();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[2]")).click();
        //clicking x to close, selecting no/cancel
        Thread.sleep(3000);
        alert.dismiss();
        Thread.sleep(3000);

        //clicking JS prompt
        driver.findElement(By.xpath("//button[3]")).click();
        //sendKeys
        alert.sendKeys("Mike Smith");
        alert.accept();





    }


    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }
}
