package com.cybertek.pages;


import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {
    public LoginPage(){   // we create a public constructor and call pageFactory class from selenium
        // here we call PageFactory class from selenium and (after init elements method)
        // we pass 2 parameters  1==> Driver.get()  2==> "this"  keyword
        // below line gives us access to ready selenium methods...
        PageFactory.initElements(Driver.get(), this);
    }
    //    @FindAll({  //  gives us to put multiple options to locate same webelement  works with OR logic
//            // if any of the given @FindBy is matched then locates the element
//// for example if the element is dynamic and changes 3 different id value (we can put them all)
//            @FindBy(id = "prependedInput"),
//            @FindBy(xpath = "_username")
//    })
//
//    @FindBys({  //  gives us to put multiple options to locate same webelement but works with AND logic
//                //      AND logic means all the FindBy should be matched
//            @FindBy(id = "prependedInput"),
//            @FindBy(xpath = "_username")
//    })
    @FindBy(id = "prependedInput")    // @FindBy ==> is a annotation by selenium, used to provide
    //@FindBy(name = "_username") works as well                     // locator for the element
    public WebElement usernameInput;
    @FindBy(id = "prependedInput2")   // any of the 8 locators work here
    public WebElement passwordInput;
    @FindBy( id="_submit")
    public WebElement loginBtn;
    public void login(String usernameStr, String passwordStr){
        usernameInput.sendKeys(usernameStr);
        passwordInput.sendKeys(passwordStr);
        loginBtn.click();
    }
}