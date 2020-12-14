package com.jelvix.tests;

import com.jelvix.environment.Environment;
import com.jelvix.environment.EnvironmentLinks;
import com.jelvix.httpclient.RequestSender;
import com.jelvix.pages.*;
import com.jelvix.pages.pageblocks.*;
import com.jelvix.useremailbox.Page_Mailinator;
import com.jelvix.useremailbox.Page_MailinatorEmailBox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
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
    protected BlogPage pageBlog;
    protected CaseStudiesPage pageCaseStudies;
    protected CompanyPage pageCompany;
    protected ContactUsPage pageContactUs;
    protected ExpertisePage pageExpertise;
    protected IndustriesPage pageIndustries;
    protected MainPage pageMain;
    protected ServicesPage pageServices;
    protected TechnologiesPage pageTechnologies;
    protected Page_Mailinator pageMailinator;
    protected Page_MailinatorEmailBox pageMailinatorEmailBox;
    protected SingleBlogPage pageSingleBlog;
    private Environment env;

    @BeforeClass
    public void start() {
        System.setProperty("webdriver.chrome.driver", "/home/user/Downloads/Drivers/chromedriver");
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
        page = new Page(driver, env.getEnvironment(EnvironmentLinks.PRODUCTION));
        pageMain = new MainPage(driver);
        pageCompany = new CompanyPage(driver);
        pageCaseStudies = new CaseStudiesPage(driver);
        pageContactUs = new ContactUsPage(driver);
        pageBlog = new BlogPage(driver);
        pageExpertise = new ExpertisePage(driver);
        pageIndustries = new IndustriesPage(driver);
        pageServices = new ServicesPage(driver);
        pageTechnologies = new TechnologiesPage(driver);
        requestSender = new RequestSender();
        pageMailinator = new Page_Mailinator(driver);
        pageMailinatorEmailBox = new Page_MailinatorEmailBox(driver);
        pageSingleBlog = new SingleBlogPage(driver);
    }


    @AfterClass
    public void stop() {
        driver.quit();
    }
}
