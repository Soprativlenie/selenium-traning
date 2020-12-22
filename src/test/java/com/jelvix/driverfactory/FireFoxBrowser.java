package com.jelvix.driverfactory;/* Created by user on 20.08.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxBrowser implements Browser {
    @Override
    public WebDriver init() {
        System.setProperty("webdriver.gecko.driver", "/home/user/Downloads/Drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
