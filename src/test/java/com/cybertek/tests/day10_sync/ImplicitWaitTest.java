package com.cybertek.tests.day10_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitTest {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void teardownMethod(){
        //driver.quit();
    }

    @Test
    public void test6() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String message=driver.findElement(By.id("finish")).getText();
        System.out.println(message);
}
}