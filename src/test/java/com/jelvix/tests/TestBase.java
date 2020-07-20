package com.jelvix.tests;

import com.jelvix.pages.*;
import com.jelvix.pages.pageblocks.*;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected ContactUsForm contactUsForm;
    protected CookiesBanner cookiesBanner;
    protected CovidBanner covidBanner;
    protected Footer footer;
    protected NavigationTabs navigationTabs;
    protected Page page;
    protected Page_Main pageMain;
    protected Page_ContactUs pageContactUs;
    protected Page_Company pageCompany;
    protected Page_CaseStudies pageCaseStudies;
    protected Page_Blog pageBlog;

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
        pageContactUs = new Page_ContactUs(driver);
        pageBlog = new Page_Blog(driver);

//        setAllCookies();
//        getAllCookies();
    }

    public void setAllCookies() {
        try {
            driver.manage().addCookie(new Cookie("_gid", "GA1.2.1676028499.1594972014"));
            driver.manage().addCookie(new Cookie("close_covid", "true"));
            driver.manage().addCookie(new Cookie("__cfduid", "de1699367d900bd5b8d1f36288f9a85c51593592072"));
            driver.manage().addCookie(new Cookie("dsq__", "3n5fgqj19cconk"));
            driver.manage().addCookie(new Cookie("wp-settings-13", "libraryContent%3Dupload"));
            driver.manage().addCookie(new Cookie("cookie_notice_accepted", "true"));
            driver.manage().addCookie(new Cookie("_ym_uid", "1590997256917455077"));
            driver.manage().addCookie(new Cookie("_hjid", "96fcf809-5cce-42a9-8bea-06b05a1bbecf"));
            driver.manage().addCookie(new Cookie("wp-settings-time-13", "1591082862"));
            driver.manage().addCookie(new Cookie("_fbp", "fb.1.1590997256057.1705520991"));
            driver.manage().addCookie(new Cookie("_ym_d", "1590997256"));
            driver.manage().addCookie(new Cookie("_ga", "GA1.2.1043716294.1583507778"));
        } finally {
            driver.quit();
        }
    }

    public Set<Cookie> getAllCookies() {
        Set<Cookie> cookies = driver.manage().getCookies();
        return cookies;
    }

//    @After
//    public void stop() {
//        driver.quit();
//    }
}
