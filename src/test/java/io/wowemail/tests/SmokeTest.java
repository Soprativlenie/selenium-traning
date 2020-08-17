package io.wowemail.tests;/* Created by user on 14.08.20 */

import com.mashape.unirest.http.exceptions.UnirestException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeTest extends TestBase {
    private String name = "John Doe";
    private String email = "testwowemail@mailinator.com";
    private String message = "Hi there! Please contact me";

    @Test
     void checkEmailFromGetInTouchForm() throws UnirestException {

        driver.get("http://192.168.88.112");
        driver.findElement(By.id("name-input")).sendKeys(name);
        driver.findElement(By.id("email-input")).sendKeys(email);
        driver.findElement(By.id("message-input")).sendKeys(message);
        driver.findElement(By.xpath("//button[@class='btn form-submit']")).click();

        WebElement successPopup = wait.until(visibilityOfElementLocated(By.id("thanks-sent-popup")));

        isEmailCameUsingIntegrationWay(name, email, message);
    }

    public void isEmailCameUsingUiWay() {
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
        assertEquals("igor.vdovichenko@jelvix.com", actualEmail);
        System.out.println(actualEmail);
    }


    public void isEmailCameUsingIntegrationWay(String name, String email, String message) throws UnirestException {
        String key = "Name: " + name + " Email: " + email + " Message: " + message;
        assertEquals(key,
                httpSender.getDataOfTheFirstMessage());
    }

    @Test
     void sendTheContactFromJelvix() {
        driver.get("// http://31.202.123.239:3043/");
        wait.until(visibilityOfElementLocated(By.xpath("//div[@class='info-banner']")));
        driver.findElement(By.xpath("//button[@class='close js-close-covid']")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Igor Test");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("igor.vdovichenko@jelvix.com");
        driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Test description");
        driver.findElement(By.xpath("//div[@class='input-row']/div[1]//span[@class='fake-input']")).click();
        driver.findElement(By.xpath("//div[@class='input-row']/div[2]")).submit();
    }
    @Test
    void sesad() throws UnirestException {
        Emails emails = new Emails();
        assertTrue(emails.isWelcomeLetterReceives("blann"));;
    }
}
