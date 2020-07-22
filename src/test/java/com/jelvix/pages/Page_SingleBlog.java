package com.jelvix.pages;/* Created by user on 22.07.20 */

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Page_SingleBlog extends Page {
    public Page_SingleBlog(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='social-block bottom-block']")
    public WebElement socialBlock;

    @FindBy(xpath = "")
    public WebElement subscriptionField;

    @FindBy(xpath = "")
    public WebElement subscriptionBtn;

    @FindBy(xpath = "//div[@class='sidebar-block sidebar-btn-block']")
    private WebElement contactUsButtonBlock;

    @FindBy(xpath = "//div[@class='sidebar-panel sidebar-nav']")
    private WebElement structureBlock;

    @FindBy(xpath = "//div[@class='rate-block']")
    public WebElement rateBlock;

    @FindBy(xpath = "//div[@class='next-article']")
    public WebElement readNextBlock;

    @FindBy(id = "disqus_thread")
    public WebElement disqusBlogCommentBlock;

    @FindBy(xpath = "//div[@class='blog-columns second-row dots flat-columns']")
    private WebElement recommendedForYouBlock;

    @FindBy(xpath = "//div[@class='blog-col flat-card']")
    private List<WebElement> recommendedForYouArticles;

    @FindBy(xpath = "//a[@class='btn btn-line btn-dark']")
    public WebElement seeAllArticlesBtn;

    @FindBy(xpath = "//div[@class='subscribe-popup']")
    private WebElement subscriptionPopup;

    @FindBy(xpath = "//div[@class='article-content']//h2[last()]")
    private WebElement lastSectionOfTheArticle;

    public int countArticlesInRecommendedForYouBlock() {
        actions.moveToElement(recommendedForYouBlock).perform();
        return recommendedForYouArticles.size();
    }

    public boolean isStructureBlockDisplaying() {
        return structureBlock.isDisplayed();
    }

    public boolean isSocialBlockDisplaying() {
        return socialBlock.isDisplayed();
    }

    public boolean isRecommendedForYouBlockDisplaying() {
        actions.moveToElement(recommendedForYouBlock);
        return recommendedForYouBlock.isDisplayed();
    }

    public boolean isSubscriptionPopupDisplaying() {
        wait.until(ExpectedConditions.visibilityOf(subscriptionPopup));
        return subscriptionPopup.isDisplayed();
    }

    public void hoverOverTheLastSectionOfTheArticle() {
        actions.moveToElement(rateBlock).perform();
    }

    public void scrollByRandomRange() {
        jsExecutor.executeScript("window.scrollBy(0,1000)");
        jsExecutor.executeScript("window.scrollBy(0,-200)");
    }

    public void closeSubscriptionPopup() {
        driver.manage().addCookie(new Cookie("close_subscribe", "true"));
    }

    public boolean isContactUsBottomBlockDisplaying() {
        return contactUsButtonBlock.isDisplayed();
    }
    public boolean isReadNextBlockDisplaying(){
        return wait.until(ExpectedConditions.visibilityOf(readNextBlock)).isDisplayed();
    }

}
