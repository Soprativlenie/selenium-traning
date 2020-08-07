package com.jelvix.pages;

import com.jelvix.cookies.CookiesHandler;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Page {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static JavascriptExecutor jsExecutor;
    protected static Actions actions;
    private static String host;
    private CookiesHandler cookiesHandler;
    private List<String> imagesLinks = new ArrayList<>();


    public Page(WebDriver driver) {
        System.setProperty("webdriver.chrome.driver", "home/user/Downloads/chromedriver");
        Page.driver = driver;
        wait = new WebDriverWait(driver, 10);
        jsExecutor = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        cookiesHandler = new CookiesHandler();

    }

    public Page(WebDriver driver, String host) {
        System.setProperty("webdriver.chrome.driver", "home/user/Downloads/chromedriver");
        Page.driver = driver;
        wait = new WebDriverWait(driver, 10);
        jsExecutor = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        Page.host = host;

    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public List<String> getAllImagesLinks() {
        addLinksAreLinkedToImagesWithSrcAttribute();
        addLinksAreLinkedToImagesWithSrcSetAttribute();
        addLinksAreLinkedToImagesWithXlinkHrefAttribute();
        return imagesLinks;
    }

    public static String getHost() {
        return host;
    }

    public void launchThePageWithAcceptedCookies() {
        driver.manage().addCookie(cookiesHandler.getCookieNoticeAcceptedCookie());
        driver.manage().addCookie(cookiesHandler.getCloseCovidCookie());
        driver.manage().addCookie(cookiesHandler.getCloseSubscribeCookie());
    }

    private void addLinksAreLinkedToImagesWithSrcAttribute() {
        try {
            List<WebElement> imgTegs = driver.findElements(By.tagName("img"));
            for (WebElement img : imgTegs) {
                if (img.getAttribute("src").length() == 0) {
                    continue;
                }
                imagesLinks.add(img.getAttribute("src"));
            }
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
        }
    }

    private void addLinksAreLinkedToImagesWithSrcSetAttribute() {
        try {
            List<WebElement> imgTags = driver.findElements(By.tagName("img"));
            for (WebElement img : imgTags) {
                if (img.getAttribute("srcset").length() == 0) {
                    continue;
                }
                imagesLinks.add(img.getAttribute("srcset"));
            }
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
        }
    }

    private void addLinksAreLinkedToImagesWithXlinkHrefAttribute() {
        try {
            List<WebElement> useTags = driver.findElements(By.cssSelector(".img-holder>svg>use"));
            for (WebElement useTag : useTags) {
                if (useTag.getAttribute("xlink:href").length() == 0) {
                    continue;
                }
                imagesLinks.add(useTag.getAttribute("xlink:href"));
            }
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
        }


    }

}
