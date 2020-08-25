package com.jelvix.tests;

import com.jayway.jsonpath.JsonPath;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class SmokeTest extends TestBase {

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheBlogPage() throws IOException {
        pageBlog.open();
        boolean isHttpCodeSuccess = requestSender.isImagesLinkValid(pageBlog.getAllImagesLinks());
        assertTrue(isHttpCodeSuccess);
    }

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheCaseStudiesPage() throws IOException {
        pageCaseStudies.open();
        boolean isHttpCodeSuccess = requestSender.isImagesLinkValid(pageCaseStudies.getAllImagesLinks());
        assertTrue(isHttpCodeSuccess);
    }

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheCompanyPage() throws IOException {
        pageCompany.open();
        boolean isHttpCodeSuccess = requestSender.isImagesLinkValid(pageCompany.getAllImagesLinks());
        assertTrue(isHttpCodeSuccess);
    }

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheContactUsPage() throws IOException {
        pageContactUs.open();
        boolean isHttpCodeSuccess = requestSender.isImagesLinkValid(pageContactUs.getAllImagesLinks());
        assertTrue(isHttpCodeSuccess);
    }

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheExpertisePage() throws IOException {
        pageExpertise.open();
        boolean isHttpCodeSuccess = requestSender.isImagesLinkValid(pageExpertise.getAllImagesLinks());
        assertTrue(isHttpCodeSuccess);
    }

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheIndustriesPage() throws IOException {
        pageIndustries.open();
        boolean isHttpCodeSuccess = requestSender.isImagesLinkValid(pageIndustries.getAllImagesLinks());
        assertTrue(isHttpCodeSuccess);
    }

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheMainPage() throws IOException {
        pageMain.open();
        boolean isHttpCodeSuccess = requestSender.isImagesLinkValid(pageMain.getAllImagesLinks());
        assertTrue(isHttpCodeSuccess);
    }

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheServicesPage() throws IOException {
        pageServices.open();
        boolean isHttpCodeSuccess = requestSender.isImagesLinkValid(pageServices.getAllImagesLinks());
        assertTrue(isHttpCodeSuccess);
    }

    @Test
    public void should_verifyThatAllImagesAreNotBroken_OnTheTechnologiesPage() throws IOException {
        pageTechnologies.open();
        boolean isHttpCodeSuccess = requestSender.isImagesLinkValid(pageTechnologies.getAllImagesLinks());
        assertTrue(isHttpCodeSuccess);
    }

    @Test
    public void should_showCovidBanner_When_TheUserTheFirstTimeOnWebSite() {
        pageMain.open();
        assertTrue(covidBanner.isDisplayed());
    }

    @Test
    public void shouldNot_displayedCovidBanner_WhenUserClosesIt() {
        pageMain.open();
        covidBanner.close();
        navigationTabs.clickIndustriesButton();
        assertFalse(covidBanner.isDisplayed());
    }

    @Test
    public void should_showCookiesBanner_When_TheUserTheFirstTimeOnWebSite() {
        pageMain.open();
        assertTrue(cookiesBanner.isCookiesBannerPresent());
    }

    @Test
    public void shouldNot_displayedTheCookiesBanner_WhenUserAcceptIt() {
        pageMain.open();
        cookiesBanner.acceptCookiesBanner();
        navigationTabs.clickCompanyButton();
        assertFalse(cookiesBanner.isCookiesBannerPresent());
    }

    @Test
    public void should_notBeEmptyTheField_WhenUserEnterTheText() {
        pageMain.open();
        covidBanner.close();
        contactUsForm.fullNameInput.sendKeys("Igor");
        assertEquals("Igor", contactUsForm.fullNameInput.getAttribute("value"));
    }

    @Test
    public void should_redirectToTheCompanyPage_WhenUserClicksOnButton() {
        pageMain.open();
        covidBanner.close();
        cookiesBanner.acceptCookiesBanner();
        pageMain.clickMoreAboutUsButton();
        assertEquals(pageCompany.getUrl(), page.getCurrentUrl());
    }

    @Ignore() // TODO: Fix the method
    public void should_redirectToTheCaseStudiesPage_WhenUserClicksOnButton() {
        pageMain.open();
        covidBanner.close();
        cookiesBanner.acceptCookiesBanner();
        pageMain.clickSeeAllCaseStudiesBtn();
        pageCaseStudies.waitUntilThePageIsLoaded();
        assertEquals(pageCaseStudies.getUrl(), page.getCurrentUrl());
        assertTrue(pageCaseStudies.isTitleDisplayed());
    }

    @Ignore("Unreachable due to ReCaptcha")
    public void should_sendContactUsForm() {
        pageContactUs.open();
        pageContactUs.fillAllInputWithValidData();
    }

    @Test
    public void should_show30Articles_WhenUserOnThePage() {
        pageBlog.open();
        assertEquals(30, pageBlog.getNumberOfArticleOnThePage());
    }

    @Test//TODO: THE BEGINNING OF THE REFACTORING
    public void should_showArticleWithTheNewsTag_WhenUserClicksOnTheNewsFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.clickTheFilterButton("News");
        pageBlog.waitUntilLoaderIsDisappearing();
        assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("NEWS"));
    }

    @Test
    public void should_showArticleWithTheTrendsTag_WhenUserClicksOnTheTrendsFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.clickTheFilterButton("Trends");
        pageBlog.waitUntilLoaderIsDisappearing();
        assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("TRENDS"));
    }

    @Test
    public void should_showArticleWithTheBusinessTag_WhenUserClicksOnTheBusinessFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.clickTheFilterButton("Business");
        pageBlog.waitUntilLoaderIsDisappearing();
        assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("BUSINESS"));
    }

    @Test
    public void should_showArticleWithTheEngineeringTag_WhenUserClicksOnTheEngineeringFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.clickTheFilterButton("Engineering");
        pageBlog.waitUntilLoaderIsDisappearing();
        assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("ENGINEERING"));
    }

    @Test
    public void should_showArticleWithTheDesignTag_WhenUserClicksOnTheDesignFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.clickTheFilterButton("Design");
        pageBlog.waitUntilLoaderIsDisappearing();
        assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("DESIGN"));
    }

    @Test
    public void should_showArticleWithTheMobileTag_WhenUserClicksOnTheMobileFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.clickTheFilterButton("Mobile");
        pageBlog.waitUntilLoaderIsDisappearing();
        assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("MOBILE"));
    }

    @Test
    public void should_showArticleWithTheDataScienceTag_WhenUserClicksOnTheDataScienceFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.clickTheFilterButton("Data Science");
        pageBlog.waitUntilLoaderIsDisappearing();
        assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("DATA SCIENCE"));
    }

    @Test
    public void should_showArticleWithTheBlockchainTag_WhenUserClicksOnTheBlockchainFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.clickTheFilterButton("Blockchain");
        pageBlog.waitUntilLoaderIsDisappearing();
        assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("BLOCKCHAIN"));
    }

    @Test
    public void should_showArticleWithTheARVRTag_WhenUserClicksOnTheARVRFilterBtn() {
        pageBlog.open();
        pageBlog.hoverOnTheCategoryBar();
        pageBlog.clickTheFilterButton("AR/VR");
        pageBlog.waitUntilLoaderIsDisappearing();
        assertTrue(pageBlog.isAllArticlesSortedByCorrectTag("AR/VR"));
    }

    @Test
    public void should_showSuccessMessage_WhenUserSubscribingTheNewsletter() {
        String email = "igorvd@mailinator.com";
        pageBlog.subscribeBlogByEmail(email);
        assertTrue(pageBlog.isSubscriptionSuccessMessageDisplayed());
    }

    @Test
    public void should_verifyThatWelocmeLetterEmailed_WhenUserSubscribeTheNewsLetter() {
        String email = "jelvixsub@mailinator.com";
        pageBlog.subscribeBlogByEmail(email);
        pageMailinator.goToEmailBox(email);
        assertTrue(pageMailinatorEmailBox.isWelcomeLetterIsEmailed());
    }

    @Test
    public void should_verifyThatSubscriptionPopupAppears_WhenUserIsOnTheSingleBlogPageForTheFirstTime() {
        pageBlog.openTheSingleBlogPage();
        pageSingleBlog.hoverOverTheLastSectionOfTheArticle();
        assertTrue(pageSingleBlog.isSubscriptionPopupDisplaying());
    }

    @Test
    public void should_verifyThatSocialBlockIsDisplay_WhenUserIsOnTheSingleBlogPage() {
        pageBlog.openTheSingleBlogPage();
        pageBlog.launchThePageWithAcceptedCookies();
        assertTrue(pageSingleBlog.isSocialBlockDisplaying());
    }

    @Test
    public void should_verifyThatStructureBlockIsDisplaying_WhenUserIsOnTheSingleBlogPage() {
        pageBlog.openTheSingleBlogPage();
        pageBlog.launchThePageWithAcceptedCookies();
        assertTrue(pageSingleBlog.isStructureBlockDisplaying());
    }

    @Test
    public void should_verifyThatContactUsBottomBlockIsDisplaying_WhenUserIsOnTheSingleBlogPage() {
        pageBlog.openTheSingleBlogPage();
        pageBlog.launchThePageWithAcceptedCookies();
        assertTrue(pageSingleBlog.isContactUsBottomBlockDisplaying());
    }

    @Test
    public void should_verifyThatReadNextBlockIsDisplaying_WhenUserIsOnTheSingleBlogPage() {
        pageBlog.openTheSingleBlogPage();
        pageBlog.launchThePageWithAcceptedCookies();
        pageSingleBlog.hoverOverTheLastSectionOfTheArticle();
        assertTrue(pageSingleBlog.isReadNextBlockDisplaying());
    }


    @Test
    public void shouldCombineIntegrationAndUiTest() throws UnirestException {
        Map<String, Object> formData = new HashMap<>();
        formData.put("action", "blog_option");
        formData.put("blog_option[category]", "trends");
        formData.put("blog_option[role]", "null");
        String blogResponse = Unirest.post("https://jelvix.com/wp-admin/admin-ajax.php")
                .fields(formData)
                .asString()
                .getBody();

        List<String> responseHashtags = JsonPath.read(blogResponse, "$.posts[*].hashtags[0]");

        HttpResponse<JsonNode> response = Unirest.post("https://jelvix.com/wp-admin/admin-ajax.php")
                .fields(formData)
                .asJson();
        assertTrue(response.getStatus() >= 200 && response.getStatus() <= 208);
//        pageBlog.clickTheFilterButton("TRENDS");
//        pageBlog.isAllArticlesSortedByCorrectTag()


    }
}
