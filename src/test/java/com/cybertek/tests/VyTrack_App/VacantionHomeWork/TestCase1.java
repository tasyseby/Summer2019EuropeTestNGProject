package com.cybertek.tests.VyTrack_App.VacantionHomeWork;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
public class TestCase1 extends TestBase {


    @Test
    public void testCase1(){
        extentLogger= report.createTest("TestCase1_Jamals homework");
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
        extentLogger.info("Hover over 3 dots icon");
        BrowserUtils.waitFor(3);
        action.moveToElement(calendarEventsPage.threeDots).build().perform();
        BrowserUtils.waitFor(3);
        List<String> expectedOptions = new ArrayList<>();
        expectedOptions.add("View");
        expectedOptions.add("Edit");
        expectedOptions.add("Delete");
        System.out.println(expectedOptions);
        List<String> actualOptions = calendarEventsPage.viewEditDeleteOptions();
        for(int i = 0; i<expectedOptions.size(); i++) {
            Assert.assertEquals(actualOptions.get(i), expectedOptions.get(i), "Verify that actual matches expected");
        }
        System.out.println("Actual is: "+actualOptions);
    }
}