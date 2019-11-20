package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amazon {

    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");

        WebElement searchBar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        searchBar.sendKeys("selenium");

        WebElement searchButton = driver.findElement(By.xpath("//input[@tabindex='20']"));

        searchButton.click();

        WebElement results = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])/child::*"));

        String res = results.getText();

        String[] arr = res.split(" ");

        int num = Integer.parseInt(arr[2]);

       System.out.println("Number of results = " + num);

        driver.quit();
    }
}