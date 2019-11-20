package com.cybertek.tests.day7_TestNG;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals("one","ones","Salut");

        System.out.println("Second assertion");
        Assert.assertEquals("title","title");

        System.out.println("after second assertion");
    }

    @Test
    public void test2(){
        //verify that title starts with C

        String actualTitle = "Cybertek";
        String expectedTitle = "B";
       // Assert.assertEquals(actualTitle,expectedTitle);

        //actualTitle.startsWith(expectedTitle);
        System.out.println("First assertion");
        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"Verify title starts with C");


    }

    @Test
    public void test3(){
       // Assert.assertTrue("yasinmail".contains("@"),"Verify if @ exist! ");
        Assert.assertNotEquals("one","two");

    }

    @Test
    public void test4(){
        Assert.assertFalse(1<0,"this conditition is false");
    }
}
