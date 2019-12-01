package com.cybertek.tests.HomeWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase7 {

    WebDriver driver;

    @BeforeMethod
    public void SetUpMethod() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void TestCase7() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com/upload");
        WebElement uploadFile = driver.findElement(By.xpath("//input[@id='file-upload']"));
        uploadFile.sendKeys("C:\\Users\\greek\\Desktop\\TestingUserStories.txt");

        WebElement fileSubmit = driver.findElement(By.xpath("//input[@id='file-submit']"));
        fileSubmit.click();
        Thread.sleep(3000);

        WebElement expected = driver.findElement(By.xpath("//h3"));
        String expectedMessage = expected.getText();
        System.out.println(expectedMessage);

        String actual = "File Uploaded!";

        Assert.assertEquals(actual,expected,"The file isnt uploaded!");



    }

}
