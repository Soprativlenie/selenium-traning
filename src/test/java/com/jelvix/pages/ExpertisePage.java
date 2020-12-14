package com.jelvix.pages;/* Created by user on 21.07.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ExpertisePage extends Page {


    public ExpertisePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ExpertisePage open() {
        driver.get(Page.getHost() + PagePaths.EXPERTISE.getRoute());
        return this;
    }

}
