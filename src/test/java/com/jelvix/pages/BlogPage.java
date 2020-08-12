package com.jelvix.pages;/* Created by user on 17.07.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BlogPage extends Page {

    public BlogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "s")
    private WebElement searchField;

    @FindBy(id = "searchsubmit")
    private WebElement searchBtn;

    @FindBy(xpath = "//input[@placeholder='Enter your email...']")
    private WebElement subscriptionField;

    @FindBy(xpath = "//div[@class='emaillist']//input[@type='submit']")
    private WebElement subscriptionBtn;

    @FindBy(xpath = "//div[@class='category-filter']/button")
    private List<WebElement> filterButtons;

    @FindBy(xpath = "//div[@class='category-filter']")
    private WebElement categoryBar;

    @FindBy(xpath = "//button[contains(text(),'All')]")
    private WebElement allFilterButton;

    @FindBy(xpath = "//button[contains(text(),'News')]")
    private WebElement newsFilterButton;

    @FindBy(xpath = "//button[contains(text(),'Trends')]")
    private WebElement trendsFilterButton;

    @FindBy(xpath = "//button[contains(text(),'Business')]")
    private WebElement businessFilterButton;

    @FindBy(xpath = "//button[contains(text(),'Engineering')]")
    private WebElement engineeringFilterButton;

    @FindBy(xpath = "//button[contains(text(),'Design')]")
    private WebElement designFilterButton;

    @FindBy(xpath = "//button[contains(text(),'Mobile')]")
    private WebElement mobileFilterButton;

    @FindBy(xpath = "//button[contains(text(),'Data Science')]")
    private WebElement dataScienceFilterButton;

    @FindBy(xpath = "//button[contains(text(),'Blockchain')]")
    private WebElement blockchainFilterButton;

    @FindBy(xpath = "//button[contains(text(),'AR/VR')]")
    private WebElement arVrFilterButton;

    @FindBy(xpath = "//div[@class='blog-col ']")
    private List<WebElement> articles;

    @FindBy(xpath = "//div[@class='blog-col ']//div[@class='hashtags']")
    private List<WebElement> hashtags;

    @FindBy(xpath = "//div[@class='blog-col '][1]")
    private WebElement firstArticle;

    @FindBy(xpath = "//div[@class='blog-col '][last()]")
    private WebElement lastArticle;

    @FindBy(xpath = "//div[@class ='loader blue']")
    private WebElement loader;

    @FindBy(xpath = "//span[@class='es_subscription_message success']")
    private WebElement subscriptionSuccessMessage;

    @FindBy(xpath = "//span[@id='spinner-image']")
    private WebElement subscriptionLoader;

    public int getNumberOfArticleOnThePage() {
        return articles.size();
    }

    public BlogPage open() {
        driver.get(Page.getHost() + PagePaths.BLOG.getLink());
        actions.moveToElement(firstArticle).perform();
        return this;
    }

    public boolean isAllArticlesSortedByCorrectTag(String tagName) {
        for (WebElement hashTag : hashtags) {
            if (!hashTag.getText().contains(tagName)) {
                return false;
            }
        }
        return true;
    }

    public void waitUntilLoaderIsDisappearing() {
        wait.until(ExpectedConditions.invisibilityOf(loader));
    }

    public void printHashtags() {
        for (WebElement s : hashtags) {
            System.out.println(s.getText());
        }
    }

    public void hoverToLastArticle() {
        actions.moveToElement(lastArticle).perform();
    }

    public void hoverOnTheCategoryBar() {
        actions.moveToElement(categoryBar).perform();
    }

    public void setContentAttributeLoad() {
        jsExecutor.executeScript("document.getElementById('main').setAttribute('data-loaded', 'true')");
    }

    public void subscribeBlogByEmail(String email) {
        open().subscriptionField.sendKeys(email);
        subscriptionBtn.submit();
        wait.until(ExpectedConditions.visibilityOf(subscriptionSuccessMessage));
    }

    public void openTheSingleBlogPage() {
        open().firstArticle.click();
    }

    public void clickTheFilterButton(String buttonName) {
        for (WebElement button : filterButtons) {
            if (button.getText().equalsIgnoreCase(buttonName)) {
                button.click();
                break;
            }
        }
    }

    public boolean isSubscriptionSuccessMessageDisplayed() {
        return subscriptionSuccessMessage.isDisplayed();
    }


}
