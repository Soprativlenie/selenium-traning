package com.jelvix.pages.pageblocks;

import com.jelvix.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsForm extends Page {

    public ContactUsForm(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement fullNameInput;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement workEmailInput;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement messageInput;

    @FindBy(xpath = "//div[@class='input-row']/div[1]//span[@class='fake-input']")
    public WebElement privacyPolicyCheckbox;

    @FindBy(xpath = "//div[@class='input-row']/div[2]")
    public WebElement submitButton;
}
