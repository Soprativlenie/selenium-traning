package io.wowemail.pages;/* Created by user on 25.08.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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

    @FindBy(id = "agree-NDA")
    private WebElement privacyCheckbox;

    @FindBy(xpath = "//a[@class='text-link cookie-link']")
    private WebElement termsLink;

    @FindBy(xpath = "//span[@class='captcha-text']//a[1]")
    private WebElement reCaptchaPrivacyLink;

    @FindBy(xpath = "//span[@class='captcha-text']//a[2]")
    private WebElement reCaptchaTermsLink;

    @FindBy(css = "span.icon-question")
    private WebElement attachmentToolTip;

    @FindBy(xpath = "//button/span[text()='Send']")
    private WebElement sendButton;

    @FindBy(xpath = "//div[@class='banner-section compact']//img")
    private WebElement mainImage;

    @FindBy(xpath = "//input[@id='user-name']/following-sibling::span")
    private WebElement nameInputErrorMessage;

    @FindBy(xpath = "//input[@id='user-email']/following-sibling::span")
    private WebElement emailInputErrorMessage;

    @FindBy(xpath = "//textarea[@id='user-comment']/following-sibling::span")
    private WebElement textAreaErrorMessage;

    @FindBy(xpath = "//input[@id='multi']/following-sibling::span")
    private WebElement attachmentsErrorMessage;

    @FindBy(xpath = "//div[@class='contact-text contact-text-success']")
    private WebElement successSendingMessage;

    @FindBy(xpath = "//input[@id='agree-NDA']/following-sibling::span")
    private WebElement privacyCheckBoxError;

    public ContactPage open() {
        driver.navigate().to(Page.host + PageRoutes.CONTACT.getRoute());
        return this;
    }
}
