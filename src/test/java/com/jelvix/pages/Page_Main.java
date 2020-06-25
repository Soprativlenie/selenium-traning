package com.jelvix.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Page_Main extends Page{

    public Page_Main(WebDriver driver) {
        super(driver);
    }

    public Page_Main open(){
        driver.get("http://31.202.123.239:3043/");
        return this;
    }
}
