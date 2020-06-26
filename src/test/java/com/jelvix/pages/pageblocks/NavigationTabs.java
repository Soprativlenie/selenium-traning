package com.jelvix.pages.pageblocks;

import com.jelvix.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationTabs extends Page {
    public NavigationTabs(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//strong[@class='logo']/a")
    public WebElement logo;

    @FindBy(xpath = "//button[@class='search-reset']")
    public WebElement searchIco;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[text()='Industries']")
    public WebElement industriesBtn;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[text()='Services']")
    public WebElement servicesBtn;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[text()='Expertise']")
    public WebElement expertiseBtn;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[text()='Technologies']")
    public WebElement technologiesBtn;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[text()='Case Studies']")
    public WebElement caseStudiesBtn;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[text()='Company']")
    public WebElement companyBtn;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[text()='Blog']")
    public WebElement blogBtn;

    @FindBy(xpath = "//a[@class='btn btn-gray btn-flip']//span[@class='default-state']")
    public WebElement contactUsBtn;
}
