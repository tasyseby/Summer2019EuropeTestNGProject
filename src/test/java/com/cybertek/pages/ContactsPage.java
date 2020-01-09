package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class ContactsPage extends BasePage {
    //We do not need to create constructor and use PageFactory class here,
    //since we are inheriting from BasePage class
    // #########  WATCH OUT ! ############
    // if you are trying to cme up with dynamic xpath you can not use @FondBt method
//    @FindBy(xpath = "//td[contains(text(),'mbrackstone9@example.com’)][@data-column-label=‘Email’]")
//    public WebElement email;
//    somehow we will have dynamic xpath which will accept email and returns ue dynamically
    //     Create a method that accepts the email as a String, and returns WebElement based on that Email
    public WebElement getContactEmail(String email){
        String emailXpath = "//td[contains(text(),'"+email+"')][@data-column-label='Email']";
        return Driver.get().findElement(By.xpath(emailXpath));
    }
// ####   locating an e-mail from the table #### More robust is better...
//td[contains(text(),'mbrackstone9@example.com')]
//*[contains(text(),'mbrackstone9@example.com')]
//td[contains(text(),'mbrackstone9@example.com’) and @data-column-label=‘Email’]
//td[contains(text(),'mbrackstone9@example.com’)][@data-column-label=‘Email’]
}