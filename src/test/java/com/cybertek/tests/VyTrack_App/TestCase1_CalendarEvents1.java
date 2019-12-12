package com.cybertek.tests.VyTrack_App;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase1_CalendarEvents1 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa1.vytrack.com/");

        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys("storemanager85");

        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.sendKeys(Keys.ENTER);

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }

    @Test
    public void optionIsDisplay() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement text = driver.findElement(By.xpath("(//h1)[2]"));
        wait.until(ExpectedConditions.visibilityOf(text));


        WebElement Activities = driver.findElement(By.linkText("Activities"));
        WebElement CalendarEvents = driver.findElement(By.xpath("//span[contains(text(),'Calendar Events')]"));


        Actions actions = new Actions(driver);

        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        actions.moveToElement(Activities).clickAndHold().moveToElement(CalendarEvents).click().build().perform();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        String optionsLink = driver.findElement(By.xpath("//div[@class='btn btn-link dropdown-toggle']")).getText();
        System.out.println(optionsLink);
        Assert.assertEquals(optionsLink, "Options","The Link button Options doesnt Exist");












    }
}
