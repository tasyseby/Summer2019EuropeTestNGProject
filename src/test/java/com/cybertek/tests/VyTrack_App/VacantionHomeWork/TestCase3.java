package com.cybertek.tests.VyTrack_App.VacantionHomeWork;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class TestCase3 extends TestBase {

    @Test
    public void testCase3() {
        extentLogger = report.createTest("TestCase_3  => Save And Close Options");
        //first I ll create a LoginPage Object so that I can call the log in methods
        LoginPage loginPage = new LoginPage();
        // my username and password are stored in the configuration.properties folder as String data type
        String userName = ConfigurationReader.get("storemanager_username");
        String passWord = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: " + userName);
        extentLogger.info("password: " + passWord);
        extentLogger.info("Logged in as store manager");
        //call log in method
        loginPage.login(userName, passWord);
        // the method will wait for 3 seconds( BrowserUtils.waitFor(3)
        new CalendarEventsPage().waitUntilLoaderScreenDisappear();
        //Navigate to Activities module->Calendar Event Pages
        //I will create Dashboard object to navigate to the modules
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Click on / create Calendar events / button");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        //click on "Create calendar events button
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();
        extentLogger.info("expand /save and close /menu");
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.saveAndCloseCreate.click();
        //expand "Save and close" menu -> click
        BrowserUtils.waitFor(3);
        List<String> expectedOptions = new ArrayList<>();
        expectedOptions.add("Save And Close");
        expectedOptions.add("Save And New");
        expectedOptions.add("Save");
        System.out.println(expectedOptions);
        extentLogger.info("Verify tha Save and Close, Save And New and Save options are available");
        List<String> actualOptions = createCalendarEventsPage.SaveAndCloseMenu();
        for (int i = 0; i<expectedOptions.size();i++){
            Assert.assertEquals(actualOptions.get(i),expectedOptions.get(i),"verify that actual matches the expected result");
        }
        System.out.println("Actual is: "+ actualOptions);
    }
}
