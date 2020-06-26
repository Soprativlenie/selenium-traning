package io.wowemail;

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
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static JavascriptExecutor js;
//  C:/38095/Downloads/chromedriver.exe
    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "/home/user/Downloads/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();

    }

    @Test
    public void checkEmailFromGetInTouchForm() {
        driver.get("http://192.168.88.112");
        driver.findElement(By.id("name-input")).sendKeys("Igor");
        driver.findElement(By.id("email-input")).sendKeys("igor.vdovichenko@jelvix.com");
        driver.findElement(By.id("message-input")).sendKeys("Some message");
        driver.findElement(By.xpath("//button[@class='btn form-submit']")).click();

        WebElement successPopup = wait.until(visibilityOfElementLocated(By.id("thanks-sent-popup")));
//        driver.findElement(By.xpath("//button[text()='Close']")).click();

        isEmailCame();
    }

    public void isEmailCame() {
        driver.get("https://flockmail.hostinger.com/");
        driver.findElement(By.xpath("//input[@placeholder='Enter your Email ID']")).sendKeys("support@wowemail.io");
        driver.findElement(By.xpath("//input[@placeholder='Enter your Password']")).sendKeys("WXcTnijDPJ");
        driver.findElement(By.xpath("//button[@class='btn-login active']")).click();
        WebElement listOfEmails = wait.until(visibilityOfElementLocated(By.xpath("//div[@class='']//div[@class='scroll-region-content-inner']")));
        wait.until(visibilityOfElementLocated(By.xpath("//div[@class='name'][contains(text(),'Info')]")));
        driver.findElement(By.xpath("//div[@class='name'][contains(text(),'Info')]")).click();
        WebElement infoEmails = wait.until(visibilityOfElementLocated(By.xpath("//div[@class='list-rows']")));
        wait.until(visibilityOfElementLocated(By.xpath("//div[@class='list-rows']/div[1]")));
        driver.findElement(By.xpath("//div[@class='list-rows']/div[1]")).click();
        wait.until(visibilityOfElementLocated(By.xpath("//div[@class='iframe-container']//iframe")));
        WebElement fr = driver.findElement(By.xpath("//div[@class='iframe-container']//iframe"));
        driver.switchTo().frame(fr);
        String actualEmail = driver.findElement(By.xpath("//div[@id='inbox-html-wrapper']//a")).getText();
//        WebElement actualEmail = wait.until(visibilityOfElementLocated(By.xpath("//a[contains(text(),'ghghfh@hkjhkjh.jki')]")))
        Assert.assertEquals("igor.vdovichenko@jelvix.com", actualEmail);
        System.out.println(actualEmail);
    }

    @Test
    public void sendTheContactFromJelvix(){
        driver.get("// http://31.202.123.239:3043/");
        wait.until(visibilityOfElementLocated(By.xpath("//div[@class='info-banner']")));
        driver.findElement(By.xpath("//button[@class='close js-close-covid']")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Igor Test");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("igor.vdovichenko@jelvix.com");
        driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Test description");
        driver.findElement(By.xpath("//div[@class='input-row']/div[1]//span[@class='fake-input']")).click();
        driver.findElement(By.xpath("//div[@class='input-row']/div[2]")).submit();
    }

//    @After
//    public void quit() {
//        driver.quit();
//    }
}
