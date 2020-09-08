package com.jelvix.pages.pageblocks;

import com.jelvix.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


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
        wait.withMessage("The cookies banner is hide").until(ExpectedConditions.visibilityOf(cookiesBanner));
        System.out.println(cookiesBanner.getSize().width);
        System.out.println(cookiesBanner.getSize().height);
        return cookiesBanner.getSize().height > 0;

    }

    public void openCookiePolicy() {
        cookiesLink.click();
    }


}
