package com.cybertek.tests.HomeWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase6 {


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
    public void TestCase6 () throws InterruptedException {
        driver.get("https://www.tempmailaddress.com/");
        String tempEmail = driver.findElement(By.xpath("//span[@id='email']")).getText();
        System.out.println("Your tempEmail is :" + tempEmail);

        driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
        WebElement signup = driver.findElement(By.xpath("//a[contains(text(),'Sign Up For Mailing List')]"));
        signup.click();

        WebElement validName = driver.findElement(By.xpath("//input[@name='full_name']"));
        validName.sendKeys("Sebastianos");
        WebElement validEmail = driver.findElement(By.xpath("//input[@name='email']"));
        validEmail.sendKeys(tempEmail);
        WebElement signIn = driver.findElement(By.xpath("//button[@name='wooden_spoon']"));
        signIn.click();

        String expectedText = "Thank you for signing up. Click the button below to return to the home page.";
        String actualText = driver.findElement(By.xpath("//h3[@name='signup_message']")).getText();
        Assert.assertEquals(actualText,expectedText,"The confirmation message is not there");
        System.out.println(expectedText);

        driver.get("https://www.tempmailaddress.com/");
        Thread.sleep(2000);

        WebElement checkEmail = driver.findElement(By.xpath("//td[@class='col-xs-9 mobileFrom']"));
        checkEmail.click();
        Thread.sleep(2000000);

        WebElement expectedEmail = driver.findElement(By.xpath("//span[contains(text(),'do-not-reply@practice.cybertekschool.com')]"));
        expectedEmail.click();
        Thread.sleep(2000);


        driver.switchTo().frame("iframeMail");

        WebElement checkEmail2 = driver.findElement(By.xpath("//iframe[@id='iframeMail']"));


        String checkingEmail = checkEmail2.getText();
        String expectedEmail2 = "Thanks for subscribing to practice.cybertekschool.com!";

        if (checkingEmail.contains(expectedEmail2)){
            System.out.println("TEST PASSED THE EMAIL CONTAINS - “Thanks for subscribing to practice.cybertekschool.com!” ");
        }else {
            System.out.println("TEST FAILED THE EMAIL DOESNT CONTAIN - “Thanks for subscribing to practice.cybertekschool.com!”");
            System.out.println(checkingEmail);
        }









    }

}
