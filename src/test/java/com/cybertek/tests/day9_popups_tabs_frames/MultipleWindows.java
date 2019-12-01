package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {


    WebDriver driver;

    @BeforeMethod
    public void SetUpMethod() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test1() {


        driver.get("http://practice.cybertekschool.com/windows");

        System.out.println("Before clicking the link  :" + driver.getTitle());

        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("After clicking the link  :" + driver.getTitle());
        //code for switching windows we have to pass handle
        //driver.switchTo().window();

        String currentWindowsHandle = driver.getWindowHandle();// this returns some unique code belongs the windows

        System.out.println("currentWindowsHandle = " + currentWindowsHandle);
        //Set is just like arrayList but without dublicate values;

        //****************************************************************
        Set<String> windowHandles = driver.getWindowHandles();
        //how many dif handles it is keeping
        System.out.println(windowHandles.size());

        //the prob is how we get new window handle from a set of handles there is no index

        for (String handle : windowHandles) {

            if (!currentWindowsHandle.equals(handle)) {
                driver.switchTo().window(handle);

            }

            System.out.println("After switching " + driver.getTitle());

        }

    }

    @Test
    public void moreThan2Windows(){
        driver.get("http://practice.cybertekschool.com/windows");
        String targetWindowTitle = "New Window";
        driver.findElement(By.linkText("Click Here")).click();
        //check how many windows we have
        System.out.println(driver.getWindowHandles().size());
        Set<String> windowHandles= driver.getWindowHandles();
        //we will keep switching windows until our title equals to targetWindowTitle.
        for (String handle : windowHandles) {
            //switch them one by one
            driver.switchTo().window(handle);
            //checking if the window title equals to my target window title
            if(driver.getTitle().equals(targetWindowTitle)){
                //if they are equal stop looping.I want to keep that window driver.
                break;
            }
        }
        System.out.println("After loop title is : "+driver.getTitle());
    }







    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }
}
