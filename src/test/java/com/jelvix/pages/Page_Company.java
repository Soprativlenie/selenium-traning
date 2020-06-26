package com.jelvix.pages;

import org.openqa.selenium.WebDriver;

public class Page_Company extends Page {


    public Page_Company(WebDriver driver) {
        super(driver);
    }

    public String getUrl() {
        return "https://jelvix.com/company";
    }
}
