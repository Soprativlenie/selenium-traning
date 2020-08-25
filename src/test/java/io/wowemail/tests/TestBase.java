package io.wowemail.tests;

import io.wowemail.httpclient.HttpSender;

import io.wowemail.pages.*;
import io.wowemail.tests.environment.Environment;
import io.wowemail.tests.environment.EnvironmentLinks;
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
    private Environment environment;

    private Page page;
    protected MainPage mainPage;
    protected SamplesPage samplesPage;
    protected SingleSamplePage singleSamplePage;
    protected HowWeWorkPage howWeWorkPage;
    protected FaqPage faqPage;
    protected ContactPage contactPage;
    protected OrderNowPage orderNowPage;

    //  C:/38095/Downloads/chromedriver.exe
    @BeforeMethod
    public void init() {
        System.setProperty("webdriver.chrome.driver", "/home/user/Downloads/Drivers/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        httpSender = new HttpSender();
        environment = new Environment();

        page = new Page(environment.getEnvironment(EnvironmentLinks.STAGE));
        mainPage = new MainPage(driver);
        samplesPage = new SamplesPage(driver);
        singleSamplePage = new SingleSamplePage(driver);
        howWeWorkPage = new HowWeWorkPage(driver);
        faqPage = new FaqPage(driver);
        contactPage = new ContactPage(driver);
        orderNowPage = new OrderNowPage(driver);


    }


    @AfterMethod
    public void quit() {
        driver.quit();
    }
}
