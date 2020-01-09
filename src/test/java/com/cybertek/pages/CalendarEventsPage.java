package com.cybertek.pages;


import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;
public class CalendarEventsPage extends BasePage {
    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;
    @FindBy(xpath = "//td[text()='Testers meeting']//parent::tr//td[9]")
    public WebElement threeDots;
    @FindBy(xpath = "//td[text()='Testers meeting']//parent::tr//td[9]/div/div/ul/li/ul/li/a")
    public WebElement view;
    @FindBy(xpath = "//i[@class='fa-cog hide-text']")
    public WebElement gridOptions;
    @FindBy(xpath = "//td[@class='visibility-cell']")
    public WebElement gridCheckBoxes;
    @FindBy(xpath = "//label[contains(text(),'Title')]")
    public WebElement titleCheckBox;

    public List<String> viewEditDeleteOptions() {
        List<WebElement> viewEditMenu = Driver.get().findElements(By.xpath("//ul[@class = 'nav nav-pills icons-holder launchers-list']/li/a"));
        List<String> saveItem = new ArrayList<>();
        for (WebElement item : viewEditMenu) {
            saveItem.add(item.getAttribute("title"));
        }
        return saveItem;
    }
//    @FindBy("")
//    public WebElement edit;
//
//    @FindBy("")
//    public WebElement delete;
}