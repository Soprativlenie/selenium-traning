package com.jelvix.pages;/* Created by user on 21.07.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page_Industries extends Page {
    public Page_Industries(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public Page_Industries open() {
        driver.get(Page.getHost()+ PagePaths.INDUSTRIES.getLink());
        return this;
    }

}
