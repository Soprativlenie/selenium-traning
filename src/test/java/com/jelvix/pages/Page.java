package com.jelvix.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Page {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static JavascriptExecutor jsExecutor;
    protected static Actions actions;
    private static String host;


    public Page(WebDriver driver) {
        System.setProperty("webdriver.chrome.driver", "home/user/Downloads/chromedriver");
        Page.driver = driver;
        wait = new WebDriverWait(driver, 10);
        jsExecutor = (JavascriptExecutor) driver;
        actions = new Actions(driver);
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

    public List<WebElement> getAllImagesWithSrcAttr() {
        return driver.findElements(By.tagName("img"));
    }

    public static String getHost() {
        return host;
    }
}
