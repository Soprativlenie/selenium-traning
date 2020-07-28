package com.jelvix.pages.pageblocks;

import com.jelvix.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CookiesBanner extends Page {
    public CookiesBanner(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "cn-accept-cookie")
    public WebElement acceptBtn;

    @FindBy(xpath = "//a[@href='/cookie-policy']")
    public WebElement cookiesLink;

    @FindBy(id = "cookie-notice")
    public WebElement cookiesBanner;

    public void acceptCookiesBanner() {
        acceptBtn.click();
    }

    public boolean isCookiesBannerPresent() {
        return cookiesBanner.getSize().height < 0;
    }

    public void openCookiePolicy() {
        cookiesLink.click();
    }


}
