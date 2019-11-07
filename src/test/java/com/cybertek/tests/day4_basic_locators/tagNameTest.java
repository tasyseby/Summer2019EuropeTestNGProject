package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNameTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        driver.manage().window().maximize();

        WebElement findName = driver.findElement(By.tagName("input"));
        findName.sendKeys("Mike Smith with tag");

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("gogosarwithtag@yahoo.com");

        WebElement signUpButtom = driver.findElement(By.tagName("button"));
        signUpButtom.click();

        WebElement printMes = driver.findElement(By.tagName("h3"));
        String message = printMes.getText();
        System.out.println("printMes = " + message);

        System.out.println(driver.findElement(By.tagName("h3")).getText());
    }
}
