package com.cybertek.tests.VyTrack_App;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class TestCase2_CalendarEvents2 extends TestBase {

    @Test
    public void numberEqualone(){

        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);

        WebElement text = driver.findElement(By.xpath("(//h1)[2]"));
        wait.until(ExpectedConditions.visibilityOf(text));

        WebElement Activities = driver.findElement(By.linkText("Activities"));
        WebElement CalendarEvents = driver.findElement(By.xpath("//span[contains(text(),'Calendar Events')]"));

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        action.moveToElement(Activities).clickAndHold().moveToElement(CalendarEvents).click().build().perform();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement number = driver.findElement(By.xpath("//input[@class='input-widget']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='input-widget']")));

        Assert.assertEquals(number.getAttribute("value"),"3","This error occurs if 1isnt shown");

        Driver.closeDriver();





    }

}
