package com.cybertek.tests.VyTrack_App;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PositiveTestCase {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://qa1.vytrack.com/user/login");

        driver.findElement(By.id("prependedInput")).sendKeys("user1");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");

        driver.findElement(By.xpath("//button[1]")).click();



        String expectedUrl = "https://qa1.vytrack.com/";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        WebElement logout = driver.findElement(By.xpath("//a[@* = 'javascript: void(0);']"));
        logout.click();
        WebElement logout2 = driver.findElement(By.xpath("//a[@* = '/user/logout']"));
        logout2.click();






        Thread.sleep(3000);
        driver.quit();



    }
}
