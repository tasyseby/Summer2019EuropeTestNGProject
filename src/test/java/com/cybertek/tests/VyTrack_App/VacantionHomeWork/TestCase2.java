package com.cybertek.tests.VyTrack_App.VacantionHomeWork;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase2 extends TestBase {


    @Test
    public void TestCase2(){
        extentLogger= report.createTest("TestCase2_Jamals homework");
        //first I ll create a LoginPage Object so that I can call the log in methods
        LoginPage loginPage = new LoginPage();
        // my username and password are stored in the configuration.properties folder as String data type
        String userName = ConfigurationReader.get("storemanager_username");
        String passWord = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: "+userName);
        extentLogger.info("password: "+passWord);
        extentLogger.info("Logged in as store manager");
        //call log in method
        loginPage.login(userName,passWord);
        // the method will wait for 3 seconds( BrowserUtils.waitFor(3)
        new CalendarEventsPage().waitUntilLoaderScreenDisappear();
        //Navigate to Activities module->Calendar Event Pages
        //I will create Dashboard object to navigate to the modules
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        extentLogger.info("Select Grid Options");
        BrowserUtils.waitFor(3);
        calendarEventsPage.gridOptions.click();
        BrowserUtils.waitFor(2);

        List<WebElement> list = driver.findElements(By.xpath("//td[@class='visibility-cell']"));
        System.out.println("Number of Total Shown column checkboxes are: " + list.size());

        //In this task I ll have to deselect all options except for "Title//
        //we can deselect all and only select title using for each loop

        extentLogger.info("Deselect all but Title checkbox");
        //first deselect only title checkbox

        calendarEventsPage.titleCheckBox.click();
        BrowserUtils.waitFor(2);

        for(WebElement each: list){
            each.click();
            BrowserUtils.waitFor(1);
        }
        System.out.println(calendarEventsPage.titleCheckBox.isEnabled());

    }
}

