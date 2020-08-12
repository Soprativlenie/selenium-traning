package com.jelvix.tests;

import com.jayway.jsonpath.JsonPath;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmokeTest extends TestBase {

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheBlogPage() throws IOException {
        pageBlog.open();
        boolean isHttpCode200 = requestSender.isImagesLinkValid(pageBlog.getAllImagesLinks());
        Assert.assertTrue(isHttpCode200);
    }

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheCaseStudiesPage() throws IOException {
        pageCaseStudies.open();
        boolean isHttpCode200 = requestSender.isImagesLinkValid(pageCaseStudies.getAllImagesLinks());
        Assert.assertTrue(isHttpCode200);
    }

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheCompanyPage() throws IOException {
        pageCompany.open();
        boolean isHttpCode200 = requestSender.isImagesLinkValid(pageCompany.getAllImagesLinks());
        Assert.assertTrue(isHttpCode200);
    }

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheContactUsPage() throws IOException {
        pageContactUs.open();
        boolean isHttpCode200 = requestSender.isImagesLinkValid(pageContactUs.getAllImagesLinks());
        Assert.assertTrue(isHttpCode200);
    }

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheExpertisePage() throws IOException {
        pageExpertise.open();
        boolean isHttpCode200 = requestSender.isImagesLinkValid(pageExpertise.getAllImagesLinks());
        Assert.assertTrue(isHttpCode200);
    }

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheIndustriesPage() throws IOException {
        pageIndustries.open();
        boolean isHttpCode200 = requestSender.isImagesLinkValid(pageIndustries.getAllImagesLinks());
        Assert.assertTrue(isHttpCode200);
    }

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheMainPage() throws IOException {
        pageMain.open();
        boolean isHttpCode200 = requestSender.isImagesLinkValid(pageMain.getAllImagesLinks());
        Assert.assertTrue(isHttpCode200);
    }

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheServicesPage() throws IOException {
        pageServices.open();
        boolean isHttpCode200 = requestSender.isImagesLinkValid(pageServices.getAllImagesLinks());
        Assert.assertTrue(isHttpCode200);
    }

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheTechnologiesPage() throws IOException {
        pageTechnologies.open();
        boolean isHttpCode200 = requestSender.isImagesLinkValid(pageTechnologies.getAllImagesLinks());
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
        navigationTabs.clickIndustriesButton();
        Assert.assertFalse(covidBanner.isDisplayed());
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
        navigationTabs.clickCompanyButton();
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
        pageMain.clickMoreAboutUsButton();
        Assert.assertEquals(pageCompany.getUrl(), page.getCurrentUrl());
    }

    @Ignore // TODO: Fix the method
    public void should_redirectToTheCaseStudiesPage_WhenUserClicksOnButton() {
        pageMain.open();
        covidBanner.close();
        cookiesBanner.acceptCookiesBanner();
        pageMain.clickSeeAllCaseStudiesBtn();
        pageCaseStudies.waitUntilThePageIsLoaded();
        Assert.assertEquals(pageCaseStudies.getUrl(), page.getCurrentUrl());
        Assert.assertTrue(pageCaseStudies.isTitleDisplayed());
    }

    @Ignore //TODO: Wait until the reCaptcha will be disabled
    public void should_sendContactUsForm() {
        pageContactUs.open();
        pageContactUs.fillAllInputWithValidData();
    }

    @Test
    public void should_show30Articles_WhenUserOnThePage() {
        pageBlog.open();
        Assert.assertEquals(30, pageBlog.getNumberOfArticleOnThePage());
    }

    @Test//TODO: THE BEGINNING OF THE REFACTORING
    public void should_showArticleWithTheNewsTag_WhenUserClicksOnTheNewsFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.clickTheFilterButton("News");
        pageBlog.waitUntilLoaderIsDisappearing();
        Assert.assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("NEWS"));
    }

    @Test
    public void should_showArticleWithTheTrendsTag_WhenUserClicksOnTheTrendsFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.clickTheFilterButton("Trends");
        pageBlog.waitUntilLoaderIsDisappearing();
        Assert.assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("TRENDS"));
    }

    @Test
    public void should_showArticleWithTheBusinessTag_WhenUserClicksOnTheBusinessFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.clickTheFilterButton("Business");
        pageBlog.waitUntilLoaderIsDisappearing();
        Assert.assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("BUSINESS"));
    }

    @Test
    public void should_showArticleWithTheEngineeringTag_WhenUserClicksOnTheEngineeringFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.clickTheFilterButton("Engineering");
        pageBlog.waitUntilLoaderIsDisappearing();
        Assert.assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("ENGINEERING"));
    }

    @Test
    public void should_showArticleWithTheDesignTag_WhenUserClicksOnTheDesignFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.clickTheFilterButton("Design");
        pageBlog.waitUntilLoaderIsDisappearing();
        Assert.assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("DESIGN"));
    }

    @Test
    public void should_showArticleWithTheMobileTag_WhenUserClicksOnTheMobileFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.clickTheFilterButton("Mobile");
        pageBlog.waitUntilLoaderIsDisappearing();
        Assert.assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("MOBILE"));
    }

    @Test
    public void should_showArticleWithTheDataScienceTag_WhenUserClicksOnTheDataScienceFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.clickTheFilterButton("Data Science");
        pageBlog.waitUntilLoaderIsDisappearing();
        Assert.assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("DATA SCIENCE"));
    }

    @Test
    public void should_showArticleWithTheBlockchainTag_WhenUserClicksOnTheBlockchainFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.clickTheFilterButton("Blockchain");
        pageBlog.waitUntilLoaderIsDisappearing();
        Assert.assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("BLOCKCHAIN"));
    }

    @Test
    public void should_showArticleWithTheARVRTag_WhenUserClicksOnTheARVRFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.clickTheFilterButton("AR/VR");
        pageBlog.waitUntilLoaderIsDisappearing();
        Assert.assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("AR/VR"));
    }

    @Test
    public void should_showSuccessMessage_WhenUserSubscribingTheNewsletter() {
        String email = "igorvd@mailinator.com";
        pageBlog.subscribeBlogByEmail(email);
        Assert.assertTrue(pageBlog.isSubscriptionSuccessMessageDisplayed());
    }

    @Test
    public void should_verifyThatWelocmeLetterEmailed_WhenUserSubscribeTheNewsLetter() {
        String email = "jelvixsub@mailinator.com";
        pageBlog.subscribeBlogByEmail(email);
        pageMailinator.goToEmailBox(email);
        Assert.assertTrue(pageMailinatorEmailBox.isWelcomeLetterIsEmailed());
    }

    @Test
    public void should_verifyThatSubscriptionPopupAppears_WhenUserIsOnTheSingleBlogPageForTheFirstTime() {
        pageBlog.openTheSingleBlogPage();
        pageSingleBlog.hoverOverTheLastSectionOfTheArticle();
        Assert.assertTrue(pageSingleBlog.isSubscriptionPopupDisplaying());
    }

    @Test
    public void should_verifyThatSocialBlockIsDisplay_WhenUserIsOnTheSingleBlogPage() {
        pageBlog.openTheSingleBlogPage();
        pageBlog.launchThePageWithAcceptedCookies();
        Assert.assertTrue(pageSingleBlog.isSocialBlockDisplaying());
    }

    @Test
    public void should_verifyThatStructureBlockIsDisplaying_WhenUserIsOnTheSingleBlogPage() {
        pageBlog.openTheSingleBlogPage();
        pageBlog.launchThePageWithAcceptedCookies();
        Assert.assertTrue(pageSingleBlog.isStructureBlockDisplaying());
    }

    @Test
    public void should_verifyThatContactUsBottomBlockIsDisplaying_WhenUserIsOnTheSingleBlogPage() {
        pageBlog.openTheSingleBlogPage();
        pageBlog.launchThePageWithAcceptedCookies();
        Assert.assertTrue(pageSingleBlog.isContactUsBottomBlockDisplaying());
    }

    @Test
    public void should_verifyThatReadNextBlockIsDisplaying() {
        pageBlog.openTheSingleBlogPage();
        pageBlog.launchThePageWithAcceptedCookies();
        pageSingleBlog.hoverOverTheLastSectionOfTheArticle();
        Assert.assertTrue(pageSingleBlog.isReadNextBlockDisplaying());
    }

    @Test
    public void shouldCloseSubscribePopUp() {
        pageMain.open();
        pageMain.launchThePageWithAcceptedCookies();
        pageBlog.openTheSingleBlogPage();
        pageSingleBlog.hoverOverTheLastSectionOfTheArticle();
    }

    @Test
    public void shouldCombineIntegrationAndUiTest() throws UnirestException {
        Map<String, Object> fields = new HashMap<>();
        fields.put("action", "blog_option");
        fields.put("blog_option[category]", "trends");
        fields.put("blog_option[role]", "null");
        String json = Unirest.post("https://jelvix.com/wp-admin/admin-ajax.php")
                .fields(fields)
                .asString()
                .getBody();

        List<String> responseHashtags = JsonPath.read(json, "$.posts[*].hashtags[0]");


        System.out.println(responseHashtags);

    }

}
