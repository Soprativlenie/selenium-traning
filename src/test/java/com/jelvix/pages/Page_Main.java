package com.jelvix.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_Main extends Page {
    private String url = "";

    public Page_Main(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'More About Us')]")
    public WebElement moreAboutUsBtn;

    @FindBy(css = ".btn-flip")
    public WebElement seeAllCaseStudiesBtn;


    public Page_Main open() {
        driver.get("http://31.202.123.239:3043/");
        return this;
    }

    public String getUrl() {
        return "";
    }
}
