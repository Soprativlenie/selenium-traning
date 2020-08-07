package com.jelvix.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_Main extends Page {

    public Page_Main(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'More About Us')]")
    private WebElement moreAboutUsBtn;

    @FindBy(xpath = "//div[@class='active-state']")
    private WebElement bla;

    @FindBy(xpath = "//div[@class='dots-block']//span[contains(text(),'See All Case Studies')]")
    private WebElement seeAllCaseStudiesBtn;


    public Page_Main open() {
        driver.get(Page.getHost() + PagePaths.MAIN.getLink());
        return this;
    }


    public void clickSeeAllCaseStudiesBtn() {  // The method doesn't work
//        actions.moveToElement(seeAllCaseStudiesBtn);
//        js.executeScript("window.scrollBy(0,3200)");
//        seeAllCaseStudiesBtn.click();
//        actions.moveToElement(seeAllCaseStudiesBtn).perform();
//        wait.until(visibilityOf(bla)).click();
//        actions.moveToElement(seeAllCaseStudiesBtn).perform();
//        actions.click();
//        seeAllCaseStudiesBtn.click();
    }

    public void clickMoreAboutUsButton() {
        moreAboutUsBtn.click();
    }
}
