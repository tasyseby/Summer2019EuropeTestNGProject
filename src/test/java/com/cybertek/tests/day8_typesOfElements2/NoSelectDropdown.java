package com.cybertek.tests.day8_typesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {


    @Test
    public void test1 (){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropdownElement = driver.findElement(By.id("dropdownMenuLink"));

        //Select links = new Select(dropdownElement); unexpected fail

                //open the dropdown
        dropdownElement.click();

        List<WebElement> listofLinks = driver.findElements(By.className("dropdown-item"));
        System.out.println("Number of Links : "  + listofLinks.size());

        System.out.println(listofLinks.get(0).getText());
        //print text of each link

        for (WebElement link : listofLinks) {
            System.out.println("List of link elements :" + link.getText());
        }
        //driver.findElements(By.linkText("Yahoo")).click();

        //or index from the list

        listofLinks.get(1).click();



    }
}
