package com.jelvix.pages.pageblocks;

import com.jelvix.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CookiesBanner extends Page {
    public CookiesBanner(WebDriver driver) {
        super(driver);
    }

    public void acceptCookiesBanner() {
        driver.findElement(By.id("cn-accept-cookie")).click();
    }

    public boolean isDisplayed() {
        return driver.findElement(By.id("cookie-notice")).isDisplayed();
    }

    public void clickCookiesPolicyLabel() {
        driver.findElement(By.xpath("//a[@href='/cookie-policy']")).click();
    }
}
