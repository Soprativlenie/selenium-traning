package com.jelvix.driverfactory;/* Created by user on 20.08.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser implements Browser {
    @Override
    public WebDriver init() {
        /*Ubuntu driver path //home/user/Downloads/Drivers/chromedriver */
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\38095\\Downloads\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
//        options.addArguments("--headless");
        options.addArguments("window-size=1366,768");
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        return driver;
    }
}
