package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void radioButton(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.id("blue"));
        WebElement redRadioButton = driver.findElement(By.id("red"));

        //how to check radio button select or not?

        System.out.println("Is blue selected: " + blueRadioButton.isSelected());
        System.out.println("Is red selected: " + redRadioButton.isSelected());

        Assert.assertTrue(blueRadioButton.isSelected(),"Verify that blue is selected");
        Assert.assertFalse(redRadioButton.isSelected(),"Verifiy that the red button not selected");



        //how to select radio button?
        redRadioButton.click();
        System.out.println("Is blue selected: " + blueRadioButton.isSelected());
        System.out.println("Is red selected: " + redRadioButton.isSelected());
        //verify blue is not selected

        Assert.assertFalse(blueRadioButton.isSelected(),"verify blue is not selected");

        //verify red is selected
        Assert.assertTrue(redRadioButton.isSelected(),"Verify red is selected");

        driver.quit();

    }

}
