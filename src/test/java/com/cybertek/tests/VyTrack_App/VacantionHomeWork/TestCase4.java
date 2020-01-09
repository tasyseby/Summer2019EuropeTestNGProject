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

public class TestCase4 extends TestBase {

    @Test
    public void TestCase4(){
        extentLogger = report.createTest("TestCase_4  => Cancel and get page Subtitle");
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
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Click Cancel Button");
        //clic on Cancel button on the CreateCalendarEvens button
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.cancelBtn.click();
        BrowserUtils.waitFor(2);
        extentLogger.info("Verify that page subtitle is displayed ");
        String expectedTitle = "All Calendar Events";
        String actualTitle = calendarEventsPage.pageSubTitle.getText();
        Assert.assertEquals(actualTitle,expectedTitle, "Verify that page subtitile is /All Calendar Events/");
    }

}
