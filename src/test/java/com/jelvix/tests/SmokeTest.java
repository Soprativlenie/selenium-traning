package com.jelvix.tests;

import com.jelvix.pages.pageblocks.*;
import org.junit.Assert;
import org.junit.Test;

public class SmokeTest extends TestBase {
    private ContactUsForm contactUsForm = new ContactUsForm(driver);
    private CookiesBanner cookiesBanner = new CookiesBanner(driver);
    private CovidBanner covidBanner = new CovidBanner(driver);
    private Footer footer = new Footer(driver);
    private NavigationTabs navigationTabs = new NavigationTabs(driver);

    @Test
    public void covidBannerDisplaying() {
        Assert.assertTrue(covidBanner.isDisplayed());
    }
}
