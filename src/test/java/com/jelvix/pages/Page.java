package com.jelvix.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Page {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static JavascriptExecutor jsExecutor;
    public static Actions actions;


    public Page(WebDriver driver) {
        System.setProperty("webdriver.chrome.driver", "home/user/Downloads/chromedriver");
        Page.driver = driver;
        wait = new WebDriverWait(driver, 10);
        jsExecutor = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public List<WebElement> getAllImagesLink() {
        return driver.findElements(By.tagName("img"));
    }

}
