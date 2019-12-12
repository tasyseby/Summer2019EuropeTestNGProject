package com.cybertek.tests.day11_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void hoverTest (){
        driver.get("http://practice.cybertekschool.com/hovers");

        //ACTIONS -> CLASS THAT CONTAINS ALL THE USER INTERACTIONS
        //HOW TO CREATE ACTIONS OBJECTS/PASSING DRIVER AS A CONSTRUCTOR

        Actions actions = new Actions(driver);

        WebElement img = driver.findElement(By.tagName("img"));

         //perform () = perform the action;
        //moveToElement move your mouse to webelement hover over
        actions.moveToElement(img).perform();

        Assert.assertTrue(driver.findElement(By.linkText("View profile")).isDisplayed(),"verify the message of the hover over");


    }

    @Test
    public void DragAndDrop(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions actions = new Actions(driver);
        // we drag this element (source)

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        //pause ()-> waiting just like thread.sleep acccepts miliseconds
        actions.pause(1000);

        driver.findElement(By.xpath("//button[.='Accept Cookies']")).click();
        //we have to provide source and target to this method it will drag and edrop
        actions.dragAndDrop(source,target).perform();
    }

    @Test
    public void DragAndDropChaining(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions actions = new Actions(driver);
        // we drag this element (source)

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        //pause ()-> waiting just like thread.sleep acccepts miliseconds
        actions.pause(1000);

        driver.findElement(By.xpath("//button[.='Accept Cookies']")).click();

        //if u are chaining actions we add build () method before perform
        actions.moveToElement(source).clickAndHold().moveToElement(target).release().build().perform();
    }
}
