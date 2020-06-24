package com.jelvix.pages;

import org.openqa.selenium.WebDriver;

public class MainPage extends Page{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage open(){
        driver.get("");
        return this;
    }
}
