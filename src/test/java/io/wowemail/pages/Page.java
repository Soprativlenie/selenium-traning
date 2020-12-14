package io.wowemail.pages;/* Created by user on 25.08.20 */


import io.wowemail.driverFactory.DriverFactory;
import io.wowemail.driverFactory.DriverType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static JavascriptExecutor jsExecutor;
    protected static Actions action;
    protected static String host;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        jsExecutor = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }

    public Page(String host) {
        this.host = host;
    }


}
