package io.wowemail.tests;

import io.wowemail.httpclient.HttpSender;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static JavascriptExecutor js;
    public HttpSender httpSender;

    //  C:/38095/Downloads/chromedriver.exe
    @BeforeMethod
    public void init() {
        System.setProperty("webdriver.chrome.driver", "/home/user/Downloads/Drivers/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        httpSender = new HttpSender();

    }


    @AfterMethod
    public void quit() {
        driver.quit();
    }
}
