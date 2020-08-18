package com.jelvix.pages;/* Created by user on 15.07.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContactUsPage extends Page {

    public ContactUsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "contact-name")
    private WebElement fullNameInput;

    @FindBy(id = "contact-company")
    private WebElement companyInput;

    @FindBy(id = "contact-email")
    private WebElement workEmailInput;

    @FindBy(xpath = "//span[@class='jcf-select-text']")
    private WebElement countryDropDown;

    @FindBy(id = "contact-comment")
    private WebElement projectDescriptionTextArea;

    @FindBy(xpath = "//span[@class='fake-input']")
    private WebElement privacyCheckbox;

    @FindBy(xpath = "//span[contains(text(),'Submit Form')]")
    private WebElement submitFormBtn;

    public ContactUsPage open() {
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
