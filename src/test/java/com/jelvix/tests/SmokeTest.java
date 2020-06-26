package com.jelvix.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.FindBy;

public class SmokeTest extends TestBase {

    @Test
    public void should_showCovidBanner_When_TheUserTheFirstTimeOnWebSite() {
        pageMain.open();
        Assert.assertTrue(covidBanner.isDisplayed());
    }

    @Test
    public void shouldNot_displayedCovidBanner_WhenUserClosesIt() {
        pageMain.open();
        covidBanner.close();
        navigationTabs.industriesBtn.click();
        Assert.assertTrue(!covidBanner.isDisplayed());
    }

    @Test
    public void should_showCookiesBanner_When_TheUserTheFirstTimeOnWebSite() {
        pageMain.open();
        Assert.assertTrue(cookiesBanner.isCookiesBannerPresent());
    }

    @Test
    public void shouldNot_displayedTheCookiesBanner_WhenUserAcceptIt() {
        pageMain.open();
        cookiesBanner.acceptCookiesBanner();
        navigationTabs.companyBtn.click();
        Assert.assertFalse(cookiesBanner.isCookiesBannerPresent());
    }

    @Test
    public void should_notBeEmptyTheField_WhenUserEnterTheText() {
        pageMain.open();
        covidBanner.close();
        contactUsForm.fullNameInput.sendKeys("Igor");
        Assert.assertEquals("Igor", contactUsForm.fullNameInput.getAttribute("value"));
    }

    @Test
    public void should_redirectToTheCompanyPage_WhenUserClicksOnButton() {
        pageMain.open();
        covidBanner.close();
        cookiesBanner.acceptCookiesBanner();
        pageMain.moreAboutUsBtn.click();
        Assert.assertEquals(pageCompany.getUrl(), page.getCurrentUrl());
    }

    @Test // The test should be fixed
    public void should_redirectToTheCaseStudiesPage_WhenUserClicksOnButton() {
        pageMain.open();
        covidBanner.close();
        cookiesBanner.acceptCookiesBanner();
        pageMain.clickSeeAllCaseStudiesBtn();
        pageCaseStudies.waitUntilThePageIsLoaded();
        Assert.assertEquals(pageCaseStudies.getUrl(), page.getCurrentUrl());
        Assert.assertTrue(pageCaseStudies.titleOfThePage.isDisplayed());
    }


}
