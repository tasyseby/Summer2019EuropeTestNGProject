package com.cybertek.tests.day3_webElement_Intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyURLnotChanged {


    /**
     * Verify URL not changed
     * open browser
     * go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
     * click on Retrieve password
     * verify that url did not change
     *
     */

    public static void main(String[] args) throws InterruptedException {

        //open chrome

        WebDriver driver = WebDriverFactory.getDriver("chrome");

         // go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.

        driver.get("http://practice.cybertekschool.com/forgot_password");

        //save URL to string variable

        String expectUrl = driver.getCurrentUrl();


        //  click on Retrieve password

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        String actualUrl = driver.getCurrentUrl();
        //verify that URL is not change
        if (expectUrl.equals(actualUrl)) {
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
            //close browser
        Thread.sleep(5000);
            driver.quit();



    }



}
