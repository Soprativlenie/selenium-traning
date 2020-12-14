package com.jelvix.pages;/* Created by user on 21.07.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ServicesPage extends Page {

    public ServicesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ServicesPage open() {
        driver.get(Page.getHost() + PagePaths.SERVICES.getLink());
        return this;
    }
}
