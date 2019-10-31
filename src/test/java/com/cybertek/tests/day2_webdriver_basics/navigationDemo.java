package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class navigationDemo {

    public static void main (String[] args) throws InterruptedException {

        //settings up the browser
        WebDriverManager.chromedriver().setup();

        //import class ctrl + enter or alt enter or control space
        //selenium object

        WebDriver driver = new ChromeDriver();

        //navigate to website
        driver.get("Https://www.amazon.com");
        Thread.sleep(5000);
        Thread.sleep(2000);
        // another way of navigate the website
        driver.navigate().to("https://www.facebook.com");

        //goes back to previous webpage
        driver.navigate().back();

        Thread.sleep(3000);
        //goes forward and back to previous
        driver.navigate().forward();


        //refresh the page!
        driver.navigate().refresh();







    }
}
