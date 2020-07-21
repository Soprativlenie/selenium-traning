package com.jelvix.tests;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

public class SmokeTest extends TestBase {

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheBlogPage() throws IOException {
        pageBlog.open();
        boolean isHttpCode200 = requestSender.isImagesLinkValid(pageBlog.getAllImagesWithSrcAttr());
        Assert.assertTrue(isHttpCode200);
    }

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheCaseStudiesPage() throws IOException {
        pageCaseStudies.open();
        boolean isHttpCode200 = requestSender.isImagesLinkValid(pageCaseStudies.getAllImagesWithSrcAttr());
        Assert.assertTrue(isHttpCode200);
    }

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheCompanyPage() throws IOException {
        pageCompany.open();
        boolean isHttpCode200 = requestSender.isImagesLinkValid(pageCompany.getAllImagesWithSrcAttr());
        Assert.assertTrue(isHttpCode200);
    }

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheContactUsPage() throws IOException {
        pageContactUs.open();
        boolean isHttpCode200 = requestSender.isImagesLinkValid(pageContactUs.getAllImagesWithSrcAttr());
        Assert.assertTrue(isHttpCode200);
    }

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheExpertisePage() throws IOException {
        pageExpertise.open();
        boolean isHttpCode200 = requestSender.isImagesLinkValid(pageExpertise.getAllImagesWithSrcAttr());
        Assert.assertTrue(isHttpCode200);
    }

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheIndustriesPage() throws IOException {
        pageIndustries.open();
        boolean isHttpCode200 = requestSender.isImagesLinkValid(pageIndustries.getAllImagesWithSrcAttr());
        Assert.assertTrue(isHttpCode200);
    }

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheMainPage() throws IOException {
        pageMain.open();
        boolean isHttpCode200 = requestSender.isImagesLinkValid(pageMain.getAllImagesWithSrcAttr());
        Assert.assertTrue(isHttpCode200);
    }

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheServicesPage() throws IOException {
        pageServices.open();
        boolean isHttpCode200 = requestSender.isImagesLinkValid(pageServices.getAllImagesWithSrcAttr());
        Assert.assertTrue(isHttpCode200);
    }

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheTechnologiesPage() throws IOException {
        pageTechnologies.open();
        boolean isHttpCode200 = requestSender.isImagesLinkValid(pageTechnologies.getAllImagesWithSrcAttr());
        Assert.assertTrue(isHttpCode200);
    }

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

    @Ignore // The test should be fixed
    public void should_redirectToTheCaseStudiesPage_WhenUserClicksOnButton() {
        pageMain.open();
        covidBanner.close();
        cookiesBanner.acceptCookiesBanner();
        pageMain.clickSeeAllCaseStudiesBtn();
        pageCaseStudies.waitUntilThePageIsLoaded();
        Assert.assertEquals(pageCaseStudies.getUrl(), page.getCurrentUrl());
        Assert.assertTrue(pageCaseStudies.titleOfThePage.isDisplayed());
    }

    @Ignore //doesn't work due to recaptcha
    public void should_sendContactUsForm() {
        pageContactUs.open();
        pageContactUs.fillAllInputWithValidData();
    }

    @Test
    public void should_show30Articles_WhenUserOnThePage() {
        pageBlog.open();
        Assert.assertEquals(30, pageBlog.getNumberOfArticleOnThePage());
    }

    @Test
    public void should_showArticleWithTheNewsTag_WhenUserClicksOnTheNewsFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.newsFilterBtn.click();
        pageBlog.waitUntilLoaderIsDisappearing();
        Assert.assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("NEWS"));
    }

    @Test
    public void should_showArticleWithTheTrendsTag_WhenUserClicksOnTheTrendsFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.trendsFilterBtn.click();
        pageBlog.waitUntilLoaderIsDisappearing();
        Assert.assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("TRENDS"));
    }

    @Test
    public void should_showArticleWithTheBusinessTag_WhenUserClicksOnTheBusinessFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.businessFilterBtn.click();
        pageBlog.waitUntilLoaderIsDisappearing();
        Assert.assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("BUSINESS"));
    }

    @Test
    public void should_showArticleWithTheEngineeringTag_WhenUserClicksOnTheEngineeringFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.engineeringFilterBtn.click();
        pageBlog.waitUntilLoaderIsDisappearing();
        Assert.assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("ENGINEERING"));
    }

    @Test
    public void should_showArticleWithTheDesignTag_WhenUserClicksOnTheDesignFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.designFilterBtn.click();
        pageBlog.waitUntilLoaderIsDisappearing();
        Assert.assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("DESIGN"));
    }

    @Test
    public void should_showArticleWithTheMobileTag_WhenUserClicksOnTheMobileFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.mobileFilterBtn.click();
        pageBlog.waitUntilLoaderIsDisappearing();
        Assert.assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("MOBILE"));
    }

    @Test
    public void should_showArticleWithTheDataScienceTag_WhenUserClicksOnTheDataScienceFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.dataScienceFilterBtn.click();
        pageBlog.waitUntilLoaderIsDisappearing();
        Assert.assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("DATA SCIENCE"));
    }

    @Test
    public void should_showArticleWithTheBlockchainTag_WhenUserClicksOnTheBlockchainFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.blockchainFilterBtn.click();
        pageBlog.waitUntilLoaderIsDisappearing();
        Assert.assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("BLOCKCHAIN"));
    }

    @Test
    public void should_showArticleWithTheARVRTag_WhenUserClicksOnTheARVRFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.arVrFilterBtn.click();
        pageBlog.waitUntilLoaderIsDisappearing();
        Assert.assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("AR/VR"));

    }

}
