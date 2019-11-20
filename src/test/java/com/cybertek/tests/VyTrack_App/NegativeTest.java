package com.cybertek.tests.VyTrack_App;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NegativeTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://qa1.vytrack.com/user/login");

        driver.findElement(By.id("prependedInput")).sendKeys("user100");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123456");

        driver.findElement(By.xpath("//button[1]")).click();


        String title = driver.getTitle();

        System.out.println("title = " + title);

        WebElement errorMessage = driver.findElement(By.xpath("//*[contains(text(),'Invalid user name or password.')]"));
        String errorMessageText = errorMessage.getText();


        if (errorMessage.getText().equals("Invalid user name or password")){

            System.out.println("Negative test failed");
            System.out.println("Error text = "+ errorMessageText);

        }else {

            System.out.println("Negative test passed");
            System.out.println("Error text = "+ errorMessageText);
        }






    }
}
