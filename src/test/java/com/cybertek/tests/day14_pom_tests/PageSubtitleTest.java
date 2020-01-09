package com.cybertek.tests.day14_pom_tests;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;


/*
Test case
Open browser
Login as a Driver
Verify that page subtitle is Quick Launchpad
Go to Activities -> Calendar Events
verify that page subtitle is Calendar Events
click create calendar events
*/

public class PageSubtitleTest extends TestBase {

    @Test
    public void verifySubtitleTest(){

        LoginPage loginPage = new LoginPage();


        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.login(username,password);

        DashboardPage dashboardPage = new DashboardPage();


        String expectedSubtitle = "Quick Launchpad";
        String actualSubtitle = dashboardPage.getPageSubTitle();
        Assert.assertEquals(actualSubtitle,expectedSubtitle,"Quick Launchpad doesnt match!");


        dashboardPage.navigateToModule("Activities", "Calendar Events");
        //dashboardPage.navigateToModule("Customers", "Accounts");
       // dashboardPage.navigateToModule("System", "Jobs");

        Assert.assertEquals(dashboardPage.getPageSubTitle(),"Calendar Events", "Verify subtitles");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events", "Verify subtitle");











    }
}
