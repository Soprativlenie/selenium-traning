package com.jelvix.pages;

import org.openqa.selenium.WebDriver;

public class CompanyPage extends Page {


    public CompanyPage(WebDriver driver) {
        super(driver);
    }

    public CompanyPage open() {
        driver.get(Page.getHost() + PagePaths.COMPANY.getLink());
        return this;
    }

    public String getUrl() {
        return Page.getHost() + PagePaths.COMPANY.getLink();
    }
}
