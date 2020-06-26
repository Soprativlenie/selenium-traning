package com.jelvix.pages.pageblocks;

import com.jelvix.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

public class CovidBanner extends Page {

    public CovidBanner(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        try {
            return driver.findElement(By.xpath("//div[@class='info-banner']")).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException ex) {
            return false;
        }
    }

    public void close() {
        driver.findElement(By.xpath("//button[@class='close js-close-covid']")).click();
        wait.until(invisibilityOfElementLocated(By.xpath("//button[@class='close js-close-covid']")));
    }
}
