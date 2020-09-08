package io.wowemail.tests;

import io.wowemail.driverFactory.Driver;
import io.wowemail.driverFactory.DriverFactory;
import io.wowemail.driverFactory.DriverType;
import io.wowemail.httpclient.HttpSender;

import io.wowemail.pages.*;
import io.wowemail.tests.environment.Environment;
import io.wowemail.tests.environment.EnvironmentLinks;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected static WebDriver webDriver;
    protected HttpSender httpSender;
    private Environment environment;

    private Page page;
    protected MainPage mainPage;
    protected SamplesPage samplesPage;
    protected SingleSamplePage singleSamplePage;
    protected HowWeWorkPage howWeWorkPage;
    protected FaqPage faqPage;
    protected ContactPage contactPage;
    protected OrderNowPage orderNowPage;
    private DriverFactory driverFactory;

    @BeforeClass
    public void init() {
        driverFactory = new DriverFactory();
        Driver driver = driverFactory.getDriver(DriverType.FIREFOX);
        webDriver = driver.setupDriver();
        httpSender = new HttpSender();
        environment = new Environment();

        page = new Page(environment.getEnvironment(EnvironmentLinks.STAGE));
        mainPage = new MainPage(webDriver);
        samplesPage = new SamplesPage(webDriver);
        singleSamplePage = new SingleSamplePage(webDriver);
        howWeWorkPage = new HowWeWorkPage(webDriver);
        faqPage = new FaqPage(webDriver);
        contactPage = new ContactPage(webDriver);
        orderNowPage = new OrderNowPage(webDriver);


    }


    @AfterClass
    public void quit() {
        webDriver.quit();
    }
}
