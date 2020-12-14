package com.jelvix.pages;/* Created by user on 21.07.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class IndustriesPage extends Page {
    public IndustriesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public IndustriesPage open() {
        driver.get(Page.getHost() + PagePaths.INDUSTRIES.getRoute());
        return this;
    }
}