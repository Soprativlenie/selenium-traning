package com.jelvix.tests;

import org.junit.Assert;
import org.junit.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class SmokeTest extends TestBase {

    @Test
    public void should_showCovidBanner_When_TheUserTheFirstTimeOnWebSite() {
        mainPage.open();
        Assert.assertTrue(covidBanner.isDisplayed());
    }

    @Test
    public void should_showCookiesBanner_When_TheUserTheFirstTimeOnWebSite() {
        mainPage.open();
        Assert.assertTrue(cookiesBanner.isDisplayed());
    }

    @Test
    public void should_notBeEmptyTheField_WhenUserEnterTheText() throws InterruptedException {
        mainPage.open();
        covidBanner.closeCovidBanner();
        contactUsForm.fullNameInput.sendKeys("Igor");
        Assert.assertEquals("Igor", contactUsForm.fullNameInput.getAttribute("value"));
    }
}
