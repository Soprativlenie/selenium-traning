package com.jelvix.pages;/* Created by user on 15.07.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Page_ContactUs extends Page {

    public Page_ContactUs(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "contact-name")
    public WebElement fullNameInput;

    @FindBy(id = "contact-company")
    public WebElement companyInput;

    @FindBy(id = "contact-email")
    public WebElement workEmailInput;

    @FindBy(xpath = "//span[@class='jcf-select-text']")
    public WebElement countryDropDown;

    @FindBy(id = "contact-comment")
    public WebElement projectDescriptionTextArea;

    @FindBy(xpath = "//span[@class='fake-input']")
    public WebElement privacyCheckbox;

    @FindBy(xpath = "//span[contains(text(),'Submit Form')]")
    public WebElement submitFormBtn;

    public Page_ContactUs open() {
        driver.get(Page.getHost()+ PagePaths.CONTACT_US.getLink());
        return this;
    }

    public void fillAllInputWithValidData() {
        fullNameInput.sendKeys("Igor Vdovichenko Test");
        companyInput.sendKeys("Jelvix Test");
        workEmailInput.sendKeys("igor.vdovichenko@jelvix.com");
        projectDescriptionTextArea.sendKeys("Test Test Test Test Test");
        privacyCheckbox.click();
        submitFormBtn.click();
    }

}
