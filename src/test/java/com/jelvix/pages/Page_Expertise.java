package com.jelvix.pages;/* Created by user on 21.07.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page_Expertise extends Page {


    public Page_Expertise(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Page_Expertise open() {
        driver.get(Page.getHost()+ PagePaths.EXPERTISE.getLink());
        return this;
    }

}
