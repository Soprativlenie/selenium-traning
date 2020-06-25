package com.jelvix.tests;

import org.junit.Assert;
import org.junit.Test;

public class SmokeTest extends TestBase {

    @Test
    public void should_showCovidBanner_When_TheUserTheFirstTimeOnWebSite() {
        pageMain.open();
        Assert.assertTrue(covidBanner.isDisplayed());
    }

    @Test
    public void should_showCookiesBanner_When_TheUserTheFirstTimeOnWebSite() {
        pageMain.open();
        Assert.assertTrue(cookiesBanner.isDisplayed());
    }

    @Test
    public void should_notBeEmptyTheField_WhenUserEnterTheText() throws InterruptedException {
        pageMain.open();
        covidBanner.close();
        contactUsForm.fullNameInput.sendKeys("Igor");
        Assert.assertEquals("Igor", contactUsForm.fullNameInput.getAttribute("value"));
    }

    @Test
    public void should_redirectToTheCompanyPage_WhenUserClicksOnButton() {
        pageMain.open();
        covidBanner.close();
        pageMain.moreAboutUsBtn.click();

        Assert.assertEquals(pageCompany.getUrl(), pageMain.getCurrentUrl());
    }

}
