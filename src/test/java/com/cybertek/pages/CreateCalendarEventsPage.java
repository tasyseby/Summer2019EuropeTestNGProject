package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;
public class CreateCalendarEventsPage extends BasePage {
    public CreateCalendarEventsPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(css = "[id^='recurrence-repeats-view']")
    public WebElement repeatOptions;
    @FindBy(className = "select2-chosen")
    public WebElement selectedOwner;
    @FindBy(css = "input[id^='oro_calendar_event_form_title-']")
    public WebElement title;
    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    public WebElement startDate;
    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end']")
    public WebElement endDate;
    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    public WebElement startTime;
    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    public WebElement endTime;
    @FindBy(xpath = "(//input[@type='radio'])[1]")
    public WebElement days;
    @FindBy(xpath = "(//input[@type='radio'])[2]")
    public WebElement weekday;
    @FindBy(xpath = "(//input[@type='radio'])[3]")
    public WebElement never;
    @FindBy(xpath = "(//input[@type='radio'])[4]")
    public WebElement after;
    @FindBy(xpath = "(//input[@type='radio'])[5]")
    public WebElement by;
    @FindBy (xpath ="//div[@class='btn-group pull-right']/a")
    public WebElement saveAndCloseCreate;
    @FindBy(xpath = "//button[contains(@class,'action-button dropdown-item')]")
    public WebElement saveAndCloseOptions;
    @FindBy(xpath = "//a[@title='Cancel'][@class='btn back icons-holder-text ']")
    public WebElement cancelBtn;
    @FindBy(xpath = "//ul[@class='ui-timepicker-list']/li[text()='9:00 PM']")
    public WebElement ninePmButton;
    @FindBy(css = "[id^='oro_calendar_event_form_allDay']")
    public WebElement alDayCheckbox;
    public Select repeatOptionsList(){
        return new Select(repeatOptions);
        /**
         * This is how we use Select objects in page object model...
         * We locate the dropdown WebElement (repeatOptions -line19 this page)
         * Then we create a method which takes this webElement as a parameter to
         * the constructor and returns me the "select object".
         * "repeatOptionList" is the name of my list, U can name as you wish
         * Now I can apply ready selenium's select class actions/methods
         *   // Note by MI */
    }
    public List<String> SaveAndCloseMenu() {
        List<WebElement> optionsMenu = Driver.get().findElements(By.xpath("//button[contains(@class,'action-button dropdown-item')]"));
        List<String> saveItem = new ArrayList<>();
        for (WebElement item : optionsMenu) {
            saveItem.add(item.getText());
        }
        return saveItem;
    }
}