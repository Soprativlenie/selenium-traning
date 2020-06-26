package com.jelvix.tests;

import com.jelvix.pages.Page;
import com.jelvix.pages.Page_CaseStudies;
import com.jelvix.pages.Page_Company;
import com.jelvix.pages.Page_Main;
import com.jelvix.pages.pageblocks.*;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected ContactUsForm contactUsForm;
    protected CookiesBanner cookiesBanner;
    protected CovidBanner covidBanner;
    protected Footer footer;
    protected NavigationTabs navigationTabs;
    protected Page page;
    protected Page_Main pageMain;
    protected Page_Company pageCompany;
    protected Page_CaseStudies pageCaseStudies;
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    private ChromeOptions options;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "/home/user/Downloads/chromedriver");
        options = new ChromeOptions();
//        options.addArguments("--headless");
//        options.addArguments("window-size=1920,1080");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        contactUsForm = new ContactUsForm(driver);
        cookiesBanner = new CookiesBanner(driver);
        covidBanner = new CovidBanner(driver);
        footer = new Footer(driver);
        navigationTabs = new NavigationTabs(driver);
        page = new Page(driver);
        pageMain = new Page_Main(driver);
        pageCompany = new Page_Company(driver);
        pageCaseStudies = new Page_CaseStudies(driver);

    }

    @After
    public void stop() {
        driver.quit();
    }
}
