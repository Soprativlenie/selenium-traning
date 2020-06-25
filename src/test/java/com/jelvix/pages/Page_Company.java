package com.jelvix.pages;

import org.openqa.selenium.WebDriver;

public class Page_Company extends Page {


    public Page_Company(WebDriver driver) {
        super(driver);
    }

    public String getUrl() {
        return "http://31.202.123.239:3043/company";
    }
}
