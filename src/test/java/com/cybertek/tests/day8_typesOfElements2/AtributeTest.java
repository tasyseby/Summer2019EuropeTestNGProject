package com.cybertek.tests.day8_typesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AtributeTest {

    @Test
    public void test1 (){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement radioButton = driver.findElement(By.id("blue"));
        radioButton.getAttribute("name");

        //get the value of name attribute
        System.out.println(radioButton.getAttribute("name"));
        System.out.println(radioButton.getAttribute("id"));

        System.out.println(radioButton.getAttribute("href"));

        //atribute without value (checked)
        //check attribute value is boolean if it is checked it will be true;
        radioButton.getAttribute("checked");

        System.out.println(radioButton.getAttribute("oouterHTML"));

        //3rd way of getting text "innerText";

        System.out.println(radioButton.getAttribute("innerHTML"));




    }
}
