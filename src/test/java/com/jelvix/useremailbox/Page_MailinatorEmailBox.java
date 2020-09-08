package com.jelvix.useremailbox;/* Created by user on 22.07.20 */

import com.jelvix.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_MailinatorEmailBox extends Page {
    public Page_MailinatorEmailBox(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tbody/tr[1]//td[3]") //   //tbody/tr[1]/td[@class='ng-binding'][2]
    public WebElement addressOfTheSenderOfTheFirstLetterInEmailBox;

    @FindBy(xpath = "//tbody/tr[1]//td[4]") // //tbody/tr[1]//a[@class='ng-binding']
    public WebElement subjectOfTheFirstLetterInEmailBox;

    @FindBy(xpath = "//tbody/tr[1]//td[5]")  //tbody/tr[1]//a[@class='ng-binding']
    public WebElement timeOfTheReceived;

    public boolean isWelcomeLetterIsEmailed() {
        return addressOfTheSenderOfTheFirstLetterInEmailBox.getText().equalsIgnoreCase("jelvix.com") &&
                subjectOfTheFirstLetterInEmailBox.getText().equalsIgnoreCase("Welcome to Jelvix newsletter!") &&
                timeOfTheReceived.getText().equalsIgnoreCase("moments ago");

    }
}
