package io.wowemail.pages;/* Created by user on 25.08.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.XMLFormatter;

public class ContactPage extends Page {
    public ContactPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement nameInput;

    @FindBy(id = "user-email")
    private WebElement emailInput;

    @FindBy(id = "user-comment")
    private WebElement messageTextArea;

    @FindBy(xpath = "//div[@class='file-upload']")
    private WebElement attachment;

    @FindBy
    private WebElement privacyCheckbox;

    @FindBy
    private WebElement termsLink;

    @FindBy
    private WebElement reCaptchaLink;

    @FindBy
    private WebElement reCaptchaTermsLink;

    @FindBy
    private WebElement attachmentToolTip;

    @FindBy
    private WebElement sendButton;

    @FindBy
    private WebElement mainImage;

    @FindBy
    private WebElement nameErrorMessage;

    @FindBy
    private WebElement emailErrorMessage;

    @FindBy
    private WebElement textAreaErrorMessage;

    @FindBy
    private WebElement attachmentsErrorMessage;

    @FindBy
    private WebElement successSendingMessage;

    @FindBy
    private WebElement privacyCheckBoxError;

    public ContactPage open() {
        driver.navigate().to(Page.host + PageRoutes.CONTACT.getRoute());
        return this;
    }
}
