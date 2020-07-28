package com.jelvix.pages;/* Created by user on 21.07.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page_Technologies extends Page {


    public Page_Technologies(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Page_Technologies open() {
        driver.get(Page.getHost() + PagePaths.TECHNOLOGIES.getLink());
        return this;
    }
}
