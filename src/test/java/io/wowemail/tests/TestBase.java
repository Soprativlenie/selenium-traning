package io.wowemail.tests;

import io.wowemail.httpclient.HttpSender;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class TestBase {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static JavascriptExecutor js;
    protected HttpSender httpSender;

    //  C:/38095/Downloads/chromedriver.exe
    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "/home/user/Downloads/Drivers/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        httpSender = new HttpSender();

    }


    @After
    public void quit() {
        driver.quit();
    }
}
