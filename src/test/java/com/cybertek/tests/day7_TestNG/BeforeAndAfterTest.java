package com.cybertek.tests.day7_TestNG;


import org.testng.annotations.*;

public class BeforeAndAfterTest {

    @Test
    public void test1 (){

        System.out.println("This is Test_1_!");
    }



    @BeforeMethod  public void setUpMethod (){

        System.out.println("BEFORE METHOD ");
        System.out.println("OPENING THE BROWSER");
    }
    @Ignore
    @Test
    public void test2() {
        System.out.println("THis is second test");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("CLOSE THE BROWSER");
    }


    @Test
    public void test3 (){
        System.out.println("THis is my test three");
    }

    @BeforeClass
    public void beforeEverything (){
        System.out.println("BEFORE CLASS CODE");
    }

    @AfterClass
    public  void afterClass(){
        System.out.println("AFTER CLASS CODE");
        System.out.println("REPORTING");
    }





}
