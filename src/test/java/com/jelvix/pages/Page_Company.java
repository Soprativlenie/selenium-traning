package com.jelvix.pages;

import org.openqa.selenium.WebDriver;

public class Page_Company extends Page {


    public Page_Company(WebDriver driver) {
        super(driver);
    }

    public Page_Company open() {
        driver.get(Page.getHost() + PagePaths.COMPANY.getLink());
        return this;
    }

    public String getUrl() {
        return Page.getHost() + PagePaths.COMPANY.getLink();
    }
}
