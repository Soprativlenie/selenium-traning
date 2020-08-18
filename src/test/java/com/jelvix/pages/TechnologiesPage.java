package com.jelvix.pages;/* Created by user on 21.07.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TechnologiesPage extends Page {


    public TechnologiesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public TechnologiesPage open() {
        driver.get(Page.getHost() + PagePaths.TECHNOLOGIES.getLink());
        return this;
    }
}
