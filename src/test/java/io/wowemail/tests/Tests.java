package io.wowemail.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Tests {
    WebDriver driver;

    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\38095\\Downloads\\chromedriver.exe"); ///home/user/Downloads/Drivers/chromedriver
        driver = new ChromeDriver();
        String sourceUrl = "http://localhost:3000/index.html";
        By nameField = By.xpath("//input[@name='name']");
        By emailField = By.xpath("//input[@name='email']");
        By messageField = By.xpath("//textarea[@name='message']");
        By privacyCheckbox = By.xpath("//span[@class='icon-check']");
        By submitButton = By.id("submit");
        driver.navigate().to(sourceUrl);

        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys("My name");
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys("email@mailinator.com");
        driver.findElement(messageField).clear();
        driver.findElement(messageField).sendKeys("Message");
        driver.findElement(privacyCheckbox).click();
        driver.findElement(submitButton).click();

    }


}
