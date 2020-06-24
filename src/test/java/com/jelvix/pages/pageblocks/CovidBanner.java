package com.jelvix.pages.pageblocks;

import com.jelvix.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class CovidBanner extends Page {

    public CovidBanner(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        return wait.until(visibilityOfElementLocated(By.xpath("//div[@class='info-banner']"))).isDisplayed();
    }

    public void closeCovidBanner() {
        driver.findElement(By.xpath("//button[@class='close js-close-covid']")).click();
    }
}
