package io.wowemail.driverFactory;/* Created by user on 20.08.20 */

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeBrowser implements Driver {

    @Override
    public WebDriver setupDriver() {
        System.setProperty("webdriver.chrome.driver", "/home/user/Downloads/Drivers/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/home/user/Downloads/Drivers/geckodriver");
        WebDriver driver = new ChromeDriver();
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        return driver;
    }
}
