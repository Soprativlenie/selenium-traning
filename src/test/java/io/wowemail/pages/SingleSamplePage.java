package io.wowemail.pages;/* Created by user on 25.08.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingleSamplePage extends Page {

    public SingleSamplePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='#tab-1']")
    private WebElement webButton;

    @FindBy(xpath = "//a[@href='#tab-2']")
    private WebElement mobileButton;

    @FindBy(id = "tab-1")
    private WebElement webImage;

    @FindBy(id = "tab-2")
    private WebElement mobileImage;

    public SingleSamplePage clickWebButton() {
        webButton.click();
        return this;
    }

    public SingleSamplePage clickMobileButton() {
        mobileButton.click();
        return this;
    }

    public boolean isWebImageDisplay() {
        return webImage.isDisplayed();
    }

    public boolean isMobileImageDisplay() {
        return mobileImage.isDisplayed();
    }


}
