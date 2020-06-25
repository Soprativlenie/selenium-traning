package com.jelvix.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private String url;

    public Page(WebDriver driver) {
        System.setProperty("webdriver.chrome.driver", "home/user/Downloads/chromedriver");
        Page.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    public String getUrl (){
        return url;
    }
}
