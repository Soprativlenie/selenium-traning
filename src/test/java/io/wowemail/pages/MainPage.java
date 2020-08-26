package io.wowemail.pages;/* Created by user on 25.08.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends Page {


    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='banner-section']//img")
    private WebElement previewImage;

    @FindBy(xpath = "//img")
    private List<WebElement> images;

    @FindBy(xpath = "//div[@class='main-text']/a")
    private WebElement orderNowButton;

    @FindBy(id = "name-input")
    private WebElement nameInput;

    @FindBy(id = "email-input")
    private WebElement emailInput;

    @FindBy(id = "message-input")
    private WebElement messageInput;

    @FindBy(xpath = "//button/span[text()='Send']")
    private WebElement sendButton;

    @FindBy(id = "thanks-sent-popup")
    private WebElement successSendingOfGetInTouchFormPopup;

    @FindBy(xpath = "//div[@id='thanks-sent-popup']//button[@title='Close']")
    private WebElement closeIconOnTheSuccessSendingOfGetInTouchPopup;

    @FindBy(xpath = "//div[@id='thanks-sent-popup']//button[text()='Close']")
    private WebElement closeButtonOnTheSuccessSendingOfGetInTouchPopup;

    public MainPage open() {
        driver.navigate().to(Page.host + PageRoutes.MAIN.getRoute());
        return this;
    }

    public boolean isPreviewImageDisplay() {
        return previewImage.isDisplayed();
    }

    public boolean AreAllImagesDisplayingOnTheMainPage() {
        for (WebElement image : images) {
            if (!image.isDisplayed()) {
                System.out.println("The image " + image.getAttribute("src") + " isn't displaying");
                return false;
            }
            System.out.println(image.getAttribute("src"));
        }
        return true;
    }

    public MainPage enterTheNameToTheNameField(String name) {
        nameInput.sendKeys(name);
        return this;
    }

    public MainPage enterTheEmailToTheEmailField(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public MainPage enterTheMessageToTheMessageField(String message) {
        messageInput.sendKeys(message);
        return this;
    }

    public void clickTheSendButton() {
        sendButton.click();
    }

    public boolean isSuccessSendingPopupDisplay() {
        wait.withMessage("Thanks for getting in touch! pop up isn't displaying").until(ExpectedConditions.visibilityOf(successSendingOfGetInTouchFormPopup));
        return successSendingOfGetInTouchFormPopup.isDisplayed();
    }

    public MainPage clickCloseIconOnTheSuccessSendingOfTheGetInTouchPopup() {
        closeIconOnTheSuccessSendingOfGetInTouchPopup.click();
        return this;
    }

    public MainPage clickCloseButtonOnTheSuccessSendingOfTheGetInTouchPopup() {
        closeButtonOnTheSuccessSendingOfGetInTouchPopup.click();
        return this;
    }
}
