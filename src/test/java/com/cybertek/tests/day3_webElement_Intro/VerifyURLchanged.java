package com.cybertek.tests.day3_webElement_Intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyURLchanged {
    /*
    open browser
    go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
    enter any email
    click on Retrieve password
    verify that url changed to http://practice.cybertekschool.com/email_sent */

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //go to http://practice.cybertekschool.com/forgot_password

        driver.get("http://practice.cybertekschool.com/forgot_password");

        //insert email

        WebElement emailInput = driver.findElement(By.name("email"));
        // sendKeys() - send keyboard actions to the webElement

        emailInput.sendKeys("email@gmail.com");

        WebElement retrivePasswordButton = driver.findElement(By.id("form_submit"));
        retrivePasswordButton.click();

        String expectUrl = "http://practice.cybertekschool.com/email_sent";
        String actualUrl = driver.getCurrentUrl();

        if (expectUrl.equals(actualUrl)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
            System.out.println("actualUrl = " + actualUrl);
            System.out.println("expectUrl = " + expectUrl);
        }


        Thread.sleep(5000);
        driver.quit();

    }
}
