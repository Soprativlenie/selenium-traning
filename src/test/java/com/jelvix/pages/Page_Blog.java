package com.jelvix.pages;/* Created by user on 17.07.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Page_Blog extends Page {

    public Page_Blog(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "s")
    public WebElement searchField;

    @FindBy(id = "searchsubmit")
    public WebElement searchBtn;

    @FindBy(id = "es_subscription_form_1594977925")
    public WebElement subscriptionField;

    @FindBy(id = "es_subscription_form_submit_1594977925")
    public WebElement subscriptionBtn;

    @FindBy(xpath = "//div[@class='category-filter']/button")
    public List<WebElement> filterBtns;
    @FindBy(xpath = "//div[@class='category-filter']")
    public WebElement categoryBar;

    @FindBy(xpath = "//button[contains(text(),'All')]")
    public WebElement allFilterBtn;

    @FindBy(xpath = "//button[contains(text(),'News')]")
    public WebElement newsFilterBtn;

    @FindBy(xpath = "//button[contains(text(),'Trends')]")
    public WebElement trendsFilterBtn;

    @FindBy(xpath = "//button[contains(text(),'Business')]")
    public WebElement businessFilterBtn;

    @FindBy(xpath = "//button[contains(text(),'Engineering')]")
    public WebElement engineeringFilterBtn;

    @FindBy(xpath = "//button[contains(text(),'Design')]")
    public WebElement designFilterBtn;

    @FindBy(xpath = "//button[contains(text(),'Mobile')]")
    public WebElement mobileFilterBtn;

    @FindBy(xpath = "//button[contains(text(),'Data Science')]")
    public WebElement dataScienceFilterBtn;

    @FindBy(xpath = "//button[contains(text(),'Blockchain')]")
    public WebElement blockchainFilterBtn;

    @FindBy(xpath = "//button[contains(text(),'AR/VR')]")
    public WebElement arVrFilterBtn;

    @FindBy(xpath = "//div[@class='blog-col ']")
    private List<WebElement> articles;

    @FindBy(xpath = "//div[@class='blog-col ']//div[@class='hashtags']")
    public List<WebElement> hashtags;

    @FindBy(xpath = "//div[@class='blog-col '][1]")
    public WebElement firstArticle;

    @FindBy(xpath = "//div[@class='blog-col '][last()]")
    public WebElement lastArticle;

    @FindBy(xpath = "//div[@class ='loader blue']")
    public WebElement loader;

    public int getNumberOfArticleOnThePage() {
        return articles.size();
    }

    public Page_Blog open() {
        driver.get(Page.getHost() + PagePaths.BLOG.getLink());
//        actions.moveToElement(firstArticle).perform();
        return this;
    }

    public boolean isAllArticlesSortedByCorrectTag(String tagName) {
        CharSequence tagNameInChar = tagName;
        for (WebElement hashTag : hashtags) {
            if (!hashTag.getText().contains(tagNameInChar)) {
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

}
