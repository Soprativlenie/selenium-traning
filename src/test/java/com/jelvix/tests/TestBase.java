package com.jelvix.tests;

import com.jelvix.httpclient.RequestSender;
import com.jelvix.pages.*;
import com.jelvix.pages.pageblocks.*;
import com.jelvix.useremailbox.Page_Mailinator;
import com.jelvix.useremailbox.Page_MailinatorEmailBox;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBase {
    private final static String PRODUCTION_HOST = "https://jelvix.com/";
    private final static String STAGING_EXTERNAL_HOST = "http://31.202.123.239:3043/";
    private final static String STAGING_INTERNAL_HOST = "http://192.168.88.173/";

    private static WebDriver driver;
    private static WebDriverWait wait;
    private ChromeOptions options;
    protected RequestSender requestSender;

    protected ContactUsForm contactUsForm;
    protected CookiesBanner cookiesBanner;
    protected CovidBanner covidBanner;
    protected Footer footer;
    protected NavigationTabs navigationTabs;
    protected Page page;
    protected Page_Blog pageBlog;
    protected Page_CaseStudies pageCaseStudies;
    protected Page_Company pageCompany;
    protected Page_ContactUs pageContactUs;
    protected Page_Expertise pageExpertise;
    protected Page_Industries pageIndustries;
    protected Page_Main pageMain;
    protected Page_Services pageServices;
    protected Page_Technologies pageTechnologies;
    protected Page_Mailinator pageMailinator;
    protected Page_MailinatorEmailBox pageMailinatorEmailBox;
    protected Page_SingleBlog pageSingleBlog;

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
        page = new Page(driver, PRODUCTION_HOST);
        pageMain = new Page_Main(driver);
        pageCompany = new Page_Company(driver);
        pageCaseStudies = new Page_CaseStudies(driver);
        pageContactUs = new Page_ContactUs(driver);
        pageBlog = new Page_Blog(driver);
        pageExpertise = new Page_Expertise(driver);
        pageIndustries = new Page_Industries(driver);
        pageServices = new Page_Services(driver);
        pageTechnologies = new Page_Technologies(driver);
        requestSender = new RequestSender();
        pageMailinator = new Page_Mailinator(driver);
        pageMailinatorEmailBox = new Page_MailinatorEmailBox(driver);
        pageSingleBlog = new Page_SingleBlog(driver);
    }


    @After
    public void stop() {
        driver.quit();
    }
}
