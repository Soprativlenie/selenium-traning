package com.jelvix.tests;

import com.jelvix.pages.Page_Company;
import com.jelvix.pages.Page_Main;
import com.jelvix.pages.pageblocks.*;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
    protected ContactUsForm contactUsForm;
    protected CookiesBanner cookiesBanner;
    protected CovidBanner covidBanner;
    protected Footer footer;
    protected NavigationTabs navigationTabs;
    protected Page_Main pageMain;
    protected Page_Company pageCompany;
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    private ChromeOptions options;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/38095/Downloads/chromedriver.exe");
        options = new ChromeOptions();
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);
        contactUsForm = new ContactUsForm(driver);
        cookiesBanner = new CookiesBanner(driver);
        covidBanner = new CovidBanner(driver);
        footer = new Footer(driver);
        navigationTabs = new NavigationTabs(driver);
        pageMain = new Page_Main(driver);
        pageCompany = new Page_Company(driver);
    }

    @After
    public void stop() {
        driver.quit();
    }
}
