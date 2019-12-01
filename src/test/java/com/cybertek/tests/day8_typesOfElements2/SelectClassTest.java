package com.cybertek.tests.day8_typesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectClassTest {

    @Test
    public void test1() throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        //1.locate the dropdown with unique element
       // WebElement dropdownElement = driver.findElement(By.id("state"));


        //create Select object by passing the element as a constructor
        Select stateList = new Select(driver.findElement(By.id("state")));//lazy way

        // verify that first option is "select a state"
        String expectedOption = "Select a State";
        String actualOption = stateList.getFirstSelectedOption().getText();
        System.out.println(actualOption);

        Assert.assertEquals(actualOption,expectedOption,"Verify first selection is a selected state!");

        //how to select options from the drop down?
        //1. using visible text -> selecting based on the visible text


        Thread.sleep(3000);
        //selecting Texas from the list
        stateList.selectByVisibleText("Texas");
        actualOption = stateList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,"Wyoming", "Compare 2nd select");


        //2nd option Using INDEX NUMBER;
        //total option i have 52 states;

        stateList.selectByIndex(51);
        System.out.println(stateList.getFirstSelectedOption().getText());
        Assert.assertEquals(actualOption,"Wyoming");
        Thread.sleep(3000);

        //3.Using Value
        Thread.sleep(3000);
        stateList.selectByValue("VA");
        System.out.println(stateList.getFirstSelectedOption().getText());









    }
}
