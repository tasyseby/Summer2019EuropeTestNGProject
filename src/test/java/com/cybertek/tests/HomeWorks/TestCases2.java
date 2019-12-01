package com.cybertek.tests.HomeWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases2 {


    WebDriver driver;

    @BeforeMethod
    public void SetUpMethod() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }

    @Test
    public void TestCase1() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com/registration_form");

        WebElement getBirthday = driver.findElement(By.xpath("//input[@placeholder='MM/DD/YYYY']"));
        getBirthday.sendKeys("wrong_dob");
        Thread.sleep(3000);

        WebElement expectedText = driver.findElement(By.xpath("//small[contains(text(),'The date of birth is not valid')]"));
        expectedText.getText();

        String actualText = "The date of birth is not valid";

        if (expectedText.equals(actualText)){
            System.out.println("TEST PASS - the warning message is displayed");
        }else{
            System.out.println("TEST FAILED - the warning message is not displayed");
            System.out.println(expectedText);
        }



    }

    @Test
    public void TestCase2(){
        driver.get("https://practice-cybertekschool.herokuapp.com/registration_form");
        String cplusplus = driver.findElement(By.xpath("//label[contains(text(),'C++')]")).getText();
        String actualcplusplus = "C++";
        String java = driver.findElement(By.xpath("//div[@class='form-group']//div[2]//label[1]")).getText();
        String actualJava = "Java";
        String JavaScript = driver.findElement(By.xpath("//label[contains(text(),'JavaScript')]")).getText();
        String actualJavaScript = "JavaScript";

        if (cplusplus.equals(actualcplusplus) && java.equals(actualJava) && JavaScript.equals(actualJavaScript)){
            System.out.println("TEST PASSED - C++ , java , JavaScript are displayed");
        }else{
            System.out.println("TEST FAILED - One of the programming languages are not displayed");
        }


    }

    @Test
    public void TestCase3(){
        driver.get("https://practice-cybertekschool.herokuapp.com/registration_form");
        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='first name']"));
        firstName.sendKeys("A");
        WebElement firstNameWarning = driver.findElement(By.xpath("//small[contains(text(),'first name must be more than 2 and less than 64 ch')] "));
        firstNameWarning.getText();
        String expectedWarningText = "first name must be more than 2 and less than 64 characters long";

        if (firstNameWarning.equals(expectedWarningText)){
            System.out.println("TEST PASSED ! - first name must be more than 2 and less than 64 characters long - is there");
        }else {
            System.out.println("TEST FAILED ! - first name must be more than 2 and less than 64 characters long - is not there");
            System.out.println(firstNameWarning.getText());
        }
    }

    @Test
    public void TestCase4(){
        driver.get("https://practice-cybertekschool.herokuapp.com/registration_form");
        WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='last name']"));
        lastName.sendKeys("a");
        WebElement actualText = driver.findElement(By.xpath("//small[contains(text(),'The last name must be more than 2 and less than 64')] "));
        String actualmessage = actualText.getText();
        String expectedMessage = "The last name must be more than 2 and less than\n" +
                "64 characters long";
        System.out.println(actualmessage);
        System.out.println(expectedMessage);

        Assert.assertTrue(actualmessage.equals(expectedMessage),"The actual is not the same text displayed");


   }

   @Test
    public void TestCase5() throws InterruptedException {
       driver.get("https://practice-cybertekschool.herokuapp.com/registration_form");

       WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='first name']"));
       firstName.sendKeys("Sebastian");

       WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='last name']"));
       lastName.sendKeys("Tasi");

       WebElement user = driver.findElement(By.xpath("//input[@placeholder='username']"));
       user.sendKeys("tasyseby");

       WebElement email1 = driver.findElement(By.xpath("//input[@placeholder='email@email.com']"));
       email1.sendKeys("greekpsych@yahoo.co.uk");

       WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
       pwd.sendKeys("tasyseby1");

       WebElement tel = driver.findElement(By.xpath("//input[@placeholder='571-000-0000']"));
       tel.sendKeys("745-330-2330");

       WebElement maleRadioButton = driver.findElement(By.xpath("//div[@class='col-sm-5']//div[1]//label[1]//input[1]"));
       WebElement femaleRadioButton = driver.findElement(By.xpath("//div[@class='row']//div[2]//label[1]//input[1]"));
       WebElement otherRadioButton = driver.findElement(By.xpath("//div[3]//label[1]//input[1]"));
       maleRadioButton.click();

       Assert.assertTrue(maleRadioButton.isSelected(),"Male is not selected!");
       Assert.assertFalse(femaleRadioButton.isSelected(),"Female is selected");
       Assert.assertFalse(otherRadioButton.isSelected(),"Other is selected");

        WebElement date = driver.findElement(By.xpath("//input[@placeholder='MM/DD/YYYY']"));
        date.sendKeys("08/23/1985");

       Select department = new Select(driver.findElement(By.xpath("//select[@name='department']")));
       String expectedDepartment = "Department of Engineering";
       String actualDepartment = department.getFirstSelectedOption().getText();

       Thread.sleep(1000);
       department.selectByVisibleText("Department of Engineering");
       actualDepartment = department.getFirstSelectedOption().getText();
       Assert.assertEquals(actualDepartment,expectedDepartment,"Department of Engineering is selected");

       Select jobTitle = new Select( driver.findElement(By.xpath("//select[@name='job_title']")));
       jobTitle.selectByVisibleText("QA");

        WebElement checkbox = driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
        checkbox.click();

        WebElement signin = driver.findElement(By.xpath("//button[@id='wooden_spoon']"));
        signin.click();

        String finalText = driver.findElement(By.xpath("//p[contains(text(),\"You've successfully completed registration!\")] ")).getText();
        String expected = "You've successfully completed registration!";

        Assert.assertEquals(finalText,expected,"You've successfully completed registration! is missing");


   }

}
