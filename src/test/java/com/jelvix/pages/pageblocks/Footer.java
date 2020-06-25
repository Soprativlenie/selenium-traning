package com.jelvix.pages.pageblocks;

import com.jelvix.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Footer extends Page {

    public Footer(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@class='contact-list']/li[1]")
    public WebElement contactPhoneLabel;

    @FindBy(xpath = "//ul[@class='contact-list']/li[2]")
    public WebElement emailLabel;

    @FindBy(xpath = "//ul[@class='contact-list']/li[3]")
    public WebElement skypeLabel;

    @FindBy(css = ".svg-facebook")
    public WebElement facebookIcon;

    @FindBy(css = ".svg-twitter")
    public WebElement twitterIcon;

    @FindBy(css = ".svg-linkedin")
    public WebElement linkedinIcon;

    @FindBy(css = ".svg-instagram")
    public WebElement instagramIcon;

    @FindBy(css = ".svg-youtube")
    public WebElement youtubeIcon;

    @FindBy(xpath = "//div[@class='footer-blog'][1]//div[@class='hashtags']")
    public WebElement firstArticleCardHashtag;

    @FindBy(xpath = "//div[@class='footer-blog'][2]//div[@class='hashtags']")
    public WebElement secondArticleCardHashtag;

    @FindBy(xpath = "//div[@class='footer-blog'][3]//div[@class='hashtags']")
    public WebElement thirdArticleCardHashtag;

    @FindBy(xpath = "//div[@class='footer-blog'][1]//h6")
    public WebElement firstArticleCardTitle;

    @FindBy(xpath = "//div[@class='footer-blog'][2]//h6")
    public WebElement secondArticleCardTitle;

    @FindBy(xpath = "//div[@class='footer-blog'][3]//h6")
    public WebElement thirdArticleCardTitle;

    @FindBy(xpath = "//ul[@class='bottom-nav']//a[contains(text(),'Privacy Policy')]")
    public WebElement privacyPolicyLink;

    @FindBy(xpath = "//ul[@class='bottom-nav']//a[contains(text(),'Cookies Policy')]")
    public WebElement cookiesPolicyLink;


}
