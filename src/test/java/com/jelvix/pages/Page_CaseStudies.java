package com.jelvix.pages;/* Created by user on 26.06.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_CaseStudies extends Page {
    public Page_CaseStudies(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[1]")
    public WebElement titleOfThePage;

    public Page_CaseStudies open() {
        driver.get(Page.getHost()+ PagePaths.CASE_STUDIES.getLink());
        return this;
    }

    public void waitUntilThePageIsLoaded() {
        titleOfThePage.isDisplayed();
    }

    public String getUrl() {
        return PagePaths.CASE_STUDIES.getLink();
    }

}
